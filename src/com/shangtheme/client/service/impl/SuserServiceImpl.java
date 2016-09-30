package com.shangtheme.client.service.impl;


import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.shangtheme.client.common.CommonUtil;
import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.dao.DBDao;
import com.shangtheme.client.dao.SuserDao;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.SuserEntity;
import com.shangtheme.client.service.SuserService;

/**
 *@类名：SuserServiceImpl
 *@作者: yangzy
 *@功能：用户管理服务接口实现类
 *@详细：此类进行详细获取数据的过程
 *@版本：1.0
 *@日期：2016-8-14
 *@说明：
 *	         如需拓展功能，务必先在SuserService中声明.
 */
@Service
public class SuserServiceImpl implements SuserService {
	
	@Resource
	private SuserDao suserDao;
	
	@Resource
	private DBDao dbDao;
	
	@Override
	public ReturnStatus checkLogin(String loginname, String password, String pagestatus) {
		ReturnStatus status = new ReturnStatus();
		//pagestatus为"1"前台输入昵称的情况
		if ("1".equals(pagestatus)) {
			SuserEntity suser = suserDao.findUserByUsername(loginname);
			if (suser == null) {
				status.setStatus(303);
				status.setMsg(DBMsgUtil.getStatusMsgByCode(303));
				return status;
			}
			if (!DigestUtils.md5Hex(password).equals(suser.getS_password())) {
				status.setStatus(304);
				status.setMsg(DBMsgUtil.getStatusMsgByCode(304));
				return status;
			}
			status.setStatus(0);
			status.setMsg("登录"+DBMsgUtil.getStatusMsgByCode(0));
			status.setData(suser);
			return status;
		}
		
		//pagestatus为"2"前台输入手机号的情况
		if ("2".equals(pagestatus)) {
			SuserEntity suser = suserDao.findUserByPhonenum(CommonUtil.encodeBase64(loginname));
			if (suser == null) {
				status.setStatus(303);
				status.setMsg(DBMsgUtil.getStatusMsgByCode(303));
				return status;
			}
			if (!DigestUtils.md5Hex(password).equals(suser.getS_password())) {
				status.setStatus(304);
				status.setMsg(DBMsgUtil.getStatusMsgByCode(304));
				return status;
			}
			status.setStatus(0);
			status.setMsg("登录"+DBMsgUtil.getStatusMsgByCode(0));
			status.setData(suser);
			return status;
			
		}
		return null;
		
	}

	@Override
	public ReturnStatus registerCheck(String username, String password, String phonenum) throws Exception{
		
		ReturnStatus status = new ReturnStatus();
		
		SuserEntity repeatEntity = suserDao.findUserByUsername(username);
		SuserEntity repeatNum = suserDao.findUserByPhonenum(DigestUtils.md5Hex(phonenum));
		if (repeatEntity != null) {
			status.setStatus(301);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(301));
			return status;
		}
		if (repeatNum != null) {
			status.setStatus(302);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(302));
			return status;
		}
		
		SuserEntity suser = new SuserEntity();
		suser.setS_username(username);
		suser.setS_password(DigestUtils.md5Hex(password));
		//会员默认未开启
		suser.setS_checkvip(0);
		suser.setS_headphoto("database/head/default");
		suser.setS_phonenum(CommonUtil.encodeBase64(phonenum));
		try {
			suserDao.register_suser(suser);
			status.setStatus(0);
			status.setMsg("注册"+DBMsgUtil.getStatusMsgByCode(0));
			return status;
		} catch (Exception e) {
			status.setStatus(501);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(501));
			e.printStackTrace();
			return status;
		}
		
	}

	@Override
	public ReturnStatus resetPwdService(String phonenum, String newPwd) {
		ReturnStatus status = new ReturnStatus();
		SuserEntity user = new SuserEntity();
		
		user.setS_phonenum(CommonUtil.encodeBase64(phonenum));
		user.setS_password(DigestUtils.md5Hex(newPwd));
		try {
			suserDao.resetPwd(user);
			status.setStatus(0);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			status.setStatus(306);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(306));
			return status;
		}
	}

	@Override
	public ReturnStatus phoneRegisteredCheck(String phonenum) {
		ReturnStatus status = new ReturnStatus();
		SuserEntity user = suserDao.findUserByPhonenum(CommonUtil.encodeBase64(phonenum));
		if (user == null) {
			status.setStatus(308);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(308));
			return status;
		}
		status.setStatus(0);
		return status;
	}

	@Override
	public ReturnStatus updateUserInfo(SuserEntity user) {
		ReturnStatus status = new ReturnStatus();
		try {
			suserDao.updateUserById(user);
			status.setStatus(0);
			status.setMsg("更新"+DBMsgUtil.getStatusMsgByCode(0));
			return status;
			
		} catch (Exception e) {
			e.printStackTrace();
			status.setStatus(306);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(306));
			return status;
		}
	}

}
