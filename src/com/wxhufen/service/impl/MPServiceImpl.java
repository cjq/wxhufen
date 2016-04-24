package com.wxhufen.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wxhufen.mapper.MPMapper;
import com.wxhufen.po.MP;
import com.wxhufen.po.Page;
import com.wxhufen.service.MPService;


public class MPServiceImpl implements MPService{
	
	@Autowired
	private MPMapper mPMapper;
	
	public boolean isExistByMPid(String mpid) {
		MP mp = mPMapper.selectMPByMPid(mpid);
		if(mp==null){
			return false;
		}
		return true;
	}

	public void insertMPid(String mpid) {
		mPMapper.insertMPid(mpid);
	}

	public boolean isExistByMPname(String mpid) {
		MP mp = mPMapper.selectMPByMPid(mpid);
		if(mp.getMpname()==null){
			return false;
		}
		return true;
	}

	public void updatePM(MP mp) {
		mPMapper.updateMP(mp);
	}

	public List<MP> selectAllMPItems(Page page) {
		return mPMapper.selectAllMPItems(page);
	}

	public Integer getMPCount() {
		return mPMapper.getMPCount();
	}

	public MP selectMPByMPid(String mpid) {
		return mPMapper.selectMPByMPid(mpid);
	}

	public void updateMPTotalCountByMPId(String mpid) {
		mPMapper.updateMPTotalCountByMPId(mpid);
	}

	
	
}
