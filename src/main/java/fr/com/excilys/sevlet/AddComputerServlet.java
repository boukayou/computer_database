package fr.com.excilys.sevlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.com.excilys.dto.ComputerDTO;
import fr.com.excilys.dto.ComputerMapper;
import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;
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
    public AddComputerServlet() {
       
        // TODO Auto-generated constructor stub
    	 companyService = CompanyService.getInstance();
         computerService= ComputerService.getInstance();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Company> listCompany = companyService.getList() ;
		
			request.setAttribute("list", listCompany);
		this.getServletContext().getRequestDispatcher("/WEB-INF/addComputer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//this.doPost(request, response);
		ComputerDTO computerDto = new ComputerDTO();
		
		computerDto.setName(request.getParameter("computerName"));
		computerDto.setIntroduced(request.getParameter("introduced"));
		computerDto.setDiscontinued(request.getParameter("discontinued"));
		computerDto.setCompanyID(request.getParameter("companyId"));
		computerService.create(ComputerMapper.DtoToComputer(computerDto).get());
		
	}

}
