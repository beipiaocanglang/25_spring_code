package frame.study.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import frame.study.dao.IUserDao;
import frame.study.domain.Account;
import frame.study.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
	
	private IUserDao accountDao;
	public void setAccountDao(IUserDao accountDao) {
		this.accountDao = accountDao;
	}
	public void transfer(final String sourceName, final String targetName, final Float money) {
		//1.根据名称获取账户信息
		Account sourceAccount = accountDao.findAccountByName(sourceName);//转出账户
		Account targetAccount = accountDao.findAccountByName(targetName);//转入账户
		//2.设置账户的金额
		sourceAccount.setMoney(sourceAccount.getMoney()-money);//转出账户减钱
		targetAccount.setMoney(targetAccount.getMoney()+money);//转入账户加钱
		//3.更新账户信息
		accountDao.updateAccount(sourceAccount);
		//手动模拟一个异常
		//int i=1/0;
		accountDao.updateAccount(targetAccount);
	}

	@Override
	public Account findAccountById(Integer id) {
		Account account = accountDao.findAccountById(id);
		return account;
	}

}
