package com.example.customerservicesystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.customerservicesystem.bean.ApplyRecord;
import com.example.customerservicesystem.bean.RetParam;
import com.example.customerservicesystem.bean.Shop;
import com.example.customerservicesystem.bean.User;
import com.example.customerservicesystem.bean.wx.AccessTokenBean;
import com.example.customerservicesystem.service.RecordService;
import com.example.customerservicesystem.service.ShopService;
import com.example.customerservicesystem.service.UserService;
import com.example.customerservicesystem.untils.AccessTokenUtil;
import com.example.customerservicesystem.untils.FileUtils;

import net.sf.json.JSONObject;

/**
 *登录控制器
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	UserService userService;
	@Resource
	RecordService recordService;
	@Resource
	ShopService shopService;
	
	@RequestMapping("/toIndex.do")
	public String toIndex(HttpSession session,Model model,HttpServletRequest req,String openId,String code){
		try {
			User user = getSessionUser(session);
			if(user==null || user.getOpenId().equals(""))
			{
				String id = "";
				if(null==openId||"".equals(openId)){
					if(code==null || "".equals(code)) {
						//model.addAttribute("errorMsg","获取您的code失败，请尝试退出重新进入");
						//return "error/404";
					}else{
						AccessTokenBean bean = AccessTokenUtil.getAccessToken(code);
						id = bean.getOpenid();
					}
				}else{
					id = openId;
				}
				FileUtils.insertFile("user", "id="+id+"\n"+",openId="+openId+",code="+code);
				User ser = userService.getUserByOpenId(id);
				if(ser==null){
					model.addAttribute("errorMsg","账号信息不存在,请先绑定!");
					return "error/404";
				}else{
					user = ser;
					session.setAttribute("user",ser);
				}
			}
		
		//绑定用户查找是否绑定店铺,未绑定则跳转绑定店铺
		Shop shop = new Shop();
		shop.setUserNo(user.getUserNo());
		List<Shop> shops = shopService.getShopByCondition(shop );
		if(shops==null || shops.size()<=0){
			return "redirect:/userBinding/toBindShop.do";
		}
		
		//所有数据绑定了则进入首页
			List<User> u = userService.getUserByCondition(user);
			log.debug("-----------------------u-----------------------"+req.getMethod());
			ApplyRecord applyRecord = new ApplyRecord();
			applyRecord.setUserNo(u.get(0).getUserNo());
			List<ApplyRecord> records = recordService.getRecordByCondition(applyRecord );
			model.addAttribute("user",u.get(0));
			model.addAttribute("records", records);
			//全局存储user,可以通过getAttribute方法取出
			session.setAttribute("user", u.get(0));
			
		} catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());
			return "error/404";
		}
		return "index";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "../../index";
	}
	@RequestMapping("/toExit.do")
	public String toExit(HttpSession session){
		session.removeAttribute("user");
		User user = (User) session.getAttribute("user");
		if(user!=null){
			session.setAttribute("user", null);
		}
		return "../../index";
	}
	
	@RequestMapping(value="/toCheckLogin.do",method=RequestMethod.POST)
	@ResponseBody
	public String toCheckLogin(User user,HttpSession session){
		RetParam<Object> param = new RetParam<Object>();
		try {
			param.setRetCode("200");
		} catch (Exception e) {
			param.setRetMsg(e.getMessage());
			param.setRetCode("201");
		}
		return JSONObject.fromObject(param).toString();
	}
	
}
