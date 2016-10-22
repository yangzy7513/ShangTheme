package com.shangtheme.client.test;

import java.util.List;

import org.junit.Test;

import com.shangtheme.client.common.CommonUtil;

public class ArrayTest {
	int[] a = {83,19,17,9,4,0,0,0,0,0};
	int[] b = {4,5,7,9,18,0,0,0,0};
//	@Test
	public void testFindCommonNumOfArrays(){
	//	System.out.println(CommonUtil.findCommonNumOfArrays(a, b));
	}
	
	@Test
	public void findNotComomonData(){
		List<Integer> list =  CommonUtil.compare(CommonUtil.parseintToInteger(a), 
														CommonUtil.parseintToInteger(b));
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		
	}
	
	
}
