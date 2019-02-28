package fr.com.excilys.persistence;
import java.util.List;

import fr.com.excilys.modele.Computer;

public interface ComputerDao {
	
	void createComputer (Computer computer);
	void UpdateComputer (Computer computer);
	void deleteComputer (Computer computer);
	int count();
	List<Computer> getList(int page,int nbOfElements );
	Computer ComputerById(long id);
	
}
