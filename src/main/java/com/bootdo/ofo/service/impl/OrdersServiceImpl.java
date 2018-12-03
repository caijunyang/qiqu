package com.bootdo.ofo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.common.domain.PageDO;
import com.bootdo.common.utils.Query;
import com.bootdo.ofo.dao.HbOrderMapper;
import com.bootdo.ofo.service.OrdersService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private HbOrderMapper orderMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public PageDO<Map<String, Object>> queryList(Query query) {
		int total = orderMapper.count(query);
		List<Map<String, Object>> logs = orderMapper.list(query);
		for (Map<String, Object> map : logs) {
			Integer type = (Integer)map.get("order_type");
			if(type==0){
				map.put("order_type", "押金");
			}else if(type == 1){
				map.put("order_type", "充值");
			}else if(type == 2){
				map.put("order_type", "退款");
			}
		}
		PageDO<Map<String, Object>> page = new PageDO<>();
		page.setTotal(total);
		page.setRows(logs);
		return page;
	}

	@Override
	public int remove(String id) {
		int count = orderMapper.remove(id);
		return count;
	}

	@Override
	public int batchRemove(String[] ids){
		return orderMapper.batchRemove(ids);
	}
}
