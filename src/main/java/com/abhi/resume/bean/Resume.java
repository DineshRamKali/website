package com.abhi.resume.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Resume {
	
	private static final String name = "Abhishek Shukla Ravishankara";

	private static final String email = "abhishek.shukla.ravi@gmail.com";

	private static final String phone = "+1-631-413-3187";

	private static final String github = "https://github.com/abhishekShukla";

	//private static final String resume_link = "http://abhishukla.com/resume/pdf";
	private static final String resume_link = "http://localhost:8080/website/resume/pdf";

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getGithub() {
		return github;
	}

	public String getResumeLink() {
		return resume_link;
	}
	
	public static byte [] resume_buffer = null;
	
	static {

		//File file = new File("/var/lib/tomcat7/Resume.pdf");
		File file = new File("/Users/abhishek/Dropbox/Resume.pdf");

		resume_buffer = new byte[(int) file.length()];
		InputStream ios = null;
		try {
			ios = new FileInputStream(file);
			if ( ios.read(resume_buffer) == -1 ) {
				throw new IOException("EOF reached while trying to read the whole file");
			}        
		} catch(Exception e){
			e.printStackTrace();
		} 
		finally { 
			try {
				if ( ios != null ) 
					ios.close();
			} catch ( IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
