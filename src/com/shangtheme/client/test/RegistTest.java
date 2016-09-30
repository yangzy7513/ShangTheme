package com.shangtheme.client.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RegistTest {
//	public static <E> void main(String[] args) {
//		/*String conf = "applicationContext.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		SuserDao suserDao = ac.getBean("suserDao", SuserDao.class);
//		SuserEntity sEntity = new SuserEntity();
//		sEntity.setS_username("tom");
//		sEntity.setS_password("tom123");
//		sEntity.setS_headphoto("/data/head.png");
//		sEntity.setS_sex("男");
//		sEntity.setS_birthday("20160729");
//		sEntity.setS_checkvip(1);
//		sEntity.setS_ip("192.168.1.1");
//		sEntity.setS_phonenum("18866668888");
//		suserDao.register_suser(sEntity);*/
//		
//		
//		//截取图片名称
//		String file = "E:Shangtheme\\head\\head.jpg";
//		
//		StringBuilder sBuilder = new StringBuilder(file);
//		String rString = null;
//		rString = sBuilder.substring(sBuilder.lastIndexOf("\\")+1);
//		System.out.println(rString);
//		
//	
//		
//		
//	}
//	
	
	@Test
	public void test2(){
	List<Object> list = new ArrayList<>();
		
		list.add("r");
		list.add("34");
		list.add("345");
		
		list.add("r4");
		list.add("345");
		list.add("3456");
		
		list.add("r4");
		list.add("345");
		list.add("3456");
		
		int flag = 0;
		for(int i=0 ;i<list.size();i++){
			System.out.print(list.get(i)+",");
			flag++;
			if (flag >2) {
				System.out.println("");
				flag = 0;
			}
		}
	}
	
}
