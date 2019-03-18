package fr.com.excilys.servlet;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import fr.com.excilys.dto.ComputerDTO;
import fr.com.excilys.dto.ComputerMapper;
import fr.com.excilys.modele.Company;
import fr.com.excilys.service.CompanyService;
import fr.com.excilys.service.ComputerService;

/**
 * Servlet implementation class AddComputerServlet
 */
@WebServlet("/AddComputer")
public class AddComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompanyService companyService;
	private ComputerService computerService; 
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AddComputerServlet(ComputerService computerService,CompanyService companyService) {
       
    	this.companyService = companyService;
         this.computerService= computerService;
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Company> listCompany = companyService.getList() ;
		
			request.setAttribute("list", listCompany);
		this.getServletContext().getRequestDispatcher("/WEB-INF/addComputer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.doPost(request, response);
		ComputerDTO computerDto = new ComputerDTO();
		
		computerDto.setName(request.getParameter("computerName"));
		computerDto.setIntroduced(request.getParameter("introduced"));
		computerDto.setDiscontinued(request.getParameter("discontinued"));
		computerDto.setCompanyID(request.getParameter("companyId"));
	try {
		computerService.create(ComputerMapper.DtoToComputer(computerDto).get());
	}catch(NoSuchElementException e) {
		
		e.getStackTrace();
	}
		
	}

}
