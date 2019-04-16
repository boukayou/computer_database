package com.excilys.boukayou.validator.tech;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.excilys.boukayou.dto.ComputerDTO;
import com.excilys.boukayou.exceptions.ValidatorException;

@Component
public class ValidatorTech {

	public void validatorTech(ComputerDTO computerDto) throws ValidatorException {

		if (!(checkDateIsValidType(computerDto) && checkNameIsNotEmpty(computerDto))) {
			throw new ValidatorException("Data computer invalid Je suis un hero un hero !");
		}
	}

	public static boolean checkDateIsValidType(ComputerDTO computerDto) {
		if ((computerDto.getIntroduced() == null || computerDto.getIntroduced().isEmpty())
				&& (computerDto.getDiscontinued() == null || computerDto.getDiscontinued().isEmpty())) {

			return true;

		}

		//String patternStr = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
		String patternStr =  "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
			      + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
			      + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
			      + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
		Pattern pattern = Pattern.compile( patternStr);

		// create a matcher that will match the given input against this pattern
		Matcher matcherIntroduced = pattern.matcher(computerDto.getIntroduced());
		boolean matchIntroduced = matcherIntroduced.matches();


		// create a matcher that will match the given input against this pattern

		Matcher matcherDiscontinued = pattern.matcher(computerDto.getIntroduced());
		boolean matchDiscontinued = matcherDiscontinued.matches();


		return (matchIntroduced & matchDiscontinued) ;
	}

	public static boolean checkNameIsNotEmpty(ComputerDTO computerDto) {

		return computerDto.getName().matches("^\\S.*");
	}

	public static boolean checkIdIsValid(ComputerDTO computerDto) {

		String patternStr = "([0-9]{4})";
		Pattern pattern = Pattern.compile(patternStr);

		// create a matcher that will match the given input against this pattern
		Matcher matcher = pattern.matcher(computerDto.getId());

		return matcher.matches(); // return true or false
	}
}