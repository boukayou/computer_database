package fr.com.excilys.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.com.excilys.modele.Computer;

public interface ComputerDaoJpa extends PagingAndSortingRepository<Computer, Long> {

}
