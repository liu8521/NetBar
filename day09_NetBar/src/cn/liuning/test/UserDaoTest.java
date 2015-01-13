package cn.liuning.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.User;
import cn.liuning.utils.PublicUtils;

public class UserDaoTest {
	
	UserDao userDao = new UserDaoImpl();
	
	/**
	 * 增加用户
	 */
	@Test
	public void addUser(){
		User user = new User();
		user.setBanlace(new BigDecimal(15.322));
		user.setId(1);
		user.setLicenceNumber("37132419940307121X");
		user.setNickname("随风浪子baef");
		user.setPassword("123456");
		user.setPhoneNumber("18369905108");
		user.setUsercard("05010");
		user.setUserState("offline");
		user.setSex("男");
		user.setRegisterTime(new Date());
		System.out.println(userDao.addUser(user));
	}
	/**
	 * 根据用户卡号修改用户信息，需要先查询这个卡号的其他信息
	 * 
	 * 再写入修改的信息
	 */
	@Test
	public void updateUser(){
		User user = new User();
		user.setBanlace(new BigDecimal(15.0));
		user.setId(1);
		user.setLicenceNumber("37132419940307151X");
		user.setNickname("随风浪子aaa");
		user.setPassword("123456");
		user.setPhoneNumber("15853958849");
		user.setUsercard("121101");
		user.setUserState("offline");
		user.setSex("女");
		System.out.println(userDao.updateUser(user, "05009"));
	}
	
	/**
	 * 根据用户卡号更改用户状态
	 * 使用户状态变为Online
	 */
	@Test
	public void updateState_Online(){
		System.out.println(userDao.updateState_Online("05004"));
	}
	/**
	 * 根据用户卡号更改用户状态
	 * 使用户状态变为offline
	 */
	@Test
	public void updateState_Offline(){
		System.out.println(userDao.updateState_Offline("05003"));
	}
	
	/**
	 * 根据用户的card号
	 * 对会员进行充值
	 */
	@Test
	public void recharge(){
		System.out.println(userDao.recharge(15, "05002"));
	}
	
	/**
	 * 删除用户信息测试
	 */
	@Test
	public void delete(){
		System.out.println(userDao.delete("05001"));
	}
	
	/**
	 * 查询所有用户信息
	 */
	@Test
	public void findAllUser(){
		System.out.println(PublicUtils.outputListBeanInfo(userDao.findAllUser(), User.class));
	}
	
	/**
	 * 查询余额少于min的用户信息
	 */
	@Test
	public void findUser(){
		System.out.println(PublicUtils.outputListBeanInfo(userDao.findBleMin(20), User.class));
	}
	
	/**
	 *  查询用户存不存在
	 */
	@Test
	public void findSingleUser(){
		User user = userDao.findUserOfUserCard("050000");
		if(user==null){
			System.out.println("AAAAAAA");
		}else{
			System.out.println("BBBBBBB");
		}
	}
	
}








