package project.libsys.service.impl;

import java.util.List;

import project.libsys.bean.Book;
import project.libsys.dao.BookDao;
import project.libsys.service.BookService;

public class BookServiceImpl implements BookService {
	
	private BookDao bookDao;

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book getBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooks() {
		return bookDao.getBooks();
	}
	
	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
