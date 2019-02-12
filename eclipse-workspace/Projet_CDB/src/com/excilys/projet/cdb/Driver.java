package com.excilys.projet.cdb;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class Driver {
	
	List<Company> listCompany = new ArrayList<>(); 
	List<Company> listComputer= new ArrayList<>(); 
	
	public List<Company> getList() {
		return listCompany;
	}

	public void setList(List<Company> list) {
		this.listCompany = list;
	
	}	
	
	public void getElements() {
		// get a connection to database
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer-database-db","admincdb", "qwerty1234");
		
			// create a statement
			Statement myStat = myConn.createStatement();
			
			// Execute a Query
			ResultSet myResult = myStat.executeQuery("SELECT * FROM company,computer");
			
			// Process the result set 
			while(myResult.next()) {
				//System.out.println("Id: " + myResult.getString("id") + "  Name: " +myResult.getString("name"));
				Company com = new Company();
				com.setId(myResult.getLong("id"));
				com.setName(myResult.getString("name"));
				
				listCompany.add(com);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

