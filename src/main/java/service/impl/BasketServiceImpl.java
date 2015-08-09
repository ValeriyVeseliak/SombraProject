/*package service.impl;

import java.util.List;

import javax.inject.Inject;

import model.Basket;
import model.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.BasketService;
import dao.BasketDao;

@Service
public class BasketServiceImpl implements BasketService {

	@Inject
	BasketDao basketDao;

	@Transactional
	public void add(Basket basket) {
		basketDao.add(basket);
	}

	@Transactional
	public Basket update(Basket basket) {
		return basketDao.update(basket);
	}

	@Transactional
	public Basket getByID(Long id) {
		return basketDao.getByID(id);
	}

	@Transactional
	public List<Basket> getAll() {
		return basketDao.getAll();
	}

	@Transactional
	public void delete(Basket basket) {
		basketDao.delete(basket);
	}

	@Transactional
	public Basket getBasketByUser(User user) {
		return basketDao.getBasketByUser(user);
	}

}
*/