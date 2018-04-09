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
import com.example.customerservicesystem.service.RecordService;
import com.example.customerservicesystem.service.ShopService;
import com.example.customerservicesystem.service.UserService;

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
	public String toRepair(HttpSession session) {
		User user = getSessionUser(session);
		if(user==null){
			return "redirect:/login/toLogin.do";
		}
		return "main/repair/repair";
	}

	@RequestMapping("/toSelfRepair.do")
	public String toSelfRepair(HttpSession session, Model model) {
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
		model.addAttribute("user", user);
//		ApplyRecord applyRecord = new ApplyRecord();
//		applyRecord.setUserNo(user.getUserNo());
//		List<ApplyRecord> records = recordService.getRecordByCondition(applyRecord);
//		if (records != null && records.size() > 0) {
//			model.addAttribute("record", records.get(0));
//		}
		return "main/repair/selfrepair";
	}

	@RequestMapping("/toReason.do")
	public String toReason(HttpSession session) {
		User user = getSessionUser(session);
		if(user==null){
			return "redirect:/login/toLogin.do";
		}
		return "main/repair/reason";
	}

	@RequestMapping("/toRecord.do")
	public String toRecord(HttpSession session, String userNo, Model model) {
		User user = getSessionUser(session);
		if(user==null){
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
		if(user==null){
			return "redirect:/login/toLogin.do";
		}
		return "main/repair/repairDetails";
	}

	@RequestMapping("/toRepairNofication.do")
	public String toRepairNofication(HttpSession session,String name,Model model) {
		User user = getSessionUser(session);
		try {
			if(user==null){
				return "redirect:/login/toLogin.do";
			}
			ApplyRecord applyRecord = new ApplyRecord();
			applyRecord.setType("0");
			applyRecord.setApplyMobile(user.getRemark());
			applyRecord.setApplyName(user.getName());
			applyRecord.setReason(name);
			applyRecord.setUserNo(user.getUserNo());
			applyRecord.setStatus("0");
			recordService.insertRecord(applyRecord );
			List<ApplyRecord> re = recordService.getRecordByCondition(applyRecord);
			if(re!=null && re.size()>0){
				model.addAttribute("record",re.get(0));
			}
		} catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());
			return "error/404";
		}
		return "main/repair/repairNofication";
	}

	@RequestMapping("/toMoreRecord.do")
	public String toMoreRecord(HttpSession session, String userNo, Model model) {
		User user = getSessionUser(session);
		if(user==null){
			return "redirect:/login/toLogin.do";
		}
		ApplyRecord applyRecord = new ApplyRecord();
		applyRecord.setUserNo(userNo);
		List<ApplyRecord> records = recordService.getRecordByCondition(applyRecord);
		model.addAttribute("records", records);
		return "main/common/record";
	}
	
}
