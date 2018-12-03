package com.bootdo.ofo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.bootdo.ofo.dao.HbMessageMapper;
import com.bootdo.ofo.domain.HbMessage;
import com.bootdo.ofo.service.MessageService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class MessageServiceImpl implements MessageService {
    @Autowired
    private HbMessageMapper hbMessageMapper;

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public HbMessage get(Integer id) {
    	HbMessage rDO = hbMessageMapper.get(id);
        return rDO;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<HbMessage> list(Map<String, Object> map) {
        List<HbMessage> notifys = hbMessageMapper.list(map);
        return notifys;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public int count(Map<String, Object> map) {
        return hbMessageMapper.count(map);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(HbMessage message) {
    	message.setMessCreatetime(new Date());
        int r = hbMessageMapper.insertSelective(message);
        return r;
    }

    @Override
    public int update(HbMessage message) {
    	message.setMessCreatetime(new Date());
        return hbMessageMapper.updateByPrimaryKeySelective(message);
    }

    @Transactional
    @Override
    public int remove(Integer id) {
        return hbMessageMapper.remove(id);
    }

    @Transactional
    @Override
    public int batchRemove(Integer[] ids) {
        return hbMessageMapper.batchRemove(ids);
    }

}
