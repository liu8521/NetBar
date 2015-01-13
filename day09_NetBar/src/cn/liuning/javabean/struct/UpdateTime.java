package cn.liuning.javabean.struct;

public class UpdateTime {
	private String usercard;
	private String duratime;
	public String getUsercard() {
		return usercard;
	}
	public void setUsercard(String usercard) {
		this.usercard = usercard;
	}
	public String getDuratime() {
		return duratime;
	}
	public void setDuratime(String duratime) {
		this.duratime = duratime;
	}
	@Override
	public String toString() {
		return "UpdateTime [usercard=" + usercard + ", duratime=" + duratime
				+ "]";
	}
	
}
