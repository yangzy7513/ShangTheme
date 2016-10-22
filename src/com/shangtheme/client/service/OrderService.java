package com.shangtheme.client.service;

import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.SuserEntity;

/**
 * 类名：OrderService
 * 作者: yangzy
 * 功能：订单管理服务接口
 * 详细：控制器会调用此接口
 * 版本：1.0
 * 日期：2016-9-3
 * 说明：
 *	         必须有实现类,可拓展并在此处说明.
 */
public interface OrderService {
	
	/**
	 * 加入购物车服务
	 * @param t_id
	 * @return
	 */
	public ReturnStatus addShopCard(SuserEntity user,int t_id, int vip);
	
	/**
	 * 获取订单信息服务
	 * @param id
	 * @return
	 */
	public ReturnStatus getOrder(int id);

	/**
	 * 删除单条订单数据服务
	 * @param o_id
	 * @param s_id
	 * @return
	 */
	public ReturnStatus delOrderById(int o_id, int s_id);
	
}
