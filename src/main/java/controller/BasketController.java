package controller;

import java.security.Principal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import model.Basket;
import model.Custom;
import model.Good;
import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.CathegoryDTO;
import service.BasketService;
import service.CathegoryService;
import service.CustomService;
import service.GoodService;
import service.UserService;

@Controller
@RequestMapping(value = "/basket")
public class BasketController {

	@Inject
	BasketService basketService;
	@Inject
	GoodService goodService;
	@Inject
	UserService userService;
	@Inject
	CustomService customService;
	@Inject
	CathegoryService cathegoryService;

	@RequestMapping()
	public String getAllGoodInBasket(Model model, Principal principal) {
		try {
			User user = userService.getUserByLogin(principal.getName());
			Basket basket = basketService.getBasketByUser(user);
			List<CathegoryDTO> cathegories = cathegoryService.getAll();
			Double sumPrice = (double) 0;
			Set<Good> goods = basket.getGoods();
			for (Good good : goods) {
				sumPrice += good.getPrice();
			}
			boolean countOfGoods = goods.isEmpty();
			model.addAttribute("countOfGoods", countOfGoods);
			model.addAttribute("sumPrice", sumPrice);
			model.addAttribute("goods", goods);
			model.addAttribute("cathegories", cathegories);
		} catch (NullPointerException e) {
			boolean countOfGoods = true;
			model.addAttribute("countOfGoods", countOfGoods);
			return "basket";
		}
		return "basket";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteGoodFromBasket(@PathVariable long id,
			Principal principal) {
		Good good = goodService.getByID(id);
		User user = userService.getUserByLogin(principal.getName());
		Basket basket = basketService.getBasketByUser(user);
		Set<Good> goods = basket.getGoods();

		Iterator<Good> g = goods.iterator();
		while (g.hasNext()) {
			if (g.next().equals(good)) {
				g.remove();
			}
		}
		basket.setGoods(goods);
		basketService.update(basket);
		return "redirect:/basket";
	}

	@RequestMapping(value = "/makeOrder", method = RequestMethod.GET)
	public String makeAnOrder(Principal principal, Model model) {
		User user = userService.getUserByLogin(principal.getName());
		Basket basket = basketService.getBasketByUser(user);
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		Set<Good> goods = basket.getGoods();
		double priceOfOrder = 0;
		for (Good good : goods) {
			priceOfOrder += good.getPrice();
		}
		Custom custom = new Custom();
		custom.setUser(user);
		custom.setTimeOfCustom(new Date());
		custom.setGoods(goods);
		custom.setPriceOfOrder(priceOfOrder);
		customService.add(custom);
		goods.clear();
		basket.setGoods(goods);
		basketService.update(basket);
		model.addAttribute("cathegories", cathegories);
		return "success";
	}

}
