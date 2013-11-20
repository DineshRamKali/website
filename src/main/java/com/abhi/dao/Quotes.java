package com.abhi.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quotes")
public class Quotes {
	
	@Id
	private String name;
	
	private String quotes;

	public Quotes(){
		
	}
	
	public Quotes(String name, String quotes) {
		this.name = name;
		this.quotes = quotes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuotes() {
		return quotes;
	}

	public void setQuotes(String quotes) {
		this.quotes = quotes;
	}

	@Override
	public String toString() {
		return "Quotes [name=" + name + ", quotes=" + quotes + "]";
	}
	
	
	
	

}
