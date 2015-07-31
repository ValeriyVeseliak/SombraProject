package dao;

import model.User;

public interface UserDao extends BaseDao<User> {

	public User getUserByLoginPassword(String login, String password);

	public User getUserByFirstLastName(String firstName, String lastName);

	public User getUserByLogin(String login);

}
