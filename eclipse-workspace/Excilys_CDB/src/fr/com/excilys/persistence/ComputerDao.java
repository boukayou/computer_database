package fr.com.excilys.persistence;

import java.sql.SQLException;
import java.util.List;

import fr.com.excilys.modele.Computer;

public interface ComputerDao {
	
	void createComputer (Computer computer)throws SQLException;
	void UpdateComputer (Computer computer)throws SQLException;
	void deleteComputer (Computer computer)throws SQLException;
	List<Computer> ListComputer()throws SQLException;
	Computer ComputerById(long id)throws SQLException;
	
}
