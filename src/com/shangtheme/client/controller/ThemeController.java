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

import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.SuserEntity;
import com.shangtheme.client.service.ThemeService;

/**
 *@类名：ThemeController
 *@作者: yangzy
 *@功能：用户数据访问层
 *@详细：通过本类可以进行对主题进行操作。
 *@版本：1.0
 *@日期：2016-09-06
 *@说明：
 *	         可拓展并在此处说明.
 */
@Controller
public class ThemeController {
	
	@Resource
	private ThemeService themeService;
	
	@RequestMapping("/search.do")
	//TODO
	public void superSearch(String str, HttpServletRequest request, HttpServletResponse response) throws IOException{
		String searParamter = str.replaceAll(" ", "").trim();
		List<Map<String, String>> searchResult = themeService.superSearch(searParamter);
		request.getSession().setAttribute("search", searchResult);
		response.sendRedirect("html/search-result.jsp");
	}
	
	/** 获取主题信息 
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/gettheme.do")
	public @ResponseBody ReturnStatus getThemeByTid(int id , HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		HttpSession session = request.getSession();
		SuserEntity user = (SuserEntity) session.getAttribute("suser");
		Map<String, Object> list = themeService.getThemeSer(id, user != null? user.getS_id() : -1 );
		//获取显示图片路径集
		String showpath = (String) list.get("t_picpath");
		list.remove("t_picpath");
		String[]  pathStrings = showpath.split("&");
		list.put("pathList", pathStrings);
		ReturnStatus status = new ReturnStatus();
		status.setData(list);
		return status;
	}
	
	/** 显示下载按钮（判断是否已经购买该主题）  add CC
	 * @param id
	 * @return
	 */
	@RequestMapping("/showDownloadBtn.do")
	public @ResponseBody ReturnStatus showDownloadBtn(HttpServletRequest request,int id) {
		
		ReturnStatus status = new ReturnStatus();
		
		HttpSession session = request.getSession();
		
		SuserEntity user = (SuserEntity) session.getAttribute("suser");
		
		boolean result = themeService.reCount(id, user.getS_id());
		
		if (result) {
			status.setStatus(0);
		}else {
			status.setStatus(1);
		}
		return status;
	}
	
	/**
	 * 根据手机品牌略称，查询该品牌下所有主题
	 * @param brandname
	 * @throws IOException 
	 */
	@RequestMapping("/getbrandtheme.do")
	public void getThemeByBrand(String brandname, HttpServletRequest request, HttpServletResponse response) throws IOException{
		 Map<String, Object> themeList = themeService.searchThemeByBrand(brandname);
		request.getSession().setAttribute("brandtheme", themeList);
		response.sendRedirect("html/brandtheme.jsp");
	}
	
	
	
	
	
	
}
