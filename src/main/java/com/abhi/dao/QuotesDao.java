package com.abhi.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("quotesDao")
@Transactional
public class QuotesDao implements IQuotesDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Quotes quotes) {
		
		session().saveOrUpdate(quotes);
		
	}
	
	public Quotes getQuotes(String id){
		
		Criteria criteria = session().createCriteria(Quotes.class);
		criteria.createAlias("user", "u").add(Restrictions.eq("u.uuid", id));
		Quotes quotes = (Quotes)criteria.uniqueResult();
		
		return quotes;
		
	}

}
