package com.excilys.boukayou.controllersRest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excilys.boukayou.dto.ComputerDTO;
import com.excilys.boukayou.mapper.ComputerMapper;
import com.excilys.boukayou.modele.Computer;
import com.excilys.boukayou.service.ComputerServiceJpa;
import com.excilys.boukayou.validator.Pagination;

@RestController
@RequestMapping(path = "/computers")
//@PreAuthorize("hasRole('USER')")

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

	ComputerMapper mapper;

	@GetMapping
	public List<ComputerDTO> getAll() {

		List<Computer> listcomputer = this.computerServiceJpa.getAll();

		List<ComputerDTO> listcomputerDto = this.computerMapper.getListComputerDto(listcomputer);

		return listcomputerDto;
	}

	 @GetMapping("/paged")
	public List<ComputerDTO> getByPaged(@RequestParam(name = "nbrOfElements", defaultValue = "10") String nbrOfElements,
			@RequestParam(name = "page", defaultValue = "1") String page,
			@RequestParam(name = "sortBycomputer", defaultValue = "name") String sortBycomputer,
			@RequestParam(name = "search", defaultValue = "") String search) {

		pagination.setPage(page);
		pagination.setSort(sortBycomputer);
		pagination.setNbOfElements(nbrOfElements);
		pagination.setSearch(search);

		List<Computer> listcomputer = this.computerServiceJpa.getList(pagination);

		List<ComputerDTO> listcomputerDto = this.computerMapper.getListComputerDto(listcomputer);

		return listcomputerDto;
	}

	@GetMapping("/{id}")
	ComputerDTO getById(@PathVariable long id) {

		return this.computerMapper.computerToDto(this.computerServiceJpa.getById(id).get());
	}

	@PostMapping
	ComputerDTO create(@RequestBody ComputerDTO newComputer) {

		Computer computer = this.computerMapper.DtoToComputer(newComputer).get();
		this.computerServiceJpa.create(computer);
		return newComputer;
	}
	
	@PatchMapping
	ComputerDTO upDate(@RequestBody ComputerDTO Computer) {

		Computer computer = this.computerMapper.DtoToComputer(Computer).get();
		this.computerServiceJpa.upDate(computer);
		return Computer;
	}

	@DeleteMapping("/{id}")
	ComputerDTO delete(@PathVariable long id) {
		Computer computer = this.computerServiceJpa.getById(id).get();
		this.computerServiceJpa.delete(computer);
		return this.computerMapper.computerToDto(computer);
	}

}
