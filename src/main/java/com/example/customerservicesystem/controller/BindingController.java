package com.example.customerservicesystem.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.customerservicesystem.bean.User;
import com.example.customerservicesystem.service.UserService;

/**
 * 用户数据绑定控制器 
 * 1.首先插入user表
 * 2.插入shop信息
 */
@Controller
@RequestMapping("/userBinding")
public class BindingController extends BaseController {

	Logger logger = LoggerFactory.getLogger(BindingController.class);
	
	@Resource
	UserService userService;
	
	@RequestMapping("/toBindUser.do")
	public String toModifyPsd(HttpSession session,User user,Model model) {
		return "main/binding/user";
	}
	
	@RequestMapping("/toBindShop.do")
	public String toBindShop(HttpSession session,User user,Model model) {
		return "main/binding/shop";
	}
	
	@RequestMapping("/bindUser.do")
	public String bindUser(HttpSession session,User user,Model model) {
		try {
			user.setOpenId(new Date().getTime()+"");
			userService.insertUser(user);
			List<User> u = userService.getUserByCondition(user);
			if(u!=null && u.size()>0){
				session.setAttribute("user", user);
			}else{
				return "redirect:/userBinding/toBindUser.do";
			}
		} catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());
			return "error/404";
		}
		return "main/binding/shop";
	}
	
}
