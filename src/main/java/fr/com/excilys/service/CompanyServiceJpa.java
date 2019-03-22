package fr.com.excilys.service;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.com.excilys.modele.Company;
import fr.com.excilys.persistence.CompanyDao;

@Component
public class CompanyServiceJpa {

	private CompanyDao companyDao;
	
	
	private CompanyServiceJpa(CompanyDao companyDao) {

		this.companyDao = companyDao;
	}

	public List<Company> getList() {

		return this.companyDao.listCompany();
	}

	public void delete(Company company) {

		companyDao.deleteCompany(company);
	}
}
