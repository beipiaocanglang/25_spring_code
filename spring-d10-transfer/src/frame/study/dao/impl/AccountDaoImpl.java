package frame.study.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import frame.study.dao.IAccountDao;
import frame.study.domain.Account;
import frame.study.utils.TransactionManager;

public class AccountDaoImpl implements IAccountDao {

	private QueryRunner qr = new QueryRunner();
	
	public Account findAccountByName(String sourceName) {
		try{
			return qr.query(TransactionManager.getConnection(),"select * from account where name = ? ",new BeanHandler<Account>(Account.class),sourceName) ;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	
	public void updateAccount(Account sourceAccount) {
		try{
			qr.update(TransactionManager.getConnection(),"update account set name=?,money=? where id=? ",sourceAccount.getName(),sourceAccount.getMoney(),sourceAccount.getId()) ;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
