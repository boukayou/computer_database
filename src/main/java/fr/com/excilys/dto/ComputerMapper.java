package fr.com.excilys.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.persistence.ComputerDaoImpl;
import fr.com.excilys.validator.ValidatorTech;

@Component
public class ComputerMapper {
	
	final static Logger logger = LoggerFactory.getLogger(ComputerDaoImpl.class);
	
	
	public static ComputerDTO computerToDto(Computer computer) {
		ComputerDTO computerDto = new ComputerDTO();

		computerDto.setId(Long.toString(computer.getId()));
		computerDto.setName(computer.getName());
		computerDto.setIntroduced(convertLocalDateToString(computer.getIntroduced()));
		computerDto.setDiscontinued(convertLocalDateToString(computer.getDiscontinued()));
		computerDto.setCompanyID(Long.toString(computer.getCompany().getId()));
		computerDto.setCompanyName(computer.getCompany().getName());
		return computerDto;
	}

	public static List<ComputerDTO> getListComputerDto(List<Computer> computers) {
		List<ComputerDTO> listToreturn = new ArrayList<ComputerDTO>();
		for (Computer computer : computers) {
			listToreturn.add(computerToDto(computer));
		}
		return listToreturn;

	}

	public static Optional<Computer> DtoToComputer(ComputerDTO computerDto) {
		Computer computer = new Computer();
		Optional<Computer> optionalComputer = Optional.empty();
		
		if (ValidatorTech.validatorComputer(computerDto)) {

			if (computerDto.getId() != null) {
				computer.setId(Long.parseLong(computerDto.getId()));
			}

			computer.setName(computerDto.getName());
			
			if (computerDto.getIntroduced().equals("")) {
				computer.setIntroduced(null);
			} else {
				computer.setIntroduced(convertStringToLocalDate(computerDto.getIntroduced()).get());
			}
			
			if (computerDto.getDiscontinued().equals("")) {
				computer.setDiscontinued(null);
			} else {
				computer.setDiscontinued(convertStringToLocalDate(computerDto.getDiscontinued()).get());
			}

			Company company = new Company();
			company.setId(Long.parseLong(computerDto.getCompanyID()));
			company.setName(computerDto.getCompanyName());
			computer.setCompany(company);
			optionalComputer = Optional.of(computer);

		}
		return optionalComputer;
	}

	public static String convertLocalDateToString(LocalDate localDate) {
		String formattedString;
		if (null != localDate) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			formattedString = localDate.format(formatter);
		} else
			formattedString = "-";

		return formattedString;
	}

	public static Optional<LocalDate> convertStringToLocalDate(String str) {
		
		Optional<LocalDate> optionalDate = Optional.empty();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		try {
			LocalDate formattedLocalDate = LocalDate.parse(str, formatter);
			optionalDate = Optional.of(formattedLocalDate);

		}catch(DateTimeParseException e) {
			logger.error("Error in Computermapper/ConvertDate the date format is not valid at index :" + e.getErrorIndex());
			
		}
		return optionalDate;
	}

	public static long StringToLong(String str) {
		return Long.parseLong(str);
	}

	public static List<String> IntToString(List<Integer> linteger) {
		List<String> strNavigation = new ArrayList<String>();

		for (Integer integer : linteger) {

			strNavigation.add(String.valueOf(integer));
		}
		return strNavigation;
	}

}
