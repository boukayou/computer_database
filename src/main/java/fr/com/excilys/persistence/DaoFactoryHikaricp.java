package fr.com.excilys.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DaoFactoryHikaricp {
	final static Logger logger = LoggerFactory.getLogger(DaoFactoryHikaricp.class);

	private static DaoFactoryHikaricp instance;

	private DaoFactoryHikaricp() {

	}

	public static DaoFactoryHikaricp getInstance() {
		if (instance == null) {

			instance = new DaoFactoryHikaricp();
		}
		return instance;
	}

	Connection getConnection() throws SQLException {
		HikariConfig cfg = new HikariConfig("/home/excilys/computer_database/hikari.properties");
		HikariDataSource ds = new HikariDataSource(cfg);

		return ds.getConnection();
	}

	public ComputerDao getComputerDao() {

		return new ComputerDaoImpl(this);
	}

	public CompanyDao getCompanyDao() {

		return new CompanyDaoImpl(this);
	}
}
