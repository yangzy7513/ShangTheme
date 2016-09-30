package com.shangtheme.client.common;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shangtheme.client.dao.DBDao;

/**
 *@类名：DBMsgUtil
 *@作者: yangzy
 *@功能：状态信息管理
 *@详细：通过本类可以从DB中获取信息内容
 *@版本：1.0
 *@日期：2016-07-24
 *@说明：
 *	         不建议在此类拓展新功能。
 */
@Service
public class DBMsgUtil {
	
	@Resource
	private DBDao dao;
	
	private static DBMsgUtil dbMsgUtil;
	
	@PostConstruct
	public void init(){
		dbMsgUtil = this;
		dbMsgUtil.dao = this.dao;
	}
	
	/**
	 * 获取消息提示信息
	 * @param code
	 * @return
	 */
	public static String getStatusMsgByCode(int code){
		String dbMsg= dbMsgUtil.dao.findMsgByCode(code);
		return (dbMsg == null ? "" : dbMsg);
	}
	
	
}
