package com.shangtheme.client.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shangtheme.client.dao.ThemeDao;
import com.shangtheme.client.entity.Assets;
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
 *			 修改了免费主题下载方式 	-yangzy 2016/10/17
 */
@Controller
public class ThemeController {
	
	@Resource
	private ThemeService themeService;
	
	@Resource
	private ThemeDao themeDao;
	
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
	
	/**
	 * 主题下载API
	 * @param id
	 * @param session
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/downloadtheme.do")
	public void downloadThemeAction(int id, int  flag, HttpSession session,HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		SuserEntity user = (SuserEntity) session.getAttribute("suser");
		String  downloadpath = "";
		if (flag == 1) {
			//收费主题
			Assets assets = new Assets();
			assets.setT_id(id);
			assets.setS_id(user.getS_id());
			//db中查询到的主题保存地址
			downloadpath =  themeDao.getDownloadPath(assets);
		} else {
			//免费主题
			downloadpath = themeDao.getFreeDownloadPath(id);
		}
		response.setContentType("multipart/form-data");
		response.setHeader("Content-disposition","attachment;filename="+downloadpath.substring(downloadpath.lastIndexOf("/")+1));
		//文件物理地址
		String realpath = request.getSession().getServletContext().getRealPath(downloadpath);
		InputStream is = new FileInputStream(new File(realpath));
		
		OutputStream os = response.getOutputStream();
		IOUtils.copy(is, os);
		byte[] b = new byte[2048];
		int length;
		while ((length = is.read(b)) > 0 ) {
			os.write(b, 0, length);
		}
		os.close();
		is.close();
	}
	
}
