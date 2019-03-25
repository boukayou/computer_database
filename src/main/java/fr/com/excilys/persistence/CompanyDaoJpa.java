
package fr.com.excilys.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.com.excilys.modele.Company;

public interface CompanyDaoJpa extends PagingAndSortingRepository<Company, Long> {

}
