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
	

	final static Logger logger = LoggerFactory.getLogger(ComputerMapper.class);

	public ComputerDTO computerToDto(Computer computer) {
		ComputerDTO computerDto = new ComputerDTO();

		computerDto.setId(Long.toString(computer.getId()));
		computerDto.setName(computer.getName());
		computerDto.setIntroduced(convertLocalDateToString(computer.getIntroduced()));
		computerDto.setDiscontinued(convertLocalDateToString(computer.getDiscontinued()));
		computerDto.setCompanyID(Long.toString(computer.getCompany().getId()));
		computerDto.setCompanyName(computer.getCompany().getName());
		return computerDto;
	}

	public  Optional<Computer> DtoToComputer(ComputerDTO computerDto){
		Computer computer = new Computer();
		Optional<Computer> optionalComputer = Optional.empty();

		if (ValidatorTech.validatorComputer(computerDto)) {

			if (computerDto.getId() != null) {
				computer.setId(Long.parseLong(computerDto.getId()));
			}

			computer.setName(computerDto.getName());
//
//			if (computerDto.getIntroduced().equals("")) {
//				computer.setIntroduced(null);
//			} else {
//				computer.setIntroduced(convertStringToLocalDate(computerDto.getIntroduced()));
//			}
			if (computerDto.getIntroduced() != null && !computerDto.getIntroduced().isEmpty()) {
				computer.setIntroduced(convertStringToLocalDate(computerDto.getIntroduced()));
			}else {
				computer.setIntroduced(null);
			}
			if (computerDto.getDiscontinued() != null && !computerDto.getDiscontinued().isEmpty()) {
				computer.setDiscontinued(convertStringToLocalDate(computerDto.getIntroduced()));
			}else {
				computer.setDiscontinued(null);
			}

			
//
//			if (computerDto.getDiscontinued().equals("")) {
//				computer.setDiscontinued(null);
//			} else {
//				computer.setDiscontinued(convertStringToLocalDate(computerDto.getDiscontinued()));
//			}

			Company company = new Company();
			company.setId(Long.parseLong(computerDto.getCompanyID()));
			company.setName(computerDto.getCompanyName());
			computer.setCompany(company);
			optionalComputer = Optional.of(computer);

		}
		return optionalComputer;
	}
	
	public  List<ComputerDTO> getListComputerDto(List<Computer> computers) {
		List<ComputerDTO> listToreturn = new ArrayList<ComputerDTO>();
		for (Computer computer : computers) {
			listToreturn.add(computerToDto(computer));
		}
		return listToreturn;

	}

	public  String convertLocalDateToString(LocalDate localDate) {
		String formattedString;
		if (null != localDate) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			formattedString = localDate.format(formatter);
		} else
			formattedString = "-";

		return formattedString;
	}

//	public  Optional<LocalDate> convertStringToLocalDate(String str) {
//		
//		
//		
//		Optional<LocalDate> optionalDate = Optional.empty();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		
//		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"+str);
//
//		try {
//			LocalDate formattedLocalDate =  LocalDate.parse("1995-01-11", formatter);
//			System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo222222222222222222222"+str);
//
//			optionalDate = Optional.of(formattedLocalDate);
//
//		} catch (DateTimeParseException e) {
//			e.getStackTrace();
//			logger.error("Error in Computermapper/ConvertDate the date format is not valid ");
//
//		}
//		return optionalDate;
//	}
	
	private LocalDate convertStringToLocalDate(String date) {
		LocalDate formattedString = null;
		if (date != null && !date.isEmpty()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			formattedString = LocalDate.parse(date, formatter);
		}
		return formattedString;
}
	
	

	public  long StringToLong(String str) {
		return Long.parseLong(str);
	}

	
	public  List<String> IntToString(List<Integer> linteger) {
		List<String> strNavigation = new ArrayList<String>();

		for (Integer integer : linteger) {

			strNavigation.add(String.valueOf(integer));
		}
		return strNavigation;
	}

}
