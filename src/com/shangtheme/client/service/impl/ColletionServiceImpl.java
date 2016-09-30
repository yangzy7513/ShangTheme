package com.shangtheme.client.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.shangtheme.client.common.CommonUtil;
import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.dao.CollectionDao;
import com.shangtheme.client.entity.Collection;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.Theme;
import com.shangtheme.client.service.CollectionService;


/**
 *@类名：ColletionServiceImpl
 *@作者: CC
 *@功能：收藏信息服务接口实现类
 *@详细：此类进行详细获取数据的过程
 *@版本：1.0
 *@日期：2016-09-04
 *@说明：
 *	         如需拓展功能，务必先在CollectionService中声明.
 */
@Service
public class ColletionServiceImpl  implements CollectionService {
	
	@Resource
	private CollectionDao collectionDao;
	
	@Override
	public void doCollection(int collecflag,  int t_id,int s_id) {
	//	ReturnStatus status = new ReturnStatus();
		Collection collection = new Collection();
		
		collection.setT_id(t_id);
		collection.setS_id(s_id);
		if (collecflag  == 1) {
			//未收藏状况，执行收藏
			collection.setC_createtime(CommonUtil.getDate("yyyy/MM/dd hh:mm:ss"));
			collectionDao.doCollection(collection);
		}else if (collecflag == 0) {
			//收藏状况，取消收藏
			collectionDao.removeCollection(collection);
		}
		
	}

	@Override
	public ReturnStatus queryByPage(int s_id, Integer pageNo, Integer pageSize) {
		
		int row = collectionDao.getRowCount(s_id);
		
		//总页数计算
		int pageCount = (row / pageSize) + (row % pageSize == 0 ? 0: 1);
		
		pageNo = pageNo == null ? 1:pageNo;
		pageSize = pageSize == null ?  CommonUtil.PAGESIZE : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Theme> result = collectionDao.selectCollectionBySuserid(s_id);
		
		//将结果与总页数封装到Map
		Map<String, Object> reMap = new HashMap<String, Object>();
		reMap.put("result", result);
		reMap.put("pageCount", pageCount);
		
		ReturnStatus status = new ReturnStatus();
		status.setStatus(0);
		status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
		status.setData(reMap);
		
		return status;
	}


}
