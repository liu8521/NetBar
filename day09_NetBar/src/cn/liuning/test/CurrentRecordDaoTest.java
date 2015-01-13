package cn.liuning.test;


import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import cn.liuning.javabean.CurrentRecord;

public class CurrentRecordDaoTest {

	@Test
	public void testAddRecord() {
		CurrentRecord record = new CurrentRecord();
		record.setUsercard("05006");
		record.setNickname("Ñ§·¨Íø¶î");
		//record.setDuratime(new BigDecimal(0));
		record.setStarttime(new Date());
		record.setCurrentCost(new BigDecimal(0));
		record.setHostnumber("117");
		record.setExpectBanlance(new BigDecimal(12));
//		System.out.println(currentRecordDao.addRecord(record));
		
	}

	@Test
	public void testDeleteRecord() {
//		System.out.println(currentRecordDao.deleteRecord("05006"));
	}

	@Test
	public void testFindAllCurrentRecord() {
//		List<CurrentRecord> list = currentRecordDao.findAllCurrentRecord();
//		System.out.println(PublicUtils.outputListBeanInfo(list, CurrentRecord.class));
		
	}

	@Test
	public void testUpdateMoney() {
	}

	@Test
	public void testUpdateDuTime() {
	}

	@Test
	public void testGetstartTime() {
		
	}

}
