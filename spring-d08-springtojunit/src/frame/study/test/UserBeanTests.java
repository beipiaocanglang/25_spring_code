package frame.study.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import frame.study.bean.UserBean;

/**
 * Spring整合Junit
 * 1、导入junit的jar包。导入spring整合junit的jar包
 * 2、要替换运行器（其实就是测试用的main函数），换成spring框架提供的，因为只有spring框架提供的才能支持spring。
 * 3、告知新运行器，spring的配置文件所在的位置
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bean.xml"})
public class UserBeanTests {

	@Autowired
	private UserBean userBean;
	
	@Test
	public void userBeanTest(){
		
		userBean.saveUser();
	}
}
