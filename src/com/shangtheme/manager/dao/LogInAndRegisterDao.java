
package com.shangtheme.manager.dao;

import com.shangtheme.manager.entity.MuserEntity;

/**
 * 类名：LogInAndRegisterDao
 * 作者: CC
 * 功能：数据
 * 详细：
 * 版本：1.0
 * 日期：2016-9-11
 * 说明：
 *	          待補充
 */
public interface LogInAndRegisterDao {

	/** 查数据是否存在
	 * @param name
	 * @return
	 */
	public int getCount(String name);
	
	/**注册
	 * @param muserEntity
	 */
	public void register(MuserEntity muserEntity);
	
	/**登陆
	 * @param user
	 */
	public String getPassword(String user);
}
