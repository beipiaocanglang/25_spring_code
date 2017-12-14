package frame.study.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import frame.study.dao.IUserDao;
import frame.study.domain.Account;
import frame.study.service.IAccountService;

/**
 * @Transactional:配置当前使用的类或方法需要使用事物
 * 		注解配置的位置：
 * 			用在业务实现类上：该类所有的方法都在事务的控制范围
 * 	
 * 			用在业务接口上：该接口的所有实现类都起作用
 * 
 * 			通过注解指定事务的定义信息。例如：在方法上使用@Transactional(readOnly=true)
 * 
 * 			注意：
 *				如果类上和方法上同时使用注解，则使用就近原则
 * @author yeying
 */

@Service("accountService")
@Transactional
public class AccountServiceImpl implements IAccountService {
	
	@Resource
	private IUserDao accountDao;

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
		int i=1/0;
		accountDao.updateAccount(targetAccount);
	}

	@Override
	public Account findAccountById(Integer id) {
		Account account = accountDao.findAccountById(id);
		return account;
	}
}
