package fr.com.excilys.service;

import java.util.List;

import fr.com.excilys.modele.Company;
import fr.com.excilys.persistence.CompanyDao;
import fr.com.excilys.persistence.DaoFactoryHikaricp;

public class CompanyService {
	
	private static CompanyService instance;
	private CompanyDao companyDao ;
	private DaoFactoryHikaricp daoFactory;
	
	private CompanyService() {
		this.daoFactory  = DaoFactoryHikaricp.getInstence();
		this.companyDao  = this.daoFactory.getCompanyDao();
	}
	
	public static CompanyService getInstance() {
		if (instance == null) {
			instance = new CompanyService();		
		}
		return instance;
	}
	
	public List<Company> getList() {
		List<Company>  listCompany = null;
		listCompany  = this.companyDao.listCompany();
		
		return listCompany ;
	}
}
