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
		this.website = "http://www.abhishukla.com";
		
		
		School undergraduate = new School("National Institute of Engineering, Mysuru, India", 
										  "Bachelors in Electronics and Communication", 
										  "August, 2005", "May, 2009");
		
		School mastersCe = new School("Stony Brook University, NY, USA",
									   "Masters in Computer Engineering", 
									   "August, 2010", "December, 2011");
		
		School mastersCs = new School("Stony Brook University, NY, USA", 
									   "Masters in Computer Science", 
									   "August, 2011", "December, 2012");
		
		this.education = new ArrayList<School>();
		this.education.add(undergraduate);
		this.education.add(mastersCe);
		this.education.add(mastersCs);
		
		this.languages = new ArrayList<String>(
						Arrays.asList("C", "Java", "HTML", "Javascript","Scala"));
		
		this.tools = new ArrayList<String>(
						Arrays.asList("Git", "Eclipse", "Jira", "Mule ESB", "Tomcat", "Stanford Parser"));
		
		this.storage = new ArrayList<String>(Arrays.asList("MySQL", "MongoDB", "Elastic Search", "Cassandra"));
		
		this.frameworks = new ArrayList<String>(
				Arrays.asList("Hibernate", "Spring - Boot, MVC, Security, Social", "Play!", "Akka", "Kafka"));
		
		List<String> tescoDescription = new ArrayList<String>();
		
		tescoDescription.add("Functional and Performance tester to test the end "
				+ "to end cycle of Tesco’s Space, Range and Display process");		
		tescoDescription.add("Black Box testing, Smoke testing and Unit testing");
		tescoDescription.add("Tested JDA applications -Space Planning and Floor Planning, "
				+ "Oracle application - RPAS (Retail Predictive Application Server)");
		
		Work tesco = new Work("Tesco HSC, Bengaluru, India", "Associate Software Engineer", 
								tescoDescription, "January, 2010", "August, 2010");
		
		List<String> caInternDescription = new ArrayList<String>();
		
		caInternDescription.add("Designed and developed a test automation suite "
				+ "using Apache REST API’s to test the IT Automation system");
		caInternDescription.add("Mentored fellow students by acting as a scrum "
				+ "master in an agile development setting");
		
		Work caIntern = new Work("CA Technologies, Stony Brook, NY", "Software Developer Intern", 
				caInternDescription, "January, 2012", "December 2012");
		
		List<String> caDescription = new ArrayList<String>();
		
		caDescription.add("Prospector: Standard security analytics "
				+ "engine by correlating data from different sources, Create flows in "
				+ "Mule ESB to handle REST requests, create notifications when anomalies occur. "
				+ "Designed the model entities and their life cycle. "
				+ "Implemented CRUD operations using Hibernate "
				+ "and REST requests over these models.Building agent-less connectors to Splunk, "
				+ "OSSIM (Open Source SIM) and a CA Mobile Security Product (currently under development) "
				+ "to collect data and run queries against the collected data to answer high level questions");
		
		caDescription.add("Big Data Management: Web application to manage big data systems like Hadoop"
				+ "Cassandra and MongoDB. Designed and created REST requests to perform Cassandra lifecycle "
				+ "operations at both node level and cluster level. Created a probe for Cassandra to perform "
				+ "node operations and collect metrics");
		
		
		Work ca = new Work("CA Technologies, Stony Brook, NY", "Software Engineer", 
				caDescription, "February, 2013", "January, 2015");	
		
		List<String> bmPlatformEngineerDescription = new ArrayList<String>();
		
		bmPlatformEngineerDescription.add("Assisting in Bytemark’s Product and Platform teams to build "
				+ "ticketing and payment apps for transit, tourism, and event companies in "
				+ "multiple cities around the world. Working closely with our Mobile teams to implement "
				+ "internal APIs and SDKs along with the other mobile teams to ensure consistency "
				+ "across platforms.");		
		
		Work bmPlatformEngineer = new Work("Bytemark Inc., New York, NY", "Platform Engineer", 
				bmPlatformEngineerDescription, "January, 2015", "February, 2016");
		
		List<String> bmPlatformArchitectDescription = new ArrayList<String>();
		
		bmPlatformArchitectDescription.add("Architect scalable, secure, and extensible APIs "
				+ "that power customer-facing experiences. "
				+ "Ensure improvement of all architectural processes within a time frame and "
				+ "provide training to all development teams to maintain project deliverables and reduce costs. "
				+ "Analyze business requirements and ensure the architecture supports those requirements."
				+ "Analyze metrics and measure the effectiveness of programs and return of investment goals.");
		
		
		Work bmPlatformArchitect = new Work("Bytemark Inc., New York, NY", "Platform Architect", 
				bmPlatformArchitectDescription, "February, 2016", "Present");
		
		
		this.workExperience = new ArrayList<Work>();
		this.workExperience.add(tesco);
		this.workExperience.add(caIntern);
		this.workExperience.add(ca);
		this.workExperience.add(bmPlatformEngineer);
		this.workExperience.add(bmPlatformArchitect);
		
		Project comorbidity = new Project("Comorbidity", 
				"A Java based web application designed to analyze lab results and records "
				+ "(stored in Cerner’s database) to indicate the presence of medical conditions "
				+ "that a patient might be facing.");
		
		Project nlp = new Project("Detecting news sources and media bias", 
							"A Java based application designed to detect a news source and "
							+ "the media bias using natural language processing techniques. "
							+ "Different statistical techniques like Probabilistic Context Free Grammar, "
							+ "N-Gram models, Typed Dependencies and Bag of Words were explored.");
		
		Project systemCallInherit = new Project("System Call Inherit", 
				"Implemented a new policy to make a new process and "
				+ "its child processes use an entirely new set of system call "
				+ "vectors atomically. Designed and implemented a new mechanism "
				+ "to intercept all system calls and overrides the global system call "
				+ "table by maintaining per-process system call vector information.");
		
		Project stackableFileSystem = new Project("File Data Encryption and implementation of Address Space Operations", 
				"Implemented various address space operations to enable WRAPFS (a stackable file system) have "
				+ "individual data pages at the upper layer with different data from those at the lower layer. "
				+ "Added security features to these new address space operations so that data in the lower layer "
				+ "pages stay encrypted and those in the upper layer are always decrypted. ");
		
		this.academicProjects = new ArrayList<Project>();
		academicProjects.add(comorbidity);
		academicProjects.add(nlp);
		academicProjects.add(systemCallInherit);
		academicProjects.add(stackableFileSystem);
				
		Project swaggerPlay = new Project("Swagger-Play", "Swagger 2.0 support for Play 1.x (1.3 and above) with swagger and jaxrs annotations.");
		
		this.personalProjects = new ArrayList<Project>();
		personalProjects.add(swaggerPlay);
		
	}
	
	private String name;

	private String email;

	private String phone;

	private String github;
	
	private String resume_link;
	
	private String website;
	
	private List<School> education;
	
	private List<Work> workExperience;
	
	private List<String> languages;
	
	private List<String> storage;
	
	private List<String> tools;
	
	private List<String> frameworks;
	
	private List<Project> academicProjects;
	
	private List<Project> personalProjects;
	
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
		return workExperience;
	}

	public void setWork_experience(List<Work> work_experience) {
		this.workExperience = work_experience;
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
		return academicProjects;
	}

	public void setAcademic_projects(List<Project> academic_projects) {
		this.academicProjects = academic_projects;
	}

	public List<Project> getPersonal_projects() {
		return personalProjects;
	}

	public void setPersonal_projects(List<Project> personal_projects) {
		this.personalProjects = personal_projects;
	}

	public static byte [] resume_buffer = null;
	
	static {

		File file = new File("/var/lib/tomcat7/Resume.pdf");
		//File file = new File("/Users/abhishek/Dropbox/Resume.pdf");

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
