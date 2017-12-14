package frame.study.service;

import frame.study.domain.Account;


/**
 * 业务核心方法的接口
 * @author zhy
 *
 */
public interface IAccountService {

	/**
	 * 转账方法
	 * @param sourceAccountName	转出账户名称
	 * @param targetAccountName 转入账户名称
	 * @param money	转账金额
	 */
	void transfer(String sourceAccountName,String targetAccountName,Float money);
	
	/**
	 * 根据id获取账户信息
	 * @param id
	 * @return
	 */
	Account findAccountById(Integer id);
}
