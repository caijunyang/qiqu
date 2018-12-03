package com.bootdo.ofo.service;

import com.bootdo.ofo.domain.HbMessage;

import java.util.List;
import java.util.Map;

/**
 * 通知通告
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-05 17:11:16
 */
public interface MessageService {

	HbMessage get(Integer id);

	List<HbMessage> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(HbMessage message);

	int update(HbMessage message);

	int remove(Integer id);

	int batchRemove(Integer[] ids);

}
