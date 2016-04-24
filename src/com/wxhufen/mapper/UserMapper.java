package com.wxhufen.mapper;

import com.wxhufen.po.User;

public interface UserMapper {
	
	public User selectUserByEmail(String email);
	
	//发布任务扣除积分
	public void updatPoint(Integer userid,Integer point);
	
	//关注增加积分
	public void updatePointByUserId(Integer userid,String point);
	
	public User selectUserByUserid(Integer userid);
	
	public void insertUser(User user);
	
	public User selectUserByUserName(String username);
}
