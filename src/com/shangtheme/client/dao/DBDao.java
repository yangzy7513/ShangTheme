package com.shangtheme.client.dao;

import java.util.List;
import java.util.Map;

import com.shangtheme.client.entity.Umsg;

/**
 *@类名：DBDao
 *@作者: yangzy
 *@功能：全局信息获取
 *@详细：连接DB,获取数据。
 *@版本：1.0
 *@日期：2016-8-7
 *@说明：
 *	     对应DBMapper.xml.
 */
public interface DBDao {
	
	/**
	 * 获取弹出消息内容
	 * @param code
	 * @return
	 */
	public String findMsgByCode(int code);
	
	/**
	 * 检查是否有新站内信
	 * @param s_id
	 * @return
	 */
	public List<Map<String, Integer>> findNewLetter(int s_id);
	
	/**
	 * 更新用户接收表
	 * @param umsg
	 */
	public void updateUmsg(Umsg umsg);
	
	/**
	 * 获取站内信
	 * @param s_id
	 * @return
	 */
	public List<Map<String, Object>> getAllLetter(int s_id);
	
	
	void changeToRead(Umsg msg);
}
