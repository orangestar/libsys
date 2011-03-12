package project.libsys.service.impl;

import project.libsys.bean.User;
import project.libsys.dao.UserDao;
import project.libsys.service.SystemService;
import project.libsys.util.MessageEncoder;

public class SystemServiceImpl implements SystemService {
	
	private UserDao userDao;

	@Override
	public User login(User user) {
		User userFromDb = userDao.getUser(user.getName());
		if(userFromDb != null) {
			return userFromDb.getPassword().equalsIgnoreCase(MessageEncoder.getMd5(user.getPassword())) ? userFromDb : null;
		}
		return null;
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
