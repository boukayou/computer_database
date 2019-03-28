package com.excilys.boukayou.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.excilys.boukayou.modele.Computer;
import com.excilys.boukayou.persistence.ComputerDaoJpa;
import com.excilys.boukayou.validator.Pagination;
import com.excilys.boukayou.validator.ValidaTorComputer;

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
	
		return computerDaoJpa.findAllByNameContains(pagination.getSearch(), createPageRequest(pagination)).getContent();
		
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
