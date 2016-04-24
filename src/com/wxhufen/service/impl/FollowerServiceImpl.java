package com.wxhufen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wxhufen.mapper.FollowerMapper;
import com.wxhufen.po.Follower;
import com.wxhufen.service.FollowerService;


public class FollowerServiceImpl implements FollowerService{
	@Autowired
	private FollowerMapper followerMapper;

	public void insertFollower(Follower follower) {
		followerMapper.insertFollower(follower);
	}

	public boolean isExistByOpenid(String openid) {
		Follower follower = followerMapper.selectFollowerByOpenid(openid);
		if(follower!=null){
			return true;
		}
		return false;
	}

	public int selectFollowerNumber(String mpid) {
		return followerMapper.selectFollowerNumber(mpid);
	}
}
