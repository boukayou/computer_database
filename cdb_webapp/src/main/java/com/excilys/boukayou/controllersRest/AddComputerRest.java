package com.excilys.boukayou.controllersRest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excilys.boukayou.dto.ComputerDTO;
import com.excilys.boukayou.mapper.ComputerMapper;
import com.excilys.boukayou.modele.Company;
import com.excilys.boukayou.modele.Computer;
import com.excilys.boukayou.service.CompanyServiceJpa;
import com.excilys.boukayou.service.ComputerServiceJpa;

@RestController
@RequestMapping(path = "/AddComputerRest")

public class AddComputerRest {

	private CompanyServiceJpa companyServiceJpa;
	private ComputerServiceJpa computerServiceJpa;
	private ComputerMapper computerMapper;

	public AddComputerRest(ComputerServiceJpa computerServiceJpa, CompanyServiceJpa companyServiceJpa,
			ComputerMapper computerMapper) {
		this.computerServiceJpa = computerServiceJpa;
		this.companyServiceJpa = companyServiceJpa;
		this.computerMapper = computerMapper;
	}

	@GetMapping
	public List<Company> get(Model model) {

		List<Company> listCompany = this.companyServiceJpa.getList();

		model.addAttribute("listCompany", listCompany);

		return listCompany;
	}

	  @PostMapping("/Computer")
	public ResponseEntity<?> save (@RequestBody ComputerDTO computerDto) {

		
		Computer computer = this.computerMapper.DtoToComputer(computerDto).get();

		this.computerServiceJpa.create(computer);
	     return ResponseEntity.ok().body("New computer has been saved with ID:" + computer.getId());

	}

}
