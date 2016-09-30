package com.shangtheme.client.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JavaToJs {
	static final String name = "yzy";
	
	public static void main(String[] args) {
		ScriptEngineManager sem = new ScriptEngineManager();
		
		ScriptEngine se = sem.getEngineByName("js");
		try {
//			 String script = "function say(){ return 'hello,'"+name+"; }"; 
//
//		      se.eval(script);  
//
//		      Invocable inv2 = (Invocable) se;  
//
//		      String res=(String)inv2.invokeFunction("say",name);  
//
//		      System.out.println(res); 
			String rootPath= System.getProperty("user.dir"); 
			System.out.println(">>>>>>>>>>>>>>>>>>");
			System.out.println(rootPath);
		} catch (Exception e) {
		}
	}
}
