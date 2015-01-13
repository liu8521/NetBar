package cn.liuning.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 单值处理器
 * @author liuning
 *
 */
public class SingleValueHanler implements ResultSetHandler{

	/**
	 * 单值处理器,指查出的值只有一个Bean
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object handler(ResultSet rs) {
		try{
			
			List list = new ArrayList();
			while(rs.next()){
				ResultSetMetaData metadata = rs.getMetaData();
				int count = metadata.getColumnCount();
				for(int i=0;i<count;){
					String name = metadata.getColumnName(i+1);
					Object value = rs.getObject(name);
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
