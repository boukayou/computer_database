package fr.com.excilys.sevlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.com.excilys.checking.Pagination;
import fr.com.excilys.dto.ComputerDTO;
import fr.com.excilys.dto.ComputerMapper;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.service.CompanyService;
import fr.com.excilys.service.ComputerService;

/**
 * Servlet implementation class DashBoardComputerServlet
 */
@WebServlet("/SearchComputerByname")

public class SearchComputerByname extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String nbrOfElements;
	private String page;
	private Pagination pagination = new Pagination();
	private ComputerService computerService ;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchComputerByname() {
		// TODO Auto-generated constructor stub
		computerService = ComputerService.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
			nbrOfElements = request.getParameter("nbrOfElements");
			page = request.getParameter("page");
		

			pagination.setPage(page);
			pagination.setNbOfElements(nbrOfElements);
			String name =request.getParameter("search");
			String stringname = "App";
			Optional<List<Computer>> optionalListComputer=pagination.ComputersByName(stringname, pagination);
			if(optionalListComputer.isPresent()) {
				List<Computer> listcomputer = optionalListComputer.get();
				for(Computer computer :listcomputer) {
					System.out.println(computer);
				}
				List<ComputerDTO> listComputerDto = ComputerMapper.getListComputerDto(listcomputer);
				request.setAttribute("listComputerByname", listComputerDto);
				List<String> listNavigation = ComputerMapper.IntToString(pagination.navigation());
				request.setAttribute("listNavigation",listNavigation );
				String nbrOfCompFOund =String.valueOf(computerService.count());
				request.setAttribute("nbrOfCompFOund",nbrOfCompFOund );
			}
		this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
