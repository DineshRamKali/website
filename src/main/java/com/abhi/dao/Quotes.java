package com.abhi.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="quotes")
public class Quotes {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank(groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	@Size(min=8, max=50, groups={FormValidationGroup.class})
	private String quote_name;
	
	@NotBlank(groups={PersistenceValidationGroup.class, FormValidationGroup.class})
	private String quotes;
	
	@OneToOne
	@JoinColumn(name="uuid")
	@ForeignKey(name="uuid")
	private User user;
	
	public Quotes(){
		this.user = new User();
	}

	public Quotes(String quote_name, String quotes, User user) {
		
		this.quote_name = quote_name;
		this.quotes = quotes;
		this.user = user;
	}

	public Quotes(int id, String quote_name, String quotes, User user) {
		
		this.id = id;
		this.quote_name = quote_name;
		this.quotes = quotes;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuote_name() {
		return quote_name;
	}

	public void setQuote_name(String quote_name) {
		this.quote_name = quote_name;
	}

	public String getQuotes() {
		return quotes;
	}

	public void setQuotes(String quotes) {
		this.quotes = quotes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((quote_name == null) ? 0 : quote_name.hashCode());
		result = prime * result + ((quotes == null) ? 0 : quotes.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quotes other = (Quotes) obj;
		if (id != other.id)
			return false;
		if (quote_name == null) {
			if (other.quote_name != null)
				return false;
		} else if (!quote_name.equals(other.quote_name))
			return false;
		if (quotes == null) {
			if (other.quotes != null)
				return false;
		} else if (!quotes.equals(other.quotes))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quotes [id=" + id + ", quote_name=" + quote_name + ", quotes="
				+ quotes + ", user=" + user + "]";
	}	
	
	
	
	
	
	
}
