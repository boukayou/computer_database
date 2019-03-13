package fr.com.excilys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.com.excilys.checking.Pagination;
import fr.com.excilys.checking.ValidaTorComputer;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.persistence.ComputerDao;
import fr.com.excilys.persistence.DaoFactoryHikaricp;

public class ComputerService {

	private static ComputerService instance;
	private ComputerDao computerDao;
	private DaoFactoryHikaricp daoFactory;

	private ComputerService() {
		daoFactory = DaoFactoryHikaricp.getInstance();
		computerDao = this.daoFactory.getComputerDao();
	}

	public static ComputerService getInstance() {
		if (instance == null) {
			instance = new ComputerService();
		}
		return instance;
	}

	public List<Computer> getList(Pagination pagination) {
		return computerDao.getList(pagination);
	}

	public int count() {
		return computerDao.count();
	}

	public Computer getById(long id) {

		return computerDao.computerById(id);
	}

	public void create(Computer computer) {
		if (ValidaTorComputer.validatorComputer(computer)) {
			computerDao.createComputer(computer);
		} else {
			System.out.println(" Invalid date ! ");
		}
	}

	public void upDate(Computer computer) {
		computerDao.UpdateComputer(computer);
	}

	public void delete(Computer computer) {
		computerDao.deleteComputer(computer);
	}
}
