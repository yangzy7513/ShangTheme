package com.shangtheme.client.entity;

import java.io.Serializable;

/**
 * 类名：Ad
 * 作者: yangzy
 * 功能：前台轮播广告实体类
 * 详细：描述轮播广告相关
 * 版本：1.0
 * 日期：2016-10-13
 * 说明：
 *	         不建议在此类拓展新功能。
 */
public class Ad implements Serializable {

	/**
	 * 广告Id
	 */
	private static int ad_id;
	
	/**
	 * 广告链接路径
	 */
	private static String ad_href;
	
	/**
	 * 广告图片地址
	 */
	private static String picpath;
	
	/**
	 * 注册时间
	 */
	private static String registtime;

	/*getter and setter*/
	
	public static int getAd_id() {
		return ad_id;
	}

	public static void setAd_id(int ad_id) {
		Ad.ad_id = ad_id;
	}

	public static String getAd_href() {
		return ad_href;
	}

	public static String getPicpath() {
		return picpath;
	}

	public static void setPicpath(String picpath) {
		Ad.picpath = picpath;
	}

	public static void setAd_href(String ad_href) {
		Ad.ad_href = ad_href;
	}

	public static String getRegisttime() {
		return registtime;
	}

	public static void setRegisttime(String registtime) {
		Ad.registtime = registtime;
	}

	private static final long serialVersionUID = 00000000000000000001L;

}
