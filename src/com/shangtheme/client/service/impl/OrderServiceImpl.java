package com.shangtheme.client.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shangtheme.client.common.CommonUtil;
import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.dao.OrderDao;
import com.shangtheme.client.entity.Order;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.SuserEntity;
import com.shangtheme.client.service.OrderService;
/**
 *@类名：OrderServiceImpl
 *@作者: yangzy
 *@功能：订单管理服务接口实现类
 *@详细：此类进行详细获取数据的过程
 *@版本：1.0
 *@日期：2016-8-14
 *@说明：
 *	         如需拓展功能，务必先在OrderService中声明.
 */

@Service
public class OrderServiceImpl implements OrderService {
	
	@Resource
	private OrderDao orderDao;
	
	@Override
	public ReturnStatus getOrder(int id) {
		ReturnStatus status = new ReturnStatus();
		
		try {
			List<Map<String, Object>> resultMap = orderDao.findOrderByUserId(id);
			status.setStatus(0);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
			status.setData(resultMap);
			return status;
			
		} catch (Exception e) {
			status.setStatus(306);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(306));
			return status;
		}
		
	}
	
	@Override
	public ReturnStatus delOrderById(int t_id, int s_id) {
		ReturnStatus status = new ReturnStatus();
		Order order = new Order();
		order.setT_id(t_id);
		order.setS_id(s_id);
		try {
			orderDao.delOrderById(order);
			status.setStatus(0);
			status.setMsg("删除"+DBMsgUtil.getStatusMsgByCode(0));
			return status;
		} catch (Exception e) {
			status.setStatus(309);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(309));
			return status;
		}
	}

	@Override
	public ReturnStatus addShopCard(SuserEntity user, int t_id, int vip) {
		ReturnStatus status = new ReturnStatus();
		if (user.getS_checkvip() < vip) {
			//判断是否可买vip商品
			status.setStatus(311);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(311));
			return status;
		}
		Order order = new Order();
		order.setS_id(user.getS_id());
		order.setT_id(t_id);
		order.setO_createtime(CommonUtil.getDate("yyyy/MM/dd HH:mm:ss"));
		
		Order findOrder = orderDao.findShop(order);
		if (findOrder != null) {
			//购物车存在的情况
			status.setStatus(312);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(312));
			return status;
		}
		try {
			orderDao.addShopCart(order);
			status.setStatus(0);
			status.setMsg("收藏"+DBMsgUtil.getStatusMsgByCode(0));
			return status;
		} catch (Exception e) {
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
			return status;
		}
	}

}
