package fr.com.excilys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.com.excilys.checking.Pagination;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.persistence.ComputerDao;
import fr.com.excilys.persistence.DaoFactoryHikaricp;

public class ComputerService {

	private static ComputerService instance;
	private ComputerDao computerDao;
	private DaoFactoryHikaricp daoFactory;

	private ComputerService() {
		daoFactory =  this.daoFactory.getInstence();
		computerDao = this.daoFactory.getComputerDao();
	}

	public static ComputerService getInstance() {
		if (instance == null) {
			instance = new ComputerService();
		}
		return instance;
	}

	public List<Computer> getList(int nbrOfElements, int page, String search) {
	
		return  computerDao.getList( nbrOfElements, page, search);
	
	}

	public int count() {
		return computerDao.count();
	}

	public Computer getById(long id) {

		return computerDao.computerById(id);
	}

	public void create(Computer computer) {
		computerDao.createComputer(computer);
	}

	public void upDate(Computer computer) {
		computerDao.UpdateComputer(computer);
	}

	public void delete(Computer computer) {
		computerDao.deleteComputer(computer);
	}
// pas d'optional sur une liste car elle est soit vide  ou remplit
	public Optional<List<Computer>> search(String computerName, Pagination pagination) {
		return computerDao.computerByName(computerName, pagination);
	}
}
