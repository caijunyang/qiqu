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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.utils.R;
import com.bootdo.ofo.domain.HbPaymoney;
import com.bootdo.ofo.service.MoneyService;


@RequestMapping("/money")
@Controller
public class MoneyController {
	
	//静态资源根目录
	private String prefix="ofo/money/";
	@Autowired
	private MoneyService moneyService;
	
	/**
	* @Function: ShareController.java
	* @Description: 跳转到充值金额设置管理页面
	* @version: v1.0.0
	* @author: 郝培荣
	*
	 */
	@RequestMapping(value="/pay",method=RequestMethod.GET)
	@RequiresPermissions("money:money:pay")
	public String toSharePage(){
		return prefix+"pay";
	}
	
	/**
	 * 
	* @Function: MoneyController.java
	* @Description: 查询设置的金额
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("money:money:pay")
	public List<HbPaymoney> searchMoney(){
		return moneyService.searchMoney();
	}
	
	@Log("添加金额页面")
	@GetMapping("/add")
	String add() {
		return prefix + "add";
	}

	@Log("编辑金额的查询并回显")
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id, Model model) {
		HbPaymoney hbPaymoney = moneyService.get(id);
		model.addAttribute("role", hbPaymoney);
		return prefix + "edit";
	}
	@Log("删除设置的金额")
	@PostMapping("/remove")
	@ResponseBody
	R remove(Integer id) {
		if (moneyService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}
	
	@Log("保存金额")
	@PostMapping("/save")
	@ResponseBody
	R save(HbPaymoney pay) {
		if (moneyService.save(pay) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}
	
	@Log("更新金额")
	@PostMapping("/update")
	@ResponseBody
	R update(HbPaymoney pay) {
		if (moneyService.update(pay) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}
	
	@Log("批量删除")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Integer[] ids) {
		int r = moneyService.batchremove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}

}
