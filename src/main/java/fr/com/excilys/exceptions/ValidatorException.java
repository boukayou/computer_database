package fr.com.excilys.exceptions;

public class ValidatorException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidatorException(){
		System.out.println("Error: You set a empty name. \n");
	}
}
