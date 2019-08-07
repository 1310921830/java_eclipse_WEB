package com.yuantu.service.impl;

import java.util.List;

import com.yuantu.dao.UserDao;
import com.yuantu.dao.impl.UserDaoImpl;
import com.yuantu.entity.User;
import com.yuantu.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl() {
		super();
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://127.0.0.1:3306/yuantu?useSSL=false";
		String dbUser = "root";
		String dbPassword = "123456";
		// super(dbUrl, dbUserName, dbPassword, dbDriver);
		this.userDao = new UserDaoImpl(dbUrl,dbDriver,dbUser,dbPassword);
	}
	
	@Override
	public User userLogin(String username, String pwd) {
		User user = userDao.queryByUser(username, pwd);
		try {
			((UserDaoImpl)userDao).closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int saveUser(User user) {
		int result = userDao.queryByName(user.getUserName());
		int result1=0;
		if(result==0) {
			result1=userDao.save(user);
		}
		try {
			((UserDaoImpl)userDao).closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result1;
	}
	@Override
	public List<User> queryAll() {
		List<User> list = userDao.queryAll();
		try {
			((UserDaoImpl)userDao).closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<User> queryByNames(String username, String name) {
		List<User> list = userDao.queryUsers(username, name);
		try {
			((UserDaoImpl)userDao).closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteUserById(String id) {
		int result = userDao.deleteById(id);
		return result;
		
	}

	@Override
	public int updateUser(User user) {
		int result = 0;
		User u = queryUserById(user.getuId());//原始没有修改的用户
		System.out.println(user.getuId());
		//用户名修改了的话，就需要查询用户名有没有被使用
		if(!u.getUserName().equals(user.getUserName())) {
			int result1 = userDao.queryByName(user.getUserName());
			if(result1==0) {
				result = userDao.update(user);
			}
		}else {
			result = userDao.update(user);
		}
		return result;
	}

	@Override
	public User queryUserById(String id) {
		User user = userDao.queryById(id);
		return user;
	}

	@Override
	public int updateUserPwd(String id,String pwd) {
		int result = userDao.updatePwd(id, pwd);
		return result;
	}

}
