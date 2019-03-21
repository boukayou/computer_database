package fr.com.excilys.validator;

import org.springframework.stereotype.Component;

import fr.com.excilys.modele.Computer;
@Component
public class ValidaTorComputer {

	
	public static boolean validatorComputer(Computer computer) {
		
			return computer.getIntroduced().isBefore(computer.getDiscontinued());
		
	}

}
