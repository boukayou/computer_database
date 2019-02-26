package fr.com.excilys.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;

public class ComputerMapper {
	
	public static ComputerDTO computerToDto(Computer computer) {
		ComputerDTO computerDto = new ComputerDTO();
		
		computerDto.setId(Long.toString(computer.getId()));
		computerDto.setName(computer.getName());
		computerDto.setIntroduced(convertToDate(computer.getIntroduced()));
		computerDto.setDiscontinued(convertToDate(computer.getDiscontinued()));
		computerDto.setCompanyID(Long.toString(computer.getCompany().getId()));
		computerDto.setCompanyName(computer.getCompany().getName());
		return computerDto;
	}
	
	public static List<ComputerDTO> getListComputerDto(List<Computer> computers){
		List<ComputerDTO> listToreturn = new ArrayList<ComputerDTO>();
		for (Computer computer : computers) {
			listToreturn.add(computerToDto(computer));
		}		
		return listToreturn;

	}
	
	public Computer DtoToComputer(ComputerDTO computerDto) {
		Computer computer = new Computer();
		computer.setId(Long.parseLong(computerDto.getId()));
		computer.setName(computer.getName());
		computer.setIntroduced(convertToString(computerDto.getIntroduced()));
		computer.setDiscontinued(convertToString(computerDto.getDiscontinued()));
		
		Company company = new Company();
		company.setId(Long.parseLong(computerDto.getCompanyID()));
		company.setName(computerDto.getCompanyName());
		computer.setCompany(company);
		
		return computer;
	}
	
	public static String convertToDate(LocalDate localDate) {
		String formattedString;
		System.out.println(localDate);
		if(null!=localDate) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formattedString = localDate.format(formatter);
		}else formattedString = "-";
		
		return formattedString;
	}
	
	public static LocalDate convertToString(String str) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate formattedString = LocalDate.parse(str,formatter);
		
		return formattedString;
	}
	
}
