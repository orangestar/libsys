package pro.libsys.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import pro.libsys.bean.Book;

public class BookDao extends AbstractDao {
	
	public void addBook(Book book) {
		SqlParameterSource params = new MapSqlParameterSource()
											.addValue("title", book.getTitle())
											.addValue("author", book.getAuthor())
											.addValue("publisher_id", book.getPublisher().getId());
		Number newId = jdbcInsert.executeAndReturnKey(params);
		book.setId(newId.intValue());
	}

	@Override
	protected void initJdbcInsert() {
		jdbcInsert = new SimpleJdbcInsert(dataSource)
							.withTableName("books")
							.usingColumns("title", "author", "publisher_id")
							.usingGeneratedKeyColumns("id");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("E:/workspaces/LibrarySystem/WebContent/WEB-INF/conf/application-context.xml");
		BookDao dao = ctx.getBean("bookDao", BookDao.class);
		Book book = new Book();
		book.setTitle("title");
		book.setAuthor("author");
//		book.setPublisher(publisher);
		dao.addBook(book);
	}

}
