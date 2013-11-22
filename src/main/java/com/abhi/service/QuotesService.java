package com.abhi.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.dao.IQuotesDao;
import com.abhi.dao.Quotes;

@Service("quotesService")
public class QuotesService implements IQuotesService {
	
	@Autowired
	private IQuotesDao quotesDao;
	
	@Override
	public void create(Quotes quotes) {
		// TODO Auto-generated method stub
		quotesDao.create(quotes);
	}

	@Override
	public Quotes getQuotes(String id){
		
		return quotesDao.getQuotes(id);
		
	}
	
	@Override
	public String getRandomQuote(String id) {
		// TODO Auto-generated method stub
		Quotes quotes = quotesDao.getQuotes(id);
		
		if(quotes != null){
			
			String[] quotesArray = quotes.getQuotes().split("\\n");
			Random random = new Random();
			
			int number = random.nextInt(quotesArray.length);
			
			return quotesArray[number];
			
		} else {
			
			return "You dont have any quotes saved on this server";
			
		}
		
	}

}
