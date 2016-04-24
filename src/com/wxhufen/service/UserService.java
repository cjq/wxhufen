package com.wxhufen.service;

import com.wxhufen.po.User;

public interface UserService {
	public User selectUserByEmail(String email);
	
	public void updatePoint(Integer userid,Integer point);
	
	public Integer getUserPoint(String email);

	public void updatePointByUserId(Integer userid,String point);
	
	public boolean isExistByUserid(Integer userid);
	
	public void insertUser(User user);
	
	public boolean isExistByEmail(String email);
	
	public String selectUsernameByUserid(Integer userid);
	
	public boolean isExistByUserName(String username);
	
	public Integer selectPointByUserName(String username);
}
