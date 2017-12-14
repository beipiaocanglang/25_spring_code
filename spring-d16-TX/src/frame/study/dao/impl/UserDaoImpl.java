package frame.study.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import frame.study.dao.IUserDao;
import frame.study.dao.rowmapper.AccoutRowMapper;
import frame.study.domain.Account;

public class UserDaoImpl extends JdbcDaoSupport implements IUserDao {
	
	public Account findAccountByName(String accountName) {
		List<Account> list = getJdbcTemplate().query("select * from account where name=?", new AccoutRowMapper(), accountName);
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	public void updateAccount(Account account) {
		getJdbcTemplate().update("update account set name=?,money=? where id=?", account.getName(),account.getMoney(),account.getId());
		
	}

	public Account findAccountById(Integer id) {
		List<Account> list = getJdbcTemplate().query("select * from account where id=?", new AccoutRowMapper(), id);
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

}
