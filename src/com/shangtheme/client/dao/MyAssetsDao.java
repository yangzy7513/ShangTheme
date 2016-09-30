package com.shangtheme.client.dao;

import java.util.List;
import java.util.Map;


/**
 *@类名：MyAssetsDao
 *@作者: CC
 *@功能：DB-资产数据
 *@详细：连接DB,插入/查询数据。
 *@版本：1.0
 *@日期：2016-9-7
 *@说明：
 *	          对应MyAssetsMapper.xml
 */
public interface MyAssetsDao {

	/**查询资产信息
	 * @param s_id
	 * @return
	 */
	public List<Map<String, Object>> getMyAssets(int s_id);
	
	/**
	 * 用于计算总页数
	 * @param s_id
	 * @return
	 */
	int getRowCount(int s_id);
}
