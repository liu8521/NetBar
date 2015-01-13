package cn.liuning.javabean;

/**
 * id：数据库用户唯一标示
 * hostNnumber：主机号（100-150）
 * nickname：用户昵称（正在使用的用户，没有用户使用则为no）
 * usercard：用户卡号（正在使用的用户卡号，没分配则为no）
 * state：状态标识位
 * @author liuning
 *
 */
public class Computer {
	
	/**
	 * 数据库唯一标示
	 */
	private Integer id;
	/**
	 * hostNnumber：主机号（100-150）
	 */
	private String hostnumber;
	/**
	 * 用户名称
	 */
	private String nickname;
	/**
	 * 用户卡号
	 */
	private String usercard;
	/**
	 * 用户状态
	 */
	private String state;
	
	
	public Computer() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Computer(Integer id, String hostnumber, String nickname,
			String usercard, String state) {
		super();
		this.id = id;
		this.hostnumber = hostnumber;
		this.nickname = nickname;
		this.usercard = usercard;
		this.state = state;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHostnumber() {
		return hostnumber;
	}
	public void setHostnumber(String hostnumber) {
		this.hostnumber = hostnumber;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsercard() {
		return usercard;
	}
	public void setUsercard(String usercard) {
		this.usercard = usercard;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Computer [id=" + id + ", hostnumber=" + hostnumber
				+ ", nickname=" + nickname + ", usercard=" + usercard
				+ ", state=" + state + "]";
	}
	
	
}
