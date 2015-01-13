package cn.liuning.javabean;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * @author liuning
 *
 */
public class CurrentRecord {
	/**
	 * 数据库唯一标标识
	 */
	private Integer id;
	/**
	 * 用户卡号
	 */
	private String usercard;
	/**
	 * 用户昵称
	 */
	private String nickname;
	/**
	 * 持续时间
	 */
	private String duratime;
	/**
	 * 开始时间
	 */
	private Date starttime;
	/**
	 * 主机号
	 */
	private String hostnumber;
	/**
	 * 当前消费
	 */
	private BigDecimal currentCost;
	/**
	 * 预计余额
	 */
	private BigDecimal expectBanlance;
	
	
	public CurrentRecord() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public CurrentRecord(Integer id, String usercard, String nickname,
			String duratime, Date starttime, String hostnumber,
			BigDecimal currentCost, BigDecimal expectBanlance) {
		super();
		this.id = id;
		this.usercard = usercard;
		this.nickname = nickname;
		this.duratime = duratime;
		this.starttime = starttime;
		this.hostnumber = hostnumber;
		this.currentCost = currentCost;
		this.expectBanlance = expectBanlance;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsercard() {
		return usercard;
	}
	public void setUsercard(String usercard) {
		this.usercard = usercard;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getDuratime() {
		return duratime;
	}
	public void setDuratime(String duratime) {
		this.duratime = duratime;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public String getHostnumber() {
		return hostnumber;
	}
	public void setHostnumber(String hostnumber) {
		this.hostnumber = hostnumber;
	}
	public BigDecimal getCurrentCost() {
		return currentCost;
	}
	public void setCurrentCost(BigDecimal currentCost) {
		this.currentCost = currentCost;
	}
	public BigDecimal getExpectBanlance() {
		return expectBanlance;
	}
	public void setExpectBanlance(BigDecimal expectBanlance) {
		this.expectBanlance = expectBanlance;
	}
	@Override
	public String toString() {
		return "CurrentRecord [id=" + id + ", usercard=" + usercard
				+ ", nickname=" + nickname + ", duratime=" + duratime
				+ ", starttime=" + starttime + ", hostnumber=" + hostnumber
				+ ", currentCost=" + currentCost + ", expectBanlance="
				+ expectBanlance + "]";
	}
	
}
