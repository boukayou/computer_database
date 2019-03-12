package fr.com.excilys.persistence;
import java.util.List;
import java.util.Optional;

import fr.com.excilys.checking.Pagination;
import fr.com.excilys.modele.Computer;

public interface ComputerDao {
	
	void createComputer (Computer computer);
	void UpdateComputer (Computer computer);
	void deleteComputer (Computer computer);
	int count();
	List<Computer> getList(Pagination pagination);
	Computer computerById(long id);


}
