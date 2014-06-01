package com.abhi.resume;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Resume {
	
	public Resume(){
		
		this.name = "Abhishek Shukla Ravishankara";
		this.email = "abhishek.shukla.ravi@gmail.com";
		this.github = "https://github.com/abhishekShukla";
		this.phone = "+1-631-413-3187"; 
		this.resume_link = "http://abhishukla.com/resume/pdf";
		//this.resume_link = "http://localhost:8080/website/resume/pdf";
		this.website = "http://www.abhishukla.com";
		
		
		School undergraduate = new School("National Institute of Engineering, Mysuru, India", 
										  "Bachelors in Electronics and Communication", 
										  "August, 2005", "May, 2009");
		
		School masters_ce = new School("Stony Brook University, NY, USA",
									   "Masters in Computer Engineering", 
									   "August, 2010", "December, 2011");
		
		School masters_cs = new School("Stony Brook University, NY, USA", 
									   "Masters in Computer Science", 
									   "August, 2011", "December, 2012");
		
		this.education = new ArrayList<School>();
		this.education.add(undergraduate);
		this.education.add(masters_ce);
		this.education.add(masters_cs);
		
		this.languages = new ArrayList<String>(
						Arrays.asList("C", "Java", "HTML", "Javascript","Scala"));
		
		this.tools = new ArrayList<String>(
						Arrays.asList("Git", "Eclipse", "Jira", "Mule ESB", "Tomcat", "Stanford Parser"));
		
		this.storage = new ArrayList<String>(Arrays.asList("MySQL", "MongoDB", "Elastic Search"));
		
		this.frameworks = new ArrayList<String>(
				Arrays.asList("Hibernate", "Spring - MVC, Security, Social", "Play!", "Akka"));
		
		List<String> tesco_description = new ArrayList<String>();
		
		tesco_description.add("Functional and Performance tester to test the end "
				+ "to end cycle of Tesco’s Space, Range and Display process");		
		tesco_description.add("Black Box testing, Smoke testing and Unit testing");
		tesco_description.add("Tested JDA applications -Space Planning and Floor Planning, "
				+ "Oracle application - RPAS (Retail Predictive Application Server)");
		
		Work tesco = new Work("Tesco HSC, Bengaluru, India", "Associate Software Engineer", 
								tesco_description, "January, 2010", "August, 2010");
		
		List<String> ca_intern_description = new ArrayList<String>();
		
		ca_intern_description.add("Designed and developed a test automation suite "
				+ "using Apache REST API’s to test the IT Automation system");
		ca_intern_description.add("Mentored fellow students by acting as a scrum "
				+ "master in an agile development setting");
		
		Work ca_intern = new Work("CA Technologies, Stony Brook, NY", "Software Developer Intern", 
				ca_intern_description, "January, 2012", "December 2012");
		
		List<String> ca_description = new ArrayList<String>();
		
		ca_description.add("Developing a standard security analytics "
				+ "engine by correlating data from different sources");
		ca_description.add("Create flows in Mule ESB to handle REST requests, "
				+ "create notifications when anomalies occur");
		ca_description.add("Designed the model entities and their life cycle. "
				+ "Implemented CRUD operations using Hibernate "
				+ "and REST requests over these models.");
		ca_description.add("Building agent-less connectors to Splunk, OSSIM (Open Source SIM) "
				+ "and a CA Mobile Security Product (currently under development) to collect "
				+ "data and run queries against the collected data to answer high level questions");
		
		Work ca = new Work("CA Technologies, Stony Brook, NY", "Software Engineer", 
				ca_description, "February, 2013", "Present");	
		
		this.work_experience = new ArrayList<Work>();
		this.work_experience.add(tesco);
		this.work_experience.add(ca_intern);
		this.work_experience.add(ca);
		
		Project comorbidity = new Project("Comorbidity", 
				"A Java based web application designed to analyze lab results and records "
				+ "(stored in Cerner’s database) to indicate the presence of medical conditions "
				+ "that a patient might be facing.");
		
		Project nlp = new Project("Detecting news sources and media bias", 
							"A Java based application designed to detect a news source and "
							+ "the media bias using natural language processing techniques. "
							+ "Different statistical techniques like Probabilistic Context Free Grammar, "
							+ "N-Gram models, Typed Dependencies and Bag of Words were explored.");
		
		Project os1 = new Project("System Call Inherit", 
				"Implemented a new policy to make a new process and "
				+ "its child processes use an entirely new set of system call "
				+ "vectors atomically. Designed and implemented a new mechanism "
				+ "to intercept all system calls and overrides the global system call "
				+ "table by maintaining per-process system call vector information.");
		
		Project os2 = new Project("	File Data Encryption and implementation of Address Space Operations", 
				"Implemented various address space operations to enable WRAPFS (a stackable file system) have "
				+ "individual data pages at the upper layer with different data from those at the lower layer. "
				+ "Added security features to these new address space operations so that data in the lower layer "
				+ "pages stay encrypted and those in the upper layer are always decrypted. ");
		
		this.academic_projects = new ArrayList<Project>();
		academic_projects.add(comorbidity);
		academic_projects.add(nlp);
		academic_projects.add(os1);
		academic_projects.add(os2);
		
		Project butler = new Project("Butler – a search for your digital world ", 
				"Butler collects users notes (from Evernote), documents (Google drive), "
				+ "saved web pages (Pocket, Readability), Twitter favorites and so on. "
				+ "This content is made searchable using Elastic Search. ");
		
		this.personal_projects = new ArrayList<Project>();
		personal_projects.add(butler);
		
	}
	
	private String name;

	private String email;

	private String phone;

	private String github;
	
	private String resume_link;
	
	private String website;
	
	private List<School> education;
	
	private List<Work> work_experience;
	
	private List<Project> projects;
	
	private List<String> languages;
	
	private List<String> storage;
	
	private List<String> tools;
	
	private List<String> frameworks;
	
	private List<Project> academic_projects;
	
	private List<Project> personal_projects;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getResume_link() {
		return resume_link;
	}

	public void setResume_link(String resume_link) {
		this.resume_link = resume_link;
	}	

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<School> getEducation() {
		return education;
	}

	public void setEducation(List<School> education) {
		this.education = education;
	}

	public List<Work> getWork_experience() {
		return work_experience;
	}

	public void setWork_experience(List<Work> work_experience) {
		this.work_experience = work_experience;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getStorage() {
		return storage;
	}

	public void setStorage(List<String> storage) {
		this.storage = storage;
	}

	public List<String> getTools() {
		return tools;
	}

	public void setTools(List<String> tools) {
		this.tools = tools;
	}

	public List<String> getFrameworks() {
		return frameworks;
	}

	public void setFrameworks(List<String> frameworks) {
		this.frameworks = frameworks;
	}

	public List<Project> getAcademic_projects() {
		return academic_projects;
	}

	public void setAcademic_projects(List<Project> academic_projects) {
		this.academic_projects = academic_projects;
	}

	public List<Project> getPersonal_projects() {
		return personal_projects;
	}

	public void setPersonal_projects(List<Project> personal_projects) {
		this.personal_projects = personal_projects;
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
