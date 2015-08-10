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
	public List<Good> getAll(int page) {
		int goodsOnPage = 10;
		try {
			return entityManager.createQuery("from Good")
					.setFirstResult(page * goodsOnPage - goodsOnPage)
					.setMaxResults(page * goodsOnPage).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Good> getGoodByCathegory(Cathegory cathegory) {
		try {
			return (List<Good>) entityManager
					.createNamedQuery(Good.GET_GOOD_BY_CATHEGORY)
					.setParameter("cathegory", cathegory).getResultList();
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
	public List<Good> searchGoodFromCathegory(String keyword,
			Cathegory cathegory) {
		try {
			return (List<Good>) entityManager
					.createQuery(
							"Select g from Good as g Where g.goodName Like :keyword AND g.cathegory =:cathegory")
					.setParameter("keyword", '%' + keyword + '%')
					.setParameter("cathegory", cathegory).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Good> searchGoodFromAll(String keyword) {
		try {
			return (List<Good>) entityManager
					.createQuery(
							"Select g from Good as g Where g.goodName Like :keyword")
					.setParameter("keyword", '%' + keyword + '%').getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

}
