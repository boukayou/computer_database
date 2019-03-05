package fr.com.excilys.checking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.com.excilys.dto.ComputerDTO;


public class ValidationComputer {

	public static boolean validatorComputer(ComputerDTO computerDto) {
		return checkDateIsValidType(computerDto.getIntroduced());
		
	}

	public boolean checkIdExist() {
		boolean response = false;
		return response;
	}
	
	public static boolean checkDateIsValidType (String dateToCheck) {

		String patternStr = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        Pattern pattern = Pattern.compile(patternStr);
        
        // create a matcher that will match the given input against this pattern
        Matcher matcher = pattern.matcher(dateToCheck);
         
        boolean matchFound = matcher.matches();
        System.out.println( " - matches: " + matchFound);
		return matchFound;
	}
	
	public static boolean checkAmbiguousDate (ComputerDTO computerDto) {

	
		return false;
	}
	
	
	public boolean checkNameIsNotEmpty() {
		boolean response = false;
		
		return response;
	}
}
