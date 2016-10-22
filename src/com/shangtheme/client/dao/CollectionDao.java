package com.shangtheme.client.dao;

import java.util.List;
import java.util.Map;

import com.shangtheme.client.entity.Collection;
import com.shangtheme.client.entity.Theme;


/**
 * 类名：CollectionDao
 * 作者: CC
 * 功能：DB-收藏数据
 * 详细：连接DB,插入数据。
 * 版本：1.0
 * 日期：2016-9-4
 * 说明：
 *	          对应CollectionMapper.xml.
 *			  增加取消收藏操作.    2016/9/17    yangzy.
 */
public interface CollectionDao {
	
	/**
	 * 收藏主题
	 * @param collection
	 */
	 void doCollection (Collection collection);
	
	/**
	 * 取消收藏
	 * @param collection
	 */
	void removeCollection(Collection collection);
	
	/**
	 * 检查主题
	 * @param collection
	 * @return
	 */
	int checkCollection (Collection collection);
	
	/**
	 * 获取主题
	 * @param s_id
	 * @return
	 */
	List<Map<String, Object>> getCollection(int s_id);
	
	
	/**
	 * 根据用户ID获取其收藏的主题
	 * @param s_id
	 * @return
	 */
	List<Theme> selectCollectionBySuserid(int s_id);
	
	/**
	 * 用于计算总页数
	 * @param s_id
	 * @return
	 */
	int getRowCount(int s_id);
	
	/**
	 * 随机获取样本数据,样本中包括客户ID和客户收藏主题的id集合。
	 * @param s_id 排除用户
	 * @return
	 */
	List<Map<String, Object>> getSampleCustomer(int s_id);
	
	/**
	 * 找到推荐商品
	 * @param list
	 * @return
	 */
	List<Theme> recommendByCol(List<Integer> list );
	
}
