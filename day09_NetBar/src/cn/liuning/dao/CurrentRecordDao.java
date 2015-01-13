package cn.liuning.dao;

import java.util.Date;
import java.util.List;

import cn.liuning.javabean.CurrentRecord;

public interface CurrentRecordDao {

	/**
	 * 有用户上机，那么记录表需要添加数据
	 */
	public abstract boolean addRecord(CurrentRecord record);

	/**
	 * 根据用户卡号查询记录信息
	 */
	public abstract CurrentRecord findRecordOfUserCard(String card);

	/**
	 * 根据主机号查询用户上机信息
	 */
	public abstract CurrentRecord findRecordOfHost(String host);

	/**
	 * 用户下机，记录表会删除数据
	 */
	public abstract boolean deleteRecord(String usercard);

	/**
	 * 得到实时记录的信息(即所有用户上机的信息)
	 * @return List<CurrentRecord>
	 */
	public abstract List<CurrentRecord> findAllCurrentRecord();

	/**
	 * 更新数据库保存的 用户余额和用户消费.
	 * @param money
	 * @return
	 */
	public abstract boolean updateAllUserMoney(String money);

	/**
	 * 更新持续时间
	 */
	public abstract boolean updateDuTime(String money);

	/**
	 * 得到开始时间
	 */
	public abstract Date getstartTime(String usercard);

	/**
	 * 其他BeanList查询查询
	 */
	public abstract List<CurrentRecord> otherBcFind(String sql);

}