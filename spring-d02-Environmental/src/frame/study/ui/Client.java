package frame.study.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frame.study.dao.IUserDao;
import frame.study.service.IUserService;

public class Client {
	public static void main(String[] args) {
		/*
		 *加载配置文件，用于创建spring的容器（map）
		 *	ClassPathXmlApplicationContext：表示配置文件在类路径下
		 *  FileSystemXmlApplicationContext()：当配置文件不在类路径下，而是在磁盘上时，使用此类加载。
		 */
		ApplicationContext aContext = new ClassPathXmlApplicationContext("bean.xml");
		IUserDao dao = (IUserDao)aContext.getBean("userDao");
		
		System.out.println(dao);

		IUserService sevice = (IUserService)aContext.getBean("userService");
		System.out.println(sevice);
	}
}
