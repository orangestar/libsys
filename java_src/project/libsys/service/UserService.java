package project.libsys.service;

import java.util.List;

import project.libsys.bean.User;

public interface UserService {

	public boolean addUser(User user);
	
	public boolean editUser(User user);
	
	public boolean deleteUser(int userId);
	
	public List<User> getUsers();
	
	public User getUser();
	
}
