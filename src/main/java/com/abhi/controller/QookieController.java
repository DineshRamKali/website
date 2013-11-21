package com.abhi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abhi.dao.FormValidationGroup;
import com.abhi.dao.Quotes;
import com.abhi.dao.User;
import com.abhi.service.IQuotesService;
import com.abhi.service.IUserService;

@Controller
public class QookieController {
	
	@Autowired
	private IQuotesService quotesService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/qookie")
	public String showQookie(Model model){
		model.addAttribute("quotes", new Quotes());
		return "qookie";
	}

	
	@RequestMapping(value="/qookie/create", method=RequestMethod.POST)
	public String createQookie(Model model, @Validated(FormValidationGroup.class) Quotes quotes, 
			BindingResult result, Principal principal){
		
		if(result.hasErrors()){
			return "qookie";
		}
		
		String username = principal.getName();		
		System.out.println(username);
		
		User user = userService.getUserByUsername(username);		
		quotes.setUser(user);
		System.out.println(quotes);
		quotesService.create(quotes);
		
		
		return "qookie";
	}
	
}
