package fr.com.excilys.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

/**
 * Servlet implementation class AddComputerServlet
 */
@Controller
@RequestMapping(path = "/AddComputer")

public class AddComputerServlet {

	private CompanyService companyService;
	private ComputerService computerService;
	private ComputerMapper computerMapper;

	public AddComputerServlet(ComputerService computerService, CompanyService companyService,
			ComputerMapper computerMapper) {
		this.computerService = computerService;
		this.companyService = companyService;
		this.computerMapper = computerMapper;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@GetMapping("/addComputer")
	public String get(Model model) {

		List<Company> listCompany = this.companyService.getList();

		// model.addAttribute("computer", new ComputerDto());
		model.addAttribute("listCompany", listCompany);

		return "addComputer";
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response)throws ServletException, IOException {
	 * 
	 * List<Company> listCompany = this.companyService.getList();
	 * 
	 * request.setAttribute("list", listCompany);
	 * this.getServletContext().getRequestDispatcher("/WEB-INF/addComputer.jsp").
	 * forward(request, response); }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@PostMapping
	public void post(@RequestParam(name = "computerName", defaultValue = "") String computerName,
			@RequestParam(name = "introduced", defaultValue = "") String introduced,
			@RequestParam(name = "discontinued", defaultValue = "") String discontinued,
			@RequestParam(name = "companyId", defaultValue = "-1") String companyId, Model model) {

		ComputerDTO computerDto = new ComputerDTO();

		computerDto.setName(computerName);
		computerDto.setIntroduced(introduced);
		computerDto.setDiscontinued(discontinued);
		computerDto.setCompanyID(companyId);
		try {
			this.computerService.create(this.computerMapper.DtoToComputer(computerDto).get());
		} catch (NoSuchElementException e) {

			e.getStackTrace();
		}

	}

}
