package fr.com.excilys.checking;

import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import fr.com.excilys.modele.Computer;
import fr.com.excilys.persistence.ComputerDaoImpl;
import fr.com.excilys.service.ComputerService;

public class Pagination {
	private int nbOfElements = 10;
	private int page = 0;
	private int max;
	// final Logger logger = LoggerFactory.getLogger(Pagination.class);

	ComputerService computerService = ComputerService.getInstance();

	public Pagination() {
		
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
				this.page = Integer.parseInt(nbOfElements);
			} catch (NumberFormatException e) {
				// Logger.WARN_INT("Le format du nombre");
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
				// Logger.WARN_INT("Le format du nombre");
			}
		}
	}

	public List<Computer> getList() {
		return computerService.getList(page, nbOfElements);
	}
}
