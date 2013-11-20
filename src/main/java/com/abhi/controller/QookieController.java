package com.abhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abhi.dao.Quotes;
import com.abhi.service.IQuotesService;

@Controller
public class QookieController {
	
	@Autowired
	private IQuotesService quotesService;
	
	@RequestMapping("/qookie")
	public String showQookie(){
		return "qookie";
	}
	
	@RequestMapping(value="/qookie/create", method=RequestMethod.POST)
	public String createQookie(Model model, Quotes quotes){
		System.out.println(quotes);
		quotesService.create(quotes);
		return "qookie";
	}
	
}
