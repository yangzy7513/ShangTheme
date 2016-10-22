package com.shangtheme.client.service;

import com.shangtheme.client.entity.ReturnStatus;

/**
 * 类名：OtherService
 * 作者: CC
 * 功能：其他相关信息接口
 * 详细：控制器会调用此接口
 * 版本：1.0
 * 日期：2016-9-6
 * 说明：
 *	         必须有实现类,可拓展并在此处说明.
 *		 修改类名 yangzy  2016/9/15
 */
public interface OtherService {
	
	/**
	 * 获取展板信息
	 * @return
	 */
	
	public ReturnStatus doRecommendation();
	
	
	
}
