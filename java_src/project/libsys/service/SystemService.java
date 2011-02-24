package project.libsys.service;

import project.libsys.bean.User;

public interface SystemService {

	public boolean login(User user);
	
	public boolean logout();
	
}
