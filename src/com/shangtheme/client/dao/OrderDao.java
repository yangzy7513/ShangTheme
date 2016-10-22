package com.shangtheme.client.dao;

import java.util.List;
import java.util.Map;

import com.shangtheme.client.entity.Order;

/**
 * 类名：OrderDao
 * 作者: yangzy
 * 功能：DB-订单数据
 * 详细：连接DB,获取数据。
 * 版本：1.0
 * 日期：2016-9-3
 * 说明：
 *	          对应OrderMapper.xml.
 */
public interface OrderDao {
	
	/**
	 * 查询订单是否存在
	 * @param order
	 */
	public Order findShop(Order order);
	
	/**
	 * 加入购物车
	 * @param order
	 */
	public void addShopCart(Order order);
	
	/**
	 * 根据用户ID,查询名下未完成的订单数据
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> findOrderByUserId(int id);

	/**
	 * 根据订单表ID，删除单条订单数据
	 * @param order
	 */
	public void delOrderById(Order order);
	
	
}
