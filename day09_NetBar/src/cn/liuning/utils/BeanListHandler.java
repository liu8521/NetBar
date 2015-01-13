package cn.liuning.utils;

import java.lang.reflect.Field;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;


/**
 * BeanListHandler
 * 
 * @author liuning
 *
 */
@SuppressWarnings("rawtypes")
public class BeanListHandler implements ResultSetHandler{
	
	private Class clazz;
	
	/**
	 * 构造函数 初始化Bean
	 * @param clazz
	 */
	public BeanListHandler(Class clazz){
		this.clazz=clazz;
	}
	
	/**
	 * BeanList处理器
	 */
	@SuppressWarnings("unchecked")
	public Object handler(ResultSet rs){
		try{
			List list = new ArrayList();
			
			while(rs.next()){
				Object bean = clazz.newInstance();
				ResultSetMetaData metadata = rs.getMetaData();
				int count = metadata.getColumnCount();
				for(int i=0;i<count;i++){
					String name = metadata.getColumnName(i+1);
					Object value = rs.getObject(name);
					
					//反射赋值
					Field f=bean.getClass().getDeclaredField(name);
					f.setAccessible(true);
					f.set(bean, value);
				}
				list.add(bean);
			}
			return list.size()>0?list:null;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
