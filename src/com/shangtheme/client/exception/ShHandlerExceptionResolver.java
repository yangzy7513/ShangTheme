package com.shangtheme.client.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.shangtheme.client.controller.SuserController;

/**
 * 类名：ShHandlerExceptionResolver
 * 作者: yangzy
 * 功能：全局异常处理
 * 详细：捕获全局异常处理进行处理。
 * 版本：1.0
 * 日期：2016-09-04
 * 说明：
 *	          不建议在此类拓展新功能.
 */
public class ShHandlerExceptionResolver implements HandlerExceptionResolver {

	/**
	 * log4j日志
	 */
	private static Logger logger = Logger.getLogger(ShHandlerExceptionResolver.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception) {
		
		logger.error("系统发生错误:错误原因<"+exception.getMessage()+">", exception);
		System.err.println(exception);
		String viewName = "index.jsp";
		return new ModelAndView(viewName);
	}

}
