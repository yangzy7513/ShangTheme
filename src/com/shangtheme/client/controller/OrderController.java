package com.shangtheme.client.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.SuserEntity;
import com.shangtheme.client.service.OrderService;

/**
 *@类名：OrderController
 *@作者: yangzy
 *@功能：订单数据访问层
 *@详细：通过本类可以进行相应订单操作。
 *@版本：1.0
 *@日期：2016-9-3
 *@说明：
 *	         可拓展并在此处说明.
 */
@Controller
public class OrderController {
	
	@Resource
	private OrderService orderService;
	
	/**
	 * 添加购物车
	 * @param id
	 * @param vip
	 * @param request
	 * @return
	 */
	@RequestMapping("/addshopcard.do")
	public @ResponseBody ReturnStatus addShopCardAction(int id, int vip, HttpServletRequest request){
		SuserEntity user = (SuserEntity) request.getSession().getAttribute("suser");
		ReturnStatus status = orderService.addShopCard(user, id, vip);
		return status;	
	}
	
	/**
	 * 获取订单表
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/getorder.do")
	public void getOrderAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		HttpSession session = request.getSession();
		SuserEntity user = (SuserEntity)session.getAttribute("suser");
		
		ReturnStatus status = orderService.getOrder(user.getS_id());
		if (status.getStatus() == 0) {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> data = (List<Map<String, Object>>)status.getData();
			session.setAttribute("order", data);
			response.sendRedirect("html/myDeal.jsp");
			//request.getRequestDispatcher("html/myDeal.jsp").forward(request, response);
			
		}
	}
	
	/**
	 * 删除订单控制
	 * @param id 主题id
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/delsingleorder.do")
	public @ResponseBody ReturnStatus delSingleOrderAction(int id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		SuserEntity user = (SuserEntity) request.getSession().getAttribute("suser");
		ReturnStatus status = orderService.delOrderById(id,user.getS_id());
		return status;
	}
	
}
