package frame.study.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import frame.study.dao.IUserDao;
import frame.study.domain.Account;

/**
 * 使用spring的jdbcTemplate
 * @author canglang
 */
public class JdbcTemplateDemo4 {
	
	public static void main(String[] args) throws DataAccessException {
		//加载spring文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		
		IUserDao bean = (IUserDao) ac.getBean("userdao");
		Account account = new Account();
		account.setName("wwww");
		account.setId(2);
		bean.saveUser(account);
	}
}
