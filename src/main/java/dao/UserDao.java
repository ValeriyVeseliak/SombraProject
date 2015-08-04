package dao;

import model.User;

public interface UserDao extends BaseDao<User> {

	public User getUserByLogin(String login);

}
