package com.shangtheme.client.test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	static int code = 0;
	
	public static void main(String[] args) {
		
		System.out.println(code);
		
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				code = 12;
				System.out.println(code);
				timer.cancel();
			}
		}, 4*1000);
	}
	
	
}
