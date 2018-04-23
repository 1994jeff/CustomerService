package com.example.customerservicesystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.customerservicesystem.bean.Shop;
import com.example.customerservicesystem.bean.User;
import com.example.customerservicesystem.bean.wx.AccessTokenBean;
import com.example.customerservicesystem.service.ShopService;
import com.example.customerservicesystem.service.UserService;
import com.example.customerservicesystem.untils.AccessTokenUtil;

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
	@Resource
	ShopService shopService;
	
	@RequestMapping("/toBindUser.do")
	public String toModifyPsd(HttpSession session,String code,Model model,String openId) {
		String id = "";
		if("".equals(openId)||null==openId){
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
		User ue = null;
		try {
			ue = userService.getUserByOpenId(id);
		} catch (Exception e) {
		}
		if(ue!=null && !ue.getOpenId().equals("")) {
			model.addAttribute("errorMsg","您已经绑定了信息，不可再次绑定哦！");
			return "error/404";
		}
		model.addAttribute("openId", id);
		return "main/binding/user";
	}
	
	@RequestMapping("/toBindShop.do")
	public String toBindShop(HttpSession session,Model model,String code) {
		User u = getSessionUser(session);
		try {
			if(u==null){
				AccessTokenBean bean = AccessTokenUtil.getAccessToken(code);
				User user = userService.getUserByOpenId(bean.getOpenid());
				if(user!=null) {
					session.setAttribute("user", user);
				}else {
					return "redirect:/userBinding/toBindUser.do";
				}
			}else {
				if(u.getOpenId().equals(""))
					return "redirect:/userBinding/toBindUser.do";
			}
		} catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());
			return "error/404";
		}
		return "main/binding/shop";
	}
	
	@RequestMapping("/bindUser.do")
	public String bindUser(HttpSession session,User user,Model model) {
		try {
			User u = userService.getUserByOpenId(user.getOpenId());
			if(u!=null && !u.getOpenId().equals("")){
				session.setAttribute("user", u);
			}else{
				userService.insertUser(user);
				User us = userService.getUserByOpenId(user.getOpenId());
				session.setAttribute("user", us);
				Shop shop = new Shop();
				shop.setUserNo(userService.getUserByOpenId(user.getOpenId()).getUserNo());
				List<Shop> shops= shopService.getShopByCondition(shop );
				if(shops!=null && shops.size()>0) {
					model.addAttribute("errorMsg","您已经绑定了门店信息哦!需要更换请进入更换绑定门店选项!");
					return "error/404";
				}
			}
			
		} catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());
			return "error/404";
		}
		return "main/binding/shop";
	}
	
	@RequestMapping("/bindShop.do")
	public String bindShop(HttpSession session,Shop shop,Model model,String code) {
		try {
			User u = getSessionUser(session);
			if(u==null){
				AccessTokenBean bean = AccessTokenUtil.getAccessToken(code);
				User user = userService.getUserByOpenId(bean.getOpenid());
				if(user!=null) {
					session.setAttribute("user", user);
					u = user;
				}else {
					return "redirect:/userBinding/toBindUser.do";
				}
			}else {
				if(u.getOpenId().equals(""))
					return "redirect:/userBinding/toBindUser.do";
			}
			Shop ss = new Shop();
			ss.setUserNo(u.getUserNo());
			//先查询是否有门店,有则调用修改的方法,没有则创建门店
			shop.setUserNo(u.getUserNo());
			List<Shop> s = shopService.getShopByCondition(ss);
			if(s!=null && s.size()>0){
				shopService.updateShopByCondition(shop);
			}else{
				shopService.insertShop(shop);
			}
		} catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());
			return "error/404";
		}
		return "index";
	}
}
