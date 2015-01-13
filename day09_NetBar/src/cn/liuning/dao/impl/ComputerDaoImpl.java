package cn.liuning.dao.impl;

import java.util.List;

import cn.liuning.dao.ComputerDao;
import cn.liuning.javabean.Computer;
import cn.liuning.utils.BeanListHandler;
import cn.liuning.utils.JdbcUtils_C3P0;
import cn.liuning.utils.SingleValueHanler;


/**
 * 主机表的数据库操作类
 * 
 * @author liuning
 *
 */
public class ComputerDaoImpl implements ComputerDao{

	/**
	 * 根据state查询空闲的主机号或正在使用的所有主机号
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> findFreeHost(String state){
		String sql = "select hostnumber from ln_computer where state=?";
		Object params[]={state};
		return (List<String>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
	}
	
	/**
	 * 查询所有主机
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Computer> findAllHost(){
		String sql = "select * from ln_computer";
		Object params[]={};
		return (List<Computer>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(Computer.class));
	}
	
	
	/**
	 * 根据用户上机时分配的主机号
	 * 修改主机状态 一般修改为 online
	 * 修改为offline使用deleteHostState
	 */
	@Override
	public boolean updateHostState(String usercard,String nicaname,String hostnumber,String state){
		String sql = "update ln_computer set nickname=?,usercard=?,state=? where hostnumber=?";
		Object params[]={
				nicaname,usercard,state,hostnumber
		};
		return JdbcUtils_C3P0.update(sql, params);
	}
	
	/**
	 * 修改主机状态为offline
	 */
	@Override
	public boolean deleteHostState(String hostnumber,String state){
		String sql = "update ln_computer set nickname=?,usercard=?,state=? where hostnumber=?";
		Object params[]={
				null,null,state,hostnumber
		};
		return JdbcUtils_C3P0.update(sql, params);
	}
	
	/**
	 * 查询卡号为 usercard的用户正在使用的主机
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String findUserHost(String usercard){
		String sql = "select hostnumber from ln_computer where usercard=?";
		Object params[]={usercard};
		List<String> list = (List<String>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0).toString();
	}
	
	/**
	 * 其他查询
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Computer> otherBcFind(String sql){
		Object params[]={};
		return (List<Computer>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(Computer.class));
	}
	
}
