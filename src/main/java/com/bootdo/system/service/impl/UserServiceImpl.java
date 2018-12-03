package com.bootdo.system.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.*;
import com.bootdo.system.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bootdo.system.dao.UserDao;
import com.bootdo.system.dao.UserRoleDao;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.domain.UserRoleDO;
import com.bootdo.system.service.UserService;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userMapper;
	@Autowired
	UserRoleDao userRoleMapper;
	@Autowired
	private FileService sysFileService;
	@Autowired
	private BootdoConfig bootdoConfig;

	@Override
	public UserDO get(Long id) {
		List<Long> roleIds = userRoleMapper.listRoleId(id);
		UserDO user = userMapper.get(id);
		user.setRoleIds(roleIds);
		return user;
	}

	@Override
	public List<UserDO> list(Map<String, Object> map) {
		return userMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return userMapper.count(map);
	}

	@Transactional
	@Override
	public int save(UserDO user) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = null;
		try {
			parse = format.parse(format.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setGmtCreate(parse);
		user.setGmtModified(parse);
		int count = userMapper.save(user);
		Long userId = user.getUserId();
		List<Long> roles = user.getRoleIds();
		userRoleMapper.removeByUserId(userId);
		List<UserRoleDO> list = new ArrayList<>();
		for (Long roleId : roles) {
			UserRoleDO ur = new UserRoleDO();
			ur.setUserId(userId);
			ur.setRoleId(roleId);
			list.add(ur);
		}
		if (list.size() > 0) {
			userRoleMapper.batchSave(list);
		}
		return count;
	}

	@Override
	public int update(UserDO user) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = null;
		try {
			parse = format.parse(format.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setGmtModified(parse);
		int r = userMapper.update(user);
		Long userId = user.getUserId();
		List<Long> roles = user.getRoleIds();
		userRoleMapper.removeByUserId(userId);
		List<UserRoleDO> list = new ArrayList<>();
		for (Long roleId : roles) {
			UserRoleDO ur = new UserRoleDO();
			ur.setUserId(userId);
			ur.setRoleId(roleId);
			list.add(ur);
		}
		if (list.size() > 0) {
			userRoleMapper.batchSave(list);
		}
		return r;
	}

	@Override
	public int remove(Long userId) {
		userRoleMapper.removeByUserId(userId);
		return userMapper.remove(userId);
	}

	@Override
	public boolean exit(Map<String, Object> params) {
		boolean exit;
		exit = userMapper.list(params).size() > 0;
		return exit;
	}

	@Override
	public Set<String> listRoles(Long userId) {
		return null;
	}

	@Override
	public int resetPwd(UserVO userVO,UserDO userDO) throws Exception {
		if(Objects.equals(userVO.getUserDO().getUserId(),userDO.getUserId())){
			if(Objects.equals(MD5Utils.encrypt(userDO.getUsername(),userVO.getPwdOld()),userDO.getPassword())){
				userDO.setPassword(MD5Utils.encrypt(userDO.getUsername(),userVO.getPwdNew()));
				return userMapper.update(userDO);
			}else{
				throw new Exception("输入的旧密码有误！");
			}
		}else{
			throw new Exception("你修改的不是你登录的账号！");
		}
	}
	@Override
	public int adminResetPwd(UserVO userVO) throws Exception {
		UserDO userDO =get(userVO.getUserDO().getUserId());
		if("admin".equals(userDO.getUsername())){
			throw new Exception("超级管理员的账号不允许直接重置！");
		}
		userDO.setPassword(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdNew()));
		return userMapper.update(userDO);


	}

	@Transactional
	@Override
	public int batchremove(Long[] userIds) {
		int count = userMapper.batchRemove(userIds);
		userRoleMapper.batchRemoveByUserId(userIds);
		return count;
	}


	@Override
	public int updatePersonal(UserDO userDO) {
		return userMapper.update(userDO);
	}

    @Override
    public Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception {
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);
		FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
		//获取图片后缀
		String prefix = fileName.substring((fileName.lastIndexOf(".")+1));
		String[] str=avatar_data.split(",");
		//获取截取的x坐标
		int x = (int)Math.floor(Double.parseDouble(str[0].split(":")[1]));
		//获取截取的y坐标
		int y = (int)Math.floor(Double.parseDouble(str[1].split(":")[1]));
		//获取截取的高度
		int h = (int)Math.floor(Double.parseDouble(str[2].split(":")[1]));
		//获取截取的宽度
		int w = (int)Math.floor(Double.parseDouble(str[3].split(":")[1]));
		//获取旋转的角度
		int r = Integer.parseInt(str[4].split(":")[1].replaceAll("}", ""));
		try {
			BufferedImage cutImage = ImageUtils.cutImage(file,x,y,w,h,prefix);
			BufferedImage rotateImage = ImageUtils.rotateImage(cutImage, r);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(rotateImage, prefix, out);
			//转换后存入数据库
			byte[] b = out.toByteArray();
			FileUtil.uploadFile(b, bootdoConfig.getUploadPath(), fileName);
		} catch (Exception e) {
			throw  new Exception("图片裁剪错误！！");
		}
		Map<String, Object> result = new HashMap<>();
		if(sysFileService.save(sysFile)>0){
			UserDO userDO = new UserDO();
			userDO.setUserId(userId);
			userDO.setPicId(sysFile.getId());
			if(userMapper.update(userDO)>0){
				result.put("url",sysFile.getUrl());
			}
		}
		return result;
    }

	@Override
	public UserDO getUser(String username) {
		UserDO userdo = userMapper.getUserName(username);
		return userdo;
	}

}
