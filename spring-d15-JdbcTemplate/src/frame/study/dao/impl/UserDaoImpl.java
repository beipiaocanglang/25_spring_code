package frame.study.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import frame.study.dao.IUserDao;
import frame.study.domain.Account;

public class UserDaoImpl implements IUserDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void saveUser(Account account) {
		jdbcTemplate.update("update account set name=? where id=?",account.getName(),account.getId());
		
	}

}
