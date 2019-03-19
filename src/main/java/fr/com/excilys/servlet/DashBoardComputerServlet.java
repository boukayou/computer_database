package fr.com.excilys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.com.excilys.dto.ComputerDTO;
import fr.com.excilys.dto.ComputerMapper;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.service.ComputerService;
import fr.com.excilys.validator.Pagination;

/**
 * Servlet implementation class DashBoardComputerServlet
 */
@Controller
@RequestMapping(path = { "/Dashboard", "" })

public class DashBoardComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String nbrOfElements;
	private String page;
	private String sort;
	private Pagination pagination = new Pagination();
	private ComputerService computerService;
	private ComputerMapper computerMapper;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashBoardComputerServlet(ComputerService computerService, ComputerMapper computerMapper) {

		this.computerService = computerService;
		this.computerMapper = computerMapper;

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		nbrOfElements = request.getParameter("nbrOfElements");
		page = request.getParameter("page");
		sort = request.getParameter("sortBycomputer");
		pagination.setPage(page);
		pagination.setSort(sort);
		pagination.setNbOfElements(nbrOfElements);

		if (null != request.getParameter("search")) {
			pagination.setSearch(request.getParameter("search"));
		}

		List<Computer> listcomputer = pagination.getList();
		List<ComputerDTO> listComputerDto = this.computerMapper.getListComputerDto(listcomputer);
		request.setAttribute("listComputerDto", listComputerDto);

		List<String> listNavigation = this.computerMapper.IntToString(pagination.navigation());
		request.setAttribute("listNavigation", listNavigation);

		String nbrOfCompFOund = String.valueOf(this.computerService.count());

		request.setAttribute("nbrOfCompFOund", nbrOfCompFOund);

		this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
