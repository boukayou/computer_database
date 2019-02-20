package fr.com.excilys.cdb.app;

import java.text.ParseException;

import fr.com.excilys.controller.Controller;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		 try {
			Controller.getInstance();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
