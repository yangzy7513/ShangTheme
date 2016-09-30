package com.shangtheme.client.test;

import org.apache.commons.codec.digest.DigestUtils;

import com.shangtheme.client.common.CommonUtil;

/**
 * MD5加解密测试
 * @author Mr.Y
 *
 */
public class MD5 {
	public static void main(String[] args) {
//		System.out.println(getMD5("13804984741"));
		System.out.println(CommonUtil.encodeBase64("123"));
		
	}
	
	public static String getMD5(String str){
		return DigestUtils.md5Hex(str);
	}
}
