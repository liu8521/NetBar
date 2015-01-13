package cn.liuning.dao;

import java.math.BigDecimal;
import java.util.List;

import cn.liuning.javabean.BackupRecord;

public interface BackupRecordDao {

	/**
	 * 用户下机需要将记录保存到备份表中
	 * 
	 */
	public abstract boolean insertIntoBaRecord(BackupRecord backupRecord);

	/**
	 * 得到所有历史记录信息
	 */
	public abstract List<BackupRecord> findAllBackupRecord();

	/*
	 * 查询用户usercard的历史记录
	 */
	public abstract List<BackupRecord> findUserBackupRecord(String usercard);

	/**
	 * 查询昵称为nickname的的历史记录
	 */
	public abstract List<BackupRecord> findNickBackupRecord(String nickname);

	/**
	 * 查询消费金额大于max的用户信息
	 */
	public abstract List<BackupRecord> findConsumeGeMax(BigDecimal max);

	/**
	 * 查询消费金额小于min的用户信息
	 */
	public abstract List<BackupRecord> findConsumeLeMin(BigDecimal min);

	/**
	 * 查询消费金额等于x的用户信息
	 */
	public abstract List<BackupRecord> findConsumeEqMin(BigDecimal x);

	/**
	 * 查持续时间大于max的信息
	 */
	public abstract List<BackupRecord> findDuraTimeGeMax(BigDecimal max);

	/**
	 * 查持续时间小于等于min的信息
	 */
	public abstract List<BackupRecord> findDuraTimeLeMin(BigDecimal min);

	/**
	 * 查持续时间介于两者之间的查询。
	 */
	public abstract List<BackupRecord> findOfGeLeDuraTime(BigDecimal min,
			BigDecimal max);

	/**
	 * 查询某个月的上网人数  用在年份统计上
	 */
	public abstract List<Long> findCountOfYear(String year);

	/**
	 * 查询某个月的收入
	 */
	public abstract List<BigDecimal> findIncomeOfYear(String year);

	/**
	 * countOnlinePersonInAday
	 * @param dateTime
	 * @return
	 */
	public abstract Integer countOnlinePersonInAday(String dateTime);

	/**
	 * 查询某一天的收入
	 */
	public abstract BigDecimal countConsumeInAday(String dateTime);

	/**
	 * 
	 * @param dateTime
	 * @return
	 */
	public abstract Integer getstartTime(String dateTime);

	/**
	 * 其他 返回BeanList的查询
	 */
	public abstract List<BackupRecord> otherBcFind(String sql);

}