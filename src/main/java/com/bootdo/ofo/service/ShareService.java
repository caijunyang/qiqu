/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.bootdo.qixin.service 
 * @author: 冯世博   
 * @date: 2018年1月24日 下午3:29:13 
 */
package com.bootdo.ofo.service;

import java.util.List;
import com.bootdo.ofo.domain.HbShare;

public interface ShareService {
	
	/**
	 * 
	* @Function: ShareService.java
	* @Description: 插入一条分享点信息
	 */
	Boolean addQiXinShare(HbShare hbShare);
	/**
	 * 
	* @Function: ShareService.java
	* @Description: 查询分享点列表
	 */
	List<HbShare> searchShareMapDo(Integer start,Integer pagesize);
	/**   
	* @Function: ShareService.java
	* @Description: 修改分享点信息
	*/
	Boolean updateShareById(HbShare HbShare);
	/**   
	* @Function: ShareService.java
	* @Description: 删除分享点信息
	*/
	Boolean deleteShareById(HbShare hbShare);
}
