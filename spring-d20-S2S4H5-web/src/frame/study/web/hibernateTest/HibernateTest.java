package frame.study.web.hibernateTest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import frame.study.domain.Account;
import frame.study.utils.HibernateUtil;

/**
 * hibernate测试类
 * @author canglang
 */
public class HibernateTest {

	@Test
	public void test(){
		Session session = HibernateUtil.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		Account account = session.get(Account.class, 1);
		
		transaction.commit();
		
		System.out.println(account);
	}
}
