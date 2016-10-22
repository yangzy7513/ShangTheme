package com.shangtheme.client.controller;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shangtheme.client.common.CommonUtil;
import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.dao.SuserDao;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.SuserEntity;
import com.shangtheme.client.service.SuserService;

/**
 *@类名：CustomerActiveController
 *@作者: yangzy
 *@功能：用户数据访问层
 *@详细：通过本类可以进行登陆、注册等检查。
 *@版本：1.0
 *@日期：2016-08-28
 *@说明：
 *	         可拓展并在此处说明.
 */
@Controller
public class SuserController {
	
	/**
	 * log4j日志
	 */
	private static Logger logger = Logger.getLogger(SuserController.class);
	
	@Resource
	private SuserService suserService;
	
	@Resource
	private SuserDao suserDao;

	/**
	 * 注册
	 * @param username
	 * @param password
	 * @param phonenum
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/register.do")
	public @ResponseBody ReturnStatus registerCustomer(String username, String password,
			String phonenum, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");		
		ReturnStatus returnStatus = suserService.registerCheck(username, password,phonenum);
		return returnStatus;
	}
	
	/**
	 * 头像上传
	 * @param request
	 * @return
	 */
	@RequestMapping("/dofileupload.do")
	public @ResponseBody ReturnStatus uploadHeadPhoto(HttpServletRequest request){
		ReturnStatus status = new ReturnStatus();
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		//要保存的路径
		String pathDir = "database/head";
		//得到图片保存目录的真实路径
		String headphotoRealPathDir = request.getSession().getServletContext().getRealPath(pathDir);
		//根据真实路径创建目录
		File fileSave = new File(headphotoRealPathDir);
		if (!fileSave.exists()) {
			fileSave.mkdirs();
		}
		//页面控件的文件流
		MultipartFile multipartFile = multipartHttpServletRequest.getFile("doc");
		//TODO:获取文件的后缀
		String suffix = multipartFile.getOriginalFilename().
				substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		SuserEntity user = (SuserEntity) request.getSession().getAttribute("suser");
		//头像名称
		String name = user.getS_username();
		//全路径
		String fileName = headphotoRealPathDir+File.separator+name+suffix;
		File file = new File(fileName);
		
		try {
			multipartFile.transferTo(file);
			user.setS_headphoto(pathDir+"/"+name+".png");
			suserDao.uploadHeadPath(user);
			status.setStatus(0);
			status.setMsg("注册"+DBMsgUtil.getStatusMsgByCode(0));
			return status;
		} catch (Exception e) {
			logger.error("用户头像上传异常:Error Code306" , e);
			file.delete();
			status.setStatus(306);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(306));
			return status;
		}
	}
	
	/**
	 * 检查用户名
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkusername.do")
	public @ResponseBody ReturnStatus checkUsernameAction(String username){
		ReturnStatus status = new ReturnStatus();
		SuserEntity uEntity = suserDao.findUserByUsername(username);
		if (uEntity == null) {
			//用户名可用
			status.setStatus(0);
			return status;
		} else {
			status.setStatus(301);
			return status;
		}
	}
	
	/**
	 * 手机注册检查
	 * @param phonenum
	 * @return
	 */
	@RequestMapping("/phonecheck.do")
	public @ResponseBody ReturnStatus phoneRegisteredCheck(String phonenum){
		ReturnStatus status = suserService.phoneRegisteredCheck(phonenum);
		return status;
	}
	
	/**
	 * 登陆检查
	 * @param loginname
	 * @param password
	 * @param pagestatus 检测是手机登录还是用户名
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/checklogin.do")
	public @ResponseBody ReturnStatus checkLogin(String loginname,   //昵称&手机号
								   String password,    //密钥
								   String pagestatus,  //前台check结果
								   HttpServletRequest request) throws IOException{
		request.setCharacterEncoding("utf-8");
		ReturnStatus status = suserService.checkLogin(loginname, password, pagestatus);
		//登陆成功
		if (status.getStatus() == 0) {
			HttpSession session = request.getSession();
			session.setAttribute("suser", (SuserEntity)status.getData());
			logger.info("用户登录:"+((SuserEntity)status.getData()).getS_username() );
		}
		return status;
	}
	
	/**
	 * 重置密码
	 * @param phonenum
	 * @param newPwd
	 * @return
	 */
	@RequestMapping("/resetpwd.do")
	public @ResponseBody ReturnStatus resetPwd(String phonenum, String newPwd){
		ReturnStatus status = suserService.resetPwdService(phonenum, newPwd);
		return status;
	}
	
	/**
	 * 个人信息资料预览
	 * @param id
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/userinfo.do")
	public @ResponseBody void getSuserAndShowAction(int id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		SuserEntity suser = suserDao.findUserById(id);
		//手机号需要解码
		String phone = CommonUtil.decodeBase64(suser.getS_phonenum());
		suser.setS_phonenum(phone);
		HttpSession session = request.getSession();
		session.setAttribute("suser", suser);
		response.sendRedirect("html/myMessage.jsp");
	}
	
	/**
	 * 用户个人资料修改
	 * @param id
	 * @param username
	 * @param phonenum
	 * @param sex
	 * @param birthday
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/updatesuserinfo.do")
	public @ResponseBody void updateSuserAction(String id,String username, String phonenum, 
					String sex, String birthday,HttpServletRequest request , HttpServletResponse response ) throws IOException{
		SuserEntity user = new SuserEntity();
		user.setS_id(Integer.parseInt(id));
		user.setS_username(username);
		user.setS_phonenum(CommonUtil.encodeBase64(phonenum));
		user.setS_sex(sex);
		user.setS_birthday(birthday);
		user.setS_phonenum(CommonUtil.encodeBase64(phonenum));
		ReturnStatus status = suserService.updateUserInfo(user);
		
		user = suserDao.findUserById(Integer.parseInt(id));
		String phone = CommonUtil.decodeBase64(user.getS_phonenum());
		user.setS_phonenum(phone);
		final HttpSession session = request.getSession();
		session.setAttribute("suser", user);
		session.setAttribute("msg", status.getStatus()+"&"+status.getMsg());
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				session.removeAttribute("msg");
			}
		}, 5000);
		
		response.sendRedirect("html/myMessage.jsp");
	}
	
	/**
	 * 退出登录
	 * @throws IOException 
	 */
	@RequestMapping("/delsession.do")
	public void destroySessionAction(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.getSession().removeAttribute("suser");
		response.sendRedirect("");
	}
}
