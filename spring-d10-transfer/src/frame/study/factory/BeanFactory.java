package frame.study.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import frame.study.service.IAccountService;
import frame.study.service.impl.AccountServiceImpl;
import frame.study.utils.LoggerManager;
import frame.study.utils.TransactionManager;

/**
 * 一个静态工厂
 * @author zhy
 * 生成Bean的工厂
 */
public class BeanFactory {

	public static IAccountService getBean(){
		final IAccountService accountService = new AccountServiceImpl();
		//生成它的代理对象
		IAccountService proxyAccountService = (IAccountService)Proxy.newProxyInstance(
						accountService.getClass().getClassLoader(), 
						accountService.getClass().getInterfaces(), 
						new InvocationHandler() {
			/**
			 * 如何代理：
			 * 	在执行transfer方法的时候开启事务
			 */
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if("transfer".equals(method.getName())){
					//开启事务
					try{
						TransactionManager.startTransaction();
						LoggerManager.printLog();
						method.invoke(accountService, args);
						TransactionManager.commit();
					}catch(Exception e){
						TransactionManager.rollback();
						e.printStackTrace();
					}finally{
						TransactionManager.release();
					}
				}
				return null;
			}
		});
		
		//返回的也是代理对象
		return proxyAccountService;
	}
}
