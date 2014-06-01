package com.abhi.resume;

public class Project {	
	
	public Project(String project_name, String description) {
		
		this.project_name = project_name;
		this.description = description;
	}

	private String project_name;
	
	private String description;	

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Project [project_name=" + project_name + ", description="
				+ description + "]";
	}
	
	
	
}
