package service;

import java.util.List;

import model.Basket;
import model.User;


public interface BasketService {
	public void add(Basket basket);

	public Basket update(Basket basket);

	public Basket getByID(Long id);

	public List<Basket> getAll();

	public void delete(Basket basket);
	
	public Basket getBasketByUser(User user);
}
