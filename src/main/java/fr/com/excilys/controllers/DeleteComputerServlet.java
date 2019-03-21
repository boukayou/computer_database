package fr.com.excilys.controllers;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.com.excilys.modele.Computer;
import fr.com.excilys.service.ComputerService;

@Controller
@RequestMapping(path = "/DeleteComputer")

public class DeleteComputerServlet {
	private ComputerService computerService;

	public DeleteComputerServlet(ComputerService computerService) {

		this.computerService = computerService;
	}

	@PostMapping
	public String post(@RequestParam(name = "selection", defaultValue = "") String selection) {

		String[] idTodelete = selection.split(",");

		try {
			for (String str : idTodelete) {

				Computer computerToDelete = this.computerService.getById(Long.parseLong(str));
				this.computerService.delete(computerToDelete);

			}

		} catch (NoSuchElementException e) {

			e.getStackTrace();
		}
		return  "redirect:/Dashboard";

	}

}
