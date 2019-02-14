package fr.com.excilys.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.persistence.CompanyDao;
import fr.com.excilys.persistence.ComputerDao;
import fr.com.excilys.persistence.DaoFactory;
import fr.com.excilys.ui.VueMenu;

public class Controller {

	private ComputerDao computerDao ;
	private CompanyDao companyDao ;
	private DaoFactory daoFactory;
	private Boolean isAlive ;
	public static Controller instance;
	
	private Controller() {
		Begin();
	}
	
	public static Controller getInstance() {
		if(instance==null) {
			instance = new Controller();
		}
		return instance;
	}

	
	private void initialise() {
		this.isAlive = true;
		this.daoFactory  = DaoFactory.getInstence();
		this.computerDao = this.daoFactory.getComputerDao();
		this.companyDao  = this.daoFactory.getCompanyDao();
	}
	
	
	private void Begin() {
		initialise();
		while(this.isAlive) {
			VueMenu.showChoice();
			try {
				UserRequest();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void UserRequest() throws SQLException {
		
		List<Computer> listComputer = computerDao.ListComputer();
		List<Company>  listCompany  = companyDao.listCompany();
		
		while(false != isAlive) {
			
			Scanner scn = new Scanner(System.in);
			String value = scn.nextLine();
			
			switch(value) {
			case "1" :
				VueMenu.showAllCompanies(listCompany);
				break;
			case "2" :
				VueMenu.showAllComputers(listComputer);
				break;
			case "3" :
				System.out.println("Enter the id you are looking for: /n");
				Scanner scnId = new Scanner(System.in);				 
				VueMenu.showComputersDetails(computerDao.ComputerById( Long.valueOf(scn.nextLine())));
				break;
			case "4" :
				VueMenu.showAllComputers(listComputer);
				break;
			case "5" :
				VueMenu.showAllComputers(listComputer);
				break;
			case "6" :
				VueMenu.showAllComputers(listComputer);
				break;
			case "7" :
				this.isAlive = false;
					//create
				break;
			default:
				System.out.println(" Error !");
			}
		}
	}
}
