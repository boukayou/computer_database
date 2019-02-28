package fr.com.excilys.service;

import java.util.ArrayList;
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
	
	public List<Computer> getList(int page,int nbOfElements){
		List<Computer>  listComputer = null;
		listComputer  = this.computerDao.getList(page, nbOfElements);
		return listComputer ;
	}
	
	public List<Computer> getList(){

		return new ArrayList<Computer>();
	}
	
	public int count() {
		return computerDao.count();
	}
	public Computer getById(long id) {
		
		return computerDao.ComputerById(id);
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