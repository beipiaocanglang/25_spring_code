package frame.study.web.hibernateTest;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import frame.study.dao.IUserDao;
import frame.study.domain.Account;
import frame.study.utils.HibernateUtil;

/**
 * spring整合hibernate，保证dao能单独运行的测试类
 * 1、拷贝jar
 * 		spring-test-4.2.4.RELEASE.jar
 * 2、替换运行器
 * 		@RunWith(SpringJUnit4ClassRunner.class)
 * 3、告知运行器配置文件的位置
 * 		@ContextConfiguration(locations={"classpath:applicationContext.xml"})
 * 4、临时拷贝applicationContext.xml配置文件到src目录下
 * @author canglang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class HibernateTest1 {

	//注入dao
	@Autowired
	private IUserDao acconutDao;
	
	@Test
	public void test(){
		Account account = acconutDao.findAccountById(1);
		System.out.println(account);
	}
}
