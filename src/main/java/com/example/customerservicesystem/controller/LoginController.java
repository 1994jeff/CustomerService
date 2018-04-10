package com.example.customerservicesystem.controller;

import java.util.List;

import javax.annotation.Resource;
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
import com.example.customerservicesystem.bean.User;
import com.example.customerservicesystem.service.RecordService;
import com.example.customerservicesystem.service.UserService;

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
	
	@RequestMapping("/toIndex.do")
	public String toIndex(HttpSession session,Model model){
		User user = getSessionUser(session);
		//TODO 根据微信id查找是否已经绑定用户,未绑定则跳转
		if(null==user || user.getUserNo().equals(""))
		{
//			user = new User();
//			user.setUserNo("1");
			return "redirect:/userBinding/toBindUser.do";
		}
			//绑定用户查找是否绑定店铺,未绑定则跳转绑定店铺
			//return "redirect:/userBinding/toBindUser.do";

		//所有数据绑定了则进入首页
		try {
			List<User> u = userService.getUserByCondition(user);
			log.debug("-----------------------u-----------------------"+u.toString());
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
