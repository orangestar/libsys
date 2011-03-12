package project.libsys.service;

import project.libsys.bean.User;

public interface SystemService {

	public User login(User user);
	
	public boolean logout();
	
}
