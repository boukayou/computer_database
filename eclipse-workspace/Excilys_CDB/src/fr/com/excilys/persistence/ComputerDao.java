package fr.com.excilys.persistence;
import java.util.List;

import fr.com.excilys.modele.Computer;

public interface ComputerDao {
	
	void createComputer (Computer computer);
	void UpdateComputer (Computer computer);
	void deleteComputer (Computer computer);
	List<Computer> ListComputer();
	Computer ComputerById(long id);
	
}
