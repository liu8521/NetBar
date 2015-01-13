package cn.liuning.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import Decoder.BASE64Encoder;


/**
 * 共用工具类 
 * 1.得到MD5加密的值
 * 2.InputStream-2-String
 * 3.通用的list bean元素输出方法
 * 4.得到随机密码
 * 5.在传过来的 List 集合当中随机选一个数返回
 * @author liuning
 *
 */
public class PublicUtils {
	
	/**
	 * 得到MD5加密的值
	 */
	public static String getMD5(String message){
			
		try {
			
			MessageDigest md=MessageDigest.getInstance("md5");
			byte md5[] = md.digest(message.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			//返回一个明文字符串
			return encoder.encode(md5);
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * InputStream-2-String
	 * 由字节数组new string的时候使用str指定的编码new
	 * @param in
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String inputStreamtoString(InputStream in,String str) throws Exception{
		
		byte[] buffer = new byte[1024];
		int len = -1;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while((len = in.read(buffer)) != -1){
			baos.write(buffer, 0, len);
		}
		baos.close();
		in.close();
		byte[] lens = baos.toByteArray();
		return new String(lens,str);
	}
	
	/**
	 * 通用的list bean元素输出方法
	 * @param list
	 * @param clazz
	 * @return String
	 */
	@SuppressWarnings("rawtypes")
	public static String outputListBeanInfo(List list,Class clazz){
		try {
			Object bean = clazz.newInstance();
			String result="[";
			for(int i=0;i<list.size();i++){
				bean = list.get(i);
				result+=bean.toString();
				if(i<list.size()-1){
					result+=",";
				}
			}
			result+="]";
			return result;
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 在传过来的 List 集合当中随机选一个数返回
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getRandomHost(List list){
		
		int index=list.size();
		Random ran = new Random();
		int i = (ran.nextInt()%index)%index;
		return (String) list.get(i);
	}
	
	/**
	 * 用户注册的时候，得到随机密码
	 * @return String
	 */
	public static String getSecret(){
		String[] array = {"a","b","c","d","e","f","g",
				"j","h","i","k","m","n","p","q","r",
				"s","t","u","v","w","x","y","z","1","2","3",
				"4","5","6","7","8","9","A","C","B","D","E",
				"F","G","H","J","K",
				"L","M","N","P","Q","R","S","T","U","V","W",
				"X","Y","Z"};
		int i=0;
		String str="";
		while(i<6){
			Random ran = new Random();
			int temp = ran.nextInt();
			int sum = array.length;
			int index = (temp%sum+sum)%sum;
			str+=array[index];
			i++;
		}
		return str;
	}
	
	/**
	 * 时间加1秒返回
	 * @param times
	 * @return String
	 */
	public String getTimesAddoneSecond(String times){
		int seconds,minute,hour;
		hour = Integer.parseInt(times.split(":")[0]);
		minute = Integer.parseInt(times.split(":")[1]);
		seconds = Integer.parseInt(times.split(":")[2]);
		if(seconds>=60){
			minute=minute+1;
			seconds=seconds%60;
    	}
    	if(minute>=60){
    		hour=hour+1;
    		minute=minute%60;
    	}
    	String str = "";
    	if(hour<10){
    		str=str+"0"+String.valueOf(hour);
    	}else{
    		str += String.valueOf(hour);
    	}
    	str+=":";
    	if(minute<10){
    		str=str+"0"+String.valueOf(minute);
    	}else{
    		str += String.valueOf(minute);
    	}
    	str+=":";
    	if(seconds<10){
    		str=str+"0"+String.valueOf(seconds);
    	}else{
    		str += String.valueOf(seconds);
    	}
	    	return str;
	}
	
	public String string2Date(Calendar calendar) {
		
		// HH 表示24小时制， hh 表示12小时制
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sf.format(calendar.getTime());
	
        return time;
	}
}





