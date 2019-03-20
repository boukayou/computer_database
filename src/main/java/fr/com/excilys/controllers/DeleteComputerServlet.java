package fr.com.excilys.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.com.excilys.modele.Computer;
import fr.com.excilys.service.ComputerService;

/**
 * Servlet implementation class DeleteComputerServlet
 */
@WebServlet("/DeleteComputer")
public class DeleteComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ComputerService computerService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteComputerServlet(ComputerService computerService) {

		this.computerService = computerService;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] idTodelete = request.getParameter("selection").split(",");
		for(String str :idTodelete ) {
		Computer computerToDelete = computerService.getById(Long.parseLong(str));
		computerService.delete(computerToDelete);
		}
		response.sendRedirect(request.getContextPath() + "/Dashboard");
	}

}
