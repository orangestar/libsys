package project.libsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import project.libsys.bean.User;

public class UserDao extends AbstractDao {
	
	public void addUser(User user) {
		String sql = "INSERT INTO users (name, password) VALUES (?, MD5(?))";
		Object[] params = new Object[] {
			user.getName(),
			user.getPassword()
		};
		jdbcTemplate.update(sql, params);
		User newUser = getUser(user.getName());
		user.setId(newUser.getId());
	}
	
	public User getUser(String name) {
		String sql = "SELECT id, name, password FROM users WHERE name = ?";
		List<User> list = jdbcTemplate.query(sql, new UserRowMapper(), name);
		return list.size() == 1 ? list.get(0) : null;
	}
	
	public boolean deleteUser(int id) {
		String sql = "DELETE FROM users WHERE id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}
	
	public boolean editUser(User user) {
		String sql = "UPDATE users SET name = ?, password = MD5(?) WHERE id = ?";
		return jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getId()) == 1;
	}
	
	public List<User> getUsers() {
		String sql = "SELECT id, name, password FROM users";
		return jdbcTemplate.query(sql, new UserRowMapper());
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
