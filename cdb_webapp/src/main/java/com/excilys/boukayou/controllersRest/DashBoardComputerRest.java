package com.excilys.boukayou.controllersRest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excilys.boukayou.dto.ComputerDTO;
import com.excilys.boukayou.mapper.ComputerMapper;
import com.excilys.boukayou.modele.Computer;
import com.excilys.boukayou.service.ComputerServiceJpa;
import com.excilys.boukayou.validator.Pagination;

@RestController
@RequestMapping(path =  "/DashboardRest")

public class DashBoardComputerRest {	

	protected Pagination pagination;

	private ComputerServiceJpa computerServiceJpa;
	private ComputerMapper computerMapper;

	public DashBoardComputerRest(ComputerServiceJpa computerServiceJpa, ComputerMapper computerMapper,
			Pagination pagination) {

		this.computerServiceJpa = computerServiceJpa;
		this.computerMapper = computerMapper;
		this.pagination = pagination;
	}

	// @PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public List<ComputerDTO> get(Model model, @RequestParam(name = "nbrOfElements", defaultValue = "10") String nbrOfElements,
			@RequestParam(name = "page", defaultValue = "1") String page,
			@RequestParam(name = "sortBycomputer", defaultValue = "name") String sortBycomputer,
			@RequestParam(name = "search", defaultValue = "") String search) {

		pagination.setPage(page);
		pagination.setSort(sortBycomputer);
		pagination.setNbOfElements(nbrOfElements);
		pagination.setSearch(search);

		List<Computer> listcomputer = this.computerServiceJpa.getList(pagination);

		List<ComputerDTO> listcomputerDto = this.computerMapper.getListComputerDto(listcomputer);

		List<String> listNavigation = this.computerMapper.IntToString(pagination.navigation());

		String nbrOfCompFOund = String.valueOf(this.computerServiceJpa.count());

		model.addAttribute("listNavigation", listNavigation);

		model.addAttribute("listComputerDto", listcomputerDto);

		model.addAttribute("nbrOfCompFOund", nbrOfCompFOund);

		return listcomputerDto;
	}

}
