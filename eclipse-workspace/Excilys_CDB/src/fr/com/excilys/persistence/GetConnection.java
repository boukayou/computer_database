package fr.com.excilys.persistence;

public class GetConnection {
	
	
	private GetConnection() {
		
	}

	private ComputerDao computerDao ;
	private CompanyDao companyDao ;
	private DaoFactory daoFactory;
	
	private void initialise() {
		//this.isAlive = true;
		this.daoFactory  = DaoFactory.getInstence();
		this.computerDao = this.daoFactory.getComputerDao();
		this.companyDao  = this.daoFactory.getCompanyDao();
	}
}
