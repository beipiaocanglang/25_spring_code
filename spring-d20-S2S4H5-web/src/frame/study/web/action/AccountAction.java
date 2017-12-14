package frame.study.web.action;

import com.opensymphony.xwork2.ModelDriven;

import frame.study.domain.Account;
import frame.study.service.IAccountService;

public class AccountAction implements ModelDriven<Account>{

	//实现ModelDriven<Account>接口必须手动实例化对象
	private Account account = new Account();
	
	//实现未实现的方法
	public Account getModel() {
		return account;
	}
	
	private IAccountService accountService;
	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	//此方法名必须和配置文件中的action标签的method属性取值一致
	public String findActionById(){
		System.out.println("struts2的AccountAction动作类中的findActionById的方法执行了");
		Account account2 = accountService.findAccountById(1);
		System.out.println(account2);
		
		return "success";
	}
}
