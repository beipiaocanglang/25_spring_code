package frame.study.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import frame.study.dao.IUserDao;
import frame.study.domain.Account;

public class UserDaoImpl1 extends JdbcDaoSupport implements IUserDao {

	public void saveUser(Account account) {
		getJdbcTemplate().update("update account set name=? where id=?",account.getName(),account.getId());
		
	}

}
