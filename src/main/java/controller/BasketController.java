package controller;

import java.security.Principal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

import service.BasketService;
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

	@RequestMapping()
	public String getAllGoodInBasket(Model model, Principal principal) {
		User user = userService.getByID(Long.parseLong(principal.getName()));
		Basket basket = basketService.getBasketByUser(user);
		Double sumPrice = (double) 0;
		List<Good> goods = basket.getGoods();
		for (Good good : goods) {
			sumPrice += good.getPrice();
		}
		model.addAttribute("sumPrice", sumPrice);
		model.addAttribute("goods", goods);
		return "basket";
	}

	@RequestMapping(value = "/${id}/delete", method = RequestMethod.GET)
	public String deleteGoodFromBasket(@PathVariable long id, Principal principal) {
		User user = userService.getByID(Long.parseLong(principal.getName()));
		Basket basket = basketService.getBasketByUser(user);
		List<Good> goods = basket.getGoods();
		Good good = goodService.getByID(id);
		Iterator<Good> iter = goods.iterator();
		while (iter.hasNext()) {
			Good g = iter.next();
			if (g.equals(good)) {
				iter.remove();
			}
		}
		return "redirect:/basket";
	}

	@RequestMapping(value = "makeOrder", method = RequestMethod.POST)
	public String makeAnOrder(Principal principal) {
		User user = userService.getByID(Long.parseLong(principal.getName()));
		Basket basket = basketService.getBasketByUser(user);
		List<Good> goods = basket.getGoods();
		Custom custom = new Custom();
		custom.setUser(userService.getByID(Long.parseLong(principal.getName())));
		custom.setTimeOfCustom(new Date());
		custom.setGoods(goods);
		customService.add(custom);
		goods.clear();
		return "success";
	}

}
