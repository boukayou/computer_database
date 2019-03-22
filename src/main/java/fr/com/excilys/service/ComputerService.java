package fr.com.excilys.service;


import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import fr.com.excilys.modele.Computer;
import fr.com.excilys.persistence.ComputerDao;
import fr.com.excilys.persistence.ComputerDaoJpa;
import fr.com.excilys.validator.Pagination;
import fr.com.excilys.validator.ValidaTorComputer;

@Component
public class ComputerService {

	protected ComputerDaoJpa computerDaoJpa;
	protected ValidaTorComputer validaTorComputer;
	
	
	protected ComputerService(ComputerDaoJpa computerDaoJpa , ValidaTorComputer validaTorComputer) {
		
		this.computerDaoJpa = computerDaoJpa;
		this.validaTorComputer = validaTorComputer;
	}

	public List<Computer> getList(Pagination pagination) {
		
		//return computerDao.getList(pagination);
		return computerDaoJpa.findAll();
	}

	public long count() {

		return computerDaoJpa.count();
	
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
	
	private Pageable createPageRequest() {
	    return  PageRequest.of(1, 10, Sort.Direction.ASC, "title", "description");
	}
}
