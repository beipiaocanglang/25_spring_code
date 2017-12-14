package frame.study.ui;

import frame.study.factory.BeanFactory;
import frame.study.service.IUserService;

/**
 * 相当一个客户端(表现层)
 * @author zhy
 *
 */
public class Client {

	public static void main(String[] args) {
		//IUserService userService = new UserServiceImpl();
		
		IUserService userService = (IUserService) BeanFactory.newInstance().getBean("USERSERVICE");
		userService.saveUser();
	}

}
