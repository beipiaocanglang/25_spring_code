package frame.study.dao.impl;

import frame.study.dao.IUserDao;

/**
 * 用户的持久层实现类
 * @author canglang
 */
public class UserDaoImpl implements IUserDao {

	public void saveUser() {
		System.out.println("保存了一个用户");
	}

	public void deleteUser() {
		System.out.println("删除了一个用户");
	}

}
