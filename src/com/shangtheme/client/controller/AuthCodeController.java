package com.shangtheme.client.controller;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.dao.SuserDao;
import com.shangtheme.client.entity.ReturnStatus;

/**
 *类名：AuthCodeController
 *作者: yangzy
 *功能：手机验证码功能类
 *详细：通过本类用户可以获取到短信验证码。
 *版本：1.0
 *日期：2016-08-28
 *说明：
 *	      不建议在此类拓展新功能。
 */
@Controller
public class AuthCodeController {
	
	/**
	 * log4j日志
	 */
	private static Logger logger = Logger.getLogger(AuthCodeController.class);
	
	@Resource
	private SuserDao suserDao;
	
	/**
	 * 互亿无线对接口
	 */
//	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	private static String Url = "";
	//验证码
	private int mobile_code;
	
	/**
	 * 获取短信验证码
	 * @param phonenum
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getauthcode.do")
	public void getAuthCode(String phonenum, HttpServletRequest request, HttpServletResponse response){
		HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(Url); 
			
		client.getParams().setContentCharset("GBK");		
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");

		//随机生成验证码
		mobile_code = (int)((Math.random()*9+1)*100000);
		
		//短信平台模板
		String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。"); 

		NameValuePair[] data = {//提交短信
			    new NameValuePair("account", "cf_yzy666"), 
			    new NameValuePair("password", "yzy154213"), //密码可以使用明文密码或使用32位MD5加密
			    //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
			    new NameValuePair("mobile", phonenum), 
			    new NameValuePair("content", content),
		};
		
		method.setRequestBody(data);		
		
		try {
			client.executeMethod(method);	
			
			String SubmitResult =method.getResponseBodyAsString();
					
			//System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult); 
			Element root = doc.getRootElement();

			String code = root.elementText("code");	
//			String msg = root.elementText("msg");	
//			String smsid = root.elementText("smsid");
			
//			System.out.println(code);
//			System.out.println(msg);
//			System.out.println(smsid);
						
			//验证码发送成功场合,将验证码存入session等待验证
			 if("2".equals(code)){
				logger.info("短信提交成功");
				final HttpSession session = request.getSession();
				session.setAttribute("mobile_code", mobile_code);
				//创建定时器销毁session中的验证码
				final Timer timer = new Timer();
				timer.schedule(new TimerTask() {					
					@Override
					public void run() {
						//重置验证码
						session.removeAttribute("mobile_code");
						timer.cancel();
					}
				}, 60*1000/*默认60s后删除*/);
			}			
				 
		} catch (Exception e) {
			logger.error("短信平台异常>>"+e.getMessage(), e);
		} 
	}
	
	/**
	 * 比对验证码控件
	 * @param code
	 * @return status
	 * @throws IOException 
	 */
	@RequestMapping("/checkAuthCode.do")
	public @ResponseBody ReturnStatus checkAuthCode(String code, HttpServletRequest request, HttpServletResponse response) throws IOException{
		ReturnStatus status = new ReturnStatus();
		HttpSession session = request.getSession();
		
		if (code.equals(String.valueOf(session.getAttribute("mobile_code")))) {
			status.setStatus(0);
			//验证成功之后立即销毁验证码
			session.removeAttribute("mobile_code");
			return status;
		}else {
			status.setStatus(307);
			status.setMsg(DBMsgUtil.getStatusMsgByCode(307));
			return status;
		}	
		
	}
	
}
