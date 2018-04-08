package com.example.customerservicesystem.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/repair")
public class RepairController {

	Logger logger = LoggerFactory.getLogger(RepairController.class);
	
	@RequestMapping("/toRepair.do")
	public String toRepair(HttpSession session) {
		return "main/repair/repair";
	}
	
	@RequestMapping("/toSelfRepair.do")
	public String toSelfRepair(HttpSession session) {
		return "main/repair/selfrepair";
	}
	
	@RequestMapping("/toReason.do")
	public String toReason(HttpSession session) {
		return "main/repair/reason";
	}
	
	@RequestMapping("/toRecord.do")
	public String toRecord(HttpSession session) {
		return "main/repair/record";
	}
	
	@RequestMapping("/toRepairDetails.do")
	public String toRepairDetails(HttpSession session) {
		return "main/repair/repairDetails";
	}
	
	@RequestMapping("/toRepairNofication.do")
	public String toRepairNofication(HttpSession session) {
		return "main/repair/repairNofication";
	}
	
	@RequestMapping("/toMoreRecord.do")
	public String toMoreRecord(HttpSession session) {
		return "main/repair/repairNofication";
	}
}
