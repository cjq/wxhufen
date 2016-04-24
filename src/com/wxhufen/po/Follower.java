package com.wxhufen.po;

public class Follower {
	private String mpid;
	private Integer userid;
	private String openid;
	public String getMpid() {
		return mpid;
	}
	public void setMpid(String mpid) {
		this.mpid = mpid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Override
	public String toString() {
		return "Follower [mpid=" + mpid + ", userid=" + userid + ", openid="
				+ openid + "]";
	}
	
}
