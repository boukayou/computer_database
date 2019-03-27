package com.excilys.boukayou.persistence;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.excilys.boukayou.modele.Computer;

public interface ComputerDaoJpa extends PagingAndSortingRepository<Computer, Long> {
	
	Page<Computer> findAllByNameContains(String search, Pageable pageable);

}
