package fr.com.excilys.service;

import java.util.List;

import fr.com.excilys.modele.Company;
import fr.com.excilys.persistence.CompanyDao;
import fr.com.excilys.persistence.DaoFactory;

public class CompanyService {
	
	private static CompanyService instance;
	private CompanyDao companyDao ;
	private DaoFactory daoFactory;
	
	private CompanyService() {
		this.daoFactory = DaoFactory.getInstence();
		this.companyDao  = this.daoFactory.getCompanyDao();
	}
	
	public static CompanyService getInstance() {
		if (instance == null) {
			instance = new CompanyService();		
		}
		return instance;
	}
	
	public List<Company> getList() throws ClassNotFoundException{
		List<Company>  listCompany = null;
		listCompany  = this.companyDao.listCompany();
		
		return listCompany ;
	
		
	}
}
