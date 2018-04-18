package com.example.customerservicesystem.controller;

import java.util.Calendar;
import java.util.Date;
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
import com.example.customerservicesystem.bean.wx.AccessTokenBean;
import com.example.customerservicesystem.service.RecordService;
import com.example.customerservicesystem.service.ShopService;
import com.example.customerservicesystem.service.UserService;
import com.example.customerservicesystem.untils.AccessTokenUtil;
import com.example.customerservicesystem.untils.CalendarUtils;

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
		if (user == null) {
			return "redirect:/login/toLogin.do";
		}
		return "main/bookpaper/applyReason";
	}

	@RequestMapping("/toBookPaper.do")
	public String toRepair(HttpSession session) {
		User user = getSessionUser(session);
		if (user == null) {
			return "redirect:/login/toLogin.do";
		}
		return "main/bookpaper/bookPaper";
	}

	@RequestMapping("/toBookNofication.do")
	public String toBookNofication(HttpSession session, Model model, String num, String reason, String recordNo) {
		User user = getSessionUser(session);
		try {
			if (user == null) {
				return "redirect:/login/toLogin.do";
			}
			ApplyRecord applyRecord = new ApplyRecord();
			if (recordNo == null || recordNo.equals("")) {
				applyRecord.setType("1");
				applyRecord.setApplyMobile(num);
				applyRecord.setApplyName(user.getName());
				if (reason == null || reason.equals("")) {
					applyRecord.setReason("卷纸正常使用完");
				} else {
					applyRecord.setReason(reason);
				}
				applyRecord.setRemark(
						CalendarUtils.getFormatDay(CalendarUtils.getDayAfterDays(Integer.valueOf(num), new Date())));
				applyRecord.setUserNo(user.getUserNo());
				applyRecord.setStatus("0");
				recordService.insertRecord(applyRecord);
			} else {
				applyRecord.setRecordNo(recordNo);
			}
			List<ApplyRecord> re = recordService.getRecordByCondition(applyRecord);
			if (re != null && re.size() > 0) {
				model.addAttribute("record", re.get(0));
			}
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "error/404";
		}
		return "main/bookpaper/bookNofication";
	}

	@RequestMapping("/toBook.do")
	public String toBook(HttpSession session, Model model, String reason) {
		User user = getSessionUser(session);
		if (user == null || user.getUserNo().equals("")) {
			return "redirect:/login/toLogin.do";
		}
		Shop s = new Shop();
		s.setUserNo(user.getUserNo());
		List<Shop> shops = shopService.getShopByCondition(s);
		if (shops != null && shops.size() > 0) {
			model.addAttribute("shop", shops.get(0));
		} else {
			return "redirect:/userBinding/toBindShop.do";
		}
		model.addAttribute("user", user);
		model.addAttribute("reason", reason);
		return "main/bookpaper/toBook";
	}

	@RequestMapping("/toWantBook.do")
	public String toWantBook(HttpSession session, Model model, String openId,String code) {
		try {
			User user = getSessionUser(session);
			if (user == null) {
				if(openId==null || "".endsWith(openId)) {
					AccessTokenBean bean = AccessTokenUtil.getAccessToken(code);
					User ue = userService.getUserByOpenId(bean.getOpenid());
					if(ue!=null) {
						session.setAttribute("user", ue);
					}else {
						return "redirect:/userBinding/toBindUser.do";
					}
				}else {
					User us = userService.getUserByOpenId(openId);
					if(us!=null)
					{
						user = us;
						session.setAttribute("user", user);
					}else{
						throw new Exception("账号信息不存在,请先绑定!");
					}
				}
			}
			Shop s = new Shop();
			s.setUserNo(user.getUserNo());
			List<Shop> shops = shopService.getShopByCondition(s);
			if (shops != null && shops.size() > 0) {
				model.addAttribute("shop", shops.get(0));
			} else {
				return "redirect:/userBinding/toBindShop.do";
			}
			ApplyRecord applyRecord = new ApplyRecord();
			applyRecord.setUserNo(user.getUserNo());
			applyRecord.setType("1");
			applyRecord.setStatus("1");
			List<ApplyRecord> records = recordService.getRecordByCondition(applyRecord);
			if (records != null && records.size() > 0) {
				ApplyRecord applyR = records.get(0);
				// 获取使用截止日期
				Calendar calendar = CalendarUtils.getDayAfterDays(Integer.valueOf(applyR.getApplyMobile()),
						applyR.getCreateTime());
				// 计算截止日期与当前日期的时间差
				int result = CalendarUtils.daysBetween(calendar, new Date());
				if (result < 0) {
					model.addAttribute("days", -result);
				}
				model.addAttribute("record", applyR);
			}
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "error/404";
		}
		return "main/bookpaper/wantBook";
	}
}
