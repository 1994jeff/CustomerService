package com.example.customerservicesystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.example.customerservicesystem.bean.User;
/**
 */
@Controller
public class BaseController {

	public User getSessionUser(HttpSession session){
		return (User) session.getAttribute("user");
	}
	
}
