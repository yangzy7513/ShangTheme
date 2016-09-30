package com.shangtheme.client.entity;

import java.io.Serializable;

/**
 *@类名：Assets
 *@作者: yangzy
 *@功能：资产类
 *@详细：描述用户已购买的主题,对应DB字段。
 *@版本：1.0
 *@日期：2016-08-28
 *@说明：
 *	      不建议在此类拓展新功能。
 */
public class Assets implements Serializable {

	/**
	 * 1.0.0
	 */
	private static final long serialVersionUID = 1L;
	
	//资产ID
	private int a_id;
	
	//用户ID
	private int s_id;
	
	//主题ID
	private int t_id;
	
	//购买时间
	private String a_buydate;

	/************getter and setter****************/
	
	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getA_buydate() {
		return a_buydate;
	}

	public void setA_buydate(String a_buydate) {
		this.a_buydate = a_buydate;
	}
	
}
