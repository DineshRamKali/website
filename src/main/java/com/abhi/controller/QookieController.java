package com.abhi.controller;

import java.security.Principal;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	private UserDetailsService myUsersDetailsService;
	
	@Autowired 
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	@RequestMapping("/qookie")
	public String showQookie(Locale locale, Model model, Principal principal){
		
		Quotes quotes = new Quotes();
		String username = principal.getName();
		
		User user = userService.getUserByUsername(username);

		Quotes userQuotes = quotesService.getQuotes(user.getUuid());
		quotes.setUser(user);
		
		model.addAttribute("quotes", quotes);
		model.addAttribute("username",username);
		
		if(userQuotes != null){
			quotes.setQuotes(userQuotes.getQuotes());
			model.addAttribute("quotesOfUser", userQuotes.getQuotes());
		} else {
			model.addAttribute("quotesOfUser", "No Quotes Yet!");
		}
		
		
		
		return "qookie";
	}

	
	@RequestMapping(value="/qookie/create", method=RequestMethod.POST)
	public String createQookie(Model model, @Validated(FormValidationGroup.class) Quotes quotes, 
			BindingResult result, Principal principal){
		
		if(result.hasErrors()){
			
			String username = principal.getName();
			model.addAttribute("username",username);
			User user = userService.getUserByUsername(username);		
			quotes.setUser(user);
			return "qookie";
		}
		
		String username = principal.getName();				
		User user = userService.getUserByUsername(username);		
		quotes.setUser(user);
		quotesService.create(quotes);
		model.addAttribute("username",username);
		
		return "qookie";
	}
	
	@RequestMapping(value="/getQookie/{username}", method=RequestMethod.GET)
	@ResponseBody
	public String getRandomQuote(@PathVariable(value="username") String username){
		
		String randomQuote = null;		
		
		User user = userService.getUserByUsername(username);
		
		UserDetails userDetails = myUsersDetailsService.loadUserByUsername(user.getUsername());
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken (userDetails, user.getPassword(), 
					userDetails.getAuthorities());
		
		if(auth.isAuthenticated()) {
		    SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		randomQuote = quotesService.getRandomQuote(user.getUuid());
		
		return randomQuote;
		
	}
	
}
