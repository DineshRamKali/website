package com.abhi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhi.dao.FormValidationGroup;
import com.abhi.dao.Quotes;
import com.abhi.dao.User;
import com.abhi.service.IQuotesService;
import com.abhi.service.IUserService;

@Controller
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserDetailsService myUsersDetailsService;
	
	@Autowired
	private IQuotesService quotesService;


	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/logout")
	public String showLogout(){
		return "logout";
	}
	
	@RequestMapping("/newAccount")
	public String showNewAccount(Model model){
		model.addAttribute("user", new User());
		return "newAccount";
	}
	
	@RequestMapping(value="/createAccount", method=RequestMethod.POST)
	public String showCreateAccount(Model model, @Validated(FormValidationGroup.class) User user, 
				BindingResult result){
		
		if(result.hasErrors()){
			return "newAccount";
		}
		
		if(userService.exists(user.getUsername())){
			result.rejectValue("username", "Duplicate.user.username", "Username already exists");
			return "newAccount";
		}
		
		if(userService.emailExists(user.getEmail())){
			result.rejectValue("email", "Duplicate.user.email", "Email already exists");
			return "newAccount";
		}
		
		user.setUuid(java.util.UUID.randomUUID().toString());
		user.setAuthority("user");
		user.setEnabled(true);
		
		try{
			userService.create(user);
			userService.email(user);
		} catch(DuplicateKeyException e){
			result.rejectValue("username", "Duplicate.user.username");
			return "newAccount";
		}
		
		return "accountCreated";
	}
	
	@RequestMapping(value="/verify", method=RequestMethod.GET)
	public String showVerifiedAccount(Model model, @RequestParam String id, Principal principal){
		
		User user = userService.emailVerify(id);
		
		Quotes quotes = new Quotes();
		
		if(user != null && user.isEnabled() && principal.getName().equals(user.getUsername())){
			
			System.out.println(principal.getName());
			
			Quotes userQuotes = quotesService.getQuotes(user.getUuid());
							
			quotes.setUser(user);			
			model.addAttribute("quotes", quotes);
			model.addAttribute("username", user.getUsername());
			
			
			if(userQuotes == null){
				model.addAttribute("quotesOfUser", "No Quotes Yet!");
			} else {
				quotes.setQuotes(userQuotes.getQuotes());
				model.addAttribute("quotesOfUser",userQuotes.getQuotes());
			}
			
			
			UserDetails userDetails = myUsersDetailsService.loadUserByUsername(user.getUsername());
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken (userDetails, user.getPassword(), 
						userDetails.getAuthorities());
			
			if(auth.isAuthenticated()) {
			    SecurityContextHolder.getContext().setAuthentication(auth);
			}
			
			return "qookie";
			
		} else {
			System.out.println("Here!");
			return "error";
		}
		
	}
}
