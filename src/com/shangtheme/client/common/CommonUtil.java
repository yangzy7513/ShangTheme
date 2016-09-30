package com.shangtheme.client.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;

/**
 *@类名：CommonUtil
 *@作者: yangzy
 *@功能：总工具类
 *@详细：通过本类可以获取基本字符串工具
 *@版本：1.0
 *@日期：2016-07-15
 *@说明：
 *	         可拓展并在此处说明.
 */
public class CommonUtil {
	
	
	public static final Integer PAGESIZE = 10;
	
	
	/**
	 * Base64加密，该算法可逆
	 * @param str
	 * @return
	 */
	public static String encodeBase64(String str){
		byte[] b = Base64.encodeBase64(str.getBytes());
		return new String(b);
	}
	
	/**
	 * Base64解密
	 * @param str
	 * @return
	 */
	public static String decodeBase64(String str){
		byte[] b = Base64.decodeBase64(str.getBytes());
		return new String(b);
	}
	
	/**
	 * 判断是否为空
	 * @param o
	 * @return
	 */
	public static boolean checkNullValue(Object o){
		if(o instanceof String){
			if (o=="" || o==null) {
				return true;
			}
			return false;
		
		}else if(o instanceof Integer) {
			if (o == "") {
				return true;
			}
			return false;
			
		}
		return false;
	}
	
	/**
	 * 过滤非文字
	 * @param str
	 * @return
	 */
	public static String plaintextFilter(String str){
		String tmpString = str.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");
		char[] cha = tmpString.toCharArray();
		for (int i = 0; i < tmpString.length(); i++) {
			if (cha[i] < 0xFF) {
				cha[i] = ' ';
			}
		}
		return String.copyValueOf(cha).trim();
	}
	
	/**
	 * 切割字符串
	 * @param str
	 * @param cutindex 切割每块的长度
	 * @return
	 */
	public static String[] subString(String str, int cutindex){
		String[] strArry2 = new String[str.length()/cutindex+1];
		StringBuilder sbBuilder = new StringBuilder(str);
		//截取索引
		int index = 0;
		for (int i = 0; i < str.length(); i+=cutindex) {
			if (i+cutindex > str.length()-1) {
				strArry2[index] = sbBuilder.substring(i);
			} else {
				strArry2[index] = sbBuilder.substring(i, i+cutindex);
			}
			index++;
		}
		
		return strArry2;
	}
	/**
	 * 获取当前系统时间
	 * @param format 格式 
	 * @格式例子 "yyyy/MM/dd" 或  "yyyy/MM/dd hh:mm:ss" 
	 * @return
	 */
	public static String getDate(String format){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String datestr = sdf.format(date);
		return datestr;
	}
	
	
}













