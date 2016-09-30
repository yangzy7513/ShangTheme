package com.shangtheme.client.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shangtheme.client.entity.SuserEntity;

/**
 *@类名：HttpFilter
 *@作者: yangzy
 *@功能：拦截器
 *@详细：大部分请求都会被拦截器拦截,验证用户是否登录.
 *@版本：1.0
 *@日期：2016-08-14
 *@说明：
 *	       不建议在此类拓展新功能。
 */
public class HttpFilter implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws IOException {
		HttpSession session = request.getSession();
//		SuserEntity user = (SuserEntity) session.getAttribute("suser");
//		if(user == null){
//			response.sendRedirect("index.jsp");
//			return false;
//		}
		return true;
	}

}
