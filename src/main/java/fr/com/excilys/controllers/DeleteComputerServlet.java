package fr.com.excilys.controllers;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.com.excilys.modele.Computer;
import fr.com.excilys.service.ComputerServiceJpa;

@Controller
@RequestMapping(path = "/DeleteComputer")

public class DeleteComputerServlet {
	
	private ComputerServiceJpa computerServiceJpa;

	public DeleteComputerServlet(ComputerServiceJpa computerServiceJpa) {

		this.computerServiceJpa = computerServiceJpa;
	}

	@PostMapping
	public String post(@RequestParam(name = "selection", defaultValue = "") String selection) {

		String[] idTodelete = selection.split(",");

		try {
			for (String str : idTodelete) {

				Computer computerToDelete = this.computerServiceJpa.getById(Long.parseLong(str)).get();
				this.computerServiceJpa.delete(computerToDelete);

			}

		} catch (NoSuchElementException e) {

			e.getStackTrace();
		}
		return  "redirect:/Dashboard";

	}

}
