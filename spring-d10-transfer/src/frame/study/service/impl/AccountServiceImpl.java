package frame.study.service.impl;

import frame.study.dao.IAccountDao;
import frame.study.dao.impl.AccountDaoImpl;
import frame.study.domain.Account;
import frame.study.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

	
		private IAccountDao dao = new AccountDaoImpl();
		
		public void transfer(String sourceName, String targetName, Float money) {
			//1.根据名称获取账户信息
			Account sourceAccount = dao.findAccountByName(sourceName);//转出账户
			Account targetAccount = dao.findAccountByName(targetName);//转入账户
			//2.设置账户的金额
			sourceAccount.setMoney(sourceAccount.getMoney()-money);//转出账户减钱
			targetAccount.setMoney(targetAccount.getMoney()+money);//转入账户加钱
			//3.更新账户信息
			dao.updateAccount(sourceAccount);
			//手动模拟一个异常
			//int i=1/0;
			dao.updateAccount(targetAccount);
		}

		@Override
		public Account findAccountById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

}
