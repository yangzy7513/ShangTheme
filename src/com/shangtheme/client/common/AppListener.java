package com.shangtheme.client.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shangtheme.manager.controller.ThemeMsgController;

/**
 *@类名：AppListener
 *@作者: yangzy
 *@功能：实时监听在线人数
 *@详细：该访问层会被实时调用，以统计实时在线人数。
 *@版本：1.0
 *@日期：2016-10-18
 *@说明：
 *	         可拓展并在此处说明.
 */
//TODO
@Controller
public class AppListener implements HttpSessionListener{
	
	/**
	 * log4j日志
	 */
	private static Logger logger = Logger.getLogger(AppListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext ctx = session.getServletContext();
		Integer count = (Integer) ctx.getAttribute("count");
		if (count == null) {
			count = 1;
		} else {
			count++;
		}
		logger.warn("一位用户登录");
		ctx.setAttribute("count", count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext ctx = 
			session.getServletContext();
		Integer count = 
			(Integer)ctx.getAttribute("count");
		if (count != null && count.intValue() > 0) {
			count --;
			ctx.setAttribute("count", count);
		}
		logger.warn("一位用户退出");
	}
	
	/**
	 * 获取实时在线人数
	 * @param session
	 * @return
	 */
	@RequestMapping("/getonlinenum.do")
	public @ResponseBody int getOnlineNumAction(HttpSession session){
		Integer count = (Integer) session.getServletContext().getAttribute("count");
		int num =   ( count == null ?   0 : count.intValue() );
		return num;
	}
	
}
