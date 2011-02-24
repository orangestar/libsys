package project.libsys.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public abstract class AbstractDao {
	
	protected DataSource dataSource;
	
	protected SimpleJdbcTemplate jdbcTemplate;
	
	protected SimpleJdbcInsert jdbcInsert;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
		initJdbcInsert();
	}
	
	protected abstract void initJdbcInsert();
	
}
