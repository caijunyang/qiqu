package com.bootdo.common.controller;

import org.springframework.stereotype.Controller;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.UserDO;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		if(getUser() == null){
			UserDO do1 = new UserDO();
			return do1.getUserId();
		}
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}