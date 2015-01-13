package cn.liuning.dao.impl;

import java.util.List;

import cn.liuning.dao.AdminDao;
import cn.liuning.javabean.Admin;
import cn.liuning.utils.BeanHandler;
import cn.liuning.utils.BeanListHandler;
import cn.liuning.utils.JdbcUtils_C3P0;

public class AdminDaoImpl implements AdminDao {
	
	/* （非 Javadoc）
	 * @see cn.liuning.dao.impl.AdminDao#updateRate(java.lang.String)
	 */
	@Override
	public boolean updateRate(String rate){
		String sql = "update ln_admin set rate=? where admincard=?";
		Object parames[]={
				rate,
				"admin"
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	

	@Override
	public Admin findRate(){
		String sql = "select * from ln_admin where admincard=?";
		Object params[]={"admin"};
		return (Admin) JdbcUtils_C3P0.query(sql, params, new BeanHandler(Admin.class));
	}
	

	
	@Override
	public boolean delete(String card){
		String sql = "delete from ln_admin where admincard=?";
		Object params[]={card};
		return JdbcUtils_C3P0.update(sql, params);
	}
	
	
	/* （非 Javadoc）
	 * @see cn.liuning.dao.impl.AdminDao#addAdmin(cn.liuning.javabean.Admin)
	 */
	
	@Override
	public boolean addAdmin(Admin admin){
		String sql = "insert into ln_admin" +
				"(admincard,adminpass,state,rate) values(?,?,?,?)";
		Object parames[]={
				admin.getAdmincard(),
				admin.getAdminpass(),
				admin.getState(),
				admin.getRate()
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	/* （非 Javadoc）
	 * @see cn.liuning.dao.impl.AdminDao#findAdmin(java.lang.String)
	 */
	@Override
	public Admin findAdmin(String card){
		String sql = "select * from ln_admin where admincard=?";
		Object params[]={card};
		return (Admin) JdbcUtils_C3P0.query(sql, params, new BeanHandler(Admin.class));
	}
	
	/* （非 Javadoc）
	 * @see cn.liuning.dao.impl.AdminDao#findAllAdmin()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Admin> findAllAdmin(){
		String sql = "select * from ln_admin";
		Object params[]={};
		return (List<Admin>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(Admin.class));
	}
}
