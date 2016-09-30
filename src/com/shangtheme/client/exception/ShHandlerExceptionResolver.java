package com.shangtheme.client.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 *@类名：ShHandlerExceptionResolver
 *@作者: yangzy
 *@功能：全局异常处理
 *@详细：捕获全局异常处理进行处理。
 *@版本：1.0
 *@日期：2016-09-04
 *@说明：
 *	          不建议在此类拓展新功能.
 */
public class ShHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception) {
		System.err.println(">>>>>>>>>>>>异常捕获");
		
		@SuppressWarnings("unchecked")
		Map<String, Object> model = new HashedMap();
		model.put("e", exception);
		System.err.println(exception);
		String viewName = "index.jsp";
		return new ModelAndView(viewName, model);
	}

}
