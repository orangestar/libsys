package project.libsys.service.impl;

import java.util.List;

import project.libsys.bean.User;
import project.libsys.dao.ReaderDao;
import project.libsys.service.UserService;

public class ReaderServiceImpl implements UserService {
	
	private ReaderDao readerDao;

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public ReaderDao getReaderDao() {
		return readerDao;
	}

	public void setReaderDao(ReaderDao readerDao) {
		this.readerDao = readerDao;
	}

}
