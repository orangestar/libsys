package project.libsys.dao;

import project.libsys.bean.Lend;

public class LendDao extends AbstractDao {
	
	public boolean addLend(Lend lend) {
		String sql = "INSERT INTO lend (book_id, reader_id, lend_date, user_id) VALUES (?, ?, ?, ?)";
		boolean inserted = jdbcTemplate.update(sql, lend.getBook().getId(), lend.getReader().getId(), lend.getLendDate(), lend.getUser().getId()) == 1;
		sql = "SELECT last_insert_id()";
		lend.setId(jdbcTemplate.queryForInt(sql));
		return inserted;
	}

	@Override
	protected void initJdbcInsert() {
		// do nothing
	}

}
