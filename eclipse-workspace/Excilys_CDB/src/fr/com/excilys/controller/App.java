package fr.com.excilys.controller;

import java.text.ParseException;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try {
			Controller.getInstance();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
