package fr.com.excilys.exceptions;

public class NameIsEmpty extends Exception {
	
	public NameIsEmpty(){
		System.out.println("Error: You set a empty name. \n");
	}
}
