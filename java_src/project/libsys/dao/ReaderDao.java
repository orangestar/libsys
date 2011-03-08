package project.libsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import project.libsys.bean.Reader;

public class ReaderDao extends AbstractDao {
	
	public List<Reader> getReaders() {
		String sql = "SELECT id, name, sex FROM readers";
		return jdbcTemplate.query(sql, new ReaderRowMapper());
	}

	@Override
	protected void initJdbcInsert() {
		// TODO Auto-generated method stub

	}
	
	private static class ReaderRowMapper implements RowMapper<Reader> {

		@Override
		public Reader mapRow(ResultSet rs, int rowNum) throws SQLException {
			Reader r = new Reader();
			r.setId(rs.getInt("id"));
			r.setName(rs.getString("name"));
			r.setMale(rs.getBoolean("sex"));
			return r;
		}
		
	}

}
