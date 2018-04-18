package com.example.customerservicesystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.record.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.example.customerservicesystem.untils.CalendarUtils;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/repair")
public class RepairController extends BaseController {

	Logger logger = LoggerFactory.getLogger(RepairController.class);

	@Resource
	RecordService recordService;
	@Resource
	UserService userService;
	@Resource
	ShopService shopService;

	@RequestMapping("/toRepair.do")
	public String toRepair(HttpSession session, String openId, Model model,String code) {
		User user = getSessionUser(session);
		try {
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
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "error/404";
		}
		return "main/repair/repair";
	}

	@RequestMapping("/toSelfRepair.do")
	public String toSelfRepair(HttpSession session, Model model) {
		User user = getSessionUser(session);
		if (user == null) {
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
		// ApplyRecord applyRecord = new ApplyRecord();
		// applyRecord.setUserNo(user.getUserNo());
		// List<ApplyRecord> records =
		// recordService.getRecordByCondition(applyRecord);
		// if (records != null && records.size() > 0) {
		// model.addAttribute("record", records.get(0));
		// }
		return "main/repair/selfrepair";
	}

	@RequestMapping("/toReason.do")
	public String toReason(HttpSession session) {
		User user = getSessionUser(session);
		if (user == null) {
			return "redirect:/login/toLogin.do";
		}
		return "main/repair/reason";
	}

	@RequestMapping("/toRecord.do")
	public String toRecord(HttpSession session, String userNo, Model model) {
		User user = getSessionUser(session);
		if (user == null) {
			return "redirect:/login/toLogin.do";
		}
		ApplyRecord applyRecord = new ApplyRecord();
		applyRecord.setUserNo(userNo);
		applyRecord.setType("0");
		List<ApplyRecord> records = recordService.getRecordByCondition(applyRecord);
		model.addAttribute("records", records);
		return "main/repair/record";
	}

	@RequestMapping("/toRepairDetails.do")
	public String toRepairDetails(HttpSession session) {
		User user = getSessionUser(session);
		if (user == null) {
			return "redirect:/login/toLogin.do";
		}
		return "main/repair/repairDetails";
	}

	@RequestMapping("/toRepairNofication.do")
	public String toRepairNofication(HttpSession session, String name, Model model, String recordNo) {
		User user = getSessionUser(session);
		try {
			if (user == null) {
				return "redirect:/login/toLogin.do";
			}
			ApplyRecord applyRecord = new ApplyRecord();
			// 记录号为空则插入数据否则查询
			if (recordNo == null || recordNo.equals("")) {
				applyRecord.setType("0");
				applyRecord.setApplyMobile(user.getRemark());
				applyRecord.setApplyName(user.getName());
				applyRecord.setReason(name);
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
		return "main/repair/repairNofication";
	}

	@RequestMapping("/toMoreRecord.do")
	public String toMoreRecord(HttpSession session, String userNo, Model model, String openId,String code) {
		User user = getSessionUser(session);
		try {
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
			ApplyRecord applyRecord = new ApplyRecord();
			applyRecord.setUserNo(userNo);
			List<ApplyRecord> records = recordService.getRecordByCondition(applyRecord);
			model.addAttribute("records", records);
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "error/404";
		}
		return "main/common/record";
	}

}
