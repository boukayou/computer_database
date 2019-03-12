package fr.com.excilys.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;

public class CompanyDaoImpl implements CompanyDao {
	final Logger logger = LoggerFactory.getLogger(CompanyDaoImpl.class);
	DaoFactoryHikaricp factory;
	static final String LIST_COMPANY = "SELECT name,id FROM company";
	final static String DELETE_COMPUTER = "DELETE FROM computer where company_id =?";
	final static String DELETE_COMPANY = "DELETE FROM company where company.id =?";
	
	public CompanyDaoImpl(DaoFactoryHikaricp fact) {
		this.factory = fact;
	}

	public List<Company> listCompany() {
		// TODO Auto-generated method stub
		List<Company> listCompany = new ArrayList<Company>();

		try (Connection connect = this.factory.getConnection()) {
			PreparedStatement prepareStat = connect.prepareStatement("SELECT * FROM company");
			ResultSet result = prepareStat.executeQuery();
			while (result.next()) {
				long id = result.getLong("id");
				String name = result.getString("name");
				Company company = new Company(id, name);
				listCompany.add(company);
			}
			return listCompany;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Error in CompanyDaoImplement/ mathod listCompany");

			e.printStackTrace();
		}
		return listCompany;
	}

	@Override
	public void deleteCompany(Company company) {
		// TODO Auto-generated method stub
		try (Connection connect = this.factory.getConnection()) {

			try {
				connect.setAutoCommit(false);
				PreparedStatement prepaStatComputer = connect.prepareStatement(DELETE_COMPUTER);
				prepaStatComputer.setLong(1, company.getId());
				prepaStatComputer.execute();

				PreparedStatement prepaStatCompany = connect.prepareStatement(DELETE_COMPANY);
				prepaStatCompany.setLong(1, company.getId());
				prepaStatCompany.execute();
				connect.commit();
				logger.info("The company: " + company + " was deleted.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				connect.rollback();
				e.printStackTrace();
				logger.error("Error in CompanyDaoImplement/deleting company");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			logger.error("Error in CompanyDaoImplement/deleting company");

		}
	}
}
