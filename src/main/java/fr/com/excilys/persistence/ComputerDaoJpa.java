package fr.com.excilys.persistence;

import org.springframework.data.repository.CrudRepository;

import fr.com.excilys.modele.Computer;

public interface ComputerDaoJpa extends CrudRepository<Computer, Long> {

}
