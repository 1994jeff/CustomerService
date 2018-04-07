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
		return "repair/repair";
	}
	
	@RequestMapping("/toSelfRepair.do")
	public String toSelfRepair(HttpSession session) {
		return "repair/selfRepair";
	}
	
	@RequestMapping("/toReason.do")
	public String toReason(HttpSession session) {
		return "repair/reason";
	}
	
	@RequestMapping("/toRecord.do")
	public String toRecord(HttpSession session) {
		return "repair/record";
	}
	
	@RequestMapping("/toRepairDetails.do")
	public String toRepairDetails(HttpSession session) {
		return "repair/record";
	}
	
	@RequestMapping("/toRepairNofication.do")
	public String toRepairNofication(HttpSession session) {
		return "repair/record";
	}
}
