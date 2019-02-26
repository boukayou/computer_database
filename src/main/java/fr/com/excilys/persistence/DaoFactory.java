package fr.com.excilys.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

	private static final String URL="jdbc:mysql://localhost:3306/computer-database-db";
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String USERNAME="admincdb";
	private static final String PASSWORD="qwerty1234"; 

	private String url;
	private String userName;
	private String password;
	
	private static DaoFactory instance;

	private DaoFactory(String url,String userName, String password){

        this.url = url;
        this.userName = userName;
        this.password = password;
	}
	
	public static DaoFactory getInstence() {
		if (instance == null) {
			try {
				Class.forName(DRIVER);
				instance = new DaoFactory(URL,USERNAME,PASSWORD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return instance;
	}
	
	Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userName, password);
	}
	
	public ComputerDao getComputerDao() {
		
		return new ComputerDaoImpl(this);
	}
	
	public CompanyDao getCompanyDao() {
			
			return new CompanyDaoImpl(this);
		}
}
