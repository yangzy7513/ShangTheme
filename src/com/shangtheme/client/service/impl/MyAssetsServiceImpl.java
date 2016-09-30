package com.shangtheme.client.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.shangtheme.client.common.CommonUtil;
import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.dao.MyAssetsDao;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.service.MyAssetsService;

/**
 * @类名：MyAssetsServiceImpl
 * @作者: CC
 * @功能：资产信息服务接口实现类
 * @详细：此类进行详细获取数据的过程
 * @版本：1.0
 * @日期：2016-09-07
 * @说明： 如需拓展功能，务必先在MyAssetsService中声明.
 */

@Service
public class MyAssetsServiceImpl implements MyAssetsService {

	@Resource
	private MyAssetsDao myAssetsDao;

	@Override
	public ReturnStatus getMyAssets(int s_id, Integer pageNo, Integer pageSize) {

		// 资产总数
		int count = myAssetsDao.getRowCount(s_id);
		// 显示总页数
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		
		pageNo = pageNo==null ? 1 : pageNo;
		pageSize = pageSize == null ?  CommonUtil.PAGESIZE : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> themeResult = myAssetsDao.getMyAssets(s_id);
		
		//打包带走（压到map）
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("pageCount", pageCount);
		result.put("themeResult", themeResult);
		
		ReturnStatus status = new ReturnStatus();
		try {
			status.setStatus(0);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
			status.setData(result);
			return status; 
		} catch (Exception e) {
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
			return status;
		}
		
	}

}
