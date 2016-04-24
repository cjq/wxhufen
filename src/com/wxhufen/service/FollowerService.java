package com.wxhufen.service;

import com.wxhufen.po.Follower;

public interface FollowerService {
	public void insertFollower(Follower follower);
	
	public boolean isExistByOpenid(String openid);
	
	public int selectFollowerNumber(String mpid);
}
