package cn.liuning.dao.impl;

import java.util.Date;
import java.util.List;

import cn.liuning.dao.CurrentRecordDao;
import cn.liuning.javabean.CurrentRecord;
import cn.liuning.javabean.struct.UpdateTime;
import cn.liuning.utils.BeanHandler;
import cn.liuning.utils.BeanListHandler;
import cn.liuning.utils.JdbcUtils_C3P0;
import cn.liuning.utils.SingleValueHanler;

/**
 * 实时记录表的数据库修改类
 *  addRecord
 *	findRecordOfUserCard
 *	deleteRecord
 *	and ....
 * @author liuning
 *
 */
public class CurrentRecordDaoImpl implements CurrentRecordDao {
	
	/**
	 * 有用户上机，那么记录表需要添加数据
	 */
	@Override
	public boolean addRecord(CurrentRecord record){
		String sql="insert into ln_currentrecord" +
				"(usercard,nickname,duratime,starttime," +
				"currentCost,hostnumber,expectBanlance) values(?,?,?,?,?,?,?)";
		Object parames[]={
				record.getUsercard(),
				record.getNickname(),
				record.getDuratime(),
				record.getStarttime(),
				record.getCurrentCost(),
				record.getHostnumber(),
				record.getExpectBanlance()
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * 根据用户卡号查询记录信息
	 */
	@Override
	public CurrentRecord findRecordOfUserCard(String card){
		String sql = "select * from ln_currentrecord where usercard=?";
		Object params[]={card};
		return (CurrentRecord) JdbcUtils_C3P0.query(sql, params, new BeanHandler(CurrentRecord.class));
	}
	
	/**
	 * 根据主机号查询用户上机信息
	 */
	@Override
	public CurrentRecord findRecordOfHost(String host){
		String sql = "select * from ln_currentrecord where hostnumber=?";
		Object params[]={host};
		return (CurrentRecord) JdbcUtils_C3P0.query(sql, params, new BeanHandler(CurrentRecord.class));
	}
	
	/**
	 * 用户下机，记录表会删除数据
	 */
	@Override
	public boolean deleteRecord(String usercard){
		String sql="delete from ln_currentrecord where usercard=?";
		Object params[]={usercard};
		return JdbcUtils_C3P0.update(sql, params);
	}
	
	/**
	 * 得到实时记录的信息(即所有用户上机的信息)
	 * @return List<CurrentRecord>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CurrentRecord> findAllCurrentRecord(){
		String sql = "select * from ln_currentrecord";
		Object params[]={};
		return (List<CurrentRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(CurrentRecord.class));
	}
	
	/**
	 * 更新数据库保存的 用户余额和用户消费.
	 * @param money
	 * @return
	 */
	@Override
	public boolean updateAllUserMoney(String money){
		String sql1 = "update ln_currentrecord set currentCost=currentCost+?";
		Object params1[]={money};
		JdbcUtils_C3P0.update(sql1, params1);
		String sql = "update ln_currentrecord set expectBanlance=expectBanlance-?";
		Object params[]={money};
		return JdbcUtils_C3P0.update(sql, params);
	}
	
	/**
	 * 更新持续时间
	 */
	@Override
	public boolean updateDuTime(String money){

		List<UpdateTime> list = findAllOnlineUser();
		for(int i=0;i<list.size();i++){
			UpdateTime up = (UpdateTime)list.get(i);
			String str = up.getDuratime();
			String hour = str.split(":")[0];
			String minute = str.split(":")[1];
			String second = str.split(":")[2];
			
			int hour_i = Integer.parseInt(hour);
			int minute_i = Integer.parseInt(minute);
			int second_i = Integer.parseInt(second);
			String strTime = getDuraTime(second_i+6,minute_i,hour_i);
			
			String sql = "update ln_currentrecord set duratime=? where usercard=?";
			Object params[]={strTime,up.getUsercard()};
			JdbcUtils_C3P0.update(sql, params);
			
			String sql2 = "update ln_user set banlace=banlace-? where usercard=?";
			Object params2[]={money,up.getUsercard()};
			JdbcUtils_C3P0.update(sql2, params2);
		}
		return true;
	}
	/**
	 * 工具函数 组装时间
	 */
	private String getDuraTime(int x, int y, int z) {
		if(x>=60){
    		y=y+1;
    		x=x%60;
    	}
    	if(y>=60){
    		z=z+1;
    		y=y%60;
    	}
    	String str = "";
    	if(z<10){
    		str=str+"0"+String.valueOf(z);
    	}else{
    		str += String.valueOf(z);
    	}
    	str+=":";
    	if(y<10){
    		str=str+"0"+String.valueOf(y);
    	}else{
    		str += String.valueOf(y);
    	}
    	str+=":";
    	if(x<10){
    		str=str+"0"+String.valueOf(x);
    	}else{
    		str += String.valueOf(x);
    	}
    	return str;
	}

	/**
	 * 查询在线的所有用户的  用户号  和 duratime 号
	 * 用于系统更新时间
	 */
	@SuppressWarnings("unchecked")
	private List<UpdateTime> findAllOnlineUser(){
		String sql = "select usercard,duratime from ln_currentrecord";
		Object params[]={};
		return (List<UpdateTime>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(UpdateTime.class));
	}
	
	
	
	//其他查询......................................
	
	/**
	 * 得到开始时间
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Date getstartTime(String usercard){
		String sql="select starttime from ln_currentrecord where usercard=?";
		Object params[]={usercard};
		List<Date> list = (List<Date>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0);
	}
	
	/**
	 * 其他BeanList查询查询
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CurrentRecord> otherBcFind(String sql){
		Object params[]={};
		return (List<CurrentRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(CurrentRecord.class));
	}
	
}









