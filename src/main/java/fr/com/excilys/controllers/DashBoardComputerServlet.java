package fr.com.excilys.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.com.excilys.dto.ComputerDTO;
import fr.com.excilys.dto.ComputerMapper;
import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.service.CompanyService;
import fr.com.excilys.service.ComputerService;
import fr.com.excilys.validator.Pagination;

@Controller
@RequestMapping(path = { "/Dashboard", ""})

public class DashBoardComputerServlet {

	private Pagination pagination;
	private ComputerService computerService;
	private ComputerMapper computerMapper;
	private CompanyService companyService;


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
			@RequestParam(name = "sortBycomputer", defaultValue = "name") String sortBycomputer,
			@RequestParam(name = "search", defaultValue = "") String search) {
		
		
		pagination.setPage(page);
		pagination.setSort(sortBycomputer);
		pagination.setNbOfElements(nbrOfElements);

		if (null != search) {
			pagination.setSearch(search);
		}

		
		
		List<Company> listCompany = this.companyService.getList();
		List<Computer> listcomputer = pagination.getList();
		List<ComputerDTO> listComputerDto = this.computerMapper.getListComputerDto(listcomputer);

		// model.addAttribute("computer", new ComputerDto());
		model.addAttribute("listComputerDto", listComputerDto);

		List<String> listNavigation = this.computerMapper.IntToString(pagination.navigation());
		model.addAttribute("listNavigation", listNavigation);

		String nbrOfCompFOund = String.valueOf(this.computerService.count());

		model.addAttribute("nbrOfCompFOund", nbrOfCompFOund);

		// return new RedirectView("redirectedUrl");
		return "dashboard";
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * nbrOfElements = request.getParameter("nbrOfElements"); page =
	 * request.getParameter("page"); sort = request.getParameter("sortBycomputer");
	 * pagination.setPage(page); pagination.setSort(sort);
	 * pagination.setNbOfElements(nbrOfElements);
	 * 
	 * if (null != request.getParameter("search")) {
	 * pagination.setSearch(request.getParameter("search")); }
	 * 
	 * List<Computer> listcomputer = pagination.getList(); List<ComputerDTO>
	 * listComputerDto = this.computerMapper.getListComputerDto(listcomputer);
	 * 
	 * request.setAttribute("listComputerDto", listComputerDto);
	 * 
	 * List<String> listNavigation =
	 * this.computerMapper.IntToString(pagination.navigation());
	 * request.setAttribute("listNavigation", listNavigation);
	 * 
	 * String nbrOfCompFOund = String.valueOf(this.computerService.count());
	 * 
	 * request.setAttribute("nbrOfCompFOund", nbrOfCompFOund);
	 * 
	 * this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").
	 * forward(request, response);
	 * 
	 * }
	 */

}
