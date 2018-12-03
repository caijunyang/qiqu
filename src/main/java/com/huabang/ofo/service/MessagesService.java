package com.huabang.ofo.service;

public interface MessagesService {

	/**
	 * 详细消息
	 * @param messageId 
	 * @return
	 */
	String selectAllMessage(String messageId);
	/**
	 * 简略信息
	 * @return
	 */
	String selectSimmpleMessage();

}
