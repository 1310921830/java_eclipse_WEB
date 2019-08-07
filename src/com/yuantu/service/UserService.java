package com.yuantu.service;

import java.util.List;

import com.yuantu.entity.User;

public interface UserService {
	//用户登录
	User userLogin(String username,String pwd);
	//用户注册
	int saveUser(User user);
	//展示所有用户
	List<User> queryAll();
	//通过用户名和姓名模糊查询
	List<User> queryByNames(String username,String name);
	
	//根据id删除用户
	int deleteUserById(String id);
	
	//根据用户更新
	int updateUser(User user);
	
	//根据id修改密码
	int updateUserPwd(String id,String pwd);
	
	User queryUserById(String id);
	
	
}
