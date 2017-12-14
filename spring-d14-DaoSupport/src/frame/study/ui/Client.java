package frame.study.ui;

import frame.study.factory.BeanFactory;
import frame.study.service.IAccountService;

/**
 * 模拟的表现层
 * @author zhy
 *
 */
public class Client {

	public static void main(String[] args) {
		//IAccountService accountService = new AccountServiceImpl();
		IAccountService accountService = BeanFactory.getBean();
		accountService.transfer("aaa", "bbb", 100f);
	}

}
