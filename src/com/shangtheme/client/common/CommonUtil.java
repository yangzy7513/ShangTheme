package com.shangtheme.client.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

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
	 * 获取当前系统时间
	 * 
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
	
	/**
	 * 後端執行JavaScript代碼
	 * 
	 * @param scriptCode
	 * @throws IOException 
	 * 
	 * 舉個栗子 ： String scriptCode = "alert('请输入正确的用户名或密码');";
	 *			CommonUtil.doSCript(scriptCode, response);
	 */
	public static void doSCript(String scriptCode , HttpServletResponse response ) throws IOException {
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("<script language='javascript' >"
				+ scriptCode
				+ "</script>");
		
	}
	
}













