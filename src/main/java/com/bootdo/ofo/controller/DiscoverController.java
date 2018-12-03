package com.bootdo.ofo.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.ofo.domain.HbMessage;
import com.bootdo.ofo.domain.User;
import com.bootdo.ofo.service.MessageService;

/**
 * 发现
 * @author chglee
 * @email 1992lcg@163.com
 */

@Controller
@RequestMapping("/discover")
public class DiscoverController {
	
	@RequestMapping("/index")
	public String index(){
		return "ofo/discover/index";
	}

}
