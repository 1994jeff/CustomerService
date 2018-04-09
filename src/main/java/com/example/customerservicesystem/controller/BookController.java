package com.example.customerservicesystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.customerservicesystem.bean.ApplyRecord;
import com.example.customerservicesystem.bean.Shop;
import com.example.customerservicesystem.bean.User;
import com.example.customerservicesystem.service.RecordService;
import com.example.customerservicesystem.service.ShopService;
import com.example.customerservicesystem.service.UserService;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController {

	Logger logger = LoggerFactory.getLogger(BookController.class);

	@Resource
	RecordService recordService;
	@Resource
	UserService userService;
	@Resource
	ShopService shopService;
	
	@RequestMapping("/toApplyReason.do")
	public String toApplyReason(HttpSession session) {
		User user = getSessionUser(session);
		if(user==null){
			return "redirect:/login/toLogin.do";
		}
		return "main/bookpaper/applyReason";
	}
	
	@RequestMapping("/toBookPaper.do")
	public String toRepair(HttpSession session) {
		User user = getSessionUser(session);
		if(user==null){
			return "redirect:/login/toLogin.do";
		}
		return "main/bookpaper/bookPaper";
	}
	
	@RequestMapping("/toBook.do")
	public String toBook(HttpSession session) {
		User user = getSessionUser(session);
		if(user==null){
			return "redirect:/login/toLogin.do";
		}
		return "main/bookpaper/toBook";
	}
	
	@RequestMapping("/toWantBook.do")
	public String toWantBook(HttpSession session,Model model) {
		User user = getSessionUser(session);
		if(user==null){
			return "redirect:/login/toLogin.do";
		}
		Shop s = new Shop();
		s.setUserNo(user.getUserNo());
		List<Shop> shops = shopService.getShopByCondition(s);
		if (shops != null && shops.size() > 0) {
			model.addAttribute("shop", shops.get(0));
		}
		ApplyRecord applyRecord = new ApplyRecord();
		applyRecord.setUserNo(user.getUserNo());
		List<ApplyRecord> records = recordService.getRecordByCondition(applyRecord);
		if (records != null && records.size() > 0) {
			model.addAttribute("record", records.get(0));
		}
		return "main/bookpaper/wantBook";
	}
}
