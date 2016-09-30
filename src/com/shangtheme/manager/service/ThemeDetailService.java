package com.shangtheme.manager.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.shangtheme.client.entity.ReturnStatus;

/**
 *@类名：ThemeDetailService
 *@作者: CC
 *@功能：数据展示
 *@详细：主题信息展示
 *@版本：1.0
 *@日期：2016-9-15
 *@说明：
 *	      
 */
public interface ThemeDetailService {

	/** 显示主题信息 service
	 * @return
	 */
	public ReturnStatus showTheme(int pageNum);
	
	/** 显示主题count
	 * @return
	 */
	public int getCount(int pageNum);
	
	
	/**显示主题
	 * @return Theme list
	 */
	public ReturnStatus showDetail(int t_id);
	
	
	/**
	 * 顯示主題
	 * 
	 * @param themeIdAry
	 * @return
	 */
	public ReturnStatus dealTheme(String[] themeIdAry, String buttonId, HttpServletResponse response);
	
}
