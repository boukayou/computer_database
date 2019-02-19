package com.excilys.services;
import java.util.List;

import fr.com.excilys.modele.Computer;
import fr.com.excilys.persistence.ComputerDao;
import fr.com.excilys.persistence.DaoFactory;

public class ComputerService {
	
	private static ComputerService instance;
	private ComputerDao computerDao ;
	private DaoFactory daoFactory;
	
	private ComputerService() {
		this.daoFactory = DaoFactory.getInstence();
		this.computerDao  = this.daoFactory.getComputerDao();
	}
	
	public static ComputerService getInstance() {
		if (instance == null) {
			instance = new ComputerService();		
		}
		return instance;
	}
	
	public List<Computer> getList() throws ClassNotFoundException{
		List<Computer>  listCompany = null;
		listCompany  = this.computerDao.ListComputer();
		return listCompany ;
	}
	public Computer getById(long id) {
		return this.computerDao.ComputerById(id);
	}
	
	public void create(Computer computer) {
		this.computerDao.createComputer(computer);
	}
	
	public void upDate (Computer computer) {
		this.computerDao.UpdateComputer(computer);
	}
	
	public void delete (Computer computer) {
		this.delete(computer);
	}
}