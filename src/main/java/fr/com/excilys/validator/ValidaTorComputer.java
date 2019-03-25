package fr.com.excilys.validator;

import org.springframework.stereotype.Component;

import fr.com.excilys.modele.Computer;
@Component
public class ValidaTorComputer {

	
	public static boolean validatorComputer(Computer computer) {
		
			if(computer.getIntroduced() ==null||computer.getDiscontinued() ==null) {
				return true;
				
			}
			return  computer.getIntroduced().isBefore(computer.getDiscontinued());
		
	}

}
