package pro.libsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import pro.libsys.bean.User;

public class UserDao extends AbstractDao {
	
	public void addUser(User user) {
		String sql = "INSERT INTO users (name, password) VALUES (?, MD5(?))";
		Object[] params = new Object[] {
			user.getName(),
			user.getPassword()
		};
		jdbcTemplate.update(sql, params);
	}
	
	public User getUser(String name) {
		String sql = "SELECT id, name, password FROM users WHERE name = ?";
		List<User> list = jdbcTemplate.query(sql, new UserRowMapper(), name);
		return list.size() == 1 ? list.get(0) : new User();
	}

	@Override
	protected void initJdbcInsert() {
		// do nothing...
	}
	
	private static class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int index) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		
	}
	
}
