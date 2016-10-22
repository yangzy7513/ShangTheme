package com.shangtheme.manager.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shangtheme.client.common.CommonUtil;
import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.Theme;
import com.shangtheme.manager.dao.ThemeMsgDao;
import com.shangtheme.manager.service.ThemeMsgService;

/**
 * 类名：ThemeMsgController
 * 作者: CC
 * 功能：主題管理
 * 详细：詳細管理主題。
 * 版本：1.0
 * 日期：2016-9-17
 * 说明：
 *	        可拓展并在此处说明.      
 */
@Controller
public class ThemeMsgController {

	/**
	 * log4j日志
	 */
	private static Logger logger = Logger.getLogger(ThemeMsgController.class);
	
	@Resource
	private ThemeMsgService themeMsgService;
	@Resource
	private ThemeMsgDao themeMsgDao;
	
	/** 主題上傳 -信息上傳
	 * @param themeName
	 * @param author
	 * @param price
	 * @param discount
	 * @param vip
	 * @param status
	 * @param brand
	 * @param firmware
	 * @param category
	 * @param upload
	 * @param introduction
	 * @throws IOException 
	 */
	@RequestMapping("/uploadtheme.do")
	public void doUploadTheme (
			String themeName , 
			String author ,
			Double price ,
			int discount ,
			int vip ,
			int status ,
			String brand ,
			String firmware ,
			String upload ,
			String category ,
			String introduction,
			HttpServletResponse response,
			HttpSession session) throws IOException {
		
		Theme theme = new Theme();
		//
		List<String> Path = (List<String>) session.getAttribute("path");
		String downloadPath = Path.get(0);
		String picPath = Path.get(1) + "&"+ Path.get(2) + "&"+ Path.get(3)+ "&" +Path.get(4);
		theme.setT_themename(themeName);
		theme.setT_author(author);
		theme.setT_price(price);
		theme.setT_discount(discount);
		theme.setT_vip(vip);
		theme.setT_status(status);
		theme.setB_id(Integer.parseInt(brand));
		theme.setT_picpath(picPath);
		theme.setT_firmware(firmware);
		theme.setT_category(category);
		theme.setT_downloadpath(downloadPath);
		theme.setT_abstract(introduction);
		theme.setT_registerdate(CommonUtil.getDate("yyyy/MM/dd HH:mm:ss"));
		
		ReturnStatus sts =  themeMsgService.doUploadThemeMsg(theme);
		if (sts.getStatus()==0) {
			session.setAttribute("theme", theme);
			response.sendRedirect("manager/thememsg.jsp?sts=1");
		}
	}
	
	@RequestMapping("/uploadthemephotos.do")
	public @ResponseBody ReturnStatus uploadThemePhotos(MultipartHttpServletRequest multipartRequest, HttpSession session){
		ReturnStatus status = new ReturnStatus();
		//获取下一条数据的主题ID
		int themeId = themeMsgDao.getLastThemeId() + 1; 
		//
		String pathDir = "";
		List<String> path = new ArrayList<>();
		Map<String, Object> fileMap = new HashMap<String, Object>();
		
		for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
			String key = (String) it.next();
			//页面控件的文件流
			MultipartFile imgFile = multipartRequest.getFile(key);
			
			//获取文件的后缀 TODO
			String suffix = imgFile.getOriginalFilename().
					substring(imgFile.getOriginalFilename().lastIndexOf(".")+1);
			// 要保存的路径
			if (suffix.equals("zip") || suffix.equals("rar") || suffix.equals("7z")) {
				pathDir = "database/theme/themePackage/" + themeId;
			} else {
				pathDir = "database/theme/picture/" + themeId;
			}
			// 得到图片保存目录的真实路径
			String themephotoRealPathDir = multipartRequest.getSession().getServletContext().getRealPath(pathDir);
			//根据真实路径创建目录
			File fileSave = new File(themephotoRealPathDir);
			if (!fileSave.exists()) {
				fileSave.mkdirs();
			}
			
			//主题ID(加密)
			String name = DigestUtils.md5Hex(imgFile.getOriginalFilename())+"."+suffix;
			//全路径
			String fileName = themephotoRealPathDir+File.separator+name;
			File file = new File(fileName);
		
			try {
				imgFile.transferTo(file);
				path.add(pathDir+"/"+name);
				status.setStatus(0);
				status.setMsg("上传"+DBMsgUtil.getStatusMsgByCode(0));
			} catch (Exception e) {
				logger.error("主题图片上传异常:Error Code306" , e);
				file.delete();
				status.setStatus(306);
				status.setMsg(DBMsgUtil.getStatusMsgByCode(306));
			}
		
		}
		session.setAttribute("path", path);
		return status;
	}
	
	
	
}
