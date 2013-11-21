package com.abhi.dao;

public interface IQuotesDao {
	
	public void create(Quotes quotes);
	
	public Quotes getQuotes(String id);

}
