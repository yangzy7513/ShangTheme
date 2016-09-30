package com.shangtheme.manager.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shangtheme.client.common.CommonUtil;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.manager.service.LogInAndRegisterService;

/**
 *@类名：LoginAndRegisterController
 *@作者: CC
 *@功能：登陆、注册访问层
 *@详细：管理员的登陆、注册。
 *@版本：1.0
 *@日期：2016-9-11
 *@说明：
 *	        可拓展并在此处说明.      
 */
@Controller
public class LoginAndRegisterController {
	
	/**
	 *  service 注入
	 */
	@Resource
	private LogInAndRegisterService logInAndRegisterService;

	/** 检查用户名是否被占用
	 * @param user_name
	 * @return
	 */
	@RequestMapping("/checkname.do")
	public @ResponseBody ReturnStatus check_name(String user_name) {
		ReturnStatus status = logInAndRegisterService.check_name(user_name);
		return status;
	}
	
	/**
	 *  注册执行
	 * @throws IOException 
	 */
	@RequestMapping("/doregister.do")
	public void doRegister(String user , String password,HttpServletResponse response) throws IOException{
		
		ReturnStatus status = logInAndRegisterService.doRegister(user, password);
		if (status.getStatus() == 0) {
			response.sendRedirect("papapa.jsp");
		}
	}
	
	
	/** 登陆执行
	 * @param user
	 * @param password
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/dologin.do")
	public void dologin(String userName, 
						String pWords,
						HttpServletRequest request, 
						HttpServletResponse response,
						HttpSession session) 
						throws IOException, ServletException {

		ReturnStatus status = logInAndRegisterService.doLogin(userName, pWords);
		if (status.getStatus()==0) {
			if (status.getData().equals(0)) {
				session.setAttribute("user", userName);
				response.sendRedirect("manager/hello.jsp");
			} else {
				String scriptCode = "alert('请输入正确的用户名或密码');window.location.href = 'papapa.jsp';";
				CommonUtil.doSCript(scriptCode, response);
			}
		}
	}
	
	/** 退出
	 * @param session
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/managerLogOut.do")
	private void managerExit (HttpSession session , HttpServletResponse response ,HttpServletRequest request) throws IOException{
		request.getSession().removeAttribute("suser");
		response.sendRedirect("papapa.jsp");
	}
}
