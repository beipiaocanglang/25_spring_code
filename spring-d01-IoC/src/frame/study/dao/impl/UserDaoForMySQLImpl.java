package frame.study.dao.impl;

import frame.study.dao.IUserDao;

/**
 * 持久层具体实现
 * @author zhy
 *
 */
public class UserDaoForMySQLImpl implements IUserDao {


	public void saveUser() {
		System.out.println("MySQL:保存了用户");
	}

	public void deleteUser() {
		System.out.println("MySQL:删除了用户");
	}

}
