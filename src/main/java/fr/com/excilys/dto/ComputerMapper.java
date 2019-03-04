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
		computerDto.setIntroduced(convertToString(computer.getIntroduced()));
		computerDto.setDiscontinued(convertToString(computer.getDiscontinued()));
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
	
	public static Computer DtoToComputer(ComputerDTO computerDto) {
		Computer computer = new Computer();
		
		if(computerDto.getId()==null) {
		}else computer.setId(Long.parseLong(computerDto.getId()));
		
		computer.setName(computerDto.getName());
		
		if(computerDto.getIntroduced().equals("")) {
			computer.setIntroduced(null);
		}else computer.setIntroduced(convertToDate(computerDto.getIntroduced()));
		
		
		if(computerDto.getDiscontinued().equals("")) {
			computer.setDiscontinued(null);
		}else computer.setDiscontinued(convertToDate(computerDto.getDiscontinued()));
		
		
		Company company = new Company();
		company.setId(Long.parseLong(computerDto.getCompanyID()));
		company.setName(computerDto.getCompanyName());
		computer.setCompany(company);
		
		return computer;
	}
	
	public static String convertToString(LocalDate localDate) {
		String formattedString;
		System.out.println(localDate);
		if(null!=localDate) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formattedString = localDate.format(formatter);
		}else formattedString = "-";
		
		return formattedString;
	}
	
	public static LocalDate convertToDate(String str) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate formattedString = LocalDate.parse(str,formatter);
		
		return formattedString;
	}
	
	public static long StringToLong(String str) {
		return Long.parseLong(str);
	}
	
	public static List<String> IntToString(List<Integer> linteger) {
		List<String> strNavigation = new ArrayList<String>();
		
			for(Integer integer : linteger) {
			
				strNavigation.add(String.valueOf(integer));
			}
		return strNavigation;
	}
	
}
