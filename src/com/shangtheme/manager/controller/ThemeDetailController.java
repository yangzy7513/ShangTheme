package com.shangtheme.manager.controller;

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

import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.manager.service.ThemeDetailService;

/**
 * 类名：ThemeDetailController
 * 作者: CC
 * 功能：登陆、注册访问层
 * 详细：管理员的管理主题。
 * 版本：1.0
 * 日期：2016-9-15
 * 说明：
 *	        可拓展并在此处说明.      
 */
@Controller
public class ThemeDetailController {
	
	@Resource
	private ThemeDetailService themeDetailService;

	/**
	 *  显示主题信息列表
	 * @return 
	 * @throws IOException 
	 */
	@RequestMapping("/showtheme.do")
	public void showThemeList(int pageNum ,
							HttpServletResponse response,
							HttpServletRequest request, 
							HttpSession session)
							throws IOException{
		
		ReturnStatus status = themeDetailService.showTheme(pageNum);
		
		String user = (String) session.getAttribute("user");
		if (user == null || user == "") {
			session.setAttribute("themeList", "");
			return;
		}
		//总行数
		int count = themeDetailService.getCount(pageNum);
		if (status.getStatus() == 0) {
			List<Map<String, Object>> themeList = (List<Map<String, Object>>) status.getData();
			//分页页数
			int pageCount = count / 8 + (count % 8 > 0 ? 1 : 0)  ;
			session.setAttribute("themeList", themeList);
			session.setAttribute("pageCount", pageCount);
			session.setAttribute("pageNum", pageNum);
			
		}
		response.sendRedirect("manager/themelist.jsp");
	}

	/**
	 * 顯示所選主題信息
	 * @param t_id
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/showdetail.do")
	public @ResponseBody
	ReturnStatus showThemeDetail(int t_id, HttpSession session) throws IOException {

		ReturnStatus status = themeDetailService.showDetail(t_id);
		if (status.getStatus() == 0) {
			session.setAttribute("theme", status.getData());
		}
		return status;
	}
	
	@RequestMapping("/dealtheme.do")
	public @ResponseBody ReturnStatus deleteTheme (String themeId, String buttonId, HttpServletResponse response){
		
		
		String[] themeIdAry = themeId.split(",");
		//調用service 處理數據
		ReturnStatus status = themeDetailService.dealTheme(themeIdAry, buttonId,response);
		return status;
	}
	
}
