package com.example.customerservicesystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.customerservicesystem.untils.SHA1;

/**
 * 微信接入流程
 * 1.公众平台配置服务器接口token等数据
 * 2.开发服务器get接口验证微信传送过来的数据,成为开发者 
 * 3.获取微信access_token,注意提前设置IP白名单
 */
@Controller
@RequestMapping("/weixin")
public class WXController extends BaseController {

	Logger log = LoggerFactory.getLogger(WXController.class);
	
    private static String Token = "yibaikefu";  //这个是之前在微信上填写的Token数据，可以自定义  
    String eEncodingAESKey = "bK7or2cZtNoJTm8GTss4TQHP8hMONjTIwBuaIHlUOWF";
    private static String encode = "k5e77FFfiI2Si84lkSA7Z9uhet0TfLk7NXc62HfMi3c";  //这个是之前在微信上填写的Token数据，可以自定义  
    
	// 与微信服务器传送过来的数据进行验证,成功后方才成为开发者,可调用接口
	@RequestMapping("/checkdev.do")
	public void checkDev(String signature,String timestamp,String nonce,String echostr,HttpSession session,HttpServletResponse response) {
		log.debug("get请求，正确");
		log.debug("获得微信请求!");
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
		Collections.sort(params, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
		String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));
		if (temp.equals(signature)) {
			log.debug("原:" + signature);
			log.debug("测试:" + temp);
			log.debug("匹配正确，传回微信了");
			try {
				response.getWriter().write(echostr);
			} catch (IOException e) {
			}
			log.debug("传回微信成功");
		} else {
			log.debug("没有传回去数据，");
		}
	}

}
