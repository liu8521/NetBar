package cn.liuning.utils;

import java.sql.ResultSet;

/**
 * 结果集处理接口
 * @author liuning
 *
 */
public interface ResultSetHandler {
	public Object handler(ResultSet rs);
}
