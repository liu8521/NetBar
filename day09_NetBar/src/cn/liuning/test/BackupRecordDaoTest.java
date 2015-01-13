package cn.liuning.test;

import static org.junit.Assert.fail;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import org.junit.Test;

import cn.liuning.dao.BackupRecordDao;
import cn.liuning.dao.impl.BackupRecordDaoImpl;
import cn.liuning.javabean.BackupRecord;

public class BackupRecordDaoTest {

	BackupRecordDao backupaaa = new BackupRecordDaoImpl();
	@SuppressWarnings("unused")
	@Test
	public void testInsertIntoBaRecord() {
		BackupRecord backup = new BackupRecord();
		
		
		String select[] = {"01","03","05","07","09","11","14",
				"16","18","20","21","22"};
		String duratime[]={"01:00","02:00"};
		String user[] = {
				"05001","05002","05003","05004","05005",
				"05006","05007","05008","05009","05010",
				"05011","05012","05013","05014","05015"
		};
		String host[]={
				"001","011","016","023","030",
				"002","012","017","024",
				"003","013","018","025",
				"004","014","019","026",
				"005","015","020","027",
				"006","009","021","028",
				"007","008","022","029"
		};
		
		for(int i=0;i<200;i++){
			String str = "2014-";
			Random random = new Random();
			Random random1 = new Random();
			Random random2 = new Random();
			Random random3 = new Random();
			int x =((random.nextInt())%13+13)%12;
			int y =((random1.nextInt())%29+29)%29;
			
			//时间
			String z = select[x];
			
			String du = duratime[x%2];
			BigDecimal aaa =null;
			if(x%2 == 1){
				aaa=new BigDecimal(1.8);
			}else{
				aaa=new BigDecimal(3.6);
			}
			if(x<9){
				x=x+1;
				str=str+"0";
				System.out.println("****"+String.valueOf(x));
			}
			str+=String.valueOf(x);
			str+="-";
			if(y<9){
				y=y+1;
				str=str+"0";
			}
			str+=String.valueOf(y);
			
			int zzz =((random2.nextInt())%15+29)%15;
		
			String dateTime = str;
			String usercard = user[zzz];
			String nickname = user[zzz];
			BigDecimal consume = aaa;
			String startTime = str+" "+z+"-"+"00"+"-00";
			String duraTime = du;
			
			char a = du.toCharArray()[1];
			String aa = String.valueOf(a);
			int b = Integer.valueOf(aa);
			int c = Integer.valueOf(z);
			int d = b+c;
			String e;
			if(d<10){
				e="0"+String.valueOf(d);
			}else{
				e=String.valueOf(d);
			}		
			backupaaa.insertIntoBaRecord(backup);
		}
		
		
	}

	
	@Test
	public void test() {
		
		List<BigDecimal> list = backupaaa.findIncomeOfYear("2014");
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	@Test
	public void testFindAllBackupRecord() {
		fail("尚未实现");
	}

	@Test
	public void testFindUserBackupRecord() {
		fail("尚未实现");
	}

	@Test
	public void testFindNickBackupRecord() {
		fail("尚未实现");
	}

	@Test
	public void testFindConsumeGeMax() {
		fail("尚未实现");
	}

	@Test
	public void testFindConsumeLeMin() {
		fail("尚未实现");
	}

	@Test
	public void testFindConsumeEqMin() {
		fail("尚未实现");
	}

	@Test
	public void testFindDuraTimeGeMax() {
		fail("尚未实现");
	}

	@Test
	public void testFindDuraTimeLeMin() {
		fail("尚未实现");
	}

	@Test
	public void testFindOfGeLeDuraTime() {
		fail("尚未实现");
	}

	@Test
	public void testCountOnlinePersonInAday() {
		fail("尚未实现");
	}

	@Test
	public void testCountConsumeInAday() {
		fail("尚未实现");
	}

	@Test
	public void testGetstartTime() {
		fail("尚未实现");
	}

	@Test
	public void testOtherBcFind() {
		fail("尚未实现");
	}

}
