package project.libsys.dao;

import project.libsys.bean.Lend;

public class LendDao extends AbstractDao {
	
	public int getLendId(Lend lend) {
		String sql = "SELECT id FROM lend WHERE book_id = ? AND reader_id = ? AND return_date IS NULL";
		return jdbcTemplate.queryForInt(sql, lend.getBook().getId(), lend.getReader().getId());
	}
	
	public boolean addLend(Lend lend) {
		String sql = "INSERT INTO lend (book_id, reader_id, lend_date, user_id) VALUES (?, ?, ?, ?)";
		boolean inserted = jdbcTemplate.update(sql, lend.getBook().getId(), lend.getReader().getId(), lend.getLendDate(), lend.getUser().getId()) == 1;
		sql = "SELECT last_insert_id()";
		lend.setId(jdbcTemplate.queryForInt(sql));
		return inserted;
	}
	
	public boolean returnBook(Lend lend) {
		String sql = "UPDATE lend SET return_date = ? WHERE id = ?";
		return jdbcTemplate.update(sql, lend.getReturnDate(), lend.getId()) == 1;
	}

	@Override
	protected void initJdbcInsert() {
		// do nothing
	}

}
