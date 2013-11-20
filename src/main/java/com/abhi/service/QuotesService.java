package com.abhi.service;

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

}
