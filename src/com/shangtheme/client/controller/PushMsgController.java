package com.shangtheme.client.controller;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shangtheme.client.dao.DBDao;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.SuserEntity;
import com.shangtheme.client.entity.Umsg;
import com.shangtheme.client.service.StationMsgService;

/**
 *@类名：PushMsgController
 *@作者: yangzy
 *@功能：页面发送弹幕控制类
 *@详细：页面发出的弹幕均会通过该类广播到相应页面。
 *@版本：1.0
 *@日期：2016-08-28
 *@说明：
 *	   	Thanks to the technology provided by goeasy.
 *		拓展：支持站内信获取  	yangzy	2016/9/12
 */
@Controller
public class PushMsgController {
	
	@Resource
	private DBDao dbDao;
	
	@Resource
	private StationMsgService msgService;
	
	/**
	 * 发送弹幕控制
	 * @param msg
	 * @param img
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/pushmsg.do")
	public void test(String msg, String img, HttpServletResponse response) throws IOException{
		
		GoEasy goEasy = new GoEasy("475987c9-e307-4842-89a0-0044306d5694");
		goEasy.publish("ShangTheme", msg, new PublishListener(){

			@Override
			public void onFailed(GoEasyError error) {
				System.err.println("Error code:"+ error.getCode() +"; error content:"+error.getContent()); 
			}
			
		});
	}
	
	/**
	 * 获取最新未读站内信
	 * @param request
	 * @return
	 */
	@RequestMapping("/checknewletter.do")
	public @ResponseBody ReturnStatus getnewLetterAction(HttpServletRequest request){
		SuserEntity user = (SuserEntity) request.getSession().getAttribute("suser");
		ReturnStatus status = msgService.getnewLetterService(user.getS_id());
		return status;
	}
	
	/**
	 * 执行查询消息
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/getletter.do")
	public void getLetterAction(HttpServletRequest request, HttpServletResponse response) throws IOException{
		SuserEntity user = (SuserEntity) request.getSession().getAttribute("suser");
		List<Map<String, Object>> list = msgService.getAllLetter(user.getS_id());
		request.getSession().setAttribute("letter", list);
		response.sendRedirect("html/general.jsp");
	}
	
	/**
	 * 修改站内信状态为已读
	 * @param msgid
	 */
	@RequestMapping("/changetoread.do")
	public void changeToReadAction(int msgid, HttpServletRequest request){
		SuserEntity user = (SuserEntity) request.getSession().getAttribute("suser");
		Umsg umsg = new Umsg();
		umsg.setMsg_id(msgid);
		umsg.setS_id(user.getS_id());
		dbDao.changeToRead(umsg);
	}
	
}
