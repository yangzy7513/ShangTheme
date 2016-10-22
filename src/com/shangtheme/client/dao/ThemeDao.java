package com.shangtheme.client.dao;

import java.util.List;
import java.util.Map;

import com.shangtheme.client.entity.Assets;
import com.shangtheme.client.entity.Brand;
import com.shangtheme.client.entity.Theme;

/**
 * 类名：ThemeDao
 * 作者: yangzy
 * 功能：DB-主题数据
 * 详细：连接DB,获取数据。
 * 版本：1.0
 * 日期：2016-9-4
 * 说明：
 *	          对应ThemeMapper.xml.
 */
public interface ThemeDao {

	/**
	 * 返回当前主题的相关数据
	 * @param map
	 * @return
	 */
	public Map<String, Object> getThemeByTid(Map<String, Integer> map);
	
	/**
	 * 搜索引擎查询
	 * @return
	 */
	public List<Map<String, Object>> search();
	
	/**
	 * 获取品牌简介
	 * @param enname
	 * @return
	 */
	public Brand getBrandInfo(String enname);
	
	/**
	 * 查询品牌下的前三下载
	 */
	public List<Theme> searchByBrandname(String enname);
	
	/**
	 * 获取收费主题下载链接
	 * @param assets
	 * @return
	 */
	public String getDownloadPath(Assets assets);
	
	/**
	 * 获取免费主题的下载链接
	 * @param themeId
	 * @return
	 */
	public String getFreeDownloadPath(int themeId);
	
}
