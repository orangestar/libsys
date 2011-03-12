package project.libsys.service.impl;

import java.util.Date;
import java.util.List;

import project.libsys.bean.Book;
import project.libsys.bean.Lend;
import project.libsys.bean.Reader;
import project.libsys.dao.BookDao;
import project.libsys.dao.LendDao;
import project.libsys.dao.ReaderDao;
import project.libsys.service.LendService;

public class LendServiceImpl implements LendService {
	
	private LendDao lendDao;
	
	private BookDao bookDao;
	
	private ReaderDao readerDao;
	
	@Override
	public Lend lendBook(Lend lend) {
		Book book = bookDao.getBook(lend.getBook().getTitle());
		if(book != null) {
			lend.setBook(book);
		} else {
			return null;
		}
		Reader reader = readerDao.getReader(lend.getReader().getName());
		if(reader != null) {
			lend.setReader(reader);
		} else {
			return null;
		}
		lend.setLendDate(new Date());
		return lendDao.addLend(lend) ? lend : null;
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

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public ReaderDao getReaderDao() {
		return readerDao;
	}

	public void setReaderDao(ReaderDao readerDao) {
		this.readerDao = readerDao;
	}

}
