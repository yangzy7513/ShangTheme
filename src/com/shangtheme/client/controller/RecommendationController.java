package com.shangtheme.client.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.service.OtherService;


/**
 *@类名：RecommendationController
 *@作者: CC
 *@功能：新品推荐访问层
 *@详细：通过本类可以查询。
 *@版本：1.0
 *@日期：2016-9-6
 *@说明：
 *	         
 */
@Controller
public class RecommendationController {
	
	@Resource
	private OtherService recommendationService;
	
	/** 新品推荐
	 * @param request
	 * @param response
	 * @throws ServletException 
	 * @throws IOException
	 */
	@RequestMapping("/doRecommendation.do")
	@Cacheable(value="Recommendation",key="#data")
	public String doRecommendation(HttpServletRequest request){
		
		ReturnStatus status = recommendationService.doRecommendation();
		
		if (status.getStatus()==0) {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> data = (List<Map<String, Object>>) status.getData();
			request.getSession().setAttribute("Recommendation", data);
		}
		
		return "index.jsp";
	}
	
}
