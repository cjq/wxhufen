package com.wxhufen.service;

import java.util.List;
import java.util.Map;

import com.wxhufen.po.MP;
import com.wxhufen.po.Page;


public interface MPService {
	
	public boolean isExistByMPid(String mpid);
	
	public void insertMPid(String mpid);
	
	public boolean isExistByMPname(String mpid);
	
	public void updatePM(MP mp);
	
	public List<MP> selectAllMPItems(Page page);
	
	public Integer getMPCount();
	
	public MP selectMPByMPid(String mpid);
	
	public void updateMPTotalCountByMPId(String mpid);
}
