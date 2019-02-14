package fr.com.excilys.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.com.excilys.modele.Computer;

public class ComputerDaoImpl implements ComputerDao {

	DaoFactory factory ;
	
	public ComputerDaoImpl(DaoFactory fact) {
		this.factory=fact;
	}
	@Override
	public void createComputer(Computer computer)throws SQLException {
		// TODO Auto-generated method stub
		Connection connect = this.factory.getConnection();
		PreparedStatement prepastat = connect.prepareStatement("Insert into computer values[?,?,?,?,?] ");
		prepastat.setLong(1, computer.getId());
		prepastat.setString(2, computer.getName());
		prepastat.setTimestamp(3, computer.getIntroduced());
		prepastat.setTimestamp(4, computer.getDiscontinued());
		prepastat.setLong(5, computer.getCompany_id());
		prepastat.executeQuery();
		connect.close();
	}

	@Override
	public void UpdateComputer(Computer computer)throws SQLException {
		// TODO Auto-generated method stub
		Connection connect = this.factory.getConnection();
		PreparedStatement prepastat = connect.prepareStatement("UPDATE computer SET name = ?, introduced = ?, discontinued = ? where id=?");
		prepastat.setString(1,computer.getName());
		prepastat.setTimestamp(2,computer.getIntroduced());
		prepastat.setTimestamp(3,computer.getDiscontinued());
		prepastat.setLong(4, computer.getId());
		prepastat.execute();
		connect.close();
	}

	@Override
	public void deleteComputer(Computer computer)throws SQLException {
		// TODO Auto-generated method stub
		Connection connect = this.factory.getConnection();
		PreparedStatement prepastat = connect.prepareStatement("DELETE FROM computer where id =?");
		prepastat.setLong(1, computer.getId());
		prepastat.execute();
		connect.close();
	}

	@Override
	public List<Computer> ListComputer()throws SQLException {
		// TODO Auto-generated method stub
		List<Computer> listComputer = new ArrayList<Computer>();
		Connection connect = this.factory.getConnection();
		PreparedStatement prepastat = connect.prepareStatement("SELECT * FROM computer");
		ResultSet result = prepastat.executeQuery();
		
		while(result.next()) {
			long id = result.getLong("id");
			String name = result.getString("name");
			Timestamp introd = result.getTimestamp("introduced");
			Timestamp discon = result.getTimestamp("discontinued");
			long idCompany = result.getLong("company_id");
			
			listComputer.add(new Computer(id,name,introd,discon,idCompany));
			
		}
		
		return listComputer;
	}

	@Override
	public Computer ComputerById(long id)throws SQLException {
		// TODO Auto-generated method stub
		//List<Computer> listComputer = new ArrayList<Computer>();
		Connection connect = this.factory.getConnection();
		PreparedStatement prepastat = connect.prepareStatement("SELECT * FROM computer WHERE id= ?");
		prepastat.setLong(1,id);
		ResultSet result = prepastat.executeQuery();
		
		result.next();
		long idcomputer = result.getLong("id");
		String name = result.getString("name");
		Timestamp introd = result.getTimestamp("introduced");
		Timestamp discon = result.getTimestamp("discontinued");
		long idCompany = result.getLong("company_id");
		Computer computer =new Computer(idcomputer,name,introd,discon,idCompany);

		return computer;
	}
	
}
