package com.shangtheme.client.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.SuserEntity;
import com.shangtheme.client.entity.Theme;
import com.shangtheme.client.service.CollectionService;

/**
 *@类名：CollectionController
 *@作者: CC
 *@功能：收藏信息访问层
 *@详细：通过本类可以插入收藏信息。
 *@版本：2.0
 *@日期：2016-9-17
 *@说明：
 *	        可拓展并在此处说明. 
 *			改进了收藏的功能    2016/9/17   yangzy 
 *			添加猜测用户喜欢API 2016/10/16   yangzy   
 */

@Controller
public class CollectionController {
	
	@Resource
	private CollectionService collectionService;
	
	/**
	 * 执行收藏
	 * @param id
	 * @param collecflag 收藏状态   0收藏  1未收藏
	 * @param request
	 */
	@RequestMapping("/docollection.do")
	public void doconAction(int id, int  collecflag, HttpServletRequest request) {
		HttpSession session = request.getSession();
		SuserEntity user = (SuserEntity) session.getAttribute("suser");
		collectionService.doCollection(collecflag, id, user.getS_id());
	}


	/**
	 * 分页查询收藏主题
	 * @param pageNo
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/getColBySid.do")
	public @ResponseBody ReturnStatus getCollectionAction(int pageNo, HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		SuserEntity user = (SuserEntity) session.getAttribute("suser");
		
		//猜你喜欢
		List<Theme> guessLikeOnCol =  collectionService.guessCustomlike(user.getS_id());
		session.setAttribute("guesslike_col", guessLikeOnCol);
		
		//获取分页每页数量
		int PAGESIZE = Integer.parseInt(DBMsgUtil.getStatusMsgByCode(1));
		
		ReturnStatus status = collectionService.queryByPage(user.getS_id(), pageNo, PAGESIZE);
		if (status.getStatus() == 0) {
			@SuppressWarnings("unchecked")
			Map<String, Object> reMap = (Map<String, Object>) status.getData();
			@SuppressWarnings("unchecked")
			List<Theme> reList = (List<Theme>) reMap.get("result");
			int pageCount = (int) reMap.get("pageCount");
			//当前页面主题
			session.setAttribute("usercollec", reList);
			
			//总页数
			session.setAttribute("pageCount", pageCount);
			
			//当前页码
			session.setAttribute("currentPage", pageNo);
		}
		response.sendRedirect("html/myCollection.jsp#"+pageNo);
		
		return status;
		
	}
	
	
	
	
}
