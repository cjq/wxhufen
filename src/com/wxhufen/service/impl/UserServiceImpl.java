package com.wxhufen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wxhufen.mapper.UserMapper;
import com.wxhufen.po.User;
import com.wxhufen.service.UserService;


public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public User selectUserByEmail(String email) {
		return userMapper.selectUserByEmail(email);
	}

	public void updatePoint(Integer userid, Integer point) {
		userMapper.updatPoint(userid, point);
		
	}

	public Integer getUserPoint(String email) {
		User user = userMapper.selectUserByEmail(email);
		return user.getPoint();
	}

	public void updatePointByUserId(Integer userid, String point) {
		userMapper.updatePointByUserId(userid, point);
	}

	public boolean isExistByUserid(Integer userid) {
		User user = userMapper.selectUserByUserid(userid);
		if(user!=null){
			return true;
		}
		return false;
	}

	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	public boolean isExistByEmail(String email) {
		User user = userMapper.selectUserByEmail(email);
		if(user!=null){
			return true;
		}
		return false;
	}

	public String selectUsernameByUserid(Integer userid) {
		User user = userMapper.selectUserByUserid(userid);
		return user.getUsername();
	}

	public boolean isExistByUserName(String username) {
		User user = userMapper.selectUserByUserName(username);
		return user!=null ? true : false;
	}

	public Integer selectPointByUserName(String username) {
		User user = userMapper.selectUserByUserName(username);
		return user.getPoint();
	}
	
}
