package pro.libsys.dao;

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

	@Override
	protected void initJdbcInsert() {
		// do nothing...
	}
	
}
