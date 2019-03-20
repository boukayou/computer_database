package fr.com.excilys.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import fr.com.excilys.dto.ComputerDTO;
import fr.com.excilys.dto.ComputerMapper;
import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.service.CompanyService;
import fr.com.excilys.service.ComputerService;

/**
 * Servlet implementation class EditComputerServlet
 */
@WebServlet("/EditComputer")
public class EditComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompanyService companyService;
	private ComputerService computerService;
	private ComputerMapper computerMapper;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Autowired
	public EditComputerServlet(CompanyService companyService, ComputerService computerService,
			ComputerMapper computerMapper) {
		this.companyService = companyService;
		this.computerService = computerService;
		this.computerMapper = computerMapper;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Computer computerToEdit = this.computerService.getById(Long.parseLong(request.getParameter("idComputer")));
		request.setAttribute("computerToEdit", computerToEdit);
		List<Company> listCompany = this.companyService.getList();
		request.setAttribute("list", listCompany);
		this.getServletContext().getRequestDispatcher("/WEB-INF/editComputer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ComputerDTO computerDto = new ComputerDTO();
		computerDto.setId((request.getParameter("idComputer")));
		computerDto.setName(request.getParameter("computerName"));
		computerDto.setIntroduced(request.getParameter("introduced"));
		computerDto.setDiscontinued(request.getParameter("discontinued"));
		computerDto.setCompanyID(request.getParameter("companyId"));
		computerService.upDate(this.computerMapper.DtoToComputer(computerDto).get());
		response.sendRedirect(request.getContextPath() + "/Dashboard");
	}

}
