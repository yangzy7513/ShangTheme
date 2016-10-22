package com.shangtheme.client.entity;

import java.io.Serializable;

/**
 * 类名：Collection
 * 作者: yangzy
 * 功能：订单信息类
 * 详细：描述用户待购买的主题,对应DB字段。
 * 版本：1.0
 * 日期：2016-09-03
 * 说明：
 *	         不建议在此类拓展新功能。
 */
public class Order implements Serializable {

	/**
	 * 1.0.0
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单表ID
	 */
	private int o_id;
	
	/**
	 * 用户ID
	 */
	private int s_id;
	
	/**
	 * 主题ID
	 */
	private int t_id;
	
	/**
	 * 创建时间
	 */
	private String o_createtime;

	/************getter and setter****************/
	
	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
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

	public String getO_createtime() {
		return o_createtime;
	}

	public void setO_createtime(String o_createtime) {
		this.o_createtime = o_createtime;
	}


	
}
