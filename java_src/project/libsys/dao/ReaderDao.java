package project.libsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import project.libsys.bean.Reader;

public class ReaderDao extends AbstractDao {
	
	public List<Reader> getReaders() {
		String sql = "SELECT id, name, sex FROM readers";
		return jdbcTemplate.query(sql, new ReaderRowMapper());
	}

	public boolean deleteReader(int id) {
		String sql = "DELETE FROM readers WHERE id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}
	
	public void addReader(Reader reader) {
		SqlParameterSource params = new MapSqlParameterSource()
											.addValue("name", reader.getName())
											.addValue("sex", reader.isMale());
		Number newId = jdbcInsert.executeAndReturnKey(params);
		reader.setId(newId.intValue());
	}
	
	public boolean editReader(Reader reader) {
		String sql = "UPDATE readers SET name = ?, sex = ? WHERE id = ?";
		return jdbcTemplate.update(sql, reader.getName(), reader.isMale(), reader.getId()) == 1;
	}
	
	public Reader getReader(String name) {
		String sql = "SELECT id, name, sex FROM readers WHERE name = ?";
		List<Reader> readers = jdbcTemplate.query(sql, new ReaderRowMapper(), name);
		return readers.size() == 1 ? readers.get(0) : null;
	}
	
	@Override
	protected void initJdbcInsert() {
		jdbcInsert = new SimpleJdbcInsert(dataSource)
							.withTableName("readers")
							.usingColumns("name")
							.usingColumns("sex")
							.usingGeneratedKeyColumns("id");
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
