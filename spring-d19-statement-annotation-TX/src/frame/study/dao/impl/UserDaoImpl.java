package frame.study.dao.impl;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import frame.study.dao.IUserDao;
import frame.study.dao.rowMapper.AccoutRowMapper;
import frame.study.domain.Account;

@Component("accountDao")
public class UserDaoImpl implements IUserDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Account findAccountByName(String accountName) {
		return jdbcTemplate.queryForObject("select * from account where name=?",new AccoutRowMapper(), accountName);
	}

	@Override
	public void updateAccount(Account account) {
		jdbcTemplate.update("update account set name=?,money=? where id=?", account.getName(),account.getMoney(),account.getId());
	}

	@Override
	public Account findAccountById(Integer id) {
		return jdbcTemplate.queryForObject("select * from account where id=?",new AccoutRowMapper(), id);
	}
}
