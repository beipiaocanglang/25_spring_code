package frame.study.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import frame.study.utils.DBCPUtil;

/**
 * 抽取的一个类
 * @author zhy
 *
 */
public class JdbcDaoSupport {
	
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	
	public int update(String sql,Object...params){
		try{
			return qr.update(sql,params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public <T> T query(String sql,ResultSetHandler<T> rsh,Object...params){
		try{
			return qr.query(sql,rsh,params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
