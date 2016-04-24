package com.wxhufen.po;

import java.util.List;

public class Page {
	private int pageCode; //页码
//	private int totalPage; //总页数
	private int itemCount; //页面条目数量
	private int totalitems; //总数据量
	private int head;
	private List<MP> list;
	
	public List<MP> getList() {
		return list;
	}
	public void setList(List<MP> list) {
		this.list = list;
	}
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	public int getTotalPage() {
		if ((totalitems % itemCount) == 0) {
            return totalitems / itemCount;
        } else {
            return totalitems / itemCount + 1;
        }
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getTotalitems() {
		return totalitems;
	}
	public void setTotalitems(int totalitems) {
		this.totalitems = totalitems;
	}
	
	public int getHead() {
		return head;
	}
	public void setHead() {
		this.head = (pageCode * itemCount) - itemCount;
	}
}
