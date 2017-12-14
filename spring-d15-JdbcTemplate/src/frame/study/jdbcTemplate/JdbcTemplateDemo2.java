package frame.study.jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 使用spring的jdbcTemplate
 * @author canglang
 */
public class JdbcTemplateDemo2 {
	
	public static void main(String[] args) throws DataAccessException {
		//加载spring文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		
		JdbcTemplate bean = (JdbcTemplate) ac.getBean("jdbcTemplate");
		bean.execute("insert into account(name,money) values('wangwu',1000)");
	}
}
