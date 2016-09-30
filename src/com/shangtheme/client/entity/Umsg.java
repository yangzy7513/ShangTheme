package com.shangtheme.client.entity;

import java.io.Serializable;

/**
 *@类名：Umsg
 *@作者: yangzy
 *@功能：用户已阅读的信息
 *@详细：描述用户已阅读的,对应DB字段。
 *@版本：1.0
 *@日期：2016-09-11
 *@说明：
 *	         不建议在此类拓展新功能。
 */
public class Umsg implements Serializable{

	/**
	 * 1.0.0
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 已阅站内信id
	 */
	private int umsg_id;
	
	/**
	 * 站内信ID
	 */
	private int msg_id;
	
	/**
	 * 用户id
	 */
	private int s_id;
	
	/**
	 * 状态
	 */
	private int status;

	public int getUmsg_id() {
		return umsg_id;
	}

	public void setUmsg_id(int umsg_id) {
		this.umsg_id = umsg_id;
	}

	public int getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

}
