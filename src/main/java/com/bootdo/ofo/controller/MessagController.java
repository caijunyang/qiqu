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
 * 通知消息
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-05 17:11:16
 */

@Controller
@RequestMapping("/message")
public class MessagController {
	@Autowired
	private MessageService messageService;

	@GetMapping()
	@RequiresPermissions("ofo:message:message")
	String oamessage() {
		return "ofo/message/message";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ofo:message:message")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<HbMessage> messageList = messageService.list(query);
		int total = messageService.count(query);
		PageUtils pageUtils = new PageUtils(messageList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	String add() {
		return "ofo/message/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id, Model model) {
		HbMessage message = messageService.get(id);
		model.addAttribute("notify", message);
		String[] split = message.getMessJbdetails().split("&");
		model.addAttribute("name", split[0]);
		model.addAttribute("sexAge", split[2]);
		model.addAttribute("address", split[3]);
		model.addAttribute("time", split[4]);
		model.addAttribute("birthday", split[5]);
		model.addAttribute("weight", split[6]);
		model.addAttribute("color", split[6]);
		return "ofo/message/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(HbMessage message,User user) {
		String name = user.getName();
		String sexAge = user.getSexAge();
		String address = user.getAddress();
		String time = user.getTime();
		String birthday = user.getBirthday();
		String weight = user.getWeight();
		String color = user.getColor();
		String mess_jbdetails = name+"&"+sexAge+"&"+address+"&"+time+"&"+birthday+"&"+weight+"&"+color;
		message.setMessJbdetails(mess_jbdetails);
		if (messageService.save(message) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(HbMessage message,Map<String,Object> map) {
		String name = (String)map.get("name");
		String sexAge = (String)map.get("sexAge");
		String address = (String)map.get("address");
		String time = (String)map.get("time");
		String birthday = (String)map.get("birthday");
		String weight = (String)map.get("weight");
		String color = (String)map.get("color");
		String mess_jbdetails = name+"&"+sexAge+"&"+address+"&"+time+"&"+birthday+"&"+weight+"&"+color;
		message.setMessJbdetails(mess_jbdetails);
		messageService.update(message);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	public R remove(Integer id) {
		if (messageService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] ids) {
		messageService.batchRemove(ids);
		return R.ok();
	}

}
