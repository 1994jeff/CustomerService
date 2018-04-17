package com.example.customerservicesystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.customerservicesystem.service.KeyWordService;

@Controller
@RequestMapping("/keyWord")
public class KeyWordController extends BaseController{

	
	@Resource
	KeyWordService keyWordService;
	
	
	
}
