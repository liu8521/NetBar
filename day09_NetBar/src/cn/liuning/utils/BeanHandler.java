package cn.liuning.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 
 * Bean处理器
 * @author liuning
 *
 */
@SuppressWarnings("rawtypes")
public class BeanHandler implements ResultSetHandler{
	
	
	private Class clazz;
	
	/**
	 * 构造函数接收哪个Bean
	 * @param clazz
	 */
	public BeanHandler(Class clazz){
		this.clazz=clazz;
	}

	/**
	 * Bean处理器
	 */
	@Override
	public Object handler(ResultSet rs) {
		try {
				if(!rs.next())
				{
					return null;
				}
				
				//新建接收的Bean的示例,相当于New出一个Bean
				Object bean = clazz.newInstance();
				
				//获取元数据,则里面包含了,表名的信息
				ResultSetMetaData metadata = rs.getMetaData();
				//得到结果集中有几列数据
				int columnCount=metadata.getColumnCount();
				
				//循环得到每一列的列名,然后通过反射将rs的值赋给Bean的实例
				for(int i=0;i<columnCount;i++){
					//得到每一列的命名
					String columnName = metadata.getColumnName(i+1);
					//获得列的数据
					Object columnData = rs.getObject(i+1);
					//反射,给bean赋值. 对象的属性名称,要和表的命名一致
					Field f = clazz.getDeclaredField(columnName);
					//设置为允许赋值
					f.setAccessible(true);
					f.set(bean, columnData);
				}
				return bean;	
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}
	}
}
