package dao.impl;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Basket;
import model.User;
import dao.BasketDao;

@Repository
public class BasketDaoImpl  extends BaseDaoImpl<Basket> implements BasketDao{

	public BasketDaoImpl() {
		super(Basket.class);
	}

	@Transactional
	public Basket getBasketByUser(User user) {
		try {
			return (Basket) entityManager
					.createNamedQuery(Basket.GET_BASKET_BY_USER)
					.setParameter("user", user).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	

}
