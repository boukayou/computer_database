/*package com.excilys.boukayou.controllersRest;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.excilys.boukayou.dto.ComputerDTO;
import com.excilys.boukayou.mapper.ComputerMapper;
import com.excilys.boukayou.modele.Company;
import com.excilys.boukayou.modele.Computer;
import com.excilys.boukayou.service.CompanyServiceJpa;
import com.excilys.boukayou.service.ComputerServiceJpa;

@Controller
@RequestMapping(path = "/EditComputerRest")

public class EditComputerRest {

	private CompanyServiceJpa companyServiceJpa;
	private ComputerServiceJpa computerServiceJpa;
	private ComputerMapper computerMapper;

	public EditComputerRest(ComputerServiceJpa computerServiceJpa, CompanyServiceJpa companyServiceJpa,ComputerMapper computerMapper) {
		this.computerServiceJpa = computerServiceJpa;
		this.companyServiceJpa = companyServiceJpa;
		this.computerMapper = computerMapper;
	}

	@GetMapping
	public String get(Model model, @RequestParam(name = "idComputer") String idComputer ){
		
		Computer computerToEdit = this.computerServiceJpa.getById(Long.parseLong(idComputer)).get();
		model.addAttribute("computerToEdit", computerToEdit);
		
		
		List<Company> listCompany = this.companyServiceJpa.getList();
		model.addAttribute("list", listCompany);

		return "editComputer";
	}

	@PostMapping
	public String post(@RequestParam(name = "computerName", required = true) String computerName,
			@RequestParam(name = "introduced") String introduced,
			@RequestParam(name = "discontinued") String discontinued,
			@RequestParam(name = "idComputer") String idComputer,
			@RequestParam(name = "companyId") String companyId) {

		ComputerDTO computerDto = new ComputerDTO();

		computerDto.setName(computerName);
		computerDto.setIntroduced(introduced);
		computerDto.setDiscontinued(discontinued);
		computerDto.setId(idComputer);
		computerDto.setCompanyID(companyId);
		Computer computer = this.computerMapper.DtoToComputer(computerDto).get();

		this.computerServiceJpa.upDate(computer);
		return "redirect:/Dashboard";

	}

}*/
