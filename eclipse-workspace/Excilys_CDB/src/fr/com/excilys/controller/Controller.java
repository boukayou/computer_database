package fr.com.excilys.controller;

import java.sql.SQLException;
import java.text.ParseException;
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
	
	private Controller() throws ParseException {
		Begin();
	}
	
	public static Controller getInstance() throws ParseException {
		if(instance==null) {
			instance = new Controller();
		}
		return instance;
	}
	
	private void addComputer(Computer computerToAdd) throws SQLException {
		
		computerDao.createComputer(computerToAdd);
	}

	
	private void initialise() {
		this.isAlive = true;
		this.daoFactory  = DaoFactory.getInstence();
		this.computerDao = this.daoFactory.getComputerDao();
		this.companyDao  = this.daoFactory.getCompanyDao();
	}
	
	
	private void Begin() throws ParseException {
		initialise();
		while(this.isAlive) {
			try {
				UserRequest();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void UserRequest() throws SQLException, ParseException {
		
			
		while(false != isAlive) {
			VueMenu.showChoice();
			Scanner scn = new Scanner(System.in);
			String value = scn.nextLine();
			
			switch(value) {
			case "1" :
				List<Company>  listCompany  = companyDao.listCompany();
				VueMenu.showAllCompanies(listCompany);
				break;
			case "2" :
				List<Computer> listComputer = computerDao.ListComputer();
				VueMenu.showAllComputers(listComputer);
				break;
			case "3" :
				Computer computer;
				VueMenu.showComputersDetails(computer =computerDao.ComputerById(VueMenu.getId()));
				break;
			case "4" :
				
				computerDao.createComputer(VueMenu.addComputerUser());
				break;
			case "5" :
				//update
				break;
			case "6" :
				computerDao.deleteComputer(computer =computerDao.ComputerById(VueMenu.getId()));
				break;
			case "7" :
				this.isAlive = false;
				break;
			default:
				System.out.println(" Error !");
			}
		}
	}
}
