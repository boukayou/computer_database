package fr.com.excilys.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.com.excilys.modele.Company;

public class CompanyDaoImpl implements CompanyDao {
	
	DaoFactory factory;
	public CompanyDaoImpl(DaoFactory fact){
		this.factory = fact;		
	}

	@Override
	public List<Company> listCompany() throws SQLException {
		// TODO Auto-generated method stub
		List<Company> listCompany = new ArrayList<Company>();
		
		Connection connect = this.factory.getConnection();
		PreparedStatement prepareStat = connect.prepareStatement("SELECT * FROM company");
		ResultSet result = prepareStat.executeQuery();
		
		while(result.next()) {
			long id = result.getLong("id");
			String name = result.getString("name");
			Company company = new Company(id,name);
			listCompany.add(company);
		}
		return listCompany;
	}

}
