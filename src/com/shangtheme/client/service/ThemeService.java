package com.shangtheme.client.service;

import java.util.List;
import java.util.Map;

/**
 *@类名：ThemeService
 *@作者: yangzy
 *@功能：主题管理服务接口
 *@详细：控制器会调用此接口
 *@版本：1.0
 *@日期：2016-9-4
 *@说明：
 *	         必须有实现类,可拓展并在此处说明.
 */
public interface ThemeService {
	
	/** 获取主题信息
	 * @param id
	 * @return
	 */
	public Map<String, Object> getThemeSer(int tid, int sid);
	
	/** 显示下载按钮（判断是否已经购买该主题） add CC
	 * @param t_id
	 * @param s_id
	 * @return
	 */
	public boolean reCount(int t_id,int s_id);
	
	/**
	 * 搜索引擎
	 * @param str
	 * @return
	 */
	public List<Map<String, String>> superSearch(String str);
	
	/**
	 * 根据手机品牌查询主题
	 * @return
	 */
	public Map<String, Object> searchThemeByBrand(String brandname);
	
	
	
}
