package com.yuantu.dao;



import java.util.List;

import com.yuantu.entity.User;

public interface UserDao extends BaseDao<User>{
	
	//登录验证
	public User queryByUser(String username,String pwd);
	
	//根据用户名查询，用于判断注册时用户名是否已存在
	public int queryByName(String uname);
	
	//根据用户名和真实姓名，模糊查询
	public List<User> queryUsers(String username,String name);
	
	//根据id修改密码
	public int updatePwd(String id,String pwd);
}
