package dao.impl;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.User;
import dao.UserDao;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Transactional
	public User getUserByLoginPassword(String login, String password) {
		try {
			return (User) entityManager
					.createNamedQuery(User.GET_USER_BY_LOGIN_PASSWORD)
					.setParameter("login", login).setParameter("password",password).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public User getUserByFirstLastName(String firstName, String lastName) {
		try {
			return (User) entityManager
					.createNamedQuery(User.GET_USER_BY_FIRST_LAST_NAME)
					.setParameter("firstName", firstName).setParameter("lastName", lastName).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public User getUserByLogin(String login) {
		try {
			return (User) entityManager
					.createNamedQuery(User.GET_USER_BY_LOGIN)
					.setParameter("login", login).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
