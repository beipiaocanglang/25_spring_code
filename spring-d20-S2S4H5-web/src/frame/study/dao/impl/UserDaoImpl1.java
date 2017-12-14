package frame.study.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import frame.study.dao.IUserDao;
import frame.study.dao.rowMapper.AccoutRowMapper;
import frame.study.domain.Account;

/**
 * 保证hibernate的dao层可以单独运行
 * @author canglang
 */
public class UserDaoImpl1 implements IUserDao {

	//提供SessionFactory工厂
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Account findAccountByName(String accountName) {
		//从当前线程获取session
		Session session = sessionFactory.getCurrentSession();
		//开启事物
		Transaction transaction = session.beginTransaction();
		//使用例外查询
		//Criteria criteria = session.createCriteria(Account.class);
		//Account account = new Account();
		//account.setName(accountName);
		//Example create = Example.create(account);
		//criteria.add(create);
		
		//使用HQL语句查询
		Query query = session.createQuery("from Account where name=?");
		//设置参数
		query.setString(0, accountName);
		//执行查询
		List<Account> list = query.list();
		
		transaction.commit();
		
		if (list.size() == 1) {
			return list.get(0);
		}
		
		return null;
	}

	public void updateAccount(Account account) {
		//从当前线程获取session
		Session session = sessionFactory.getCurrentSession();
		//开启事物
		Transaction transaction = session.beginTransaction();
		
		session.update(account);
		
		transaction.commit();
	}

	public Account findAccountById(Integer id) {
		//从当前线程获取session
		Session session = sessionFactory.getCurrentSession();
		//开启事物
		Transaction transaction = session.beginTransaction();
		
		Account account = session.get(Account.class, 1);
		
		transaction.commit();
		
		return account;
	}
}
