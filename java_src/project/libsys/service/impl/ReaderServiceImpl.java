package project.libsys.service.impl;

import java.util.List;

import project.libsys.bean.Reader;
import project.libsys.dao.ReaderDao;
import project.libsys.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
	
	private ReaderDao readerDao;

	@Override
	public boolean addReader(Reader reader) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReader(int readerId) {
		return readerDao.deleteReader(readerId);
	}

	@Override
	public boolean editReader(Reader reader) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reader getReader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reader> getReaders() {
		return readerDao.getReaders();
	}
	
	public ReaderDao getReaderDao() {
		return readerDao;
	}

	public void setReaderDao(ReaderDao readerDao) {
		this.readerDao = readerDao;
	}

}
