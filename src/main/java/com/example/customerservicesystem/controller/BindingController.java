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
	public String toModifyPsd(HttpSession session,String code,Model model) {
		if("".equals(code)) {
			model.addAttribute("errorMsg","获取您的code失败，请尝试退出重新进入");
			return "error/404";
		}
		AccessTokenBean bean = AccessTokenUtil.getAccessToken(code);
		model.addAttribute("openId", bean.getOpenid());
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
			userService.insertUser(user);
			User u = userService.getUserByOpenId(user.getOpenId());
			if(u!=null){
				session.setAttribute("user", user);
				Shop shop = new Shop();
				shop.setUserNo(user.getUserNo());
				List<Shop> shops= shopService.getShopByCondition(shop );
				if(shops!=null && shops.size()>0) {
					return "redirect:/login/toIndex.do";
				}
			}else{
				throw new Exception("获取您的openId失败，请尝试退出重新进入绑定");
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
				}else {
					return "redirect:/userBinding/toBindUser.do";
				}
			}else {
				if(u.getOpenId().equals(""))
					return "redirect:/userBinding/toBindUser.do";
			}
			shop.setUserNo(u.getUserNo());
			//先查询是否有门店,有则调用修改的方法,没有则创建门店
			List<Shop> s = shopService.getShopByCondition(shop);
			if(s!=null && s.size()>0){
				shopService.updateShopByCondition(shop);
			}else{
				shopService.insertShop(shop);
			}
			List<Shop> ss = shopService.getShopByCondition(shop);
			if(ss!=null && ss.size()>0){
				session.setAttribute("shop", ss.get(0));
			}else{
				return "redirect:/userBinding/toBindShop.do";
			}
		} catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());
			return "error/404";
		}
		return "index";
	}
}
