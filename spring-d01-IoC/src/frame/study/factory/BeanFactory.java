package frame.study.factory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 工厂模式
 * @author zhy
 * Bean：在程序开发中，bean的含义就是可重用的组件。
 * JavaBean：就是用java语言开发的可重用组件。
 */
public class BeanFactory {
	
	private static BeanFactory factory = new BeanFactory();
	private static ResourceBundle bundle = ResourceBundle.getBundle("cn.itcast.factory.bean");
	//初始化一个容器，用于存放配置文件的key和value的对应关系。
	private static Map<String,Object> beanMap = new HashMap<String,Object>();
	
	//使用静态代码块赋值
	static{	
		//1.获取bean.properties中的所有key
		Enumeration<String> keys = bundle.getKeys();
		try {
			//2.遍历keys
			while(keys.hasMoreElements()){
				String key = keys.nextElement();//获取每个key
				//3.根据key获取value
				String classPath = bundle.getString(key);
				//4.使用反射创建classPath对应的对象
				Object obj = Class.forName(classPath).newInstance();
				//5.把key和value存入map中
				beanMap.put(key, obj);
			}		
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化bean容器失败！");
		}	
	}
	
	//私有化构造函数
	private BeanFactory(){
		
	}
	
	//提供一个公有的方法，来获取BeanFactory的实例对象
	public static BeanFactory newInstance(){
		return factory;
	}
	
	/* 此方法的问题是只能生产一种Bean对象
	 使用反射的方式，来创建对象
	public IUserDao getUserDao(){
		IUserDao userDao = null;
		try{
			String classPath = bundle.getString("USERDAO");
			userDao = (IUserDao) Class.forName(classPath).newInstance();
			return userDao;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}*/
	
	/*
	 * 升级版
	 * 存在的问题：
	 * 	每次都是创建了一个新的对象实例。
	 * 	而我们在开发中，持久层和业务层的类对象都是没有类成员属性的。
	 * 	即便是有，由于我们都把它看成是接口类型，也调用不到。
	 * 	所以说，我们的持久层和业务层对象应该是单例的。	 
	 * 而现在是多例的
	public Object getBean(String className){
		Object obj = null;
		try{
			String classPath = bundle.getString(className);
			obj = Class.forName(classPath).newInstance();
			return obj;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}*/
	
	//终极版
	public Object getBean(String className){
		return beanMap.get(className);
	}
}


























