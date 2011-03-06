package project.libsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import project.libsys.bean.Publisher;

public class PublisherDao extends AbstractDao {
	
	public void addPublisher(Publisher publ) {
		SqlParameterSource params = new MapSqlParameterSource()
											.addValue("name", publ.getName());
		Number newId = jdbcInsert.executeAndReturnKey(params);
		publ.setId(newId.intValue());
	}
	
	public List<Publisher> getPublishers() {
		String sql = "SELECT id, name FROM publishers";
		return jdbcTemplate.query(sql, new PublisherRowMapper());
	}
	
	public boolean editPublisher(Publisher publ) {
		String sql = "UPDATE publishers SET name = ? WHERE id = ?";
		return jdbcTemplate.update(sql, publ.getName(), publ.getId()) == 1;
	}
	
	public boolean delPublisher(int id) {
		String sql = "DELETE FROM publishers WHERE id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	@Override
	protected void initJdbcInsert() {
		jdbcInsert = new SimpleJdbcInsert(dataSource)
							.withTableName("publishers")
							.usingColumns("name")
							.usingGeneratedKeyColumns("id");
	}
	
	private static class PublisherRowMapper implements RowMapper<Publisher> {

		@Override
		public Publisher mapRow(ResultSet rs, int index) throws SQLException {
			Publisher publ = new Publisher();
			publ.setId(rs.getInt("id"));
			publ.setName(rs.getString("name"));
			return publ;
		}
		
	}

}
