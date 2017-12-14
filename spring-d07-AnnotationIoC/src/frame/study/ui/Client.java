package frame.study.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import frame.study.bean.UserBean;
import frame.study.service.IUserService;
/**
 * Spring中常用注解：
 *		@Component
 *			作用：
 *				写在类上面是就是生命当前的类是一个可重用组件
 *				相当于<bean id="当前类名且首字母转小写" class="当前类的全类路径名"></bean>
 *			取值：
 *				默认使用当前类名且首字母转小写做为id的取值
 *				value：给id赋值只有一个属性时value可以不写，只写value值就行
 *			
 *			@Component的三个精细语义化衍生注解
 *		 		@Controller：一般多用于Action。针对表现层的组件注解
 *		 		@Service ：一般多用于业务层。
 *				@Repository：一般多用于持久层
 *				注意：
 *					此三个的属性和@Component注解一样
 *		@Autowired
 * 			作用：自动按照类型注入。
 * 			注意：
 * 				当使用注解注入时，set方法就不是必须的了。因为spring用的是字段反射。
 * 				它只能注入其他bean类型的，不能注入基本类型和String类型。
 * 				如果有多个符合条件时，会使用变量的名称作为key，在spring容器中查找。
 * 				如果找到了就注入，如果没有找到就报错
 *		@Qualifier
 * 			作用：在自动按照类型注入的基础之上，再按照名称注入
 * 			属性：
 * 				value:用于指定去容器中查找的bean的id
 * 			注意：
 * 				使用该注解时，@Autowired必须存在
 * 
 * 		@Resource
 * 			作用：整合@Autowired和@Qualifier。直接就是按照名称注入
 * 			属性：
 * 				name：用于指定去容器中查找的bean的id
 * 		@Value 
 * 			作用：
 * 				给基本类型或者String类型注入数据 		
 * 				也可以注入配置文件中的数据			
 * @author canglang
 */
@Controller
public class Client {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		
		IUserService bean = (IUserService)ac.getBean("userServiceImpl");
		bean.saveUser();
	}
}
