package com.shangtheme.client.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.service.OtherService;


/**
 * 类名：RecommendationController
 * author : CC
 * 功能：新品推荐访问层
 * 详细：通过本类可以查询。
 * 版本：1.0
 * 日期：2016-9-6
 * 说明：
 *	         添加获取首页轮播广告信息   -add by yangzy 2016/10/13
 */
@Controller
public class RecommendationController {
	
	@Resource
	private OtherService recommendationService;

	/**
	 *  新品推荐
	 * @param request
	 * @return
	 */
	@RequestMapping("/doRecommendation.do")
	public String doRecommendation(HttpServletRequest request){
		
		ReturnStatus status = recommendationService.doRecommendation();
		if (status.getStatus()==0) {
			@SuppressWarnings("unchecked")
			Map<String, Object> data = (Map<String, Object>) status.getData();
			request.getSession().setAttribute("homeinfo", data);
		}
		return "index.jsp";
	}
	
}
