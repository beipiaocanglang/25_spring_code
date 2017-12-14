package frame.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个剧组
 * 使用Proxy实现动态代理，要求被代理对象必须实现一个或多个接口。
 * 如果不实现任何接口，不能使用。
 * 
 * 动态代理的作用：
 * 		就是对被代理对象的方法进行增强。
 * 动态代理的特点：
 * 		字节码随用随创建，随用随加载。
 * 
 * 静态代理就是装饰者模式
 * 
 * 动态代理分为：
 * 		基于接口的：Proxy		JDK官方
 *  	基于子类的：Enhancer	第三方的
 * 在实际开发中,能使用基于接口的就不使用基于子类的
 * 
 * 动态代理的精髓：
 * 		深刻理解：间接
 */
public class Client {

	public static void main(String[] args) {
		//--------------之前剧组直接找演员--------------
		/*Actor actor = new Actor();
		actor.baseAct(200);
		actor.dangerAct(1000);*/
		
		//--------------有了经纪公司后剧组不能直接找演员，而是需要通过经纪公司--------------
		final Actor actor = new Actor();
		/**
		 * 	loader：类加载器，使用和被代理对象相同的类加载器。
		 *	interfacese：代理对象要实现的接口。要求和被代理对象具有相同的行为。
		 *	handler：如何代理。
		 *		InvocationHandler用的就是策略模式
		 *		策略模式适用场景：
		 *			1.数据已经有了
		 *			2.目标明确
		 *		如何达成目标：就是策略
		 */
		IActor act = (IActor)Proxy.newProxyInstance(actor.getClass().getClassLoader(), 
				actor.getClass().getInterfaces(), 
				new InvocationHandler() {
			/**
			 * invoke方法：
			 * 		执行被代理对象的任何方法，都会经过该方法。此方法具有拦截的特点。
			 * 
			 * 参数详解
			 * 		Object proxy ：代理对象的引用。但是不一定每次都用得到
			 * 		Method method ： 当前执行被代理对象的方法。
			 * 		Object[] args ：执行方法时所需要的参数
			 * 
			 * 返回值：
			 * 		Object：被代理对象方法的返回值
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {

				Float maney = (Float)args[0];
				
				if(method.getName().equals("baseAct")){
					/*基本演出
					 * 要演出的人，支付的金额
					 */
					return method.invoke(actor, maney/2);
				}
				if(method.getName().equals("dangerAct")){
					/*基本演出
					 * 要演出的人，支付的金额
					 */
					return method.invoke(actor, maney/4);
				}
				return null;
			}
		});
		
		act.baseAct(200);
		act.dangerAct(1000);
	}
}
