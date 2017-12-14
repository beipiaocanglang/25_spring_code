package frame.study.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;

import frame.study.dao.IAccountDao;
import frame.study.domain.Account;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

	public Account findAccountByName(String sourceName) {
		return query("select * from account where name = ? ",new BeanHandler<Account>(Account.class),sourceName) ;
	}

	
	public void updateAccount(Account sourceAccount) {
		update("update account set name=?,money=? where id=? ",sourceAccount.getName(),sourceAccount.getMoney(),sourceAccount.getId()) ;
	}

}
