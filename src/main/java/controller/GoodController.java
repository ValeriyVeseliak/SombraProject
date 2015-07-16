package controller;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import model.Basket;
import model.Cathegory;
import model.Good;
import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.BasketService;
import service.CathegoryService;
import service.GoodService;
import service.UserService;
import dto.GoodDTO;

@Controller
public class GoodController {

	@Inject
	UserService userService;

	@Inject
	GoodService goodService;

	@Inject
	CathegoryService cathegoryService;

	@Inject
	BasketService basketService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String AllGoods(Model model) {
		model.addAttribute("maxPrice", goodService.getMaxPrice());
		List<GoodDTO> goods = goodService.getAll();
		model.addAttribute("goods", goods);
		return "all";
	}

	@RequestMapping(value = "/${id}", method = RequestMethod.GET)
	public String getGood(@PathVariable long id, Model model) {
		Good good = goodService.getByID(id);
		model.addAttribute("good", good);
		return "good";
	}

	@RequestMapping(value = "/${cathName}", method = RequestMethod.GET)
	public String AllGoodsOfCathegory(@PathVariable String cathName, Model model) {
		Cathegory cathegory = cathegoryService.getCathegoryByName(cathName);
		List<GoodDTO> goodsCath = goodService.getGoodByCathegory(cathegory);
		model.addAttribute("goodsCath", goodsCath);
		return "allCathGoods";
	}

	@RequestMapping(value = "/${id}/toBasket", method = RequestMethod.POST)
	public String addGoodToBasket(@PathVariable long id, Principal principal) {
		Good good = goodService.getByID(id);

		Basket b = basketService.getBasketByUser(userService.getByID(Long
				.parseLong(principal.getName())));
		if (b == null) {
			User user = userService
					.getByID(Long.parseLong(principal.getName()));
			Basket basket = new Basket(user);
			basketService.add(basket);
			basket.getGoods().add(good);
		} else {
			b.getGoods().add(good);
		}
		return "redirect:/basket";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchGoodByCathegoryAndKeyword(@RequestParam String keyword, HttpServletRequest request, Model model){
		String cathName = request.getParameter("cathName");
		Cathegory cathegory = cathegoryService.getCathegoryByName(cathName);
		List<Good> searchGoods = goodService.getGoodBySearch(keyword, cathegory);
		model.addAttribute("searchGoods", searchGoods);
		return "searchedGoods";
	}

}
