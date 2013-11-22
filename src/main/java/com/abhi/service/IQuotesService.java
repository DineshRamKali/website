package com.abhi.service;

import com.abhi.dao.Quotes;

public interface IQuotesService {
	
	public void create(Quotes quotes);
	
	public String getRandomQuote(String id);
	
	public Quotes getQuotes(String id);
	
}
