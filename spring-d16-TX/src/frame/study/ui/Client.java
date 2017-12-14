package frame.study.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frame.study.service.IAccountService;

public class Client {

	public static void main(String[] args) {
		//加载spring的配置文件
		ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
		
		IAccountService accountService = (IAccountService) app.getBean("accountService");
		
		accountService.transfer("ccc", "ooo", 200F);
	}
}
