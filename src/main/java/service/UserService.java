package service;

import java.util.List;

import model.User;
import dto.UserDTO;


public interface UserService {
	
	public void add(User user);

	public User update(User user);

	public User getByID(Long id);

	public List<UserDTO> getAll();

	public void delete(User user);
	
	public User getUserByLogin(String login);

}
