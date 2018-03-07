package com.yhc.weixin.model;

import com.google.common.collect.Lists;

import java.util.List;

public class WodiRoom {
	
	private String roomNum;
	
	private String amdinId;
	
	private String wodiWord;
	
	private String commonWord;
	
	private WodiUser wodi;
	
	private List<WodiUser> users= Lists.newArrayList();

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getAmdinId() {
		return amdinId;
	}

	public void setAmdinId(String amdinId) {
		this.amdinId = amdinId;
	}

	public String getWodiWord() {
		return wodiWord;
	}

	public void setWodiWord(String wodiWord) {
		this.wodiWord = wodiWord;
	}

	public String getCommonWord() {
		return commonWord;
	}

	public void setCommonWord(String commonWord) {
		this.commonWord = commonWord;
	}

	public WodiUser getWodi() {
		return wodi;
	}

	public void setWodi(WodiUser wodi) {
		this.wodi = wodi;
	}

	public List<WodiUser> getUsers() {
		return users;
	}

	public void addUser(WodiUser user) {
		this.users.add(user);
	}

}
