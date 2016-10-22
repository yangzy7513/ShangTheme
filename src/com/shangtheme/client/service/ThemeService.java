package com.shangtheme.client.service;

import java.util.List;
import java.util.Map;

/**
 * 类名：ThemeService
 * 作者: yangzy
 * 功能：主题管理服务接口
 * 详细：控制器会调用此接口
 * 版本：1.0
 * 日期：2016-9-4
 * 说明：
 *	         必须有实现类,可拓展并在此处说明.
 */
public interface ThemeService {

	/**
	 * 获取主题信息
	 * @param tid
	 * @param sid
	 * @return
	 */
	public Map<String, Object> getThemeSer(int tid, int sid);
	
	/**
	 * 搜索引擎
	 * @param str
	 * @return
	 */
	public List<Map<String, String>> superSearch(String str);
	
	/**
	 * 根据手机品牌查询前三下载主题
	 * @return
	 */
	public Map<String, Object> searchThemeByBrand(String brandname);
	
	
	
}
