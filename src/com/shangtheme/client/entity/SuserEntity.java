package com.shangtheme.client.entity;

import java.io.Serializable;

/**
 * 类名：SuserEntity
 * 作者: yangzy
 * 功能：用户信息类
 * 详细：描述用户信息,对应DB字段。
 * 版本：1.0
 * 日期：2016-09-03
 * 说明：
 *	         不建议在此类拓展新功能。
 */
public class SuserEntity implements Serializable{
	
	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private int s_id;
	
	/**
	 * 用户昵称
	 */
	private String s_username;
	
	/**
	 * 用户密码
	 */
	private String s_password;
	
	/**
	 * 用户头像
	 */
	private String s_headphoto;
	
	/**
	 * 用户性别
	 */
	private String s_sex;
	
	/**
	 * 用户生日
	 */
	private String s_birthday;
	
	/**
	 * VIP会员检查
	 */
	private int s_checkvip;
	
	/**
	 * 注册手机
	 */
	private String s_phonenum;

	/************getter and setter****************/
	
	public SuserEntity() {
		
	}
	
	
	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_username() {
		return s_username;
	}

	public void setS_username(String s_username) {
		this.s_username = s_username;
	}

	public String getS_password() {
		return s_password;
	}

	public void setS_password(String s_password) {
		this.s_password = s_password;
	}

	public String getS_headphoto() {
		return s_headphoto;
	}

	public void setS_headphoto(String s_headphoto) {
		this.s_headphoto = s_headphoto;
	}

	public String getS_sex() {
		return s_sex;
	}

	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}

	public String getS_birthday() {
		return s_birthday;
	}

	public void setS_birthday(String s_birthday) {
		this.s_birthday = s_birthday;
	}

	public int getS_checkvip() {
		return s_checkvip;
	}

	public void setS_checkvip(int s_checkvip) {
		this.s_checkvip = s_checkvip;
	}

	public String getS_phonenum() {
		return s_phonenum;
	}

	public void setS_phonenum(String s_phonenum) {
		this.s_phonenum = s_phonenum;
	}

	public SuserEntity(int s_id, String s_username, String s_password,
			String s_headphoto, String s_sex, String s_birthday,
			int s_checkvip, String s_phonenum) {
		super();
		this.s_id = s_id;
		this.s_username = s_username;
		this.s_password = s_password;
		this.s_headphoto = s_headphoto;
		this.s_sex = s_sex;
		this.s_birthday = s_birthday;
		this.s_checkvip = s_checkvip;
		this.s_phonenum = s_phonenum;
	}
	
	
}
