package com.wxhufen.po;

import java.util.Date;

public class MP {
	private String mpid;
	private String mpname;
	private String qrcode;
	private String taskpoint;
	private String totalcount;
	private Integer fnumber;
	private Date time;
	private Integer userid;
	public String getMpid() {
		return mpid;
	}
	public void setMpid(String mpid) {
		this.mpid = mpid;
	}
	public String getMpname() {
		return mpname;
	}
	public void setMpname(String mpname) {
		this.mpname = mpname;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getTaskpoint() {
		return taskpoint;
	}
	public void setTaskpoint(String taskpoint) {
		this.taskpoint = taskpoint;
	}
	public String getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}
	public Integer getFnumber() {
		return fnumber;
	}
	public void setFnumber(Integer fnumber) {
		this.fnumber = fnumber;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date date) {
		this.time = date;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "MP [mpid=" + mpid + ", mpname=" + mpname + ", qrcode=" + qrcode
				+ ", taskpoint=" + taskpoint + ", totalcount=" + totalcount
				+ ", fnumber=" + fnumber + ", time=" + time + ", userid="
				+ userid + "]";
	}
	
	
	
	
}
