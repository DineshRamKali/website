package com.abhi.dao;

public interface IUsersDao {
	
	public void create(User user);

	public boolean exists(String username);
	
	public User getUser(String username);
	
	public boolean verifyLogin(String username, String password);
	
	public User emailVerify(String access);
	
	public String getEmail(String email);
	
}
