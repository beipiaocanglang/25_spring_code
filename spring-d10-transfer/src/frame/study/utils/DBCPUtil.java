package frame.study.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * DBCP的工具类
 * @author zhy
 *
 */
public class DBCPUtil {

	//创建一个数据源
	private static DataSource ds;
	
	//通过读取配置文件，给数据源
	static{
		InputStream in = null;
		try {
			Properties prop = new Properties();
			in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			prop.load(in);
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("��ʼ������ʧ�ܣ�");
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	//获取数据源
	public static DataSource getDataSource(){
		return ds;
	}
	
	
	//从数据源中获取一个连接
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
