package com.excilys.projet.cdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeleComputer {
	// Method to elements from database
		public static List <EntityComputer> getElements() {
			List<EntityComputer> listComputer = new ArrayList<>(); 
			// get a connection to database
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer-database-db","admincdb", "qwerty1234");
			
				// create a statement
				Statement myStat = myConn.createStatement();
				
				// Execute a Query
				ResultSet myResult = myStat.executeQuery("SELECT * FROM computer");
				
				// Process the result set of company 
				while(myResult.next()) {
					//System.out.println("Id: " + myResult.getString("id") + "  Name: " +myResult.getString("name"));
					EntityComputer com = new EntityComputer();
					com.setId(myResult.getLong("id"));
					com.setName(myResult.getString("name"));
					com.setIntroduced(myResult.getTimestamp("introduced"));
					com.setDiscontuned(myResult.getTimestamp("discontuned"));
					listComputer.add(com);
				}	
				return listComputer ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public static void setElements(List <EntityComputer> list) { 
			// get a connection to database
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer-database-db","admincdb", "qwerty1234");
			
				// create a statement
				Statement myStat = myConn.createStatement();	
				
				// Execute a Query
                String strSql = new String("INSERT INTO computer (name,introduced,discontinued) VALUES ('" + list.get(0).getName()+ "','"+ list.get(0).getIntroduced()+"','"+list.get(0).getDiscontuned()+"')");
			    myStat.executeUpdate(strSql);
				
				// Process the result set of company 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
