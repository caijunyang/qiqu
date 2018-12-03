package com.bootdo.ofo.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import com.bootdo.common.domain.PageDO;
import com.bootdo.common.utils.Query;

@Service
public interface XingCheService {
	PageDO<Map<String, Object>> queryList(Query query);
	int remove(String id);
	int batchRemove(String[] ids);
}
