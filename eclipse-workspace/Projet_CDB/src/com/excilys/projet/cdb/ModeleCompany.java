package com.excilys.projet.cdb;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class ModeleCompany {
		// Method to elements from database
	public static List <EntityCompany> getElements() {
		List<EntityCompany> listCompany = new ArrayList<>(); 
		// get a connection to database
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer-database-db","admincdb", "qwerty1234");
		
			// create a statement
			Statement myStat = myConn.createStatement();
			
			// Execute a Query
			ResultSet myResult = myStat.executeQuery("SELECT * FROM company");
			
			// Process the result set of company 
			while(myResult.next()) {
				//System.out.println("Id: " + myResult.getString("id") + "  Name: " +myResult.getString("name"));
				EntityCompany com = new EntityCompany();
				com.setId(myResult.getLong("id"));
				com.setName(myResult.getString("name"));
				listCompany.add(com);
			}	
			return listCompany ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
	
	


