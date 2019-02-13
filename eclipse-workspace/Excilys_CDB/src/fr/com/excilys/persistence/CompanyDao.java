package fr.com.excilys.persistence;

import java.sql.SQLException;
import java.util.List;

import fr.com.excilys.modele.Company;

public interface CompanyDao {

	List<Company> listCompany() throws SQLException;
}
