package com.huabang.ofo.service;


public interface JourneyService {
	/**
	 * 行程
	 * @param phone
	 * @return
	 */
	public String selectJourney(String phone);
	/**
	 * 行程详细信息
	 * @param journeyId
	 * @return
	 */
	public String selectById(String journeyId);
	
}
