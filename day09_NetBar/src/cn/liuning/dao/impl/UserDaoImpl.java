package cn.liuning.dao.impl;

import java.util.List;

import cn.liuning.dao.UserDao;
import cn.liuning.javabean.User;
import cn.liuning.utils.BeanHandler;
import cn.liuning.utils.BeanListHandler;
import cn.liuning.utils.JdbcUtils_C3P0;


/**
 * 用户表的修改类
 * 包括用户信息的增删改查
 * @author liuning
 *
 */
public class UserDaoImpl implements UserDao {
	
	/**
	 * 会员注册
	 */
	@Override
	public boolean addUser(User user){
		String sql = "insert into ln_user" +
				"(usercard,password,banlace,licenceNumber," +
				"sex,nickname,phoneNumber,userState,registerTime)" +
				" values(?,?,?,?,?,?,?,?,?)";
		Object parames[]={
				user.getUsercard(),
				user.getPassword(),
				user.getBanlace(),
				user.getLicenceNumber(),
				user.getSex(),
				user.getNickname(),
				user.getPhoneNumber(),
				user.getUserState(),
				user.getRegisterTime()
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * 根据卡号对会员信息进行修改
	 */
	@Override
	public boolean updateUser(User user,String card){
		String sql = "update ln_user set sex=?,nickname=?,phoneNumber=?,password=?,banlace=? where usercard=?";
		Object parames[]={
				user.getSex(),
				user.getNickname(),
				user.getPhoneNumber(),
				user.getPassword(),
				user.getBanlace(),
				card
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * 根据用户card号
	 * 更新用户状态-使用户变为Online
	 */
	@Override
	public boolean updateState_Online(String card){
		String sql = "update ln_user set userState=? where usercard=?";
		Object parames[]={
				"online",card
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * 根据用户card号
	 * 更新用户状态-使用户变为offline
	 */
	@Override
	public boolean updateState_Offline(String card){
		String sql = "update ln_user set userState=? where usercard=?";
		Object parames[]={
				"offline",card
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * 根据用户的card号
	 * 对会员进行充值
	 */
	@Override
	public boolean recharge(double money,String card){
		String sql = "update ln_user set banlace=banlace+? where usercard=?";
		Object parames[]={
				money,card
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * 删除用户信息
	 */
	@Override
	public boolean delete(String card){
		System.out.println("******");
		String sql = "delete from ln_user where usercard=?";
		Object params[]={card};
		return JdbcUtils_C3P0.update(sql, params);
	}
	
	/**
	 * 根据用户卡号，查询单个用户的信息
	 */
	@Override
	public User findUserOfUserCard(String card){
		String sql = "select * from ln_user where usercard=?";
		Object params[]={card};
		return (User) JdbcUtils_C3P0.query(sql, params, new BeanHandler(User.class));
	}
	
	/**
	 * 查询最高id的用户信息
	 */
	@Override
	public User findMaxidInfo(){
		String sql = "select * from ln_user where id=(select max(id) from ln_user)";
		Object params[]={};
		return (User) JdbcUtils_C3P0.query(sql, params, new BeanHandler(User.class));
	}
	
	/**
	 * 查询所有用户的信息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAllUser(){
		String sql = "select * from ln_user";
		Object params[]={};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
	
	
	
	//其他可能的查询.......................................................
	
	/**
	 * 查询身份证号为 idcard的用户信息
	 */
	@Override
	public User findUserOfIdcard(String idCard){
		String sql = "select * from ln_user where licenceNumber=?";
		Object params[]={idCard};
		return (User) JdbcUtils_C3P0.query(sql, params, new BeanHandler(User.class));
	}
	
	/**
	 * 根据nickname查询用户的信息
	 */
	@Override
	public User findUserOfNickname(String nickname){
		String sql = "select * from ln_user where nickname=?";
		Object params[]={nickname};
		return (User) JdbcUtils_C3P0.query(sql, params, new BeanHandler(User.class));
	}
	
	/**
	 * 根据参数 state可查询所有在线或者离线用户的信息。
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findManyUserOfState(String state){
		String sql = "select * from ln_user where userState=?";
		Object params[]={state};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
	
	/**
	 * 根据sex查询所有用户的信息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findManyUserOfSex(String sex){
		String sql = "select * from ln_user where sex=?";
		Object params[]={sex};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
	
	/**
	 * 查询余额少于等于min的用户信息
	 * 要想查询余额为0的用户信息也可以使用这个查询
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findBleMin(float min){
		String sql = "select * from ln_user where banlace <=?";
		Object params[]={min};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
	
	/**
	 * 查询余额大于等于max的用户信息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findBgeMax(float max){
		String sql = "select * from ln_user where banlace >=?";
		Object params[]={max};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
	
	/**
	 * 其他BeanList查询查询
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> otherBcFind(String sql){
		Object params[]={};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
}











