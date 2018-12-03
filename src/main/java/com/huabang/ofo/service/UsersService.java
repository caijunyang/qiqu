package com.huabang.ofo.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.huabang.ofo.domain.HbAccount;
import com.huabang.ofo.domain.HbOrder;
import com.huabang.ofo.domain.HbUser;
import com.huabang.ofo.domain.HbUserCash;

public interface UsersService {

	/**
	 * 用户的登陆/注册
	 * @param telephone
	 * @return
	 */
	public Map<String,Object> login(String telephone);
	/**
	 * 用户账户余额
	 * @param telephone
	 * @return
	 */
	public HbAccount selectMoney(String telephone);
	/**
	 * 用户头像及其他图片
	 * @param type
	 * @param fileName
	 * @param telephone
	 * @return 
	 */
	public String savaImage(Integer type, String fileName, String telephone);
	/**
	 * 根据手机号修改用户的昵称
	 * @param telePhone
	 * @param name
	 * @param type 
	 * @return
	 */
	public int updateByName(String telePhone, String name, int type);
	/**
	 * 更换手机号
	 * @param oldPhone
	 * @param newPhone
	 * @return
	 */
	public int updateByPhone(String oldPhone, String newPhone);
	/**
	 * 查看用户的基本信息
	 * @param telephone
	 * @return
	 */
	public String selectUser(String telephone);
	/**
	 * 缴纳押金/认证
	 * @param telephone
	 * @param money
	 * @param type
	 * @param request 
	 * @param type2 
	 * @return
	 */
	public String renZheng(String telephone, String cashMoney, int type, Integer money, HttpServletRequest request);
	/**
	 * 充值
	 * @param telephone
	 * @param money
	 * @return
	 */
	public String pay(String telephone, String money);
	/**
	 * 我的页面
	 * @param telephone
	 * @return
	 */
	public String selectUserMe(String telephone);
	/**
	 * 查询我的钱包
	 * @param userId
	 * @return
	 */
	public String selectMyMoney(String userId);
	/**
	 * 查询用户信息根据手机号
	 * @param valueOf
	 * @return
	 */
	public HbUser selectUserObject(String valueOf);
	/**
	 * 保存押金和用户的信息
	 * @param cash
	 */
	public void saveUserCash(HbUserCash cash);
	/**
	 * 保存订单信息
	 * @param order
	 */
	public void saveOrder(HbOrder order);
	
}
