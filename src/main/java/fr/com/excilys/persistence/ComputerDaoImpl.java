package fr.com.excilys.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.validator.ConvertData;
import fr.com.excilys.validator.Pagination;

public class ComputerDaoImpl implements ComputerDao {
	final Logger logger = LoggerFactory.getLogger(ComputerDaoImpl.class);
	final static String INSERT = "Insert into computer (name,introduced,discontinued,company_id) values(?,?,?,?) ";
	final static String UP_DATE = "UPDATE computer SET name = ?, introduced = ?, discontinued = ? , company_id =? where id=?";
	final static String DELETE = "DELETE FROM computer where id =?";
	final static String COUNT_ELEMENTS = "SELECT COUNT(*) AS nbElements FROM computer ";
	final static String COMPUTER_BY_ID = "SELECT computer.id,computer.name,computer.introduced,computer.discontinued,computer.company_id, company.name "
			+ "								FROM computer "
			+ "									LEFT JOIN company ON computer.company_id = company.id "
			+ "							 			WHERE computer.id= ?";

	final static String COMPUTER_BY_NAME = "SELECT computer.id,computer.name,computer.introduced,computer.discontinued,computer.company_id, company.name "
			+ "									FROM computer "
			+ "										LEFT JOIN company ON computer.company_id = company.id "
			+ "							 				WHERE computer.name LIKE ? ORDER BY %s ASC"
			+ "												 LIMIT ?  OFFSET ?  ";

	final static String LIST = "SELECT computer.id,computer.name,computer.introduced,computer.discontinued,computer.company_id, company.name "
			+ "								FROM computer "
			+ "									LEFT JOIN company ON computer.company_id = company.id "
			+ "										LIMIT ? OFFSET ?";

	DaoFactoryHikaricp factory;

	public ComputerDaoImpl(DaoFactoryHikaricp fact) {
		this.factory = fact;
	}

	@Override
	public void createComputer(Computer computer) {
		// TODO Auto-generated method stub

		try (Connection connect = this.factory.getConnection()) {

			PreparedStatement prepastat = connect.prepareStatement(INSERT);
			// prepastat.setLong(1, computer.getId());
			prepastat.setString(1, computer.getName());
			if (computer.getIntroduced() == null) {
				prepastat.setTimestamp(2, null);
			} else {
				prepastat.setTimestamp(2, new java.sql.Timestamp(Date.valueOf(computer.getIntroduced()).getTime()));
			}
			if (computer.getDiscontinued() == null) {
				prepastat.setTimestamp(3, null);
			} else {
				prepastat.setTimestamp(3, new java.sql.Timestamp(Date.valueOf(computer.getDiscontinued()).getTime()));
			}
			prepastat.setLong(4, computer.getCompany().getId());
			prepastat.execute();
			logger.info("The computer: " + computer + " was added to database.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Error in ComputerDaoImplement/creating computer");
			e.printStackTrace();
			
		}
	}

	@Override
	public void UpdateComputer(Computer computer) {
		// TODO Auto-generated method stub

		try (Connection connect = this.factory.getConnection()) {

			PreparedStatement prepastat = connect.prepareStatement(UP_DATE);
			prepastat.setString(1, computer.getName());
			if (computer.getIntroduced() == null) {
				prepastat.setTimestamp(2, null);
			} else {
				prepastat.setTimestamp(2, new java.sql.Timestamp(Date.valueOf(computer.getIntroduced()).getTime()));
			}
			if (computer.getDiscontinued() == null) {
				prepastat.setTimestamp(3, null);
			} else {
				prepastat.setTimestamp(3, new java.sql.Timestamp(Date.valueOf(computer.getDiscontinued()).getTime()));
			}

			prepastat.setLong(4, computer.getCompany().getId());
			prepastat.setLong(5, computer.getId());
			prepastat.execute();
			logger.info("The computer: " + computer + " was updated to database.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error in ComputerDaoImplement/Updating computer");
		}
	}

	@Override
	public void deleteComputer(Computer computer) {
		// TODO Auto-generated method stub
		try (Connection connect = this.factory.getConnection()) {
			PreparedStatement prepastat = connect.prepareStatement(DELETE);
			prepastat.setLong(1, computer.getId());
			prepastat.execute();
			logger.info("The computer: " + computer + " was deleted.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error in ComputerDaoImplement/deleting computer");

		}
	}

	@Override
	public List<Computer> getList(Pagination pagination) {
		// TODO Auto-generated method stub
		List<Computer> listComputer = new ArrayList<Computer>();
		try (Connection connect = this.factory.getConnection()) {

			String formattedComputerByName = String.format(COMPUTER_BY_NAME, pagination.getSort());
			PreparedStatement prepastat = connect.prepareStatement(formattedComputerByName);

			prepastat.setString(1, "%" + pagination.getSearch() + "%");
			prepastat.setInt(2, pagination.getNbOfElements());
			prepastat.setInt(3, pagination.getNbOfElements() * pagination.getPage());

			ResultSet result = prepastat.executeQuery();

			while (result.next()) {
				long id = result.getLong("computer.id");
				String name = result.getString("computer.name");
				LocalDate introd = ConvertData.timestampToLocalDate(result.getTimestamp("computer.introduced"))
						.orElse(null);
				LocalDate discon = ConvertData.timestampToLocalDate(result.getTimestamp("computer.discontinued"))
						.orElse(null);
				long idCompany = result.getLong("computer.company_id");
				Company company = new Company();
				company.setId(idCompany);
				company.setName(result.getString("company.name"));
				listComputer.add(new Computer(id, name, introd, discon, company));
			}

			return listComputer;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Error in ComputerDaoImplement/to get list of computer");
			e.printStackTrace();

		}

		return listComputer;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int count = 0;
		try (Connection connect = this.factory.getConnection()) {

			PreparedStatement prepastat = connect.prepareStatement(COUNT_ELEMENTS);

			ResultSet result = prepastat.executeQuery();
			if (result.next()) {
				count = result.getInt("nbElements");
			}

			logger.info(count + " computers found in database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error("Error in ComputerDaoImplement/counting computer");

		}

		return count;
	}

	@Override
	public Computer computerById(long id) {
		// TODO Auto-generated method stub
		Computer computer = null;

		try (Connection connect = this.factory.getConnection()) {

			PreparedStatement prepastat = connect.prepareStatement(COMPUTER_BY_ID);
			prepastat.setLong(1, id);
			ResultSet result = prepastat.executeQuery();
			result.next();
			long idcomputer = result.getLong("id");
			String name = result.getString("name");
			LocalDate introd = ConvertData.timestampToLocalDate(result.getTimestamp("introduced")).orElse(null);
			LocalDate discon = ConvertData.timestampToLocalDate(result.getTimestamp("discontinued")).orElse(null);
			long idCompany = result.getLong("company_id");
			computer = new Computer(idcomputer, name, introd, discon, new Company(idCompany));
			logger.info("the computer:" + computer + " was found in the database.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error("Error in ComputerDaoImplement/to get computer by id");

		}
		return computer;
	}

}
