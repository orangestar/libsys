package project.libsys.service.impl;

import java.util.List;

import project.libsys.bean.User;
import project.libsys.dao.UserDao;
import project.libsys.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		userDao.addUser(user);
		return user;
	}

	@Override
	public boolean deleteUser(int userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public boolean editUser(User user) {
		return userDao.editUser(user);
	}

	@Override
	public User getUser(String name) {
		return userDao.getUser(name);
	}

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
