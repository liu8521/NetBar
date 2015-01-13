package cn.liuning.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 计数处理器 返回只有一个值的list
 * @author liuning
 *
 */
public class CountHandler implements ResultSetHandler{

	/**
	 * count(*)查询  查询单值的处理器  ----  计数处理器
 	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object handler(ResultSet rs) {
		try{
			List list = new ArrayList();
			while(rs.next()){
	
				ResultSetMetaData metadata = rs.getMetaData();
				int count = metadata.getColumnCount();
				for(int i=0;i<count;){
					long value = (Long) rs.getObject("count(*)");
					list.add(value);
					break;
				}
			}
			return list.size()>0?list:null;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
