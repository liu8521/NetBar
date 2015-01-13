package cn.liuning.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cn.liuning.dao.BackupRecordDao;
import cn.liuning.javabean.BackupRecord;
import cn.liuning.utils.BeanListHandler;
import cn.liuning.utils.CountHandler;
import cn.liuning.utils.JdbcUtils_C3P0;
import cn.liuning.utils.SingleValueHanler;


/**
 * 历史记录表的操作类
 * 
 * 此类用于查询历史记录，配合系统进行统计报表功能。
 * @author liuning
 *
 */
public class BackupRecordDaoImpl implements BackupRecordDao{
	
	/**
	 * 用户下机需要将记录保存到备份表中
	 * 
	 */
	@Override
	public boolean insertIntoBaRecord(BackupRecord backupRecord){
		String sql="insert into ln_backuprecord" +
				"(year,month,day,usercard,nickname,consume," +
				"startTime,duraTime,overTime,hostNumber) values(?,?,?,?,?,?,?,?,?,?)";
		Object parames[]={
				backupRecord.getYear(),
				backupRecord.getDay(),
				backupRecord.getMonth(),
				backupRecord.getUsercard(),
				backupRecord.getNickname(),
				backupRecord.getConsume(),
				backupRecord.getStartTime(),
				backupRecord.getDuraTime(),
				backupRecord.getOverTime(),
				backupRecord.getHostnumber()
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * 得到所有历史记录信息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findAllBackupRecord(){
		String sql = "select * from ln_backuprecord";
		Object params[]={};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * 查询用户usercard的历史记录
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findUserBackupRecord(String usercard){
		String sql = "select * from ln_backuprecord where usercard=?";
		Object params[]={usercard};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * 查询昵称为nickname的的历史记录
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findNickBackupRecord(String nickname){
		String sql = "select * from ln_backuprecord where nickname=?";
		Object params[]={nickname};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * 查询消费金额大于max的用户信息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findConsumeGeMax(BigDecimal max){
		String sql = "select * from ln_backuprecord where consume>=?";
		Object params[]={max};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * 查询消费金额小于min的用户信息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findConsumeLeMin(BigDecimal min){
		String sql = "select * from ln_backuprecord where consume<=?";
		Object params[]={min};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * 查询消费金额等于x的用户信息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findConsumeEqMin(BigDecimal x){
		String sql = "select * from ln_backuprecord where consume=?";
		Object params[]={x};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * 查持续时间大于max的信息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findDuraTimeGeMax(BigDecimal max){
		String sql = "select * from ln_backuprecord where duraTime>=?";
		Object params[]={max};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * 查持续时间小于等于min的信息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findDuraTimeLeMin(BigDecimal min){
		String sql = "select * from ln_backuprecord where duraTime<=?";
		Object params[]={min};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * 查持续时间介于两者之间的查询。
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findOfGeLeDuraTime(BigDecimal min,BigDecimal max){
		String sql = "select * from ln_backuprecord where duraTime>=? and duraime<=?";
		Object params[]={max,min};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}

	/**
	 * 查询某个月的上网人数  用在年份统计上
	 */
	@Override
	public List<Long> findCountOfYear(String year){
		
		List<Long> list = new ArrayList<Long>();
		for(int i=1;i<=12;i++){
			String str = "";
			if(i<10){
				str+="0";
				str=str+String.valueOf(i);
			}else{
				str=String.valueOf(i);
			}
			long aa = findCount_Year(str,year);
			list.add(aa);
		}
		return list;
	}
	
	/**
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Long findCount_Year(String month,String year){
		String sql="select count(*) from ln_backuprecord where month=? and year=?";
		Object params[]={month,year};
		List list = (List) JdbcUtils_C3P0.query(sql, params, new CountHandler());
		return (Long) list.get(0);
	}
	
	/**
	 * 查询某个月的收入
	 */
	@Override
	public List<BigDecimal> findIncomeOfYear(String year){
		
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		for(int i=1;i<=12;i++){
			String str = "";
			if(i<10){
				str+="0";
				str=str+String.valueOf(i);
			}else{
				str=String.valueOf(i);
			}
			BigDecimal aa = findIncome_Year(str,year);
			if(aa == null){
				list.add(new BigDecimal(0));
			}else{
				list.add(aa);
			}
		}
		return list;
	}
	
	/**
	 * findIncome_Year
	 * @param month
	 * @param year
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private BigDecimal findIncome_Year(String month,String year){
		String sql="select sum(consume) from ln_backuprecord where month=? and year=?";
		Object params[]={month,year};
		List<BigDecimal> list = (List<BigDecimal>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0);
	}
	
	/**
	 * countOnlinePersonInAday
	 * @param dateTime
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Integer countOnlinePersonInAday(String dateTime){
		String sql="select * from ln_backuprecord where dateTime=?";
		Object params[]={dateTime};
		List<Integer> list = (List<Integer>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0);
	}
	
	/**
	 * 查询某一天的收入
	 */
	@Override
	@SuppressWarnings("unchecked")
	public BigDecimal countConsumeInAday(String dateTime){
		String sql="select count(consume) from ln_backuprecord where dateTime=?";
		Object params[]={dateTime};
		List<BigDecimal> list = (List<BigDecimal>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0);
	}
	
	/**
	 * 
	 * @param dateTime
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Integer getstartTime(String dateTime){
		String sql="select count(*) from ln_backuprecord where dateTime=?";
		Object params[]={dateTime};
		List<Integer> list = (List<Integer>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0);
	}
	
	/**
	 * 其他 返回BeanList的查询
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> otherBcFind(String sql){
		Object params[]={};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	
}









