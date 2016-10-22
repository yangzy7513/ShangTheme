package com.shangtheme.client.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
	
	/**
	 * 默认最大显示页数
	 */
	public static final Integer PAGESIZE = 10;
	
	/**
	 * 首页轮播图片存储地址
	 */
	public static final String ADPicPath =  "database/ad/";
	
	public static final String DEFAULTHEADPATH = "database/head/default.png";
	
	/**
	 * Base64加密，该算法可逆
	 * @param str 要编码的字符串
	 * @return 编码后的字符串
	 */
	public static String encodeBase64(final String str) {
		byte[] b = Base64.encodeBase64(str.getBytes());
		return new String(b);
	}
	
	/**
	 * Base64解密
	 * @param str
	 * @return
	 */
	public static String decodeBase64(final String str){
		byte[] b = Base64.decodeBase64(str.getBytes());
		return new String(b);
	}
	
	/**
	 * 判断是否为空
	 * @param o
	 * @return
	 */
	public static boolean checkNullValue(final Object o){
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
	
	/**
	 * 计算两个数组中的相同内容的数目
	 * @param arryone
	 * @param arrytwo
	 * @return 相同数目
	 */
	public static int findCommonNumOfArrays(int[] arryone, int[] arrytwo) {
		int num = 0;
		for (int i = 0; i < arryone.length; i++) {
			for (int j = 0; j < arrytwo.length; j++) {
				if (arryone[i] == arrytwo[j] && arryone[i] !=0  ) {
					num++;
				}
			}
		}
		return num;
	}
	
	/**
	 * 一个数组除去0的长度
	 * @param array
	 * @return
	 */
	public static int notZeroNumOfArrays(int[] array){
		int num = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				num++;
			}
		}
		return num;
	}
	
	/**
	 * 将int[]传换位Integer[]
	 * @param array
	 * @return
	 */
	public static Integer[] parseintToInteger(int[] array) {
		Integer[] in = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			in[i] = Integer.valueOf(array[i]);
		}
		return in;
	}
	
	
	/**
	 * 找出存在数组t2，而不在数组t1的数据
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static<T> List<T> compare(T[] t1, T[] t2){
		List<T> list1 = Arrays.asList(t1);
		List<T> list2 = new ArrayList<T>();
		for(T t : t2){
			if (!list1.contains(t)) {
				list2.add(t);
			}
		}
		return list2;
	}
	
	
	
	
}












