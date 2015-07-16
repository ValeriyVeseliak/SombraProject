package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import dao.BaseDao;

public class BaseDaoImpl<E> implements BaseDao<E> {
	private Class<E> entityClass;

	public BaseDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@PersistenceContext(name = "sombra")
	EntityManager entityManager;

	@Transactional
	public void add(E element) {
		entityManager.merge(element);
//		entityManager.flush();
	}

	@Transactional
	public E update(E entity) {
		return entityManager.merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public E getByID(Long elementId) {
		try {
			return (E) entityManager
					.createQuery(
							"select e from " + entityClass.getSimpleName()
									+ " e where e.id = :id")
					.setParameter("id", elementId).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> getAll() {
		return entityManager.createQuery("from " + entityClass.getSimpleName())
				.getResultList();
	}

	@Transactional
	public void delete(E element) {
		entityManager.remove(entityManager.merge(element));
	}

	

}
