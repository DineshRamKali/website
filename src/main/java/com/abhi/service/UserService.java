package com.abhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abhi.dao.IUsersDao;
import com.abhi.dao.User;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private IUsersDao usersDao;

	@Autowired
	private MailSender mailSender;

	public void create(User user){

		//DebugUtils.transactionRequired("UserService.create");
		usersDao.create(user);
	}

	@Override
	public boolean exists(String username) {
		return usersDao.exists(username);
	}
	
	@Override
	public boolean emailExists(String email) {
		if (usersDao.getEmail(email) != null){
			return true;
		}
		return false;
	}

	public boolean verifyLogin(String username, String password) {    	
		return usersDao.verifyLogin(username, password);
	}

	@Override
	public User emailVerify(String access) {
		return usersDao.emailVerify(access);
	}

	@Override
	public boolean email(User user) {

		SimpleMailMessage message = new SimpleMailMessage();

		String from = "abhishek.shukla.ravi@gmail.com";
		message.setFrom(from);

		message.setTo(user.getEmail());

		String subject = "Qookie Account Activation";
		message.setSubject(subject);

		String msg = "Dear " + user.getUsername() + "," + "\n\n" +  

					  "Thank you for opening an account with Qookie." + "\n" +

					  "Please click on the following link to activate your account. " + "\n" + 

					  "If you did not expect to receive this e-mail, please ignore" + "\n\n" +

					  //"http://localhost:8080/website/verify?id=" + user.getUuid() + "\n\n" +
					  "http://abhishukla.com/verify?id=" + user.getUuid() + "\n\n" +

					  "Regards," + "\n" +

					  "Qookie team";

		message.setText(msg);

		try{
			this.mailSender.send(message);
		}
		catch(MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());            
		}

		return false;
	}
	
	public User getUserByUsername(String username)
			throws UsernameNotFoundException {
		
		User user = usersDao.getUser(username);
		
		if(user != null){
			return user;
		} else {
			throw new UsernameNotFoundException(username + " not found!");
		}
		
	}

}
