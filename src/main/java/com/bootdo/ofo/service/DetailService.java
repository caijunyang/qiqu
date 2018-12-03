package com.bootdo.ofo.service;

import java.util.List;

import com.bootdo.ofo.domain.HbDetail;

public interface DetailService {
	/**
	 * 查询金额
	 * @return
	 */
	List<HbDetail> searchMoney();
	/**
	 * 编辑金额
	 * @param id
	 * @return
	 */
	HbDetail get(Integer id);
	/**
	 * 删除金额
	 * @param id
	 * @return
	 */
	int remove(Integer id);
	/**
	 * 保存设置的金额
	 * @param pay
	 * @return
	 */
	int save(HbDetail pay);
	/**
	 * 保存修改操作
	 * @param pay
	 * @return
	 */
	int update(HbDetail pay);
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	int batchremove(Integer[] ids);

}
