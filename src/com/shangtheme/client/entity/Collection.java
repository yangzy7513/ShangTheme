package com.shangtheme.client.entity;

import java.io.Serializable;

/**
 *@类名：Collection
 *@作者: yangzy
 *@功能：收藏信息类
 *@详细：描述用户已收藏的主题,对应DB字段。
 *@版本：1.0
 *@日期：2016-08-28
 *@说明：
 *	         不建议在此类拓展新功能。
 */
public class Collection implements Serializable {

	/**
	 * 1.0.0
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 收藏表ID
	 */
	private int c_id;
	
	/**
	 * 收藏创建时间
	 */
	private String c_createtime;
	
	/**
	 * 用户ID
	 */
	private int s_id;
	
	/**
	 * 主题ID
	 */
	private int t_id;

	/************getter and setter****************/
	
	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_createtime() {
		return c_createtime;
	}

	public void setC_createtime(String c_createtime) {
		this.c_createtime = c_createtime;
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
	
	
}
