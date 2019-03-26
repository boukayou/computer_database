package com.excilys.dto.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.excilys.dto.ComputerDTO;
import com.excilys.dto.ComputerMapper;
import com.excilys.modele.Company;
import com.excilys.modele.Computer;

class ComputerMapperTest {
	
	ComputerMapper computerMapper;
	ComputerMapperTest(ComputerMapper computerMapper){
		this.computerMapper =computerMapper;
		
	}
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	private Company company = new Company(10, "Apple Inc.");

	private ComputerDTO computerDto = new ComputerDTO("AZ", "2029/03/24", "2019/03/24", "Apple Inc.", "10", "1");
	private Computer computer = new Computer(1, "AZ", LocalDate.parse("2029/03/24", formatter),
			LocalDate.parse("2019/03/24", formatter), company);
	

	@Test
	void testListComputerTodListDto() {

		List<Computer> listDetest = new ArrayList<Computer>();
		listDetest.add(computer);

		assertEquals(computerDto, computerMapper.getListComputerDto(listDetest).get(0));
	}

	@Test
	void testListComputerTodListDto2() {
		computerDto.setIntroduced("-");
		computerDto.setName(null);

		computer.setIntroduced(null);
		computer.setName(null);
		List<Computer> listDetest = new ArrayList<Computer>();
		listDetest.add(computer);

		assertEquals(computerDto, computerMapper.getListComputerDto(listDetest).get(0));

	}

	@Test
	void testComputerTodDto() {

		assertEquals(computerDto, computerMapper.computerToDto(computer));

	}

	@Test
	void testDtoTodComputer() {
		assertEquals(computer, computerMapper.DtoToComputer(computerDto).get());

	}

	@Test
	void testStringToLong() {
		String str = "1";
		long strTolng = 1;
		assertEquals(strTolng, computerMapper.StringToLong(str));
	}
/*
	@Test
	void testStringToLocalDate() {
		LocalDate localDate = LocalDate.of(2012, 12, 22);
		String localDateStr = "2012/12/22";
		assertEquals(localDate, computerMapper.convertStringToLocalDate(localDateStr).get());

	}*/

	@Test
	void testLocalDateToString() {
	}

}
