package com.excilys.dto;

import org.springframework.stereotype.Component;

@Component
public class CompanyDTO {

	private String id;
	private String name;

	public CompanyDTO() {
	}

	public CompanyDTO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
