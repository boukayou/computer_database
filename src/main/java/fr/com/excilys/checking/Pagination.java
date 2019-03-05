package fr.com.excilys.checking;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.com.excilys.modele.Computer;
import fr.com.excilys.persistence.ComputerDaoImpl;
import fr.com.excilys.service.ComputerService;

public class Pagination {
	private int nbOfElements = 10;
	private int page = 0;
	private int max;

	final Logger logger = LoggerFactory.getLogger(Pagination.class);

	ComputerService computerService = ComputerService.getInstance();

	public Pagination() {
		//navigation();
		
	}

	public Pagination(int nbOfElements, int page) {
		this.nbOfElements = nbOfElements;
		this.page = page;
	}

	public int getNbOfElements() {
		return nbOfElements;
	}

	public void setNbOfElements(String nbOfElements) {
		if (nbOfElements != null) {
			try {
				this.nbOfElements = Integer.parseInt(nbOfElements);
			} catch (NumberFormatException e) {
			 logger.warn("Error in the method SetNbOfElements in the class :fr.com.excilys.cheking/Pagination: check if the parsing type is valid!");
			}
		}
	}

	public int getPage() {
		
		return page;
	}

	public void setPage(String page) {

		if (page != null) {
			try {
				this.page = Integer.parseInt(page)-1;
				if (this.page < 0) {
					this.page = 0;
				}
			} catch (NumberFormatException e) {
				 logger.warn("Error in the method setPage in the class :fr.com.excilys.cheking/Pagination: check if the parsing type is valid!");

			}
		}
	}

	public List<Computer> getList() {
		return computerService.getList(page, nbOfElements);
	}

	public List<Integer> navigation() {
		
		List<Integer> listNavigation= new ArrayList<Integer>();
		List<Integer> navigation= new ArrayList<Integer>();
		long computersFound =  computerService.count();
		long pages = computersFound/nbOfElements;
		
		for(Integer i=1;i<=pages+1;i++){
			listNavigation.add(i);
		}
		for(int i =-2;i<page+2;i++)
		navigation.add(listNavigation.indexOf(page));
		
		return listNavigation;
				
	}
	
}