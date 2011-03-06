package project.libsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import project.libsys.bean.Book;
import project.libsys.bean.Publisher;

public class BookDao extends AbstractDao {
	
	public void addBook(Book book) {
		SqlParameterSource params = new MapSqlParameterSource()
											.addValue("title", book.getTitle())
											.addValue("author", book.getAuthor())
											.addValue("publisher_id", book.getPublisher().getId());
		Number newId = jdbcInsert.executeAndReturnKey(params);
		book.setId(newId.intValue());
	}
	
	public List<Book> getBooks() {
		String sql = "SELECT books.id, books.title, books.author, books.publisher_id, publishers.name FROM books, publishers WHERE books.publisher_id = publishers.id";
		return jdbcTemplate.query(sql, new BookRowMapper());
	}
	
	@Override
	protected void initJdbcInsert() {
		jdbcInsert = new SimpleJdbcInsert(dataSource)
							.withTableName("books")
							.usingColumns("title", "author", "publisher_id")
							.usingGeneratedKeyColumns("id");
	}
	
	private static class BookRowMapper implements RowMapper<Book> {

		@Override
		public Book mapRow(ResultSet rs, int index) throws SQLException {
			Publisher publ = new Publisher();
			publ.setId(rs.getInt("books.publisher_id"));
			publ.setName(rs.getString("publishers.name"));
			Book book = new Book();
			book.setId(rs.getInt("books.id"));
			book.setTitle(rs.getString("books.title"));
			book.setAuthor(rs.getString("books.author"));
			book.setPublisher(publ);
			return book;
		}
		
	}

}
