package com.shangtheme.client.service;

import com.shangtheme.client.entity.ReturnStatus;

/**
 *@类名：MyAssetsService
 *@作者: CC
 *@功能：资产信息服务接口
 *@详细：控制器会调用此接口
 *@版本：1.0
 *@日期：2016-9-7
 *@说明：
 *	         必须有实现类,可拓展并在此处说明.
 */
public interface MyAssetsService {

	public ReturnStatus getMyAssets(int s_id,Integer pageNo, Integer pageSize);
	
	
}
