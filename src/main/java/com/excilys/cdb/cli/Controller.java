package com.excilys.cdb.cli;

/*@Component
public class Controller {

	private Boolean isAlive;
	// public static Controller instance;
	private CompanyService companyService;
	private ComputerService computerService;

	private Controller(ComputerService computerService, CompanyService companyService)
			throws ParseException, ClassNotFoundException {
		this.computerService = computerService;
		this.companyService = companyService;

		// Begin();
	}

	
//	  public static Controller getInstance() throws ParseException,
//	  ClassNotFoundException { if(instance==null) { instance = new Controller(); }
//	  return instance; }
//	 

	private void initialise() {
		this.isAlive = true;
		// this.computerService = ComputerService.getInstance();
		// this.companyService = CompanyService.getInstance();
	}

	private void Begin() throws ParseException, ClassNotFoundException {
		initialise();
		while (this.isAlive) {
			try {
				UserRequest();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void UserRequest() throws SQLException, ParseException, ClassNotFoundException {

		while (false != isAlive) {
			VueMenu.showChoice();

			switch (VueMenu.Choice()) {
			case "1":
				// List<Company> listCompany = companyDao.listCompany();
				// VueMenu.showAllCompanies(companyService.getList());
				break;
			case "2":
				// List<Computer> listComputer = computerDao.ListComputer();
				// VueMenu.showAllComputers(computerService.getList(10,2,"appl"));
				break;
			case "3":
				Computer computer;
				VueMenu.showComputersDetails(computer = computerService.getById((VueMenu.getId())));
				break;
			case "4":
				computerService.create(VueMenu.addComputer());
				break;
			case "5":
				computerService.upDate(VueMenu.upDateComputer());
				break;
			case "6":
				computerService.delete((computer = computerService.getById(VueMenu.getId())));
				break;
			case "7":
				this.isAlive = false;
				break;
			default:
				System.out.println(" Error !");
			}
		}
	}
}*/
