package cn.liuning.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * JdbcUtils_C3P0 模板
 * @author liuning
 *
 */
public class JdbcUtils_C3P0 {
	private static ComboPooledDataSource dataSource = null;
	
	/**
	 * 初始化数据库连接池
	 */
	static{
		try {
			//不指定的话会使用缺省的配置
			dataSource=new ComboPooledDataSource("liuning");
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/**
	 * 获取连接
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * 释放资源
	 */
	public static void release(Connection conn,Statement st,ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		if(st!=null){
			try{
				st.close();
			}catch (Exception e){
				e.printStackTrace();
			}
			
		}
		if(conn!=null){
			try{
				conn.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}	
	}
	
	/**
	 * 替换dao中的增删改方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public static boolean update(String sql,Object params[]){
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs= null;
		try{
			conn = getConnection();
			//预编译sql语句，里面有问号，需要用Object数据替换
			st = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				st.setObject(i+1, params[i]);
			}
			int count = st.executeUpdate();
			System.out.println("影响的记录数："+count);
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}finally{
			release(conn, st, rs);
		}
	}
	
	/**
	 * 替换dao中的增删改方法   ----- 自己释放资源,用在需要自己处理事务的数据库操作.
	 * @param sql
	 * @param params
	 * @return
	 */
	public static boolean update_acid(String sql,Object params[]){
		Connection conn = null;
		PreparedStatement st = null;
		try{
			conn = getConnection();
			st = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				st.setObject(i+1, params[i]);
			}
			st.executeUpdate();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	

	/**
	 * 替换所有dao中的查询 ,策略模式,不知道处理的策略,由用户传进来.
	 * ResultSetHandler 是一个接口,因此,用户自己写的处理器要实现这个接口.
	 * 可以实现写几个常用的Handler到用的时候直接使用
	 * @param sql
	 * @param params
	 * @param rsh
	 * @return
	 */
	public static Object query(String sql,Object params[], ResultSetHandler rsh){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs= null;
		try{
			conn = getConnection();
			st = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				st.setObject(i+1, params[i]);
			}
			rs = st.executeQuery();
			//不知道对结果集怎么处理，由用户决定怎么处理。约定用户类的写法，接口技术
			return rsh.handler(rs);

		}catch (Exception e){
			e.printStackTrace();
			return null;
		}finally{
			release(conn, st, rs);
		}
	}
}
