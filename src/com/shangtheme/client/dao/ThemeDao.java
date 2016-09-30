package com.shangtheme.client.dao;

import java.util.List;
import java.util.Map;

import com.shangtheme.client.entity.Assets;
import com.shangtheme.client.entity.Brand;
import com.shangtheme.client.entity.Theme;

/**
 *@类名：ThemeDao
 *@作者: yangzy
 *@功能：DB-主题数据
 *@详细：连接DB,获取数据。
 *@版本：1.0
 *@日期：2016-9-4
 *@说明：
 *	          对应ThemeMapper.xml.
 */
public interface ThemeDao {
	
	/**
	 * 返回当前主题的相关数据
	 * @param t_id
	 * @return
	 */
	public Map<String, Object> getThemeByTid(Map<String, Integer> map);
	
	/** 判断是否已经购买该主题
	 * @param t_id
	 * @param s_id
	 * @return
	 */
	public int getThemenews(Assets assets);
	
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
	 * 查询品牌下的所有主题
	 */
	public List<Theme> searchByBrandname(String enname);
	
}
