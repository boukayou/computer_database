package com.excilys.projet.cdb;

import java.util.List;

public class ControleurComputer {
	public List<EntityComputer> getComputer() {
		return ModeleComputer.getElements();
	}	
	
	public void setComputer(List<EntityComputer> list) {
		ModeleComputer.setElements(list);
	}	
}
