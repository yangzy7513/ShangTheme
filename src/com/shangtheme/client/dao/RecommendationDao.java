package com.shangtheme.client.dao;

import java.util.List;
import java.util.Map;

import com.shangtheme.client.entity.Ad;

/**
 * 类名：RecommendationDao
 * 作者: CC
 * 功能：新品推荐
 * 详细：连接DB,查询数据。
 * 版本：1.0
 * 日期：2016-9-6
 * 说明：
 *	          对应RecommendationMapper.xml
 */
public interface RecommendationDao {
	
	/**
	 * 主页新品推荐查询
	 * @return
	 */
	public List<Map<String, Object>> doRecommendation();
	
	/**
	 * 登记轮播广告
	 * @param ad
	 */
	public void registAd(Ad ad);
	
	/**
	 * 清空Ad
	 */
	public void emptyAd();
	
	/**
	 * 获取轮播图片信息
	 * @return
	 */
	public List<Map<String, String>> getCarouselAdMsg();
	
	
	
	
}
