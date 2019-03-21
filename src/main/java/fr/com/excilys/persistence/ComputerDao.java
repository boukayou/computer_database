package fr.com.excilys.persistence;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import fr.com.excilys.modele.Computer;
import fr.com.excilys.validator.Pagination;
@Component
public interface ComputerDao extends RowMapper<Computer> {

	void createComputer(Computer computer);

	void UpdateComputer(Computer computer);

	void deleteComputer(Computer computer);

	int count();

	List<Computer> getList(Pagination pagination);

	Computer computerById(long id);

}
