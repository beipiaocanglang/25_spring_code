package frame.study.ui;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 定义一个公共的切入点
 * @author canglang
 */
public class MyPointcut {

	@Pointcut("execution(* frame.study.service.impl.*.*(..))")
	public void pt1(){}
}
