package dao;

import model.Basket;
import model.User;

public interface BasketDao extends BaseDao<Basket>{
	public Basket getBasketByUser(User user);
}
