/*package com.excilys.boukayou.controllersRest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.excilys.boukayou.modele.User;

@Controller
@RequestMapping(path = {"/LoginRest"})
public class LoginUserRest {

	public LoginUserRest() {

	}
	
	@GetMapping
	public String get(Model model) {

		return "login";
	}


	@PostMapping
	public String post(@RequestParam(name = "username", required = true) String Username,
			@RequestParam(name = "password") String password) {

		User user = new User();
		User userSafe = new User();
		user.setName(Username);
		user.setPassword(password);
		
		userSafe.setName("user");
		userSafe.setPassword("password");

		if (user.equals(userSafe)) {
		return "redirect:/Dashboard";
		}else {
			return "login";
		}

	}

}*/
