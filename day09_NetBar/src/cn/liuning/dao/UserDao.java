package cn.liuning.dao;

import java.util.List;

import cn.liuning.javabean.User;

public interface UserDao {

	/**
	 * 会员注册
	 */
	public abstract boolean addUser(User user);

	/**
	 * 根据卡号对会员信息进行修改
	 */
	public abstract boolean updateUser(User user, String card);

	/**
	 * 根据用户card号
	 * 更新用户状态-使用户变为Online
	 */
	public abstract boolean updateState_Online(String card);

	/**
	 * 根据用户card号
	 * 更新用户状态-使用户变为offline
	 */
	public abstract boolean updateState_Offline(String card);

	/**
	 * 根据用户的card号
	 * 对会员进行充值
	 */
	public abstract boolean recharge(double money, String card);

	/**
	 * 删除用户信息
	 */
	public abstract boolean delete(String card);

	/**
	 * 根据用户卡号，查询单个用户的信息
	 */
	public abstract User findUserOfUserCard(String card);

	/**
	 * 查询最高id的用户信息
	 */
	public abstract User findMaxidInfo();

	/**
	 * 查询所有用户的信息
	 */
	public abstract List<User> findAllUser();

	/**
	 * 查询身份证号为 idcard的用户信息
	 */
	public abstract User findUserOfIdcard(String idCard);

	/**
	 * 根据nickname查询用户的信息
	 */
	public abstract User findUserOfNickname(String nickname);

	/**
	 * 根据参数 state可查询所有在线或者离线用户的信息。
	 */
	public abstract List<User> findManyUserOfState(String state);

	/**
	 * 根据sex查询所有用户的信息
	 */
	public abstract List<User> findManyUserOfSex(String sex);

	/**
	 * 查询余额少于等于min的用户信息
	 * 要想查询余额为0的用户信息也可以使用这个查询
	 */
	public abstract List<User> findBleMin(float min);

	/**
	 * 查询余额大于等于max的用户信息
	 */
	public abstract List<User> findBgeMax(float max);

	/**
	 * 其他BeanList查询查询
	 */
	public abstract List<User> otherBcFind(String sql);

}