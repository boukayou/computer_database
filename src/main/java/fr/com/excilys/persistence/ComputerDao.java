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
	List<Computer> getList(int nbrOfElements , int page , String search);
	Computer computerById(long id);
	Optional<List<Computer>>computerByName(String computerName,Pagination pagination);

}
