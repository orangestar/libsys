package project.libsys.service;

import java.util.List;

import project.libsys.bean.Lend;

public interface LendService {

	public boolean addLend(Lend lend);
	
	public boolean editLend(Lend lend);
	
	public boolean deleteLend(int lendId);
	
	public List<Lend> getLends();
	
	public Lend getLend();
	
}