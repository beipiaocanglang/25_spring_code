package frame.study.factory;

import frame.study.service.IUserService;
import frame.study.service.impl.UserServiceImpl;

/**
 * 实例工厂
 * 
 * @author canglang
 */
public class InstanceFactory {

	public IUserService getUserService() {

		return new UserServiceImpl();
	}
}
