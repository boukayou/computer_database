package fr.com.excilys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.com.excilys.dto.ComputerDTO;
import fr.com.excilys.dto.ComputerMapper;
import fr.com.excilys.modele.Company;
import fr.com.excilys.service.CompanyService;
import fr.com.excilys.service.ComputerService;
import fr.com.excilys.springConf.SpringConfig;

/**
 * Servlet implementation class AddComputerServlet
 */
@Controller
@RequestMapping(path = "/AddComputer")

public class AddComputerServlet  {

	private CompanyService companyService;
	private ComputerService computerService;
	private ComputerMapper computerMapper;

	public AddComputerServlet(ComputerService computerService, CompanyService companyService,ComputerMapper computerMapper) {
		this.computerService = computerService;
		this.companyService = companyService;
		this.computerMapper = computerMapper;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	 @GetMapping
	  public String get(Model model) {
	    ArrayList<Company> companies = companyService.getList();

	    model.addAttribute("computer", new ComputerDto());
	    model.addAttribute("companies", companies);

	    return "addComputer";
	}
	 
	 
	 
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<Company> listCompany = this.companyService.getList();

		request.setAttribute("list", listCompany);
		this.getServletContext().getRequestDispatcher("/WEB-INF/addComputer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// this.doPost(request, response);
		ComputerDTO computerDto = new ComputerDTO();

		computerDto.setName(request.getParameter("computerName"));
		computerDto.setIntroduced(request.getParameter("introduced"));
		computerDto.setDiscontinued(request.getParameter("discontinued"));
		computerDto.setCompanyID(request.getParameter("companyId"));
		try {
			this.computerService.create(this.computerMapper.DtoToComputer(computerDto).get());
		} catch (NoSuchElementException e) {

			e.getStackTrace();
		}

	}

}
