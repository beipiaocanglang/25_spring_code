package frame.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frame.study.dao.IUserDao;
import frame.study.dao.impl.UserDaoImpl;
import frame.study.service.IUserService;

/**
 * 用户服务层实现类
 * @author canglang
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	public void saveUser() {
		userDao.saveUser();
	}

	public void deleteUser() {
		userDao.deleteUser();
	}

}
