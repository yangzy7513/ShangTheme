package com.shangtheme.client.service;

import java.util.List;
import java.util.Map;

import com.shangtheme.client.entity.ReturnStatus;

/**
 *@类名：StationMsgService
 *@作者: CC
 *@功能：站内信服务接口
 *@详细：控制器会调用此接口
 *@版本：1.0
 *@日期：2016-9-11
 *@说明：
 *	         必须有实现类,可拓展并在此处说明.
 */
public interface StationMsgService {
	
	/**
	 * 查看是否有新站内信
	 * @return
	 */
	public ReturnStatus getnewLetterService(int s_id);
	
	/**
	 * 获取全部站内信
	 * @param s_id
	 * @return
	 */
	public List<Map<String, Object>> getAllLetter(int s_id);
	
}
