package fr.com.excilys.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.com.excilys.dto.ComputerDTO;
import fr.com.excilys.dto.ComputerMapper;
import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.service.CompanyServiceJpa;
import fr.com.excilys.service.ComputerServiceJpa;

@Controller
@RequestMapping(path = "/AddComputer")

public class AddComputerServlet {

	private CompanyServiceJpa companyServiceJpa;
	private ComputerServiceJpa computerServiceJpa;
	private ComputerMapper computerMapper;

	public AddComputerServlet(ComputerServiceJpa computerServiceJpa, CompanyServiceJpa companyServiceJpa,
			ComputerMapper computerMapperJpa) {
		this.computerServiceJpa = computerServiceJpa;
		this.companyServiceJpa = companyServiceJpa;
		this.computerMapper = computerMapperJpa;
	}

	@GetMapping
	public String get(Model model) {

		List<Company> listCompany = this.companyServiceJpa.getList();

		model.addAttribute("listCompany", listCompany);

		return "addComputer";
	}

	@PostMapping
	public String post(@RequestParam(name = "computerName", required = true) String computerName,
			@RequestParam(name = "introduced") String introduced,
			@RequestParam(name = "discontinued") String discontinued,
			@RequestParam(name = "companyId") String companyId) {

		ComputerDTO computerDto = new ComputerDTO();

		computerDto.setName(computerName);
		computerDto.setIntroduced(introduced);
		computerDto.setDiscontinued(discontinued);
		computerDto.setCompanyID(companyId);
		Computer computer = this.computerMapper.DtoToComputer(computerDto).get();

		this.computerServiceJpa.create(computer);
		return "redirect:/Dashboard";

	}

}
