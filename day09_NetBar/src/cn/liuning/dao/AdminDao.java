package cn.liuning.dao;

import java.util.List;

import cn.liuning.javabean.Admin;

public interface AdminDao {

	/**
	 * 更新计费方式
	 */
	public abstract boolean updateRate(String rate);

	/**
	 * 查询费率
	 */
	public abstract Admin findRate();

	/**
	 * 删除管理员
	 */

	public abstract boolean delete(String card);

	/**
	 * 增加管理员
	 */

	public abstract boolean addAdmin(Admin admin);

	/**
	 * 查询管理员在不在
	 */
	public abstract Admin findAdmin(String card);

	/**
	 * 返回所有管理员的信息
	 */
	public abstract List<Admin> findAllAdmin();

}