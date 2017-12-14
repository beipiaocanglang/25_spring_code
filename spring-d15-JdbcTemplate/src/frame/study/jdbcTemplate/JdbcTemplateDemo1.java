package frame.study.jdbcTemplate;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 使用spring的jdbcTemplate
 * @author canglang
 */
public class JdbcTemplateDemo1 {
	
	public static void main(String[] args) throws DataAccessException {
		//Spring提供了一个内置的数据源，该数据源没有性能问题，可以使用
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql:///sping-d10-transfer");
		dmds.setUsername("root");
		dmds.setPassword("root");
		
		//创建一个新的spring的jdbc模版
		JdbcTemplate jt = new JdbcTemplate();
		//给模版赋值数据源
		jt.setDataSource(dmds);
		jt.execute("insert into account(name,money) values('lisi',1000)");
	}
}
