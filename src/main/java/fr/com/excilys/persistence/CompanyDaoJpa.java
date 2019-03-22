package fr.com.excilys.persistence;

import org.springframework.data.repository.CrudRepository;

import fr.com.excilys.modele.Company;

public interface CompanyDaoJpa extends CrudRepository<Company, Long> {

}
