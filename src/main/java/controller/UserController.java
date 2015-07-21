package controller;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import model.User;
import model.UserRole;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserService;


@Controller
public class UserController {

	@Inject
	private UserService userService;

	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String signUp(Model model) {
		return "signup";
	}
	
	@RequestMapping(value="/no_access")
	public String noAccess(){
		return "no_access";
	}

	
	@RequestMapping(value = { "/signup/create" }, method = RequestMethod.POST)
	public String signUp(Model model, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email,
			@RequestParam String login, @RequestParam String password) {
		try{
		UserRole role = UserRole.ROLE_USER;
		User User = new User(firstName, lastName, email, login, password, role);
		userService.add(User);
		}catch(PersistenceException e){
			String error = "A user with the following data already exists";
			model.addAttribute("error", error);
			return "redirect:/signup";
		}
		return "redirect:/login";
	}
	
	
}
