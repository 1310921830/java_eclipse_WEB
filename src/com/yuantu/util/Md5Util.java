package com.yuantu.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
	public static String encrypt(String str) throws UnsupportedEncodingException {
		System.out.println(str);
		byte[] data = str.getBytes("utf-8");
		//获取消息摘要对象
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//把数据更新入对象中，只接受byte数组
		md5.update(data);	
		//加密结果
		byte[] result = md5.digest(); //16个byte
		
		//转换为16进制字符串
		String str1 = new BigInteger(1, result).toString(16);
		return str1;
	}
	
}
