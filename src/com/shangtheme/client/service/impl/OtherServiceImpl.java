package com.shangtheme.client.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.dao.DBDao;
import com.shangtheme.client.dao.RecommendationDao;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.service.OtherService;

/**
 * 类名：RecommendationServiceImpl
 * 作者: CC
 * 功能：新品推荐服务接口实现类
 * 详细：此类进行详细获取数据的过程
 * 版本：1.0
 * 日期：2016-09-06
 * 说明：
 *	         添加获取轮播ad信息   -add by yangzy 2016/10/13
 */

@Service
public class OtherServiceImpl implements OtherService {
	
	/**
	 * log4j日志
	 */
	private static Logger logger = Logger.getLogger(OtherServiceImpl.class);
	
	@Resource
	private RecommendationDao recommendationDao;
	
	@Resource
	private DBDao dbDao;

	@Override
	@Cacheable(value="homeInfo")
	public ReturnStatus doRecommendation() {
		ReturnStatus status = new ReturnStatus();
		try {
			//推荐主题
			List<Map<String, Object>> themresult = recommendationDao.doRecommendation();
			//轮播广告
			List<Map<String, String>> adList = recommendationDao.getCarouselAdMsg();
			Map<String, Object> reMap = new HashMap<>();
			reMap.put("themresult", themresult);
			reMap.put("adList", adList);
			
			status.setStatus(0);
			status.setData(reMap);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
			return status;
		} catch (Exception e) {
			logger.error("展板信息系统异常>>Error code:501", e);
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
			return status;
		}
		
	}

}
