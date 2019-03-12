/*package fr.com.excilys.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DaoFactoryHikaricpWithOutFile {
	final static Logger logger = LoggerFactory.getLogger(DaoFactoryHikaricpWithOutFile.class);
	private static final String URL = "jdbc:mysql://localhost:3306/computer-database-db";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "admincdb";
	private static final String PASSWORD = "qwerty1234";

	private String url;
	private String userName;
	private String password;

	private static DaoFactoryHikaricpWithOutFile instance;

	private DaoFactoryHikaricpWithOutFile(String url, String userName, String password) {

		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	private DaoFactoryHikaricpWithOutFile() {

	}

	public static DaoFactoryHikaricpWithOutFile getInstance() {
		if (instance == null) {
			try {
				Class.forName(DRIVER);
				instance = new DaoFactoryHikaricpWithOutFile(URL, USERNAME, PASSWORD);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				logger.error("Error in DaoFactory/ in method getInstence");

				e.printStackTrace();
			}

		}
		return instance;
	}

	Connection getConnection() throws SQLException {
		HikariConfig cfg = new HikariConfig();
		cfg.setJdbcUrl(url);
		cfg.setUsername(userName);
		cfg.setPassword(password);
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
*/