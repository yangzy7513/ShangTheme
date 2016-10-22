package com.shangtheme.client.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.shangtheme.client.common.CommonUtil;
import com.shangtheme.client.common.DBMsgUtil;
import com.shangtheme.client.dao.CollectionDao;
import com.shangtheme.client.entity.Collection;
import com.shangtheme.client.entity.ReturnStatus;
import com.shangtheme.client.entity.Theme;
import com.shangtheme.client.service.CollectionService;

/**
 * 类名：ColletionServiceImpl
 * 作者: CC
 * 功能：收藏信息服务接口实现类
 * 详细：此类进行详细获取数据的过程
 * 版本：1.0
 * 日期：2016-09-04
 * 说明：
 *	         如需拓展功能，务必先在CollectionService中声明.
 */
@Service
public class ColletionServiceImpl  implements CollectionService {

    @Resource
    private CollectionDao collectionDao;

    @Override
    public void doCollection(int collecflag,  int t_id,int s_id) {
        //	ReturnStatus status = new ReturnStatus();
        Collection collection = new Collection();

        collection.setT_id(t_id);
        collection.setS_id(s_id);
        if (collecflag  == 1) {
            //未收藏状况，执行收藏
            collection.setC_createtime(CommonUtil.getDate("yyyy/MM/dd HH:mm:ss"));
            collectionDao.doCollection(collection);
        }else if (collecflag == 0) {
            //收藏状况，取消收藏
            collectionDao.removeCollection(collection);
        }

    }

    @Override
    public ReturnStatus queryByPage(int s_id, Integer pageNo, Integer pageSize) {

        int row = collectionDao.getRowCount(s_id);

        //总页数计算
        int pageCount = (row / pageSize) + (row % pageSize == 0 ? 0: 1);

        pageNo = pageNo == null ? 1:pageNo;
        pageSize = pageSize == null ?  CommonUtil.PAGESIZE : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Theme> result = collectionDao.selectCollectionBySuserid(s_id);

        //将结果与总页数封装到Map
        Map<String, Object> reMap = new HashMap<String, Object>();
        reMap.put("result", result);
        reMap.put("pageCount", pageCount);

        ReturnStatus status = new ReturnStatus();
        status.setStatus(0);
        status.setMsg(DBMsgUtil.getStatusMsgByCode(0));
        status.setData(reMap);

        return status;
    }

	@Override
	public List<Theme> guessCustomlike(int s_id) {
		//获取样本数据
		List<Map<String, Object>>   sampleData   =  collectionDao.getSampleCustomer(s_id);
		//二维数组
		int[][]  sampleArray = new int[sampleData.size()][10];
		//第一行为登陆用户数据
		//二维数组每行第一个值为用户id
		for (int i = 0; i < sampleData.size(); i++) {
			sampleArray[i][0] = (int)sampleData.get(i).get("s_id");
			String[] themeId =  String.valueOf(sampleData.get(i).get("love")).split(",");
			for (int j = 0; j < themeId.length; j++) {
				if (j+1 >=10) {
					//防止数组下标越界，最多取10个样本
					break;
				}
				sampleArray[i][j+1] = Integer.parseInt(themeId[j]);
			}
		}
		
		//记录相似度最高的一组所在位置
		int similar = 1;
		//用于对比相似度
		double flag = 0.0;
		//用户喜欢的数目
		int userLoveNum = CommonUtil.notZeroNumOfArrays(sampleArray[0]);
		//行
		for (int i = 1; i < sampleArray.length; i++) {
			//共同喜欢数
			int commonNum = 0;
			int sampleLoveNum = CommonUtil.notZeroNumOfArrays(sampleArray[i]);
			//计算与用户相同主题数目
			commonNum =  CommonUtil.findCommonNumOfArrays(sampleArray[0], sampleArray[i]) ;
			//相似度计算
			double similarity = (double)commonNum / Math.sqrt(userLoveNum * sampleLoveNum);
			//越大越接近
			if (similarity > flag  ) {
				flag = similarity;
				similar = i;
			}
		}
		//TODO找到推荐的主题
		//警告：result第一个为用户id，查询时候需要排除
		List<Integer> result = CommonUtil.compare( CommonUtil.parseintToInteger(sampleArray[0]), 
																					  CommonUtil.parseintToInteger(sampleArray[similar]) );
		//返回推荐的主题
		return collectionDao.recommendByCol(result);
	}


}
