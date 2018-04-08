package com.example.customerservicesystem.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userBinding")
public class BindingController extends BaseController {

	Logger logger = LoggerFactory.getLogger(BindingController.class);
	
	@RequestMapping("/toBindUser.do")
	public String toModifyPsd(HttpSession session) {
		return "main/binding/user";
	}
	
}
