package com.bootdo.ofo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.ofo.dao.HbAccountMapper;
import com.bootdo.ofo.dao.HbUserMapper;
import com.bootdo.ofo.domain.HbAccount;
import com.bootdo.ofo.domain.HbUser;
import com.bootdo.ofo.service.UService;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UServiceImpl implements UService {


    @Autowired
    HbUserMapper roleMapper;
    @Autowired
    HbAccountMapper accountMapper;

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<HbUser> list() {
        List<HbUser> roles = roleMapper.selectByExample(null);
        return roles;
    }


    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public HbUser list(String userId) {
       HbUser user = this.roleMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public int save(HbUser role) {
    	String string = UUID.randomUUID().toString().replace("-", "");
    	role.setUserId(string);
    	role.setUserImage("localhost/share/image/default.jpg");
    	HbAccount acc = new HbAccount();
    	acc.setAccountUserId(string);
    	acc.setAccountPay(0.0);
    	this.accountMapper.insertSelective(acc);
    	System.err.println(acc.getAccountId());
        return this.roleMapper.insertSelective(role);
    }

    @Override
    public int remove(String id) {
        int count = roleMapper.deleteByPrimaryKey(id);
        return count;
    }

    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    @Override
    public HbUser get(String id) {
        HbUser HbUser = roleMapper.selectByPrimaryKey(id);
        return HbUser;
    }

    @Override
    public int update(HbUser role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int batchremove(String[] ids) {
    	for (String string : ids) {
    		accountMapper.deleteByUserid(string);
		}
        int r = roleMapper.batchRemove(ids);
        return r;
    }

}
