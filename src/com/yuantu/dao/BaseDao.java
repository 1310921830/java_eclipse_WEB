package com.yuantu.dao;

import java.util.List;

public interface BaseDao<T> {
	//保存实体
	public int save(T t);
	
	//删除实体
	int delete(T t);
	
	int deleteById(String id);
	//更新实体
	int update(T t);
	
	//根据id查询
	public T queryById(String id);
	
	//查询所有
	public List<T> queryAll();

	
}
