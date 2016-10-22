/**
 * 
 */
package com.shangtheme.client.entity;

import java.io.Serializable;

/**
 * 类名：AuthCodeController
 * 作者: yangzy
 * 功能：品牌类
 * 详细：描述品牌的一些基本特性,对应DB字段。
 * 版本：1.0
 * 日期：2016-08-28
 * 说明：
 *	      不建议在此类拓展新功能。
 */
public class Brand implements Serializable {

	/**
	 * 1.0.0
	 */
	private static final long serialVersionUID = 1L;
	
	//品牌ID
	private int b_id;
	
	//品牌名称
	private String b_brandname;
	
	//公司注册时间
	private String b_registetime;
	
	//公司名称
	private String b_company;
	
	//公司简介
	private String b_briefintroduce;
	
	//logo图片路径
	private String logo;

	/************getter and setter****************/
	
	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_brandname() {
		return b_brandname;
	}

	public void setB_brandname(String b_brandname) {
		this.b_brandname = b_brandname;
	}

	

	public String getB_registetime() {
		return b_registetime;
	}

	public void setB_registetime(String b_registetime) {
		this.b_registetime = b_registetime;
	}

	public String getB_company() {
		return b_company;
	}

	public void setB_company(String b_company) {
		this.b_company = b_company;
	}

	public String getB_briefintroduce() {
		return b_briefintroduce;
	}

	public void setB_briefintroduce(String b_briefintroduce) {
		this.b_briefintroduce = b_briefintroduce;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
}
