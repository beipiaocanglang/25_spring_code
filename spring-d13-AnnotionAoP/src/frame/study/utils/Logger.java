package frame.study.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 模拟一个通知
 * 
 * 此通知是针对日志的方面
 * @author canglang
 * 
 * 常用注解
 * @Aspect:
 * 		作用：表明当前类是一个切面
 * @Pointcut:
 * 		作用:可以提取出来一个公共的方法使用此注解定义一个当前类的公共切入点
 * 		属性value：指定切入点表达式。
 * 		注意：
 * 			当使用注解定义公用切入点表达式时，表达式的id就是方法的名称。
 * 			在引用时，必须写上()。
 * 			例如：pt1()
 * 		想要提取成全局的公共切入点需要创建一个类，在类中写一个方法，此方法没有任何意义，只是为了提出全局的切入点表达式
 * 			注意：
 * 				只需要在方法上使用@Pointcut注解就行，不需要在类上使用@Component
 * 				在引用时需要使用当前定义的类的全类路径名点上方法名
 * @Before
 * 	 	作用：配置一个前置通知，可以接收参数JoinPoint jp
 * 		属性value：指定切入点表达式，还可以指定切入点表达式的引用。
 * 		例如：
 * 			@Before(value="pt1()")
 * 			@Before(value="frame.study.ui.MyPointcut.pt1()")
 * 			@Before(value="execution(* frame.study.service.impl.*.*(..))")
 * @AfterReturning
 * 		作用：配置一个后置通知,在业务核心方法执行之后执行
 * 		属性：
 * 			value：指定切入点表达式，还可以指定切入点表达式的引用。
 * 			returning：可以接收返回值，取值必须和参数变量一致，且严格区分大小写
 * @AfterThrowing
 * 		作用：配置一个异常通知
 * 		属性：
 * 			value：指定切入点表达式，还可以指定切入点表达式的引用。
 * 			throwing：输出异常信息，取值必须和参数变量一致，且严格区分大小写
 * @After
 * 		作用：配置一个最终通知
 * 		属性value：指定切入点表达式，还可以指定切入点表达式的引用。
 * @Around
 * 		作用：配置一个环绕通知
 * 		属性value：指定切入点表达式，还可以指定切入点表达式的引用。
 * 		注意：
 * 			和配置文件的配置方法是一样的，配置在哪里就会当作什么通知
 */
@Component
@Aspect
public class Logger {
	@Pointcut("execution(* frame.study.service.impl.*.*(..))")
	public void pt1(){}
	
	//前置通知
	@Before(value="pt1()")
	public static void beforPrintLog(JoinPoint jp){
		Object[] args = jp.getArgs();
		System.out.println(Arrays.toString(args));
		System.out.println("Logger的beforPrintLog方法开始记录日志。。。。。。。");
	}
	//后置通知
	@AfterReturning(value="pt1()", returning="rtValue")
	public static void AfterReturningPrintLog(Object rtValue){
		System.out.println(rtValue);
		System.out.println("Logger的AfterReturningPrintLog方法开始记录日志。。。。。。。");
	}
	//异常通知
	@AfterThrowing(value="pt1()",throwing="th")
	public static void AfterThrowingPrintLog(Throwable th){
		System.out.println("执行了异常通知："+th);
		System.out.println("Logger的AfterThrowingPrintLog方法开始记录日志。。。。。。。");
	}
	//最终通知
	@After(value="pt1()")
	public static void AfterPrintLog(){
		System.out.println("Logger的AfterPrintLog方法开始记录日志。。。。。。。");
	}
	//环绕通知
	/*@Around(value="pt1()")
	public static void AroundPrintLog(ProceedingJoinPoint pjp){
		try {
			pjp.proceed();
		} catch (Throwable e) {
			System.out.println("Logger的AroundPrintLog方法开始记录日志。。。。。。。");
			e.printStackTrace();
		}finally{
			
		}
	}*/
}
