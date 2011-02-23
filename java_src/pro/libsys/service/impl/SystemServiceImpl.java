package pro.libsys.service.impl;

import pro.libsys.bean.User;
import pro.libsys.dao.UserDao;
import pro.libsys.service.SystemService;

public class SystemServiceImpl implements SystemService {
	
	private UserDao userDao;

	@Override
	public boolean login(User user) {
		User userFromDb = userDao.getUser(user.getName());
		return user.getPassword().equals(userFromDb.getPassword());
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
