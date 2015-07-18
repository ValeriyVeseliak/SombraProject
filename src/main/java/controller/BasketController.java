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
		
		User user = userService.getUserByLogin(principal.getName());
		
		Basket basket = basketService.getBasketByUser(user);
		System.out.println(basket.getId());
		Double sumPrice = (double) 0;
		List<Good> goods = basket.getGoods();
		for (Good good : goods) {
			System.out.println(good);
			sumPrice += good.getPrice();
		}
		int countOfGoods = goods.size();
		model.addAttribute("countOfGoods", countOfGoods);
		model.addAttribute("sumPrice", sumPrice);
		model.addAttribute("goods", goods);
		return "basket";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteGoodFromBasket(@PathVariable long id, Principal principal) {
		Good good = goodService.getByID(id);
		User user = userService.getUserByLogin(principal.getName());
		Basket basket = basketService.getBasketByUser(user);
		List<Good> goods = basket.getGoods();
		
		Iterator<Good> g = goods.iterator();
		while(g.hasNext()){
			if(g.next().equals(good)){
				g.remove();
			}
		}
		basket.setGoods(goods);
		basketService.update(basket);
		return "redirect:/basket";
	}

	@RequestMapping(value = "/makeOrder", method = RequestMethod.GET)
	public String makeAnOrder(Principal principal) {
		User user = userService.getUserByLogin(principal.getName());
		Basket basket = basketService.getBasketByUser(user);
		List<Good> goods = basket.getGoods();
		Custom custom = new Custom();
		custom.setUser(user);
		custom.setTimeOfCustom(new Date());
		custom.setGoods(goods);
		customService.add(custom);
		goods.clear();
		return "success";
	}

}
