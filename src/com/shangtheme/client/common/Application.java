package com.shangtheme.client.common;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 *@类名：Application
 *@作者: yangzy
 *@功能：辅助类
 *@详细：该类在应用初始化完成后开始执行
 *@版本：1.0
 *@日期：2016-09-22
 *@说明：
 *	         可拓展并在此处说明.
 */
public class Application implements ApplicationListener<ContextRefreshedEvent>{
	
	private static final String URL = "http://localhost:8080/ShangTheme/doRecommendation.do";
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("当前时间："+CommonUtil.getDate("yyyy年MM月dd日  HH:mm:ss"));
		
		if (event.getApplicationContext().getParent() == null) {
			HttpClient client = new HttpClient();
			HttpMethod method = new GetMethod(URL);
			
			try {
				//TODO
				client.executeMethod(method);
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	

}
