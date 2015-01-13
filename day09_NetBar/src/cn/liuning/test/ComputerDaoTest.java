package cn.liuning.test;

import java.util.List;

import org.junit.Test;

import cn.liuning.dao.ComputerDao;
import cn.liuning.dao.impl.ComputerDaoImpl;
import cn.liuning.utils.PublicUtils;

public class ComputerDaoTest {
	
	ComputerDao conputerDao = new ComputerDaoImpl();
	@Test
	public void findFreeHost(){
		List<String> list = conputerDao.findFreeHost("offline");
		String str = PublicUtils.outputListBeanInfo(list, String.class);
		System.out.println(str);
	}
	
	@Test
	public void updateHostState(){
		boolean leag = conputerDao.updateHostState("05009", "Ëæ·çÀË×Ó", "101", "online");
		System.out.println(leag);
	}
	
	@Test
	public void deleteHostState(){
		boolean leag = conputerDao.deleteHostState("101", "offline");
		System.out.println(leag);
	}
	
	@Test
	public void findUserHost(){
		String aaa = conputerDao.findUserHost("05007");
		System.out.println(aaa);
	}
}





