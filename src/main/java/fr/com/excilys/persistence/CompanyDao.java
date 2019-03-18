package fr.com.excilys.persistence;
import java.util.List;

import fr.com.excilys.modele.Company;

public interface CompanyDao {

	List<Company> listCompany() ;
	void deleteCompany (Company company);
}
