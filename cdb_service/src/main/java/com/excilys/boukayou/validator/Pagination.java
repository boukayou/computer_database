package com.excilys.boukayou.validator;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.excilys.boukayou.service.ComputerServiceJpa;

@Component
public class Pagination {
	final Logger logger = LoggerFactory.getLogger(Pagination.class);
	private int nbOfElements = 10;
	private int page = 0;
	private String search = "";
	private String sort = "computer.name";

	protected ComputerServiceJpa computerServiceJpa;

	public Pagination( ComputerServiceJpa computerServiceJpa) {
		this.computerServiceJpa = computerServiceJpa;
	}

	public int getNbOfElements() {
		return nbOfElements;
	}

	public void setNbOfElements(String nbOfElements) {
		if (nbOfElements != null) {
			try {
				this.nbOfElements = Integer.parseInt(nbOfElements);
			} catch (NumberFormatException e) {
				logger.warn(
						"Error in the method SetNbOfElements in the class :fr.com.excilys.cheking/Pagination: check if the parsing type is valid!");
			}
		}
	}

	public int getPage() {

		return page;
	}

	public void setPage(String page) {

		if (page != null) {
			try {
				this.page = Integer.parseInt(page) - 1;
				if (this.page < 0) {
					this.page = 0;
				}
			} catch (NumberFormatException e) {
				logger.warn(
						"Error in the method setPage in the class :fr.com.excilys.cheking/Pagination: check if the parsing type is valid!");

			}
		}
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public List<Integer> navigation() {

		List<Integer> listNavigation = new ArrayList<Integer>();
		List<Integer> navigation = new ArrayList<Integer>();

		long computersFound = 60 ;//computerServiceJpa.count();
		long pages = computersFound / nbOfElements;

		for (Integer i = 1; i <= pages + 1; i++) {
			listNavigation.add(i);
		}
		for (int i = -2; i < page + 2; i++)
			navigation.add(listNavigation.indexOf(page));

		return listNavigation;

	}

	@Override
	public String toString() {
		return "Pagination [nbOfElements=" + nbOfElements + ", page=" + page + ", search=" + search + ", sort=" + sort
				+ "]";
	}

}
