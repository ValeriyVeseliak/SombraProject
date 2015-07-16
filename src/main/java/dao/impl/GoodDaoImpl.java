package dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import model.Cathegory;
import model.Good;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.GoodDao;

@Repository
public class GoodDaoImpl extends BaseDaoImpl<Good> implements GoodDao {

	public GoodDaoImpl() {
		super(Good.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Good> getGoodByCathegory(Cathegory cathegory) {
		try {
			return (List<Good>) entityManager
					.createNamedQuery(Good.GET_GOOD_BY_CATHEGORY)
					.setParameter("cathName", cathegory.getCathName())
					.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public Good getGoodByPrice(Double price) {
		try {
			return (Good) entityManager
					.createNamedQuery(Good.GET_GOOD_BY_PRICE)
					.setParameter("price", price).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public Double getMaxPrice() {
		try {
			return (Double) entityManager.createNativeQuery(
					"Select Max(price) from Good").getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Good> getGoodBySearch(String keyword, Cathegory cathegory) {
		try {
			return (List<Good>) entityManager
					.createQuery(
							"Select g from Good as g Where g.goodName Like :keyword, g.cathegory =:cathegory")
					.setParameter("keyword", '%' + keyword + '%')
					.setParameter("cathegory", cathegory).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public Good getGoodByCathegoryAndPrice(Cathegory cathegory, Double price) {
		try {
			return (Good) entityManager
					.createNamedQuery(Good.GET_GOOD_BY_CATHEGORY_AND_PRICE)
					.setParameter("cathegory", cathegory)
					.setParameter("price", price).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}
