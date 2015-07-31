package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import model.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.UserService;
import dao.UserDao;
import dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao userDao;

	@Transactional
	public User getUserByFirstLastName(String firstName, String lastName) {
		return userDao.getUserByFirstLastName(firstName, lastName);
	}

	@Transactional
	public User getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

	@Transactional
	public User update(User user) {
		return userDao.update(user);
	}

	@Transactional
	public void delete(User user) {
		userDao.delete(user);
	}

	@Transactional
	public void add(User user) {
		userDao.add(user);
	}

	@Transactional
	public User getByID(Long id) {
		User user = userDao.getByID(id);
		if (user != null) {
			return user;
		} else {
			return new User();
		}
	}

	@Transactional
	public List<UserDTO> getAll() {
		List<UserDTO> dtos = new ArrayList<>();
		for (User user : userDao.getAll()) {
			dtos.add(new UserDTO(user.getId(), user.getFirstName(), user
					.getLastName(), user.getEmail(), user.getLogin(), user
					.getPassword()));
		}
		return dtos;
	}

	@Transactional
	public User getUserByLoginPassword(String login, String password) {
		return userDao.getUserByLoginPassword(login, password);
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

}
