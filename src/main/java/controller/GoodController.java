package controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Cathegory;
import model.Good;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
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
@SuppressWarnings({ "rawtypes", "unchecked" })
public class GoodController {

	@Inject
	UserService userService;
	@Inject
	GoodService goodService;
	@Inject
	CathegoryService cathegoryService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String AllGoods(Model model, HttpServletRequest request) {
		List<GoodDTO> goods = goodService.getAll();
		PagedListHolder pagedListHolder = new PagedListHolder(goods);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		model.addAttribute("pagedListHolder", pagedListHolder);
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		model.addAttribute("cathegories", cathegories);
		return "all";
	}

	@RequestMapping(value = "/good/{id}", method = RequestMethod.GET)
	public String getGood(Model model, @PathVariable long id,
			HttpSession session) {
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		model.addAttribute("cathegories", cathegories);
		Good good = goodService.getByID(id);
		boolean ordered = false;
		if ((Set<Good>) session.getAttribute("goodsList") != null) {
			for (Good g : (Set<Good>) session.getAttribute("goodsList")) {
				if (g.equals(good)) {
					ordered = true;
				}
			}
		}
		model.addAttribute("ordered", ordered);
		model.addAttribute("good", good);
		model.addAttribute("cathegory", good.getCathegory());
		return "good";
	}

	@RequestMapping(value = "/goods/{cathName}/", method = RequestMethod.GET)
	public String AllGoodsOfCathegory(@PathVariable String cathName,
			Model model, HttpServletRequest request) {
		Cathegory cathegory = cathegoryService.getCathegoryByName(cathName);
		List<GoodDTO> goods = goodService.getGoodByCathegory(cathegory);
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		model.addAttribute("cathegories", cathegories);
		PagedListHolder pagedListHolder = new PagedListHolder(goods);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("cathegory", cathegory);
		return "allCathGoods";
	}

	@RequestMapping(value = "/toBasket/{id}", method = RequestMethod.GET)
	public String addGoodToBasket(@PathVariable long id, HttpSession session,
			Model model) {
		Good good = goodService.getByID(id);
		Set<Good> shoppingCart = (Set<Good>) session.getAttribute("goodsList");
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

	@RequestMapping(value = "/search/", method = RequestMethod.GET)
	public String searchGoodByCathegoryAndKeyword(@RequestParam String keyword,
			HttpServletRequest request, Model model) {
		List<CathegoryDTO> cathegories = cathegoryService.getAll();
		model.addAttribute("cathegories", cathegories);
		String cathName = request.getParameter("cathName");

		if (cathName.equals("ALL")) {
			List<GoodDTO> goods = goodService.searchGoodFromAll(keyword);
			PagedListHolder pagedListHolder = new PagedListHolder(goods);
			int page = ServletRequestUtils.getIntParameter(request, "page", 0);
			pagedListHolder.setPage(page);
			int pageSize = 10;
			pagedListHolder.setPageSize(pageSize);
			model.addAttribute("pagedListHolder", pagedListHolder);
		} else {
			Cathegory cathegory = cathegoryService.getCathegoryByName(cathName);
			List<GoodDTO> goods = goodService.searchGoodFromCathegory(keyword,
					cathegory);
			PagedListHolder pagedListHolder = new PagedListHolder(goods);
			int page = ServletRequestUtils.getIntParameter(request, "page", 0);
			pagedListHolder.setPage(page);
			int pageSize = 10;
			pagedListHolder.setPageSize(pageSize);
			model.addAttribute("pagedListHolder", pagedListHolder);
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("cathName", cathName);
		return "searchedGoods";

	}
}
