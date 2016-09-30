package com.shangtheme.manager.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shangtheme.manager.dao.ThemeMsgDao;
import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.Theme;
import com.shangtheme.manager.service.ThemeMsgService;

/**
 *@类名：ThemeMsgServiceImpl
 *@作者: CC
 *@功能：主題管理
 *@详细：詳細管理主題。
 *@版本：1.0
 *@日期：2016-9-17
 *@说明：
 */
@Service
public class ThemeMsgServiceImpl implements ThemeMsgService {

	@Resource
	private ThemeMsgDao themeMsgDao;
	
	@Override
	public ReturnStatus doUploadThemeMsg(Theme theme) {
		
		ReturnStatus status = new ReturnStatus();
		try {
			themeMsgDao.upLoadTheme(theme);
			status.setStatus(0);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
		} catch (Exception e) {
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
		}
		
		return status;
	}

}
