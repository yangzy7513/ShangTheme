package com.shangtheme.manager.service;

import com.shangtheme.client.entity.ReturnStatus;

/**
 *@类名：CollectionService
 *@作者: CC
 *@功能：登陆、注册访问层
 *@详细：管理员的登陆、注册。
 *@版本：1.0
 *@日期：2016-9-11
 *@说明：
 *	         必须有实现类,可拓展并在此处说明.
 */
public interface LogInAndRegisterService {

	/**检查用户名是否被占用
	 * @param user_name
	 * @return
	 */
	public ReturnStatus check_name(String user_name); 
	
	/** 注册
	 * @param user
	 * @param password
	 */
	public ReturnStatus  doRegister(String user,String password);
	
	/** 登陆
	 * @param user
	 * @param password
	 */
	public ReturnStatus doLogin(String user,String password);

}
