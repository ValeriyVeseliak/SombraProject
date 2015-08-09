package controller;

import java.security.Principal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Custom;
import model.Good;
import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.CathegoryService;
import service.CustomService;
import service.GoodService;
import service.UserService;
import dto.CathegoryDTO;

@Controller
@RequestMapping(value = "/basket")
public class BasketController {
	@Inject
	GoodService goodService;
	@Inject
	UserService userService;
	@Inject
	CustomService customService;
	@Inject
	CathegoryService cathegoryService;

	@SuppressWarnings("unchecked")
	@RequestMapping()
	public String getAllGoodInBasket(Model model, HttpServletRequest request, HttpSession session) {
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		model.addAttribute("cathegories", cathegories);
		Set<Good> cart = (Set<Good>) session.getAttribute("goodsList");
		boolean isEmpty = true;
		double sumPrice = 0;
		if (cart != null) {
			model.addAttribute("goods", cart);
			if (!cart.isEmpty()) {
				isEmpty = false;
			}
			for (Good good : cart) {
				sumPrice += good.getPrice();
			}
		}
		model.addAttribute("isEmpty", isEmpty);
		model.addAttribute("sumPrice", sumPrice);
		return "basket";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public String deleteGoodFromBasket(@PathVariable long id,
			Principal principal, HttpSession session) {
		Good good = goodService.getByID(id);
		Set<Good> goods = (Set<Good>) session.getAttribute(
				"goodsList");
		Iterator<Good> g = goods.iterator();
		while (g.hasNext()) {
			if (g.next().equals(good)) {
				g.remove();
			}
		}
		return "redirect:/basket";
	}

	@RequestMapping(value = "/makeOrder", method = RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public String makeAnOrder(Principal principal, Model model,
			HttpSession session) {
		User user = userService.getUserByLogin(principal.getName());
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		Set<Good> goods = (Set<Good>) session.getAttribute("goodsList");
		double priceOfOrder = 0;
		for (Good good : goods) {
			priceOfOrder += good.getPrice();
		}
		Custom custom = new Custom(user, goods, new Date(), priceOfOrder);
		customService.add(custom);
		session.invalidate();
		model.addAttribute("cathegories", cathegories);
		return "success";
	}

}
