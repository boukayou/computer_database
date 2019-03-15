package fr.com.excilys.validator;

import fr.com.excilys.modele.Computer;

public class ValidaTorComputer {

	public static boolean validatorComputer(Computer computer) {
		
			return computer.getIntroduced().isBefore(computer.getDiscontinued());
		
	}

}
