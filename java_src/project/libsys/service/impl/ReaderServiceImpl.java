package project.libsys.service.impl;

import java.util.List;

import project.libsys.bean.Reader;
import project.libsys.dao.ReaderDao;
import project.libsys.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
	
	private ReaderDao readerDao;

	@Override
	public Reader addReader(Reader reader) {
		readerDao.addReader(reader);
		return reader;
	}

	@Override
	public boolean deleteReader(int readerId) {
		return readerDao.deleteReader(readerId);
	}

	@Override
	public boolean editReader(Reader reader) {
		return readerDao.editReader(reader);
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
