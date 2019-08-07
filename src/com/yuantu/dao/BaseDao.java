package com.yuantu.dao;

import java.util.List;

public interface BaseDao<T> {
	//����ʵ��
	public int save(T t);
	
	//ɾ��ʵ��
	int delete(T t);
	
	int deleteById(String id);
	//����ʵ��
	int update(T t);
	
	//����id��ѯ
	public T queryById(String id);
	
	//��ѯ����
	public List<T> queryAll();

	
}
