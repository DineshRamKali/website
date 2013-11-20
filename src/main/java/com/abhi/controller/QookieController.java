package com.abhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QookieController {
	
	@RequestMapping("/qookie")
	public String showQookie(){
		return "qookie";
	}
	
}
