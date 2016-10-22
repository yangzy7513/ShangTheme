package com.shangtheme.client.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shangtheme.client.dao.ThemeDao;
import com.shangtheme.client.entity.Brand;
import com.shangtheme.client.entity.Theme;
import com.shangtheme.client.service.ThemeService;

/**
 * 类名：ThemeServiceImpl
 * 作者: yangzy
 * 功能：主题管理服务接口实现类
 * 详细：此类进行详细获取数据的过程
 * 版本：1.0
 * 日期：2016-9-4
 * 说明：
 *	         如需拓展功能，务必先在ThemeService中声明.
 */
@Service
public class ThemeServiceImpl implements ThemeService {
	
	@Resource
	private ThemeDao themeDao;
	
	/* 
	 * 获取主题信息,确定用户对主题的操作状态
	 */
	@Override
	public Map<String, Object> getThemeSer(int id, int sid) {
		Map<String, Integer> map = new HashMap<>();
		map.put("t_id", id);
		map.put("s_id", sid);
		Map<String, Object> resultList = themeDao.getThemeByTid(map);
		return resultList;
	}

	@Override
	public List<Map<String, String>> superSearch(String str) {
		//裁剪搜索字符串
		char[] Search = str.toCharArray();
		int index = 0;
		//查询数据库信息
		List<Map<String, Object>> list = themeDao.search();
		//查询结果
		List<Map<String, String>> reList = new LinkedList<>();
		//抽出一条信息，遍历判断是否包含上面切割的字符串
		for(Map<String, Object> map : list){
			//数据库端待比对字符串
			String su = (String) map.get("searchlist");
			for(char s : Search){
				if (su.contains( String.valueOf(s))) {
					index++;
				}
			}
			if (index >= str.length()/2) {
				Map<String, String> map2 = new HashMap<String, String>();
				String title = (String) map.get("t_themename");
				String path =String.valueOf(map.get("t_id"));
				map2.put("title"	, title);
				map2.put("tid",path);
				reList.add(map2);
			}
		}
		return reList;
	}

	@Override
	public Map<String, Object> searchThemeByBrand(String brandname) {
		
		Brand brand = themeDao.getBrandInfo(brandname);
		List<Theme> themeList = themeDao.searchByBrandname(brandname);
		Map<String, Object> brandthemeList = new HashMap<>();
		brandthemeList.put("brandinfo", brand);
		brandthemeList.put("themeList", themeList);
		
		return brandthemeList;
	}

}
