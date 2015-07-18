package controller;

import java.security.Principal;
import java.util.ArrayList;
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

	@RequestMapping(value = "/good/{id}", method = RequestMethod.GET)
	public String getGood(Model model, @PathVariable long id) {
		Good good = goodService.getByID(id);
		model.addAttribute("good", good);
		return "good";
	}

	@RequestMapping(value = "/{cathName}", method = RequestMethod.GET)
	public String AllGoodsOfCathegory(@PathVariable String cathName, Model model) {
		Cathegory cathegory = cathegoryService.getCathegoryByName(cathName);
		List<GoodDTO> goodsCath = goodService.getGoodByCathegory(cathegory);
		model.addAttribute("goods", goodsCath);
		return "allCathGoods";
	}

	@RequestMapping(value = "/{id}/toBasket", method = RequestMethod.GET)
	public String addGoodToBasket(@PathVariable long id, Principal principal) {
		User user = userService.getUserByLogin(principal.getName());
		Good good = goodService.getByID(id);
		
		
		
		Basket b = basketService.getBasketByUser(userService
				.getUserByLogin(principal.getName()));
		
		if (b == null) {
			List<Good> goods = new ArrayList<Good>();
			goods.add(good);
			Basket basket = new Basket(user, goods);
			basketService.add(basket);
			System.out.println(basket.getId());
		} else {
			List<Good> goods = b.getGoods();
			goods.add(good);
			b.setGoods(goods);
			basketService.update(b);
		}
		return "redirect:/basket";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchGoodByCathegoryAndKeyword(@RequestParam String keyword,
			HttpServletRequest request, Model model) {
		String cathName = request.getParameter("cathName");
		Cathegory cathegory = cathegoryService.getCathegoryByName(cathName);
		List<Good> goods = goodService.getGoodBySearch(keyword, cathegory);
		model.addAttribute("goods", goods);
		return "searchedGoods";
	}

}
