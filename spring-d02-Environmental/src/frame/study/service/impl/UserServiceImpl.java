package frame.study.service.impl;

import frame.study.dao.IUserDao;
import frame.study.dao.impl.UserDaoImpl;
import frame.study.service.IUserService;

/**
 * 用户服务层实现类
 * @author canglang
 */
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	public void saveUser() {
		userDao.saveUser();
	}

	public void deleteUser() {
		userDao.deleteUser();
	}

}
