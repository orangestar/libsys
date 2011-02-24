package project.libsys.service;

import java.util.List;

import project.libsys.bean.Book;

public interface BookService {

	public boolean addBook(Book book);
	
	public boolean editBook(Book book);
	
	public boolean deleteBook(int bookId);
	
	public List<Book> getBooks();
	
	public Book getBook();
	
}
