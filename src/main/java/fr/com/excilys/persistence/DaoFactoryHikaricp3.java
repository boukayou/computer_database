/*package fr.com.excilys.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DaoFactoryHikaricp3 {
	final static Logger logger = LoggerFactory.getLogger(DaoFactoryHikaricp.class);
	private static final String URL = "jdbc:mysql://localhost:3306/computer-database-db";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "admincdb";
	private static final String PASSWORD = "qwerty1234";

	//private String url;
	//private String userName;
	//private String password;

//	private static DaoFactoryHikaricp instance;
	private static Connection instance;

	private DaoFactoryHikaricp(String url, String userName, String password) {

		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public static Connection getInstence() throws SQLException {
		if (instance == null || instance.isClosed()) {
			try {
				Class.forName(DRIVER);

				instance = DaoFactoryHikaricp.getConnection();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				logger.error("Error in DaoFactory/ in method getInstence");

				e.printStackTrace();
			}

		}
		return instance;
	}

	public static Connection getConnection() throws SQLException {
		HikariConfig cfg = new HikariConfig();
		cfg.setJdbcUrl(URL);
		cfg.setUsername(USERNAME);
		cfg.setPassword(PASSWORD);
		HikariDataSource ds = new HikariDataSource(cfg);
		
		return ds.getConnection();
	}

	public ComputerDao getComputerDao() {

		return new ComputerDaoImpl(this);
	}

	public CompanyDao getCompanyDao() {

		return new CompanyDaoImpl(this);
	}
}*/
