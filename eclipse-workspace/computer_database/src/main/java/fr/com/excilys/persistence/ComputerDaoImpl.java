package fr.com.excilys.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.com.excilys.checking.ConvertData;
import fr.com.excilys.modele.Computer;


public class ComputerDaoImpl implements ComputerDao {
	final Logger logger = LoggerFactory.getLogger(ComputerDaoImpl.class);
	DaoFactory factory ;
	
	public ComputerDaoImpl(DaoFactory fact) {
		this.factory=fact;
	}
	@Override
	public void createComputer(Computer computer) {
		// TODO Auto-generated method stub
		
		try (Connection connect = this.factory.getConnection()) {
			
			PreparedStatement prepastat = connect.prepareStatement("Insert into computer (name,introduced,discontinued,company_id) values(?,?,?,?) ");
			//prepastat.setLong(1, computer.getId());
			prepastat.setString(1, computer.getName());
			if (computer.getIntroduced()==null) { 
				prepastat.setTimestamp(2, null);
			}else {
				prepastat.setTimestamp(2,new java.sql.Timestamp(Date.valueOf(computer.getIntroduced()).getTime()));
			}
			if(computer.getDiscontinued()==null) {
				prepastat.setTimestamp(3,null);
			}else {
				prepastat.setTimestamp(3, new java.sql.Timestamp(Date.valueOf(computer.getDiscontinued()).getTime()));
			}
			prepastat.setLong(4, computer.getCompany_id());
			prepastat.execute();
		    logger.info(" was added to database.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void UpdateComputer(Computer computer) {
		// TODO Auto-generated method stub
		 
		try(Connection connect = this.factory.getConnection();) {
				
			PreparedStatement prepastat = connect.prepareStatement("UPDATE computer SET name = ?, introduced = ?, discontinued = ? where id=?");
			prepastat.setString(1,computer.getName());
			if (computer.getIntroduced()==null) { 
				prepastat.setTimestamp(2, null);
			}else {
				prepastat.setTimestamp(2,new java.sql.Timestamp(Date.valueOf(computer.getIntroduced()).getTime()));
			}
			if(computer.getDiscontinued()==null) {
				prepastat.setTimestamp(3,null);
			}else {
				prepastat.setTimestamp(3, new java.sql.Timestamp(Date.valueOf(computer.getDiscontinued()).getTime()));
			}
			//prepastat.setTimestamp(2,new java.sql.Timestamp(Date.valueOf(computer.getIntroduced()).getTime()));
			//prepastat.setTimestamp(3,new java.sql.Timestamp(Date.valueOf(computer.getDiscontinued()).getTime()));
			prepastat.setLong(4, computer.getId());
			prepastat.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteComputer(Computer computer) {
		// TODO Auto-generated method stub
		
		try(Connection connect = this.factory.getConnection();) {		
			PreparedStatement prepastat = connect.prepareStatement("DELETE FROM computer where id =?");
			prepastat.setLong(1, computer.getId());
			prepastat.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Computer> ListComputer() {
		// TODO Auto-generated method stub
		List<Computer> listComputer = new ArrayList<Computer>();
		
		try (Connection connect = this.factory.getConnection();){
			
			PreparedStatement prepastat = connect.prepareStatement("SELECT id,name,introduced,discontinued,company_id FROM computer");
			ResultSet result = prepastat.executeQuery();
			
			while(result.next()) {
				long id = result.getLong("id");
				String name = result.getString("name");
				LocalDate introd = ConvertData.timestampToLocalDate(result.getTimestamp("introduced")).orElse(null) ;
				LocalDate discon=ConvertData.timestampToLocalDate(result.getTimestamp("discontinued")).orElse(null) ;
				long idCompany = result.getLong("company_id");
				listComputer.add(new Computer(id,name,introd,discon,idCompany));
				
			}
			return listComputer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listComputer;
	}

	@Override
	public Computer ComputerById(long id) {
		// TODO Auto-generated method stub
		Computer computer = null;
		
		try (Connection connect = this.factory.getConnection();) {
			
			PreparedStatement prepastat = connect.prepareStatement("SELECT * FROM computer WHERE id= ?");
			prepastat.setLong(1,id);
			ResultSet result = prepastat.executeQuery();
			result.next();
			long idcomputer = result.getLong("id");
			String name = result.getString("name");
			LocalDate introd = ConvertData.timestampToLocalDate(result.getTimestamp("introduced")).orElse(null) ;
			LocalDate discon=ConvertData.timestampToLocalDate(result.getTimestamp("discontinued")).orElse(null) ;
			long idCompany = result.getLong("company_id");
			computer =new Computer(idcomputer,name,introd,discon,idCompany);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return computer ;
	}
	
}