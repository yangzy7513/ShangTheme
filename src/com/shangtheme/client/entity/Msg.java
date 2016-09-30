package com.shangtheme.client.entity;

import java.io.Serializable;

/**
 *@类名：Msg
 *@作者: yangzy
 *@功能：站内信类
 *@详细：描述收件内容相关
 *@版本：1.0
 *@日期：2016-09-11
 *@说明：
 *	         不建议在此类拓展新功能。
 */
public class Msg implements Serializable{
	
	/**
	 * 1.0.0
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 站内信ID
	 */
	private int msg_id;
	
	/**
	 * 发件人名称
	 */
	private String sendname;
	
	/**
	 * 收件人ID
	 */
	private int s_id;
	
	/**
	 * 发件标题
	 */
	private String msgtitle;
	
	/**
	 * 信件内容
	 */
	private String msgcontent;

	/**
	 * 时间
	 */
	private String totime;
	
	public int getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public String getSendname() {
		return sendname;
	}

	public void setSendname(String sendname) {
		this.sendname = sendname;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getMsgtitle() {
		return msgtitle;
	}

	public void setMsgtitle(String msgtitle) {
		this.msgtitle = msgtitle;
	}

	public String getMsgcontent() {
		return msgcontent;
	}

	public void setMsgcontent(String msgcontent) {
		this.msgcontent = msgcontent;
	}

	public String getTotime() {
		return totime;
	}

	public void setTotime(String totime) {
		this.totime = totime;
	}
	
}
