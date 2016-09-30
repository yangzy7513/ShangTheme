package com.shangtheme.client.service;

import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.SuserEntity;

/**
 *@类名：SuserService
 *@作者: yangzy
 *@功能：用户管理服务接口
 *@详细：控制器会调用此接口
 *@版本：3.0
 *@日期：2016-9-3
 *@说明：
 *	         必须有实现类,可拓展并在此处说明.
 */
public interface SuserService {

	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	public ReturnStatus checkLogin(String loginname, String password,String pagestatus);
	
	/**
	 * 注册
	 * @param username
	 * @param password
	 * @param sex
	 * @param birthday
	 * @param phonenumm
	 * @return
	 */
	public ReturnStatus registerCheck(String username, String password, String phonenumm) throws Exception;
	
	/**
	 * 用户信息更新
	 * @param user
	 * @return
	 */
	public ReturnStatus updateUserInfo(SuserEntity user);
	
	/**
	 * 密码重置
	 * @param phonenumm
	 * @return
	 */
	public ReturnStatus resetPwdService(String phonenum, String newPwd);
		
	/**
	 * 验证手机号是否注册过
	 * @param phonenum
	 * @return
	 */
	public ReturnStatus phoneRegisteredCheck(String phonenum);
}
