package dao.impl;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Cathegory;
import dao.CathegoryDao;


@Repository
public class CathegoryDaoImpl extends BaseDaoImpl<Cathegory> implements CathegoryDao {

	public CathegoryDaoImpl() {
		super(Cathegory.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public Cathegory getCathegoryByName(String cathName) {
		try {
			return (Cathegory) entityManager
					.createNamedQuery(Cathegory.GET_CATHEGORY_BY_NAME)
					.setParameter("cathName", cathName).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
