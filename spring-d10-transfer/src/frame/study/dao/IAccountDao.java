package frame.study.dao;

import frame.study.domain.Account;

public interface IAccountDao {
	

	Account findAccountByName(String sourceName);
	
	
	void updateAccount(Account sourceAccount);

}
