package fr.com.excilys.persistence;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import fr.com.excilys.modele.Company;

//extends CrudRepository<Company, Long> enlever Rowmapper
 public interface CompanyDao extends RowMapper <Company> {

	List<Company> listCompany() ;
	
	void deleteCompany (Company company);
}