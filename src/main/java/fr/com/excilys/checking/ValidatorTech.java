package fr.com.excilys.checking;

	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	import fr.com.excilys.dto.ComputerDTO;


public class ValidatorTech {

		public static boolean validatorComputer(ComputerDTO computerDto) {
			System.out.println(((checkDateIsValidType(computerDto) & checkNameIsNotEmpty(computerDto))) ? true : false);
			return ((checkDateIsValidType(computerDto) & checkNameIsNotEmpty(computerDto))) ? true : false;
			
		}

		public static boolean checkDateIsValidType(ComputerDTO computerDto) {

			String patternStr = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
			Pattern pattern = Pattern.compile(patternStr);

			// create a matcher that will match the given input against this pattern
			Matcher matcherIntroduced = pattern.matcher(computerDto.getIntroduced());
			boolean matchIntroduced = matcherIntroduced.matches();

			// create a matcher that will match the given input against this pattern
			Matcher matcherDiscontinued = pattern.matcher(computerDto.getIntroduced());
			boolean matchDiscontinued = matcherDiscontinued.matches();
			
			
			return (matchIntroduced  & matchDiscontinued ) ? true : false;
		}

		public static boolean checkNameIsNotEmpty(ComputerDTO computerDto) {
			
			return computerDto.getName().matches( "^\\S.*");
		}

		public static boolean checkIdIsValid(ComputerDTO computerDto) {

			String patternStr = "([0-9]{4})";
			Pattern pattern = Pattern.compile(patternStr);

			// create a matcher that will match the given input against this pattern
			Matcher matcher = pattern.matcher(computerDto.getId());

			return matcher.matches(); // return true or false	 
		}
	}