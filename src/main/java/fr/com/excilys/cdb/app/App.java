package fr.com.excilys.cdb.app;

import java.text.ParseException;


import fr.com.excilys.controller.Controller;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		
		try {
			  Controller.getInstance();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
	}

}
