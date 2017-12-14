package frame.study.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frame.study.bean.UserBean;
import frame.study.bean.UserBean1;
import frame.study.bean.UserBean2;
import frame.study.bean.UserBean3;
import frame.study.bean.UserBean4;

public class Client {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		
		/*UserBean bean = (UserBean)ac.getBean("userbean");
		bean.saveUser();*/
		/*UserBean1 bean1 = (UserBean1)ac.getBean("userbean1");
		bean1.saveUser();*/
		/*UserBean2 bean2 = (UserBean2)ac.getBean("userbean2");
		bean2.saveUser();*/
		/*UserBean3 bean3 = (UserBean3)ac.getBean("userbean3");
		bean3.saveUser();*/
		UserBean4 bean4 = (UserBean4)ac.getBean("myArray");
		bean4.saveUser();
	}
}
