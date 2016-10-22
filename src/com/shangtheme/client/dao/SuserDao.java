package com.shangtheme.client.dao;

import com.shangtheme.client.entity.SuserEntity;

/**
 * 类名：SuserDao
 * 作者: yangzy
 * 功能：DB-用户数据
 * 详细：连接DB,获取数据。
 * 版本：3.0
 * 日期：2016-9-3
 * 说明：
 *	          对应SuserMapper.xml.
 */
public interface SuserDao{
	
	//根据用户名查询
	public SuserEntity findUserByUsername(String username);
	
	//手机号登录
	public SuserEntity findUserByPhonenum(String phonenum);
	
	//根据ID查询用户信息
	public SuserEntity findUserById(int id);
	
	//个人信息更新
	public void updateUserById(SuserEntity suser);
	
	//注册
	public void register_suser(SuserEntity suser);
	
	//存储头像路径
	public void uploadHeadPath(SuserEntity suser);
	
	//重置密码
	public void resetPwd(SuserEntity suser);
}
