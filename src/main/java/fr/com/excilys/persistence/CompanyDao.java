package fr.com.excilys.persistence;
import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;

import java.util.List;

public interface CompanyDao {

	List<Company> listCompany() ;
	void deleteCompany (Company company);
}
