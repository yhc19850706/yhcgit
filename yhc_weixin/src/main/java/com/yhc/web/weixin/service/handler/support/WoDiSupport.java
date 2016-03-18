package com.yhc.web.weixin.service.handler.support;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.yhc.weixin.model.WodiRoom;
import com.yhc.weixin.model.WodiUser;

public class WoDiSupport {
	
	private static Cache<String, WodiRoom> rooms =CacheBuilder
			.newBuilder()
			.expireAfterAccess(7200, TimeUnit.SECONDS)
			.build();
	
	private static AtomicInteger numCreater= new AtomicInteger(1000);
	
	public static WodiRoom createRoom(final String openId){
		final String roomNum = String.valueOf(numCreater.addAndGet(1));
		try {
			return rooms.get(roomNum,new Callable<WodiRoom>() {
				@Override
				public WodiRoom call() throws Exception {
					WodiRoom room = new WodiRoom();
					room.setAmdinId(openId);
					room.setRoomNum(roomNum);
					return room;
				}
			});
		} catch (ExecutionException e) {
			return null;
		}
	}
	
	public static WodiRoom getRoomByOpenId(String openId){
		Map<String, WodiRoom> roomMap = rooms.asMap();
		for(Entry<String, WodiRoom> entry: roomMap.entrySet()){
			WodiRoom room = entry.getValue();
			if(room.getAmdinId().equals(openId)){
				return room;
			}
		}
		return null;
	}
	
	public static WodiRoom getRoom(String roomNum){
		return rooms.getIfPresent(roomNum);
	}
	
	public static synchronized void addUser(String roomNum,WodiUser user){
		WodiRoom room = getRoom(roomNum);
		room.addUser(user);
		rooms.put(roomNum, room);
	}
	

}
