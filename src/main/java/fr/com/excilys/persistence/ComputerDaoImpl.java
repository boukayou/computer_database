package fr.com.excilys.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.validator.ConvertData;
import fr.com.excilys.validator.Pagination;
/*
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

	final static String COMPUTER_BY_NAME = "SELECT computer.id,computer.name,computer.introduced,computer.discontinued,computer.company_id, company.name"
			+ "									 FROM computer LEFT JOIN company ON computer.company_id = company.id "
			+ "							 				WHERE computer.name LIKE ? ORDER BY %s ASC"
			+ "												 LIMIT ?  OFFSET ?  ";

	final static String LIST = "SELECT computer.id,computer.name,computer.introduced,computer.discontinued,computer.company_id, company.name "
			+ "								FROM computer "
			+ "									LEFT JOIN company ON computer.company_id = company.id "
			+ "										LIMIT ? OFFSET ?";

	private JdbcTemplate jdbcTemplate;
	private ConvertData convertData;

	public ComputerDaoImpl(JdbcTemplate jdbcTemplate, ConvertData convertData) {
		this.jdbcTemplate = jdbcTemplate;
		this.convertData = convertData;
	}

	@Override
	public void createComputer(Computer computer) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement prepastat = connection.prepareStatement(INSERT, new String[] { "id" });
				prepastat.setString(1, computer.getName());

				if (computer.getIntroduced() == null) {
					prepastat.setTimestamp(2, null);
				} else {
					prepastat.setTimestamp(2, new java.sql.Timestamp(Date.valueOf(computer.getIntroduced()).getTime()));
				}

				if (computer.getDiscontinued() == null) {
					prepastat.setTimestamp(3, null);
				} else {
					prepastat.setTimestamp(3,
							new java.sql.Timestamp(Date.valueOf(computer.getDiscontinued()).getTime()));
				}

				prepastat.setLong(4, computer.getCompany().getId());
				return prepastat;
			}
		}, keyHolder);
	}

	@Override
	public void UpdateComputer(Computer computer) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement prepastat = connection.prepareStatement(UP_DATE, new String[] { "id" });

				prepastat.setString(1, computer.getName());

				if (computer.getIntroduced() == null) {

					prepastat.setTimestamp(2, null);

				} else {

					prepastat.setTimestamp(2, new java.sql.Timestamp(Date.valueOf(computer.getIntroduced()).getTime()));
				}

				if (computer.getDiscontinued() == null) {

					prepastat.setTimestamp(3, null);

				} else {

					prepastat.setTimestamp(3,
							new java.sql.Timestamp(Date.valueOf(computer.getDiscontinued()).getTime()));
				}

				prepastat.setLong(4, computer.getCompany().getId());
				prepastat.setLong(5, computer.getId());
				return prepastat;
			}
		}, keyHolder);
	}

	@Override
	public void deleteComputer(Computer computer) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement prepastat = connection.prepareStatement(DELETE, new String[] { "id" });

				prepastat.setLong(1, computer.getId());

				return prepastat;
			}
		}, keyHolder);

	}

	@Override
	public List<Computer> getList(Pagination pagination) {
		String formattedComputerByName = String.format(COMPUTER_BY_NAME, pagination.getSort());

		return jdbcTemplate.query(formattedComputerByName, new Object[] { "%" + pagination.getSearch() + "%",
				pagination.getNbOfElements(), pagination.getNbOfElements() * pagination.getPage() }, this);

	}

	@Override
	public Computer computerById(long id) {
		try {
			return jdbcTemplate.queryForObject(COMPUTER_BY_ID, new Object[] { id }, this);
		} catch (IncorrectResultSizeDataAccessException ex) {
			ex.printStackTrace();
			return null;

		}
	}

	@Override
	public int count() {
		int count = 0;

		count = jdbcTemplate.queryForObject(COUNT_ELEMENTS, Integer.class);
		return count;
	}

	@Override
	public Computer mapRow(ResultSet result, int rowNum) throws SQLException {
		long idcomputer = result.getLong("id");
		String nameComputer = result.getString("computer.name");
		LocalDate introd = this.convertData.timestampToLocalDate(result.getTimestamp("introduced")).orElse(null);
		LocalDate discon = this.convertData.timestampToLocalDate(result.getTimestamp("discontinued")).orElse(null);
		String nameCompany = result.getString("company.name");
		long idCompany = result.getLong("company_id");
		return new Computer(idcomputer, nameComputer, introd, discon, new Company(idCompany,nameCompany));
	}

}
*/