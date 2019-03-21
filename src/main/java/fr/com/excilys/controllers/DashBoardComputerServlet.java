package fr.com.excilys.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.com.excilys.dto.ComputerDTO;
import fr.com.excilys.dto.ComputerMapper;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.service.CompanyService;
import fr.com.excilys.service.ComputerService;
import fr.com.excilys.validator.Pagination;

@Controller
@RequestMapping(path = { "/Dashboard", "" })

public class DashBoardComputerServlet {

	protected Pagination pagination;
	protected ComputerService computerService;
	protected ComputerMapper computerMapper;
	protected CompanyService companyService;

	public DashBoardComputerServlet(ComputerService computerService, CompanyService companyService,
			ComputerMapper computerMapper, Pagination pagination) {

		this.computerService = computerService;
		this.companyService = companyService;
		this.computerMapper = computerMapper;
		this.pagination = pagination;
	}

	@GetMapping
	public String get(Model model, @RequestParam(name = "nbrOfElements", defaultValue = "10") String nbrOfElements,
			@RequestParam(name = "page", defaultValue = "1") String page,
			@RequestParam(name = "sortBycomputer", defaultValue = "computer.name") String sortBycomputer,
			@RequestParam(name = "search", defaultValue = "") String search) {

		pagination.setPage(page);
		pagination.setSort(sortBycomputer);
		pagination.setNbOfElements(nbrOfElements);

		if (null != search) {
			pagination.setSearch(search);
		}

		List<Computer> listcomputer = this.computerService.getList(pagination);

		List<ComputerDTO> listComputerDto = this.computerMapper.getListComputerDto(listcomputer);
		List<String> listNavigation = this.computerMapper.IntToString(pagination.navigation());

		String nbrOfCompFOund = String.valueOf(this.computerService.count());

		model.addAttribute("listNavigation", listNavigation);

		model.addAttribute("listComputerDto", listComputerDto);

		model.addAttribute("nbrOfCompFOund", nbrOfCompFOund);

		return "dashboard";
	}

}
