package frame.study.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 模拟一个通知
 * 
 * 此通知是针对日志的方面
 * @author canglang
 */
public class Logger {

	/**
	 * 前置通知：它可以获取切入点方法的参数
	 * Spring框架给我们提供了一个接口：JoinPoint
	 * 在程序执行到前置通知方法时，spring框架会为我们注入该接口的实现类。
	 * 该接口中有一个方法：
	 * 		Object[] args = jp.getArgs();
	 */
	public static void beforePrintLog(JoinPoint jp){
		Object[] args = jp.getArgs();
		System.out.println(Arrays.toString(args));
		System.out.println("Logger的beforePrintLog方法开始记录日志。。。。。。。");
	}
	
	/**
	 * 后置通知：它可以获取切入点方法的返回值
	 * 需要我们在后置通知的方法中提供一个参数，参数的类型是Object
	 * 参数的变量名称必须和配置文件中的returning属性保持一致
	 */
	public static void afterReturningPrintLog(Object rtValue){
		System.out.println(rtValue);
		System.out.println("Logger的afterReturningPrintLog方法开始记录日志。。。。。。。");
	}
	
	/**
	 * 例外通知：它可以获取切入点方法的异常对象
	 * 需要我们在例外通知的方法中提供一个参数，参数的类型是Throwable
	 * 参数的变量名称必须和配置文件中的throwing属性保持一致 
	 */
	public static void afterThrowingprintLog(Throwable th){
		System.out.println("异常信息是："+th);
		System.out.println("Logger的afterThrowingprintLog方法开始记录日志。。。。。。。");
	}
	
	/**
	 * 环绕通知详细说明：
	 * 		它不是在配置切入点方法的前后执行，而是spring给我们提供的一种方式。让我们自己决定该通知是前置还是后者，例外还是最终。
	 * 问题：
	 * 		当我们执行时，只会看见通知方法的语句输出，而看不到业务核心方法的输出语句。
	 * 分析原因：
	 * 		在我们使用动态代理控制事务时，有明确的一句话调用业务核心方法：method.invoke(obj,args);
	 * 		而此时我们没有明确的调用业务核心方法。
	 * 		所以只能看到通知的语句输出，而无法看到业务核心方法的语句输出。
	 * 解决办法：
	 * 		Spring给我们提供的一个接口：ProceedingJoinPoint
	 * 		当Spring框架在执行通知时，会为我们提供该接口的实现类，我们在使用时，直接用即可。无须关心谁给我们提供。
	 * 		ProceedingJoinPoint接口有一个方法：proceed()，它就相当于method的invoke方法。
	 *  		pjp.proceed();	======== method.invoke(obj,args);
	 */
	public static void aroundPrintLog(ProceedingJoinPoint pjp){
		try {
			System.out.println("Logger的aroundPrintLog方法在核心业务之前执行开始记录日志。。。。。。。");
			pjp.proceed();
			System.out.println("Logger的aroundPrintLog方法在核心业务之后执行开始记录日志。。。。。。。");
		} catch (Throwable e) {
			System.out.println("Logger的aroundPrintLog方法在核心业务异常执行开始记录日志。。。。。。。");
			e.printStackTrace();
		}finally{
			System.out.println("Logger的aroundPrintLog方法在核心业务最终执行开始记录日志。。。。。。。");
		}
		System.out.println("--------------------------------------------------------");
	}
}
