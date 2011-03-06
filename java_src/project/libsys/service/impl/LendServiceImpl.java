package project.libsys.service.impl;

import java.util.List;

import project.libsys.bean.Lend;
import project.libsys.dao.LendDao;
import project.libsys.service.LendService;

public class LendServiceImpl implements LendService {
	
	private LendDao lendDao;

	@Override
	public boolean addLend(Lend lend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLend(int lendId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editLend(Lend lend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Lend getLend() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lend> getLends() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public LendDao getLendDao() {
		return lendDao;
	}

	public void setLendDao(LendDao lendDao) {
		this.lendDao = lendDao;
	}

}
