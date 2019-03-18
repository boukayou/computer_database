package fr.com.excilys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.com.excilys.modele.Company;
import fr.com.excilys.persistence.CompanyDao;
import fr.com.excilys.persistence.DaoFactoryHikaricp;

@Service
public class CompanyService {
	
	private static CompanyService instance;
	private CompanyDao companyDao ;
	private DaoFactoryHikaricp daoFactory;
	
	private CompanyService() {
		this.daoFactory  = DaoFactoryHikaricp.getInstance();
		this.companyDao  = this.daoFactory.getCompanyDao();
	}
	
	public static CompanyService getInstance() {
		if (instance == null) {
			instance = new CompanyService();		
		}
		return instance;
	}
	
	public List<Company> getList() {
		return this.companyDao.listCompany();
			
	}
	
	public void delete(Company company) {
		companyDao.deleteCompany(company);
	}
}
