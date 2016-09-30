package com.shangtheme.client.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.dao.DBDao;
import com.shangtheme.client.dao.RecommendationDao;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.service.OtherService;

/**
 *@类名：RecommendationServiceImpl
 *@作者: CC
 *@功能：新品推荐服务接口实现类
 *@详细：此类进行详细获取数据的过程
 *@版本：1.0
 *@日期：2016-09-06
 *@说明：
 *	         
 */

@Service
public class OtherServiceImpl implements OtherService {
	
	@Resource
	private RecommendationDao recommendationDao;
	
	@Resource
	private DBDao dbDao;

	@Override
	public ReturnStatus doRecommendation() {
		ReturnStatus status = new ReturnStatus();
		
		try {
			List<Map<String, Object>> result = recommendationDao.doRecommendation();
			status.setData(result);
			status.setStatus(0);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
			return status;
		} catch (Exception e) {
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
			return status;
		}
		
	}

}
