package pro.libsys.test;

import org.springframework.jdbc.core.JdbcTemplate;

public class HelloWorldSpring {
	
	private JdbcTemplate jdbcTemplate;
	
	public String helloSpring() {
		return "Hello, Spring!";
	}
	
	public boolean test() {
		boolean ok = false;
		jdbcTemplate.execute("create table book(id int);");
		return ok;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
