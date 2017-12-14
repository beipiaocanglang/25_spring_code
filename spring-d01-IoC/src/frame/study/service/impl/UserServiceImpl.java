package frame.study.service.impl;

import frame.study.dao.IUserDao;
import frame.study.factory.BeanFactory;
import frame.study.service.IUserService;

/**
 * 业务层的具体实现
 * 	它应该找持久层要东西
 * @author zhy
 *
 */
public class UserServiceImpl implements IUserService {

/*
 * 	此种方式的弊端：当UserServiceImpl在执行时，紧紧依赖于Dao的具体实现类。
 *  			程序的耦合度非常高
 */
//	private IUserDao userDao = new UserDaoForMySQLImpl();
//	private IUserDao userDao = new UserDaoForOracleImpl();
	
	//此种方式的弊端：是工厂只能生产一种Dao（bean）。局限性很大
//	private IUserDao userDao = BeanFactory.newInstance().getUserDao();
	
	private IUserDao userDao = (IUserDao) BeanFactory.newInstance().getBean("USERDAOFORORACLE");

	public void saveUser() {
		userDao.saveUser();
	}

	public void deleteUser() {
		userDao.deleteUser();
	}

}
