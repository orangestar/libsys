package pro.libsys.service;

import pro.libsys.bean.User;

public interface SystemService {

	public boolean login(User user);
	
	public boolean logout();
	
}
