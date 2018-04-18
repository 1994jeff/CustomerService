package com.example.customerservicesystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.customerservicesystem.bean.User;
import com.example.customerservicesystem.bean.wx.TextMsg;
import com.example.customerservicesystem.service.UserService;
import com.example.customerservicesystem.untils.CoreService;
import com.example.customerservicesystem.untils.SHA1;

/**
 * 微信接入流程 1.公众平台配置服务器接口token等数据 2.开发服务器get接口验证微信传送过来的数据,成为开发者
 * 
 * 成为开发者之后，用户发生消息给服务号都会调用之前填写的接口，只不过是调用的post方法接口，通过微信传送的消息和数据
 * 我们可以对用户进行回复消息
 */
@Controller
@RequestMapping("/weixin")
public class WXController extends BaseController {

	
	Logger log = LoggerFactory.getLogger(WXController.class);

	public static final String BASE_ADDRESS = "http://www.wq321.xyz/";
	private static String Token = "yibaikefu"; // 这个是之前在微信上填写的Token数据，可以自定义
	private static String encode = "k5e77FFfiI2Si84lkSA7Z9uhet0TfLk7NXc62HfMi3c"; // 这个是之前在微信上填写的Token数据，可以自定义

	@Resource
	UserService userService;
	
	@RequestMapping(value = "/checkdev.do", method = RequestMethod.GET)
	protected void doGet(HttpServletRequest req, HttpServletResponse response){
		try {
			log.debug("get请求，正确");
			log.debug("获得微信请求!");
			String signature = req.getParameter("signature"); // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
			String timestamp = req.getParameter("timestamp"); // 时间戳
			String nonce = req.getParameter("nonce"); // 随机数
			String echostr = req.getParameter("echostr"); // 随机字符串
			log.debug("signature=" + signature);
			log.debug("timestamp=" + timestamp);
			log.debug("nonce=" + nonce);
			log.debug("echostr=" + echostr);
			log.debug("Token=" + Token);

			List<String> params = new ArrayList<String>();
			params.add(Token);
			params.add(timestamp);
			params.add(nonce);
			// 1. 将token、timestamp、nonce三个参数进行字典序排序
			Collections.sort(params);
			// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
			String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));
			if (temp.equals(signature)) {
				PrintWriter out = response.getWriter();
				out.print(echostr);
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkdev.do", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		// 设置编码
		PrintWriter out = null;
		String textMsg2Xml = "";
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			// 调用核心业务类接收消息、处理消息
			CoreService core = new CoreService();
			Map<String,String> map = core.processRequest(request, response);
			// 发送方帐号（open_id）
			String fromUserName = map.get("FromUserName");
			// 公众帐号
			String toUserName = map.get("ToUserName");
			// 消息类型
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			TextMsg textMsg = new TextMsg();
			// 第一步：按照回复文本信息构造需要的参数
			textMsg.setToUserName(fromUserName);//
			// 发送和接收信息“User”刚好相反
			textMsg.setFromUserName(toUserName);
			textMsg.setCreateTime(new Date().getTime());// 消息创建时间 （整型）
			textMsg.setMsgType("text");// 文本类型消息
			User query = new User();
			query.setOpenId(fromUserName);
			List<User> users = null;
			users = userService.getUserByCondition(query);
			if (users != null && users.size() > 0) {
				query = users.get(0);
				session.setAttribute("user", query);
				if (content.contains("订纸")) {
					textMsg.setContent("您是要去订纸吗?请点击<a href=\""+BASE_ADDRESS+"book/toWantBook.do?openId="+query.getOpenId()+"\">进入订纸页面</a>");
				} else if (content.contains("报修")) {
					textMsg.setContent("您是要报修机器吗?请点击<a href=\""+BASE_ADDRESS+"repair/toRepair.do?openId="+query.getOpenId()+"\">进入报修页面</a>");
				} else if (content.contains("申请记录")) {
					textMsg.setContent("您是要查看申请记录吗?请点击<a href=\""+BASE_ADDRESS+"repair/toMoreRecord.do?openId="+query.getOpenId()+"\">进入申请记录页面</a>");
				} else {
					// 由于href属性值必须用双引号引起，这与字符串本身的双引号冲突，所以要转义
					StringBuffer contentMsg = new StringBuffer();
					contentMsg.append("欢迎使用易佰客服管理系统哟,小E将竭诚为您服务").append("\n");
					contentMsg.append("不过小E现在还不够智能,暂时不能理解您的输入哟,您可以输入订纸,报修,或者申请记录这些关键词哟").append("\n\n");
					textMsg.setContent(contentMsg.toString());
				}
			} else {
				textMsg.setContent("小E提示:您尚未绑定用户信息,请点击<a href=\""+BASE_ADDRESS+"userBinding/toBindUser.do?openId="+fromUserName+"\">进入绑定</a>");
			}
			// // 第二步，将构造的信息转化为微信识别的xml格式【百度：xstream bean转xml】
			textMsg2Xml = core.MsgToString(textMsg);
			// // 第三步，发送xml的格式信息给微信服务器，服务器转发给用户
			out = response.getWriter();
			out.print(textMsg2Xml);
			out.flush();
		} catch (Exception e) {
		} finally{
			out.close();
		}
	}

}
