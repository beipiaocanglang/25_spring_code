package frame.study.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frame.study.service.IAccountService;

/**
 * 模拟一个客户端
 * @author yeying
 */
public class Client {
	public static void main(String[] args) {
		//加载spring的配置文件
		ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
		
		IAccountService service = (IAccountService) app.getBean("accountService");
		
		service.transfer("aaa", "bbb", 100F);
	}
}
