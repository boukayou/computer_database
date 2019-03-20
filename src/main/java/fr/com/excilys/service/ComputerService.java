package fr.com.excilys.service;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.com.excilys.modele.Computer;
import fr.com.excilys.persistence.ComputerDao;
import fr.com.excilys.validator.Pagination;
import fr.com.excilys.validator.ValidaTorComputer;

@Component
public class ComputerService {
	public int test = 2;

	private ComputerDao computerDao;

	private ComputerService(ComputerDao computerDao) {

		this.computerDao = computerDao;
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
