package project.libsys.service.impl;

import java.util.List;

import project.libsys.bean.Book;
import project.libsys.dao.BookDao;
import project.libsys.service.BookService;

public class BookServiceImpl implements BookService {
	
	private BookDao bookDao;

	@Override
	public Book addBook(Book book) {
		bookDao.addBook(book);
		return book;
	}

	@Override
	public boolean deleteBook(int bookId) {
		return bookDao.deleteBook(bookId);
	}

	@Override
	public boolean editBook(Book book) {
		return bookDao.editBook(book);
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
