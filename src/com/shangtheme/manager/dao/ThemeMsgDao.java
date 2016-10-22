package com.shangtheme.manager.dao;

import com.shangtheme.client.entity.Theme;


/**
 * 类名：ThemeMsgDao
 * 作者: CC
 * 功能：主題管理
 * 详细：詳細管理主題。
 * 版本：1.0
 * 日期：2016-9-17
 * 说明：
 */
public interface ThemeMsgDao {

	
	/**
	 * 更新主题 
	 *
	 * @param theme
	 */
	public void upLoadTheme(Theme theme);
	
	/**
	 * 获取数据库中最后一条数据的主题ID
	 * 
	 * @return
	 */
	public int getLastThemeId();
	
}
