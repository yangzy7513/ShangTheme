package com.shangtheme.client.entity;

import java.io.Serializable;

/**
 *@类名：Theme
 *@作者: yangzy
 *@功能：主题信息类
 *@详细：描述主题信息,对应DB字段。
 *@版本：1.0
 *@日期：2016-09-03
 *@说明：
 *	         不建议在此类拓展新功能。
 */
public class Theme implements Serializable {

	/**
	 * 1.0.0
	 */
	private static final long serialVersionUID = 1L;
	
	//主题ID
	private int t_id;
	
	//主题名称
	private String t_themename;
	
	//作者
	private String t_author;
	
	//类别组
	private String t_category;
	
	//品牌ID
	private int b_id;
	
	//适配固件
	private String t_firmware;
	
	//上架时间
	private String t_registerdate;
	
	//下载次数
	private int t_downloadnum;
	
	//价格
	private double t_price;
	
	//折扣
	private double t_discount;
	
	//主题图片路径组
	private String t_picpath;
	
	//主题状态
	private int t_status;
	
	//VIP专享
	private int t_vip;
	
	//下载地址
	private String t_downloadpath;
	
	//详细描述
	private String t_abstract;
	
	/************getter and setter****************/
	
	public int getT_status() {
		return t_status;
	}

	public void setT_status(int t_status) {
		this.t_status = t_status;
	}
	
	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_themename() {
		return t_themename;
	}

	public void setT_themename(String t_themename) {
		this.t_themename = t_themename;
	}

	public String getT_author() {
		return t_author;
	}

	public void setT_author(String t_author) {
		this.t_author = t_author;
	}

	public String getT_category() {
		return t_category;
	}

	public void setT_category(String t_category) {
		this.t_category = t_category;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}


	public String getT_registerdate() {
		return t_registerdate;
	}

	public void setT_registerdate(String t_registerdate) {
		this.t_registerdate = t_registerdate;
	}

	public int getT_downloadnum() {
		return t_downloadnum;
	}

	public void setT_downloadnum(int t_downloadnum) {
		this.t_downloadnum = t_downloadnum;
	}

	public double getT_price() {
		return t_price;
	}

	public void setT_price(double t_price) {
		this.t_price = t_price;
	}

	public double getT_discount() {
		return t_discount;
	}

	public void setT_discount(double t_discount) {
		this.t_discount = t_discount;
	}

	public String getT_picpath() {
		return t_picpath;
	}

	public void setT_picpath(String t_picpath) {
		this.t_picpath = t_picpath;
	}

	public String getT_firmware() {
		return t_firmware;
	}

	public void setT_firmware(String t_firmware) {
		this.t_firmware = t_firmware;
	}

	public String getT_downloadpath() {
		return t_downloadpath;
	}

	public void setT_downloadpath(String t_downloadpath) {
		this.t_downloadpath = t_downloadpath;
	}

	public int getT_vip() {
		return t_vip;
	}

	public void setT_vip(int t_vip) {
		this.t_vip = t_vip;
	}

	public String getT_abstract() {
		return t_abstract;
	}

	public void setT_abstract(String t_abstract) {
		this.t_abstract = t_abstract;
	}
	
	
}
