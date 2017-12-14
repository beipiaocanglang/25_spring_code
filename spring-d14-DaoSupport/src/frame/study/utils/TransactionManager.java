package frame.study.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 和事务相关的工具类
 * @author zhy
 * 它也是一个通知
 */
public class TransactionManager {

	//1.定义一个线程局部变量，只能存放连接
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//2.从线程局部变量上获取一个连接。以后获取连接必须使用此方法。
	public static Connection getConnection(){
		//获取连接
		Connection conn = tl.get();
		if(conn == null){
			//从数据源中获取一个连接，绑定到线程局部变量上
			tl.set(DBCPUtil.getConnection());
		}
		return tl.get();
	}
	
	//3.开启事务
	public static void startTransaction(){
		//调用当前类中的获取连接方法
		Connection conn = getConnection();
		//开始事务的支持
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//4.提交事务
	public static void commit(){
		Connection conn = getConnection();
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//5.回滚事务
	public static void rollback(){
		Connection conn = getConnection();
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//6.释放资源
	public static void release(){
		Connection conn = getConnection();
		try {
			conn.close();//还回池中
			tl.remove();//把连接和当前线程解绑。在服务器中，线程也有线程池。我们用完的线程不是直接销毁，而是回到线程池中。
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
