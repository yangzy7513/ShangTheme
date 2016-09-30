package com.shangtheme.client.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.SuserEntity;
import com.shangtheme.client.entity.Theme;
import com.shangtheme.client.service.MyAssetsService;

/**
 * @类名：MyAssetsController.java
 * @作者: CC
 * @功能：资产信息访问层
 * @详细：通过本类可以查询/插入资产信息。
 * @版本：1.0
 * @日期：2016-9-7
 * @说明：
 * 		   可拓展并在此处说明.
 */
@Controller
public class MyAssetsController {

	@Resource
	private MyAssetsService myAssetsService;
	
	/**
	 * 获取资产信息
	 * @param request
	 * @param response
	 * @param pageNo
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/getmyassets.do")
	public @ResponseBody ReturnStatus getMyAssets(HttpServletRequest request ,HttpServletResponse response, int pageNo ) throws IOException {

		HttpSession session = request.getSession();
		SuserEntity user = (SuserEntity) session.getAttribute("suser");
		
		int pageSize = Integer.parseInt(DBMsgUtil.getStatusMsgByCode(1));
		
		ReturnStatus status = myAssetsService.getMyAssets(user.getS_id(), pageNo, pageSize);
		
		if (status.getStatus()==0) {
			@SuppressWarnings("unchecked")
			Map<String, Object> reMap = (Map<String, Object>) status.getData();
			
			@SuppressWarnings("unchecked")
			List<Theme> reList = (List<Theme>) reMap.get("themeResult");
			int pageCount = (int) reMap.get("pageCount");
			//当前页面主题
			session.setAttribute("myassets", reList);
			
			//总页数
			session.setAttribute("pageCount_a", pageCount);
			
			//当前页码
			session.setAttribute("currentPage_a", pageNo);

		}
		response.sendRedirect("html/MyAssets.jsp#"+pageNo);
		
		return status;
	}

}
