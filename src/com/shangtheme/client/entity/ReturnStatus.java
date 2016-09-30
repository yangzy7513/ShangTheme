package com.shangtheme.client.entity;

import java.io.Serializable;

/**
 *@类名：ReturnStatus
 *@作者: yangzy
 *@功能：状态信息类
 *@详细：返回前台的json封装为此类,对应DB字段。
 *@版本：1.0
 *@日期：2016-09-03
 *@说明：
 *	         不建议在此类拓展新功能。
 */
public class ReturnStatus implements Serializable{
	/**
	 * 1.0.0
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 状态
	 */
	private int status;
	
	/**
	 * 消息
	 */
	private String msg;
	
	/**
	 * 数据
	 */
	private Object data;
	
	/************getter and setter****************/
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
