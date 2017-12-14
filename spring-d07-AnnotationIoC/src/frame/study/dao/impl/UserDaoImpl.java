package frame.study.dao.impl;

import org.springframework.stereotype.Repository;

import frame.study.dao.IUserDao;

/**
 * 用户的持久层实现类
 * @author canglang
 */
@Repository
public class UserDaoImpl implements IUserDao {

	public void saveUser() {
		System.out.println("保存了一个用户a");
	}

	public void deleteUser() {
		System.out.println("删除了一个用户");
	}

}
