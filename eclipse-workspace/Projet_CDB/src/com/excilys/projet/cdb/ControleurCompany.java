package com.excilys.projet.cdb;

import java.util.List;

public class ControleurCompany {
	
	public List<EntityCompany> getCompany() {
		return ModeleCompany.getElements();
	}	
}
