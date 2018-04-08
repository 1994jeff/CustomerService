package com.example.customerservicesystem.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController {

	Logger logger = LoggerFactory.getLogger(BookController.class);

	@RequestMapping("/toApplyReason.do")
	public String toApplyReason(HttpSession session) {
		return "main/bookpaper/applyReason";
	}
	
	@RequestMapping("/toBookPaper.do")
	public String toRepair(HttpSession session) {
		return "main/bookpaper/bookPaper";
	}
	
	@RequestMapping("/toBook.do")
	public String toBook(HttpSession session) {
		return "main/bookpaper/toBook";
	}
	
	@RequestMapping("/toWantBook.do")
	public String toWantBook(HttpSession session) {
		return "main/bookpaper/wantBook";
	}
}
