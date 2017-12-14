package frame.study.web.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import frame.study.domain.Account;
import frame.study.service.IAccountService;

public class AccountServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//加载配置文件，此种方法每一次都会创建一个新的spring容器，没有必要
		//ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		
		//使用servletContext来从当前ServletContext对象中获取spring容器(注意：是获取而不是创建)
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
		System.out.println(ac);
		
		IAccountService accountService = (IAccountService) ac.getBean("accountService");
		Account account = accountService.findAccountById(1);
		
		System.out.println(account);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
