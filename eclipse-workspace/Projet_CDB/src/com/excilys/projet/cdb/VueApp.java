package com.excilys.projet.cdb;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class VueApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//manage company
		ControleurCompany ccompany = new ControleurCompany();
		for(EntityCompany com :ccompany.getCompany()) {
			System.out.println(com);
		}
		
		//manage computer
		List<EntityComputer> listComputer = new ArrayList<EntityComputer>();
		EntityCompany company = new EntityCompany();
		EntityComputer cmp =new EntityComputer();
		ControleurComputer ccomputer =new ControleurComputer();
		cmp.setName("Momomarque");
		cmp.setIntroduced(	Timestamp.valueOf("1991-01-01 00:00:00"));
		cmp.setDiscontuned(	Timestamp.valueOf("1999-01-01 00:00:00"));
		//cmp.getCompany(company);
		listComputer.add(cmp);
		ccomputer.setComputer(listComputer);
		

	}

}