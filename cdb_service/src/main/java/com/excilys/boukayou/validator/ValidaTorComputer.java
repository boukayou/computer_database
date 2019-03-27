package com.excilys.boukayou.validator;

import org.springframework.stereotype.Component;

import com.excilys.boukayou.modele.Computer;
@Component
public class ValidaTorComputer {

	
	public static boolean validatorComputer(Computer computer) {
		
			if(computer.getIntroduced() ==null||computer.getDiscontinued() ==null) {
				return true;
				
			}
			return  computer.getIntroduced().isBefore(computer.getDiscontinued());
		
	}

}
