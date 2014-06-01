package com.abhi.resume;

import java.util.List;

public class Work {
		
	
	public Work(String company, String role, List<String> description,
			String start_date, String end_date) {
		super();
		this.company = company;
		this.role = role;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	private String company;
	
	private String role;
	
	private List<String> description;
	
	private String start_date;
	
	private String end_date;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "Work [company=" + company + ", role=" + role + ", description="
				+ description + ", start_date=" + start_date + ", end_date="
				+ end_date + "]";
	}
		
	

}
