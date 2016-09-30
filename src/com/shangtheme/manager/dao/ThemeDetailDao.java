package com.shangtheme.manager.dao;

import java.util.List;
import java.util.Map;

/**
 *@类名：LogInAndRegisterDao
 *@作者: CC
 *@功能：数据
 *@详细：
 *@版本：1.0
 *@日期：2016-9-15
 *@说明：
 */
public interface ThemeDetailDao {
 
	/** 获取全部主题
	 * @param pageNum
	 * @return
	 */
	public List<Map<String, Object>> getThemeMessage(int pageNum);
	
	
	/**
	 * 獲取主題
	 * 
	 * @param t_id
	 * @return
	 */
	public Map<String, Object> getTheme(int t_id);
	
	/**
	 * 刪除主題
	 * 
	 * @param themeId
	 */
	public void deleteTheme (int themeId);
	
	
	/**
	 * 獲取主題狀態信息
	 * 
	 * @param themeId
	 * @return
	 */
	public int getThemeStatus(int themeId);
	
	
	/**
	 * 上架主题
	 * 
	 * @param themeId
	 */
	public void upStoreTheme(int themeId);
	
	
	/**
	 * 下架主題
	 * 
	 * @param themeId
	 */
	public void downStoreTheme(int themeId);
	
}
