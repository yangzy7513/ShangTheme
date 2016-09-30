package com.shangtheme.client.test;

import com.shangtheme.client.common.CommonUtil;

public class StringSplitTest {
	
	public static void main(String[] args) {
		String str = "你是我最爱的人ui";
		
		for(String s:CommonUtil.subString(str, 2)){
			System.out.println(s);
		}
	}
	
	
	private static String[] get1(String str){
		String[] strArry2 = new String[str.length()/2+1];
		StringBuilder sbBuilder = new StringBuilder(str);
		//截取索引
		int index = 0;
		for (int i = 0; i < str.length(); i+=2) {
			if (i+2 > str.length()-1) {
				strArry2[index] = sbBuilder.substring(i);
			} else {
				strArry2[index] = sbBuilder.substring(i, i+2);
			}
			index++;
		}
		
		return strArry2;
		
	}
	
	
}
