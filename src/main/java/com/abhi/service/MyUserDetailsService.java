package com.abhi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abhi.dao.IUsersDao;
import com.abhi.dao.User;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUsersDao usersDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = usersDao.getUser(username);

		if(user != null){
			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			UserDetails UdUser = new org.springframework.security.core.userdetails.User(user.getUsername(), 
					user.getPassword(), user.isEnabled(), true, true, 
					true, grantedAuths); 
			
			return UdUser;
		} else {
			throw new UsernameNotFoundException(username + " not found!");	
		}


	}

}
