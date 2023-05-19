package com.Flight_Reservation_App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_Reservation_App.Entity.User;
import com.Flight_Reservation_App.Repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "Login/login";
	}

	// http://localhost:8080/flights/showReg
	@RequestMapping("/showReg")
	public String showReg() {
		return "Login/showReg";
	}

	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("User") User user) {
		userRepo.save(user);
		return "Login/login";
	}

	@RequestMapping("/verifyLogin")
	public String verifyLogin(
			@RequestParam("email") String email, 
			@RequestParam("password") String password,
			ModelMap modelMap) {
		User user = userRepo.findByEmail(email);
		if (user != null) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return "findFlights";
			} else {
				modelMap.addAttribute("error", "invalid usename/password");
				return "Login/login";
			}

		} else {
			modelMap.addAttribute("error", "invalid usename/password");
			return "Login/login";
		}
	}
}
