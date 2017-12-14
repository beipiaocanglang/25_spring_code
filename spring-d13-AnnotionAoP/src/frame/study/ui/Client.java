package frame.study.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frame.study.service.IUserService;

/**
 * 模拟一个表现层
 * @author canglang
 */
public class Client {

	public static void main(String[] args) {
		//加载spring的配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		IUserService userService = (IUserService) ac.getBean("userService");
		
		//userService.saveUser();
		//userService.updateUser(10,50);
		int i = userService.deleteUser();
		
	}
}
