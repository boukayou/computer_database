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
import fr.com.excilys.service.CompanyService;
import fr.com.excilys.service.ComputerService;


@Controller
@RequestMapping(path = "/AddComputer")

public class AddComputerServlet {

	private CompanyService companyService;
	private ComputerService computerService;
	private ComputerMapper computerMapper;

	public AddComputerServlet(ComputerService computerService, CompanyService companyService,ComputerMapper computerMapper) {
		this.computerService = computerService;
		this.companyService = companyService;
		this.computerMapper = computerMapper;
	}



	@GetMapping
	public String get(Model model) {

		List<Company> listCompany = this.companyService.getList();

		model.addAttribute("listCompany", listCompany);

		return "addComputer";
	}


	@PostMapping
	public String post(@RequestParam(name = "computerName",required=true) String computerName,
			@RequestParam(name = "introduced") String introduced,
			@RequestParam(name = "discontinued") String discontinued,
			@RequestParam(name = "companyId") String companyId) {

		ComputerDTO computerDto = new ComputerDTO();

		computerDto.setName(computerName);
		computerDto.setIntroduced(introduced);
		computerDto.setDiscontinued(discontinued);
		computerDto.setCompanyID(companyId);
			this.computerService.create(this.computerMapper.DtoToComputer(computerDto).get());
			System.out.println("fin nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		return  "redirect:/Dashboard";

	}

}
