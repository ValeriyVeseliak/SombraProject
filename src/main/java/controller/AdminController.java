package controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import model.Cathegory;
import model.Good;
import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.CathegoryService;
import service.CustomService;
import service.GoodService;
import service.UserService;
import dto.CathegoryDTO;
import dto.CustomDTO;
import dto.GoodDTO;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Inject
	UserService userService;

	@Inject
	CathegoryService cathegoryService;

	@Inject
	GoodService goodService;

	@Inject
	CustomService customService;

	@RequestMapping(method = RequestMethod.GET)
	public String getAdmin(Model model) {
		List<GoodDTO> goods = goodService.getAll();
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		model.addAttribute("cathegories", cathegories);
		model.addAttribute("goods", goods);
		return "admin";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String showAllUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users";

	}

	@RequestMapping(value = "/users/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable long id) {
		User user = userService.getByID(id);
		userService.delete(user);
		return "redirect:/admin/users";
	}

	@RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
	public String updateUser(@PathVariable long id,
			@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String login,
			@RequestParam String password) {
		User user = userService.getByID(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setLogin(login);
		user.setPassword(password);
		userService.update(user);
		return "redirect:/admin/users";
	}

	@RequestMapping(value = "/cathegories", method = RequestMethod.GET)
	public String showAllCathegories(Model model) {
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		model.addAttribute("cathegories", cathegories);
		return "cathegories";
	}

	@RequestMapping(value = "/cathegories/create", method = RequestMethod.GET)
	public String createCathegory(@RequestParam String cathName) {
		Cathegory cathegory = new Cathegory(cathName);
		cathegoryService.add(cathegory);
		return "redirect:/admin/cathegories";
	}

	@RequestMapping(value = "cathegories/{id}/delete", method = RequestMethod.GET)
	public String deleteCathegory(@PathVariable long id) {
		Cathegory cathegory = cathegoryService.getByID(id);
		cathegoryService.delete(cathegory);
		return "redirect:/admin/cathegories";
	}

	@RequestMapping(value = "/goods/create", method = RequestMethod.GET)
	public String createNewGood(HttpServletRequest request,
			@RequestParam String goodName, @RequestParam String description,
			@RequestParam Double price) {
		Cathegory cathegory = cathegoryService.getCathegoryByName(request
				.getParameter("cathegories"));
		Good good = new Good(goodName, price, description, cathegory);
		goodService.add(good);
		return "redirect:/admin";
	}

	@RequestMapping(value = "/goods/{id}/update", method = RequestMethod.GET)
	public String goodUpdate(HttpServletRequest request, @PathVariable long id,
			Model model, @RequestParam String goodName,
			@RequestParam String description, @RequestParam Double price) {
		Good good = goodService.getByID(id);
		model.addAttribute("good", good);
		good.setGoodName(goodName);
		good.setDescription(description);
		good.setPrice(price);
		Cathegory cathegory = cathegoryService.getCathegoryByName(request
				.getParameter("cathName"));
		good.setCathegory(cathegory);

		goodService.update(good);
		return "redirect:/admin";
	}

	@RequestMapping(value = "/goods/{id}/delete", method = RequestMethod.GET)
	public String deleteGood(@PathVariable long id) {
		Good good = goodService.getByID(id);
		goodService.delete(good);
		return "redirect:/admin";
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String getAllOrders(Model model) {
		List<CustomDTO> orders = customService.getAll();
		model.addAttribute("orders", orders);
		return "orders";
	}

}
