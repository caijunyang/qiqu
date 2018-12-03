package com.bootdo.ofo.controller;

import java.util.List;

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

import com.bootdo.common.annotation.Log;
import com.bootdo.common.utils.R;
import com.bootdo.ofo.dao.HbShareMapper;
import com.bootdo.ofo.domain.HbShare;
import com.bootdo.ofo.domain.HbUser;
import com.bootdo.ofo.service.ShareService;
import com.bootdo.ofo.service.UService;

@RequestMapping("/user")
@Controller
public class UController{
	String prefix = "ofo/user";
	@Autowired
	private ShareService shareService;
	@Autowired
	private HbShareMapper hbShareMapper;
	@Autowired
	UService userService;
	@Autowired
	

	@GetMapping("/index")
	String index() {
		return "/index";
	}
	@RequiresPermissions("sys:user:user")
	@GetMapping()
	String role() {
		return prefix + "/user";
	}
 
	@RequiresPermissions("sys:user:user")
	@GetMapping("/list")
	@ResponseBody
	List<HbUser> list() {
		List<HbUser> roles = userService.list();
		return roles;
	}
	@GetMapping("/sharelist")
	@ResponseBody
	public List<HbShare> sharelist(Integer page,Integer rows){
		return shareService.searchShareMapDo(1,9999);
	}
	
	@PostMapping("/deleteShareById")
	@ResponseBody()
	R deleteShareById(String id) {
		if (hbShareMapper.deleteByPrimaryKey(id)>0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}
	
	@Log("添加客户")
	@GetMapping("/add")
	String add() {
		return prefix + "/add";
	}

	@Log("编辑客户")
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") String id, Model model) {
		HbUser HbUser = userService.get(id);
		model.addAttribute("role", HbUser);
		return prefix + "/edit";
	}

	@Log("保存客户")
	@PostMapping("/save")
	@ResponseBody()
	R save(HbUser role) {
		if (userService.save(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("更新客户")
	@PostMapping("/update")
	@ResponseBody()
	R update(HbUser role) {
		if (userService.update(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("删除客户")
	@PostMapping("/remove")
	@ResponseBody()
	R save(String id) {
		if (userService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}
	
	@Log("批量删除客户")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") String[] ids) {
		
		int r = userService.batchremove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
