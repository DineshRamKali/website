package com.abhi.controller;

import java.security.Principal;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abhi.dao.CustomAuthenticationProvider;
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
	
	@Autowired 
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	@RequestMapping("/qookie")
	public String showQookie(Locale locale, Model model, Principal principal){
		
		Quotes quotes = new Quotes();
		String username = principal.getName();
		
		User user = userService.getUserByUsername(username);		
		quotes.setUser(user);
		
		model.addAttribute("quotes", quotes);
		model.addAttribute("username",username);
		
		return "qookie";
	}

	
	@RequestMapping(value="/qookie/create", method=RequestMethod.POST)
	public String createQookie(Model model, @Validated(FormValidationGroup.class) Quotes quotes, 
			BindingResult result, Principal principal){
		
		if(result.hasErrors()){
			return "qookie";
		}
		
		String username = principal.getName();		
		
		User user = userService.getUserByUsername(username);		
		quotes.setUser(user);
		quotesService.create(quotes);
		
		model.addAttribute("username",username);
		return "qookie";
	}
	
	@RequestMapping(value="/getQookie", method=RequestMethod.GET)
	@ResponseBody
	public String getRandomQuote(@RequestParam("id") String id){
		
		String randomQuote = null;		
		randomQuote = quotesService.getRandomQuote(id);		
		return randomQuote;
		
	}
	
}
