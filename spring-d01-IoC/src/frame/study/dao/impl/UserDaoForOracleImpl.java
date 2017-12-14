package frame.study.dao.impl;

import frame.study.dao.IUserDao;


/**
 * 持久层具体实现
 * @author zhy
 *
 */
public class UserDaoForOracleImpl implements IUserDao {

	public void saveUser() {
		System.out.println("Oracle:保存了用户");
	}

	public void deleteUser() {
		System.out.println("Oracle:删除了用户");
	}

}
