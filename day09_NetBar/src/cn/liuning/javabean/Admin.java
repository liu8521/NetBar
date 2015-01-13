package cn.liuning.javabean;

/**
 * 
 * 管理员实体：
 * @author liuning
 *
 */
public class Admin {
	/**
	 * 数据库唯一标示
	 */
	private Integer id;
	
	/**
	 * 管理员卡号
	 */
	private String admincard;
	/**
	 * 管理员密码
	 */
	private String adminpass;
	
	/**
	 * 管理员状态 lock锁着  unlock未锁住
	 */
	private String state;
	
	/**
	 * 费率
	 */
	private String rate;
	
	public Admin() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Admin(Integer id, String admincard, String adminpass, String state,
			String rate) {
		super();
		this.id = id;
		this.admincard = admincard;
		this.adminpass = adminpass;
		this.state = state;
		this.rate = rate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdmincard() {
		return admincard;
	}
	public void setAdmincard(String admincard) {
		this.admincard = admincard;
	}
	public String getAdminpass() {
		return adminpass;
	}
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", admincard=" + admincard + ", adminpass="
				+ adminpass + ", state=" + state + ", rate=" + rate + "]";
	}
	
	
	
	
}
