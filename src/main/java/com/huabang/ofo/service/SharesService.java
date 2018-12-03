package com.huabang.ofo.service;


public interface SharesService {
	
	/**
	 * 查询所有小黄车的经纬度
	 * @param lng 
	 * @param lat 
	 * @return
	 */
	String selectShareAll(String lat, String lng);

	
}
