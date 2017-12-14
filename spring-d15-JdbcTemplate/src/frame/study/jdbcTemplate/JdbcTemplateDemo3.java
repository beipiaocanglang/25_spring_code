package frame.study.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import frame.study.domain.Account;

/**
 * 使用spring的jdbcTemplate
 * @author canglang
 */
public class JdbcTemplateDemo3 {
	
	public static void main(String[] args) throws DataAccessException {
		//加载spring文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		
		JdbcTemplate bean = (JdbcTemplate) ac.getBean("jdbcTemplate");
		
		//保存
		//bean.update("insert into account(name,money) values(?,?)","eee",200);
		
		//修改
		//bean.update("update account set name=? where id=?","ooo",7);
		//删除
		//bean.update("delete from account where id = ? ",6);
		//查询一条
		//方法一：
		//Account query = bean.query("select * from account where id = ?",new MyResultSetExctractor(),1);
		//System.out.println(query);
		//方法二
		//List<Account> list = bean.query("select * from account where id = ?",new AccountRowMapper(),1);
		//System.out.println(list);
		
		//查询所有
		//List<Account> query = bean.query("select * from account",new AccountRowMapper());
		//System.out.println(query);
		//查询一行一列,例如count(*)
		int totalRecords = bean.queryForObject("select count(*) from account", Integer.class);
		System.out.println(totalRecords);
	}
}

//查询一条记录
class MyResultSetExctractor implements ResultSetExtractor<Account>{

	public Account extractData(ResultSet rs) throws SQLException,DataAccessException {
		Account account = null;
		//1.判断是否有结果集
		if(rs.next()){
			account = new Account();
			account.setId(rs.getInt("id"));
			account.setName(rs.getString("name"));
			account.setMoney(rs.getFloat("money"));
		}
		return account;
	}
}
//查询所有
class AccountRowMapper implements RowMapper<Account>{
	
	/**
	 * 它是每次遍历都会调用一次此方法
	 * List<Account> list = new ArrayList<Account>();
	 * while(rs.next){
	 * 		Account account = mapRow(rs);
	 *  	list.add(acount);
	 * }
	 * return list;
	 */
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setId(rs.getInt("id"));
		account.setName(rs.getString("name"));
		account.setMoney(rs.getFloat("money"));
		return account;
	}
}
