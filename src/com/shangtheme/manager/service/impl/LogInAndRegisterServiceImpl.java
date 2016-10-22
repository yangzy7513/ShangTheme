package com.shangtheme.manager.service.impl;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.manager.controller.ADController;
import com.shangtheme.manager.dao.LogInAndRegisterDao;
import com.shangtheme.manager.entity.MuserEntity;
import com.shangtheme.manager.service.LogInAndRegisterService;

/**
 * 类名：ColletionServiceImpl
 * 作者: CC
 * 功能：登陆、注册访问层
 * 详细：管理员的登陆、注册。
 * 版本：1.0
 * 日期：2016-09-10
 * 说明：
 *
 */
@Service
public class LogInAndRegisterServiceImpl implements LogInAndRegisterService {

	/**
	 * log4j日志
	 */
	private static Logger logger = Logger.getLogger(LogInAndRegisterServiceImpl.class);
	
	@Resource
	private LogInAndRegisterDao logInAndRegisterDao;
	
	/* 
	 *  检查用户名是否被占用
	 */
	@Override
	public ReturnStatus check_name(String user_name) {
		int count = 0;
		ReturnStatus status = new ReturnStatus();
		try {
			count = logInAndRegisterDao.getCount(user_name);
			if (count > 0) {
				status.setStatus(301);
				status.setMsg(DBMsgUtil.getStatusMsgByCode(301));
			}
			status.setStatus(0);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
			status.setData(count);
		} catch (Exception e) {
			logger.error("管理平台用户名检查异常:Error Code501" , e);
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
		}
		return status;
	}

	/* 
	 * 注册
	 * @param user 用户名 
	 * @param user 密码
	 */
	@Override
	public ReturnStatus doRegister(String user, String password) {
		
		ReturnStatus status = new ReturnStatus();
		
		MuserEntity muser = new MuserEntity();
		//H5加密
		password = DigestUtils.md5Hex(password);
		muser.setM_user_name(user);
		muser.setM_password(password);
		//注册执行
		try {
			logInAndRegisterDao.register(muser);
			status.setStatus(0);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
		} catch (Exception e) {
			logger.error("管理平台注册异常:Error Code501" , e);
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
		}
		return status;
	}

	/* 
	 * 登录成功
	 * @param user 用户名 
	 * @param user 密码
	 */
	@Override
	public ReturnStatus doLogin(String user, String password) {
		
		ReturnStatus status = new ReturnStatus();
		//密码H5加密
		password = DigestUtils.md5Hex(password);
		try {
			String getPassword = logInAndRegisterDao.getPassword(user);
			status.setStatus(0);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
			//判断密码是否正确
			if (password.equals(getPassword)) {
				status.setData(0);
			} else {
				status.setData(1);
			}
		} catch (Exception e) {
			logger.error("管理平台登录异常:Error Code501" , e);
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
		}
		return status;
	}

}
