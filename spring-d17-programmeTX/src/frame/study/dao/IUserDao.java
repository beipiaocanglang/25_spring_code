package frame.study.dao;

import frame.study.domain.Account;

public interface IUserDao {

	/**
	 * 根据账户名查询账户信息
	 * @param accountName
	 * @return
	 */
	Account findAccountByName(String accountName);
	
	/**
	 * 更新账户信息
	 * @param account
	 */
	void updateAccount(Account account);
	
	/**
	 * 根据id查询账户信息
	 * @param id
	 * @return
	 */
	Account findAccountById(Integer id);
}
