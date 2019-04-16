/*package com.excilys.boukayou.controllersRest;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.excilys.boukayou.modele.Computer;
import com.excilys.boukayou.service.ComputerServiceJpa;

@Controller
@RequestMapping(path = "/DeleteComputerRest")

public class DeleteComputerRest {
	
	private ComputerServiceJpa computerServiceJpa;

	public DeleteComputerRest(ComputerServiceJpa computerServiceJpa) {

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
*/