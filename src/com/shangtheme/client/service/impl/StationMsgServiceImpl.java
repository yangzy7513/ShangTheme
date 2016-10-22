package com.shangtheme.client.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.dao.DBDao;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.Umsg;
import com.shangtheme.client.service.StationMsgService;
/**
 * 类名：StationMsgServiceImpl
 * 作者: yangzy
 * 功能：站内信服务接口实现类
 * 详细：此类进行详细获取数据的过程
 * 版本：1.0
 * 日期：2016-9-11
 * 说明：
 *	         如需拓展功能，务必先在StationMsgService中声明.
 */
@Service
public class StationMsgServiceImpl implements StationMsgService{
	
	/**
	 * log4j日志
	 */
	private static Logger logger = Logger.getLogger(StationMsgServiceImpl.class);
	
	@Resource
	private DBDao dbDao;
	
	@Override
	public ReturnStatus getnewLetterService(int s_id) {
		ReturnStatus status = new ReturnStatus();
		try {
			List<Map<String, Integer>> msgidList = dbDao.findNewLetter(s_id);
			//有新消息
			if (msgidList.size() > 0) {
				status.setStatus(313);
				status.setMsg(DBMsgUtil.getStatusMsgByCode(313));
				//将消息插入到用户站内信表里
				for(Map<String, Integer> map : msgidList){
					Umsg msg = new Umsg();
					msg.setMsg_id(map.get("msg_id"));
					msg.setS_id(s_id);
					msg.setStatus(0);
					dbDao.updateUmsg(msg);
				}
				return status;
			}else {
				status.setStatus(0);
				return status;
			}
			
		} catch (Exception e) {
			logger.error("获取站内信系统异常>>Error code:501", e);
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
			return status;
		}
		
	}

	@Override
	public List<Map<String, Object>> getAllLetter(int s_id) {
		List<Map<String, Object>> relList = dbDao.getAllLetter(s_id);
		return relList;
	}

}
