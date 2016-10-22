package com.shangtheme.manager.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shangtheme.client.common.CommonUtil;
import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.dao.RecommendationDao;
import com.shangtheme.client.entity.Ad;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.service.impl.MyAssetsServiceImpl;

/**
 * 类名：ADController
 * 作者: yangzy
 * 功能：广告处理API
 * 详细：管理前台展示广告。
 * 版本：1.0
 * 日期：2016-10-12
 * 说明：
 *	        可拓展并在此处说明.      
 */
@Controller
public class ADController {
	
	/**
	 * log4j日志
	 */
	private static Logger logger = Logger.getLogger(ADController.class);
	
	@Resource
	private RecommendationDao recommendationDao;
	
	/**
	 * 上传轮播图片广告
	 * @param multipartRequest
	 * @return
	 * @throws RuntimeException
	 * @throws IOException
	 */
	@RequestMapping("/uploadadpic.do")
	@CacheEvict(value="homeInfo")
	public @ResponseBody ReturnStatus updateADPicAction(MultipartHttpServletRequest multipartRequest, 
					String href1, String href2, String href3) throws RuntimeException, IOException{
		recommendationDao.emptyAd();
		String[] hrefs = {href1,href2,href3};
		int i = 0;
		for(Iterator it = multipartRequest.getFileNames(); it.hasNext();  ){
			String key = (String) it.next();
			MultipartFile adPicFile = multipartRequest.getFile(key);
			
			String adPicSavePath = multipartRequest.getSession().getServletContext().
					getRealPath(CommonUtil.ADPicPath);
			File filePath = new File(adPicSavePath);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}
			String suffix = adPicFile.getOriginalFilename().
					substring(adPicFile.getOriginalFilename().lastIndexOf(".")+1);
			String dbsavepath = CommonUtil.ADPicPath + DigestUtils.md5Hex(adPicFile.getOriginalFilename())+"."+suffix;
			final String realSavePath = adPicSavePath+DigestUtils.md5Hex(adPicFile.getOriginalFilename())+"."+suffix;
			File file = new File(realSavePath);
			adPicFile.transferTo(file);
			Ad ad = new Ad();
			ad.setAd_href(hrefs[i++]);
			ad.setPicpath(dbsavepath);
			ad.setRegisttime(CommonUtil.getDate("yyyy/MM/dd HH:mm:ss"));
			
			recommendationDao.registAd(ad);
			logger.warn("展板信息已更新!");
		}
		return new ReturnStatus(0, DBMsgUtil.getStatusMsgByCode(0));
	}
	
}
