package frame.study.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import frame.study.proxy.IActor;

/**
 * 模拟一个剧组
 * 如果被代理类没有实现任何接口，则不能使用Jdk提供的Proxy生成代理对象。(Proxy的动态代理叫做：基于接口的动态代理)
 * 只能使用第三方的CGLIB生成代理对象。
 * 
 * 基于子类的动态代理
 * 		1.导入必须的jar
 *			cglib-2.1.3.jar
 * 			如果报错再导入asm.jar
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
		 * 基于子类的动态代理
		 * 	参数：
		 * 		Class：被代理对象的字节码
		 * 		CallBack：如何代理
		 */
		Actor act = (Actor)Enhancer.create(actor.getClass(), new MethodInterceptor() {
			/**
			 * 执行被代理对象的任何方法，都会经过该方法。
			 * 参数详解：
			 * 		Object proxy ：代理对象的引用。但是不一定每次都用得到
			 * 		Method method ： 当前执行被代理对象的方法。
			 * 		Object[] args ：执行方法时所需要的参数
			 *  	MethodProxy:当前执行方法的代理对象。
			 */
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy arg3) throws Throwable {
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
