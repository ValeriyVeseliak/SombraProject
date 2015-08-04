package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import model.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		String pass = encoder.encode(user.getPassword());
		User u = new User(user.getFirstName(), user.getLastName(),
				user.getEmail(), user.getLogin(), pass, user.getPhoneNumber(),
				user.getRole(), user.getIsEnabled());
		userDao.add(u);
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
					.getPassword(), user.getPhoneNumber(), user.getIsEnabled()));
		}
		return dtos;
	}

}
