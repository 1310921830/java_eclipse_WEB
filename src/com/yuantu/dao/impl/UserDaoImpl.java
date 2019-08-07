package com.yuantu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yuantu.dao.UserDao;
import com.yuantu.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	public UserDaoImpl(String url, String driver, String user, String pwd) {
		super(url, driver, user, pwd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int save(User t) {
		int result=0;
		String sql = "insert into user(id,username,password,"
				+ " name,gender,age,delete_flag)"
				+ " values(?,?,?,?,?,?,'N')";
		PreparedStatement pst = null;
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1, t.getuId());
			pst.setString(2, t.getUserName());
			pst.setString(3, t.getPwd());
			pst.setString(4, t.getName());
			pst.setString(5, t.getGender());
			pst.setInt(6, t.getAge());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int deleteById(String id) {
		int result=0;
		String sql = "update user set delete_flag='Y' where id=?";
		
		PreparedStatement pst = null;
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1, id);
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	@Override
	public int update(User t) {
		int result=0;
		String sql = "update user set"+
				" username=?,password=?,name=?,gender=?,age=?"
				+ " where id=?";
		PreparedStatement pst = null;
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(3, t.getName());
			pst.setString(4, t.getGender());
			pst.setInt(5, t.getAge());
			pst.setString(1, t.getUserName());
			pst.setString(2, t.getPwd());
			pst.setString(6, t.getuId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//根据id修改密码
	public int updatePwd(String id,String pwd) {
		int result=0;
		String sql = "update user set"+
				" password=?"
				+ " where id=?";
		PreparedStatement pst = null;
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1, pwd);
			pst.setString(2, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//根据id查询用户
	@Override
	//根据id查询用户
	public User queryById(String id) {
		User user = null;
		String sql = "select id,"
				+ " username,"
				+ " password,"
				+ " name,"
				+ " gender,"
				+ " age"
				+ " from user"
				+ " where id=? and delete_flag='N'";
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1, id);
			resultSet = pst.executeQuery();
			if(resultSet.next()) {
				user = new User(resultSet.getString(1),resultSet.getString(2), 
					resultSet.getString(3), resultSet.getString(4), 
					resultSet.getString(5), resultSet.getInt(6)
			);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	
	//展示所有用户信息
	@Override
	public List<User> queryAll() {
		List<User> list = new ArrayList<User>();
		String sql = "select id,"
				+ " username,"
				+ " password,"
				+ " name,"
				+ " gender,"
				+ " age"
				+ " from user"
				+ " where delete_flag='N'";
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		
		try {
			pst = getCon().prepareStatement(sql);
			resultSet = pst.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getString(1),resultSet.getString(2), 
						resultSet.getString(3), resultSet.getString(4), 
						resultSet.getString(5), resultSet.getInt(6)
						);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	//登录验证
	public User queryByUser(String username,String pwd) {
		User user = null;
		String sql = "select * from user" + 
	" where username=? and password=?"
	+ " and delete_flag='N'";
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		try {
			pst = getCon().prepareStatement(sql);
		pst.setString(1, username);
			pst.setString(2, pwd);
			resultSet = pst.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getString(1),resultSet.getString(2), 
						resultSet.getString(3), resultSet.getString(4), 
						resultSet.getString(5), resultSet.getInt(6)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	//根据用户名查询，用于判断注册时用户名是否已存在
	public int queryByName(String uname) {
		String sql = "select * from user" + " where username=?"
				+ " and delete_flag='N'";
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1, uname);
			
			resultSet = pst.executeQuery();
			if (resultSet.next()) {
				result= 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//根据用户名和真实姓名，模糊查询
	public List<User> queryUsers(String username,String name) {
		List<User> list = new ArrayList<User>();
		String sql = "select id,"
				+ " username,"
				+ " password,"
				+ " name,"
				+ " gender,"
				+ " age"
				+ " from user"
				+ " where delete_flag='N'";
		if(null!=username&&!"".equals(username)) {
			sql = sql+" and username like '%"+
					username.trim()+"%'";
		}
		if(null!=name&&!"".equals(name)) {
			sql = sql+" and name like '%"+
					name.trim()+"%'";
		}
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		
		try {
			pst = getCon().prepareStatement(sql);
			resultSet = pst.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getString(1),resultSet.getString(2), 
						resultSet.getString(3), resultSet.getString(4), 
						resultSet.getString(5), resultSet.getInt(6)
						);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
