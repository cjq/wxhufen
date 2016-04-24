package com.wxhufen.mapper;

import com.wxhufen.po.Follower;

public interface FollowerMapper {
	public void insertFollower(Follower follower);
	
	public Follower selectFollowerByOpenid(String openid);
	
	public int selectFollowerNumber(String mpid);
}
