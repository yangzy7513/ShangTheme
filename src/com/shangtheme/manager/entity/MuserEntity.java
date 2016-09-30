package com.shangtheme.manager.entity;

import java.io.Serializable;


/**
 *@类名：MuserEntity
 *@作者: cc
 *@功能：管理员信息类
 *@详细：描述用户信息,对应DB字段。
 *@版本：1.0
 *@日期：2016-09-14
 *@说明：
 */
public class MuserEntity implements Serializable {
	
	/**
	 *  管理员账号
	 */
	private String m_user_name;
	
	/**
	 *  账户密码
	 */
	private String m_password;

	
	
	public String getM_user_name() {
		return m_user_name;
	}

	public void setM_user_name(String m_user_name) {
		this.m_user_name = m_user_name;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

}
