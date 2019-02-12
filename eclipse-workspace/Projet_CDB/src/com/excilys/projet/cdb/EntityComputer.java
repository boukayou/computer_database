package com.excilys.projet.cdb;

import java.sql.Timestamp;

public class EntityComputer {
	
	private long id ;
	private EntityCompany company;
	private String name ;
	private Timestamp introduced ;
	private Timestamp discontuned ;
	public EntityCompany getCompany() {
		return company;
	}
	public void setCompany(EntityCompany company) {
		this.company = company;
	}
	public Timestamp getIntroduced() {
		return introduced;
	}
	public void setIntroduced(Timestamp introduced) {
		this.introduced = introduced;
	}
	public Timestamp getDiscontuned() {
		return discontuned;
	}
	public void setDiscontuned(Timestamp discontuned) {
		this.discontuned = discontuned;
	}	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
