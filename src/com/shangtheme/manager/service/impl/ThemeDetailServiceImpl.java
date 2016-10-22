package com.shangtheme.manager.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.manager.dao.ThemeDetailDao;
import com.shangtheme.manager.service.ThemeDetailService;

@Service
public class ThemeDetailServiceImpl implements ThemeDetailService {

	@Resource
	private ThemeDetailDao themeDetailDao;

	@Override
	public ReturnStatus showTheme(int pageNum) {

		ReturnStatus status = new ReturnStatus();
		
		pageNum = (pageNum-1) * 8;
		try {
			List<Map<String, Object>> themeList = themeDetailDao.getThemeMessage(pageNum);
			status.setStatus(0);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
			status.setData(dealData(themeList,pageNum));
		} catch (Exception e) {
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
		}
		return status;
	}

	/** 处理数据
	 * @param themeList
	 * @return
	 */
	private List<Map<String, Object>> dealData( List<Map<String, Object>> themeList, int pageNum) {
		// 分成
		double proportion;
		
		List<Map<String, Object>> tList = new ArrayList<>();
		int a = themeList.size();
		int pageNumEnd = (pageNum + 8 > a) ? themeList.size() : pageNum + 8;
		
		for (int j = pageNum; j < pageNumEnd; j++) {
			
			Map<String, Object> tMap = themeList.get(j);
			tList.add(tMap);
		}
		for (int i = 0; i < tList.size(); i++) {

			Map<String, Object> themeMap = tList.get(i);

			int vip = (int) themeMap.get("t_vip");

			double price = (double) themeMap.get("t_price");

			long downloadnum = (long) themeMap.get("t_downloadnum");

			if (vip > 0) {
				proportion = 0.8;
			} else {
				proportion = 0.7;
			}
			
			String formatProportion = proportion * 100 + "%";
			
			// 纯利润
			double profit = (double) (1 - proportion) * price * downloadnum;
			// 格式化 显示两位小数 TODO
			profit = Double.parseDouble(new DecimalFormat("#.##")
					.format(profit));
			themeMap.put("proportion", formatProportion);
			themeMap.put("profit", profit);
			tList.set(i, themeMap);
		}
		return tList;
	}

	/* 
	 * 獲取當前數據條數
	 * @param pageNum 當前頁數
	 */
	@Override
	public int getCount(int pageNum) {
			List<Map<String, Object>> themeList = themeDetailDao.getThemeMessage(pageNum);
			int count = themeList.size();
		return count;
	}

	/* 
	 * 顯示所選主題信息 
	 * @param t_id 主題ID
	 */
	@Override
	public ReturnStatus showDetail(int t_id) {
		
		ReturnStatus status = new ReturnStatus();
		
		try {
			Map<String, Object> theme = themeDetailDao.getTheme(t_id);
			status.setStatus(0);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
			status.setData(theme);
		} catch (Exception e) {
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
		}
		
		return status;
	}

	
	/* 
	 * 处理主题（删除 、上架 、 下架）
	 */
	@Override
	public ReturnStatus dealTheme(String[] themeIdAry, 
								  String buttonId ,
								  HttpServletResponse response) {

		ReturnStatus status = new ReturnStatus();
		try {
			// 循環刪除數組里的每一條主題
			for (int i = 0; i < themeIdAry.length; i++) {
				int themeId = Integer.parseInt(themeIdAry[i]);
				//獲取主題當前狀態
				int themeStatus = getThemeStatus(themeId);
				//刪除操作
				if (buttonId.equals("delete")) {
					themeDetailDao.deleteTheme(themeId);
				//上架操作
				}else if (buttonId.endsWith("upStore")) {
					if (themeStatus == 1) {
						themeDetailDao.upStoreTheme(themeId);
					}else if(themeStatus == 0) {
						status.setStatus(502);
						status.setMsg(DBMsgUtil.getStatusMsgByCode(502));
					}
				//下架操作
				}else {
					if (themeStatus == 0) {
						themeDetailDao.downStoreTheme(themeId);
					}else if (themeStatus == 1) {
						status.setStatus(503);
						status.setMsg(DBMsgUtil.getStatusMsgByCode(503));
					}
				}
			status.setStatus(0);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
			}
		} catch (Exception e) {
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
		}
		
		return status;
	}

	/**
	 * 獲取主題狀態
	 * @param themeId
	 * @return
	 */
	private int getThemeStatus(int themeId) {
		int themeStatus = themeDetailDao.getThemeStatus(themeId);
		return themeStatus;
	}
}

