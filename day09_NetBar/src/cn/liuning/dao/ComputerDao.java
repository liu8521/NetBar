package cn.liuning.dao;

import java.util.List;

import cn.liuning.javabean.Computer;

public interface ComputerDao {

	/**
	 * 根据state查询空闲的主机号或正在使用的所有主机号
	 */
	public abstract List<String> findFreeHost(String state);

	/**
	 * 查询所有主机
	 */
	public abstract List<Computer> findAllHost();

	/**
	 * 根据用户上机时分配的主机号
	 * 修改主机状态 一般修改为 online
	 * 修改为offline使用deleteHostState
	 */
	public abstract boolean updateHostState(String usercard, String nicaname,
			String hostnumber, String state);

	/**
	 * 修改主机状态为offline
	 */
	public abstract boolean deleteHostState(String hostnumber, String state);

	/**
	 * 查询卡号为 usercard的用户正在使用的主机
	 */
	public abstract String findUserHost(String usercard);

	/**
	 * 其他查询
	 */
	public abstract List<Computer> otherBcFind(String sql);

}