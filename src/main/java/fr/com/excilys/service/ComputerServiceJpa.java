package fr.com.excilys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.com.excilys.modele.Computer;
import fr.com.excilys.persistence.ComputerDaoJpa;
import fr.com.excilys.validator.Pagination;
import fr.com.excilys.validator.ValidaTorComputer;

@Component
public class ComputerServiceJpa {

	protected ComputerDaoJpa computerDaoJpa;
	protected ValidaTorComputer validaTorComputer;
	//protected Pagination pagination;
	
	
	public  ComputerServiceJpa(ComputerDaoJpa computerDaoJpa , ValidaTorComputer validaTorComputer/* Pagination pagination*/) {
		
		this.computerDaoJpa = computerDaoJpa;
		this.validaTorComputer = validaTorComputer;
		//this.pagination = pagination;
	}

	
	public List<Computer> getList(Pagination pagination) {
	
		return computerDaoJpa.findAll(createPageRequest(pagination)).getContent();
		
	}

	public long count() {

		return computerDaoJpa.count();
	
	}
	

	public Optional<Computer> getById(long id) {
		
		return computerDaoJpa.findById(id);
	}
 

	public Computer create(Computer computer) {
		
		if (ValidaTorComputer.validatorComputer(computer)) {

			return computerDaoJpa.save(computer);

		} else {

			System.out.println(" *****Invalid date ! ");
			return null;
		}
	}

	public Computer upDate(Computer computer) {
		if (ValidaTorComputer.validatorComputer(computer)) {

			return computerDaoJpa.save(computer);

		} else {

			System.out.println(" Invalid date ! ");
			return null;
		}
	}

	public void delete(Computer computer) {
		
		try {
		computerDaoJpa.delete(computer);
		
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	private Pageable createPageRequest(Pagination pagination) {
	
		return PageRequest.of(pagination.getPage(), pagination.getNbOfElements(), Sort.by(pagination.getSort()).ascending());
	}
}
