package fr.com.excilys.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.com.excilys.modele.Company;

@Component
public class CompanyDaoImpl implements CompanyDao {
	final Logger logger = LoggerFactory.getLogger(CompanyDaoImpl.class);
	static final String LIST_COMPANY = "SELECT name,id FROM company";
	final static String DELETE_COMPUTER = "DELETE FROM computer where company_id =?";
	final static String DELETE_COMPANY = "DELETE FROM company where company.id =?";

	private JdbcTemplate jdbcTemplate;

	public CompanyDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Company> listCompany() {

		return jdbcTemplate.query(LIST_COMPANY, this);

	}

	@Transactional
	@Override
	public void deleteCompany(Company company) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement prepastat = connection.prepareStatement(DELETE_COMPUTER, new String[] { "id" });

				prepastat.setLong(1, company.getId());

				return prepastat;
			}
		}, keyHolder);

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement prepastat = connection.prepareStatement(DELETE_COMPANY, new String[] { "id" });

				prepastat.setLong(1, company.getId());

				return prepastat;
			}
		}, keyHolder);

	}

	@Override
	public Company mapRow(ResultSet result, int rowNum) throws SQLException {
		long idcompany = result.getLong("id");
		String name = result.getString("name");

		return new Company(idcompany, name);
	}

}
