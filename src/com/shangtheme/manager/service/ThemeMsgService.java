package com.shangtheme.manager.service;

import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.Theme;


/**
 *@类名：ThemeMsgService
 *@作者: CC
 *@功能：主題管理
 *@详细：詳細管理主題。
 *@版本：1.0
 *@日期：2016-9-17
 *@说明：
 *	      
 */
public interface ThemeMsgService {

	
	/** 上傳主題
	 * @param theme
	 * @return
	 */
	public ReturnStatus doUploadThemeMsg(Theme theme);
}
