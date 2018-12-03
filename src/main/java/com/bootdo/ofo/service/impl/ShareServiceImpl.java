/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.bootdo.qixin.service.impl 
 * @author: 冯世博   
 * @date: 2018年1月24日 下午3:29:32 
 */
package com.bootdo.ofo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.bootdo.ofo.dao.HbShareMapper;
import com.bootdo.ofo.domain.HbShare;
import com.bootdo.ofo.service.ShareService;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @ClassName: ShareServiceImpl.java
 * @Description: 分享点功能接口实现
 */
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ShareServiceImpl implements ShareService {
	
	@Autowired
	private HbShareMapper hbShareMapper;

	/**
	 * 
	 * @see com.bootdo.ofo.service.ShareService#addQiXinShare(com.bootdo.ofo.domain.QixinShare)
	 * @Function: ShareServiceImpl.java
	 * @Description: 新增分享点
	 */
	@Transactional
	public Boolean addQiXinShare(HbShare hbShare) {
		return  hbShareMapper.insert(hbShare)> 0;
	}

	/**
	 * 
	 * @Function: ShareServiceImpl.java
	 * @Description: 查询所有分享信息
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<HbShare> searchShareMapDo(Integer start,Integer pagesize) {
		PageHelper.startPage(start, pagesize);
		List<HbShare> shareS = hbShareMapper.selectByExample(null);
		return shareS;
	}


	/** 
	* @Function: ShareServiceImpl.java
	* @Description: 修改分享点信息
	*/
	@Override
	@Transactional
	public Boolean updateShareById(HbShare hbShare) {
		return hbShareMapper.updateByPrimaryKeySelective(hbShare)>0;
	}
	/** 
	* @Function: ShareServiceImpl.java
	* @Description: 删除分享点信息
	*/
	@Override
	public Boolean deleteShareById(HbShare hbShare) {
		return hbShareMapper.deleteByPrimaryKey(hbShare.getShareId())>0;
	}
}
