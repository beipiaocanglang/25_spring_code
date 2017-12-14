package frame.study.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;

import frame.study.dao.IUserDao;
import frame.study.dao.rowMapper.AccoutRowMapper;
import frame.study.domain.Account;

/**
 * 优化：
 * 		使用hibernate的模版操作
 * @author canglang
 */
public class UserDaoImpl2 implements IUserDao {

	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Account findAccountByName(String accountName) {
		List<Account> list = (List<Account>) hibernateTemplate.find("from Account where name=?", accountName);
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	public void updateAccount(Account account) {
		hibernateTemplate.update(account);
	}

	public Account findAccountById(Integer id) {
		return hibernateTemplate.get(Account.class, id);
	}
}
