package com.excilys.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.modele.Company;
import com.excilys.persistence.CompanyDaoJpa;
import com.excilys.persistence.ComputerDaoJpa;

@Component
public class CompanyServiceJpa {

	private CompanyDaoJpa companyDaoJpa;
	
	
	public CompanyServiceJpa(CompanyDaoJpa companyDaoJpa) {

		this.companyDaoJpa = companyDaoJpa;

	}

	public List<Company> getList() {
		
	return (List<Company>) this.companyDaoJpa.findAll();
	}
	@Transactional
	public void delete(Company company) {
		
		try {
			
			companyDaoJpa.delete(company);
		}catch (Exception e) {
			e.getStackTrace();
		}
		
	}
}
 