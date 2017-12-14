package frame.study.factory;

import frame.study.dao.impl.UserDaoImpl;
import frame.study.service.IUserService;
import frame.study.service.impl.UserServiceImpl;

/**
 * 静态工厂
 * @author canglang
 *
 */
public class StaticFactory {

	public static IUserService getUserService(){
		
		return new UserServiceImpl();
	}
}
