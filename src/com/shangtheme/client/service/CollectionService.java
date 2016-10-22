package com.shangtheme.client.service;

import java.util.List;

import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.Theme;

/**
 * 类名：CollectionService
 * 作者: CC
 * 功能：收藏信息服务接口
 * 详细：控制器会调用此接口
 * 版本：1.0
 * 日期：2016-9-4
 * 说明：
 *	         必须有实现类,可拓展并在此处说明.
 *			添加猜测用户喜欢服务组件   2016/10/16   yangzy   
 */
public interface CollectionService {
	
	//TODO
	public void doCollection(int collecflag,  int t_id,int s_id);
	
	
	/**
	 * 分页查询用户收藏主题
	 * @param s_id
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	ReturnStatus queryByPage(int s_id, Integer pageNo, Integer pageSize);
	
	/**
	 * 猜测用户喜欢的主题
	 */
	 List<Theme> guessCustomlike(int s_id);
	
	
}
