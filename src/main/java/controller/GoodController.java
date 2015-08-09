package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Cathegory;
import model.Good;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.CathegoryService;
import service.GoodService;
import service.UserService;
import dto.CathegoryDTO;
import dto.GoodDTO;

@Controller
public class GoodController {

	@Inject
	UserService userService;
	@Inject
	GoodService goodService;
	@Inject
	CathegoryService cathegoryService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Main() {
		return "redirect:/1";
	}

	@RequestMapping(value = { "/{page}" }, method = RequestMethod.GET)
	public String AllGoods(Model model, @PathVariable int page) {
		List<GoodDTO> goods = goodService.getAll();
		int countOnPage = 10;
		int maxPage = (int) Math.ceil((double) goods.size() / countOnPage);
		if (page < 1) {
			page = 1;
		} else if (page > maxPage) {
			page = maxPage;
		}
		List<GoodDTO> dispayedGoods = new ArrayList<GoodDTO>();
		try {
			for (int i = page * countOnPage - countOnPage; i < page
					* countOnPage; i++) {
				dispayedGoods.add(goods.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
		}
		model.addAttribute("goods", dispayedGoods);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("page", page);
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		model.addAttribute("cathegories", cathegories);
		return "all";
	}

	@RequestMapping(value = "/good/{id}", method = RequestMethod.GET)
	public String getGood(Model model, @PathVariable long id) {
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		model.addAttribute("cathegories", cathegories);
		Good good = goodService.getByID(id);
		model.addAttribute("good", good);
		model.addAttribute("cathegory", good.getCathegory());
		return "good";
	}

	@RequestMapping(value = "/goods/{cathName}/{page}", method = RequestMethod.GET)
	public String AllGoodsOfCathegory(@PathVariable String cathName,
			@PathVariable int page, Model model) {
		Cathegory cathegory = cathegoryService.getCathegoryByName(cathName);
		List<GoodDTO> goodsCath = goodService.getGoodByCathegory(cathegory);

		int countOnPage = 10;
		int maxPage = (int) Math.ceil((double) goodsCath.size() / countOnPage);
		if (maxPage == 0)
			maxPage = 1;
		if (page < 1) {
			page = 1;
		} else if (page > maxPage) {
			page = maxPage;
		}
		List<GoodDTO> dispayedGoods = new ArrayList<GoodDTO>();
		try {
			for (int i = page * countOnPage - countOnPage; i < page
					* countOnPage; i++) {
				dispayedGoods.add(goodsCath.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
		}
		model.addAttribute("goods", dispayedGoods);
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("cathegories", cathegories);
		model.addAttribute("cathegory", cathegory);
		return "allCathGoods";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/toBasket/{id}", method = RequestMethod.GET)
	public String addGoodToBasket(@PathVariable long id,
			HttpSession session) {
		Good good = goodService.getByID(id);
		Set<Good> shoppingCart = (Set<Good>) session
				.getAttribute("goodsList");
		session.setMaxInactiveInterval(60 * 60 * 3);
		if (shoppingCart == null) {
			shoppingCart = new HashSet<Good>();
			shoppingCart.add(good);
			session.setAttribute("goodsList", shoppingCart);
		} else {
			shoppingCart.add(good);
			session.setAttribute("goodsList", shoppingCart);
		}
		return "redirect:/basket";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchGoodByCathegoryAndKeyword(@RequestParam String keyword,
			HttpServletRequest request, Model model) {
		String cathName = request.getParameter("cathName");
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		model.addAttribute("cathegories", cathegories);
		if (cathName.equals("ALL")) {
			List<GoodDTO> goods = goodService.searchGoodFromAll(keyword);
			/*
			 * Pagination int countOnPage = 10; int maxPage = (int)
			 * Math.ceil((double) goods.size() / countOnPage); if (page < 1) {
			 * page = 1; } else if (page > maxPage) { page = maxPage; }
			 * List<GoodDTO> dispayedGoods = new ArrayList<GoodDTO>(); try { for
			 * (int i = page * countOnPage - countOnPage; i < page countOnPage;
			 * i++) { dispayedGoods.add(goods.get(i)); } } catch
			 * (IndexOutOfBoundsException e) { }
			 */
			model.addAttribute("goods", goods);
		} else {
			Cathegory cathegory = cathegoryService.getCathegoryByName(cathName);
			List<GoodDTO> goods = goodService.searchGoodFromCathegory(keyword,
					cathegory);
			/*
			 * Pagination int countOnPage = 10; int maxPage = (int)
			 * Math.ceil((double) goods.size() / countOnPage); if (page < 1) {
			 * page = 1; } else if (page > maxPage) { page = maxPage; }
			 * List<GoodDTO> dispayedGoods = new ArrayList<GoodDTO>(); try { for
			 * (int i = page * countOnPage - countOnPage; i < page countOnPage;
			 * i++) { dispayedGoods.add(goods.get(i)); } } catch
			 * (IndexOutOfBoundsException e) { }
			 */
			model.addAttribute("goods", goods);
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("cathName", cathName);
		return "searchedGoods";
	}
}
