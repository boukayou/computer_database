package com.excilys.boukayou.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.excilys.boukayou.dto.ComputerDTO;
import com.excilys.boukayou.modele.Company;
import com.excilys.boukayou.modele.Computer;
import com.excilys.boukayou.validator.tech.ValidatorTech;

@Component
public class ComputerMapper {
	
	ValidatorTech validatorTech;
 public ComputerMapper(ValidatorTech validatorTech) {
	 this.validatorTech = validatorTech;
 }
	final static Logger logger = LoggerFactory.getLogger(ComputerMapper.class);

	public ComputerDTO computerToDto(Computer computer) {

		ComputerDTO computerDto = new ComputerDTO();

		computerDto.setId(Long.toString(computer.getId()));
		computerDto.setName(computer.getName());
		computerDto.setIntroduced(convertLocalDateToString(computer.getIntroduced()));
		computerDto.setDiscontinued(convertLocalDateToString(computer.getDiscontinued()));
		
		if(computer.getCompany()!=null) {
			
		computerDto.setCompanyID(Long.toString(computer.getCompany().getId()));
		computerDto.setCompanyName(computer.getCompany().getName());
		}
		return computerDto;
	}

	public Optional<Computer> DtoToComputer(ComputerDTO computerDto) {
		
		Computer computer = new Computer();
		Optional<Computer> optionalComputer = Optional.empty();

			 try {
				this.validatorTech.validatorTech(computerDto);
				
				if (computerDto.getId() != null) {
					computer.setId(Long.parseLong(computerDto.getId()));
				}

				computer.setName(computerDto.getName());

				if (computerDto.getIntroduced() != null && !computerDto.getIntroduced().isEmpty()) {
					computer.setIntroduced(convertStringToLocalDate(computerDto.getIntroduced()));
				} else {
					computer.setIntroduced(null);
				}
				if (computerDto.getDiscontinued() != null && !computerDto.getDiscontinued().isEmpty()) {
					computer.setDiscontinued(convertStringToLocalDate(computerDto.getDiscontinued()));
				} else {
					computer.setDiscontinued(null);
				}

				Company company = new Company();
				company.setId(Long.parseLong(computerDto.getCompanyID()));
				
				company.setName(computerDto.getCompanyName());
				
				computer.setCompany(company);
				
				optionalComputer = Optional.of(computer);
				
			} catch (com.excilys.boukayou.exceptions.ValidatorException e) {
				e.getMessage();
			}

		return optionalComputer;
	}

	public List<ComputerDTO> getListComputerDto(List<Computer> computers) {
 
		List<ComputerDTO> listToreturn = new ArrayList<ComputerDTO>();
		
		for (Computer computer : computers) {

		 listToreturn.add(computerToDto(computer));

		}

		return listToreturn;
	}

	public String convertLocalDateToString(LocalDate localDate) {
		
		String formattedString;
		
		if (null != localDate) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			formattedString = localDate.format(formatter);
			
		} else {
			
			formattedString = "-";
		}

		return formattedString;
	}

	private LocalDate convertStringToLocalDate(String date) {
		
		LocalDate formattedLocalDate = null;
		
		if (date != null && !date.isEmpty()) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			formattedLocalDate = LocalDate.parse(date, formatter);
			
		}
		
		return formattedLocalDate;
	}

	public long StringToLong(String str) {
		
		return Long.parseLong(str);
	}

	public List<String> IntToString(List<Integer> linteger) {
		
		List<String> strNavigation = new ArrayList<String>();

		for (Integer integer : linteger) {

			strNavigation.add(String.valueOf(integer));
		}
		return strNavigation;
	}

}
