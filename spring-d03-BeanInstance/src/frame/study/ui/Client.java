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
		
		//静态工厂调用
		IUserService bean = (IUserService)aContext.getBean("staticBean");
		System.out.println(bean);
		
		//实例工厂调用
		IUserService bean1 = (IUserService)aContext.getBean("instanceBean");
		System.out.println(bean1);
	}
}
