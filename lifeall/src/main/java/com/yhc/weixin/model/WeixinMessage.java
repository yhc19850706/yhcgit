package com.yhc.weixin.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="xml")
@XStreamAlias("xml")
public class WeixinMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	//base
	@XStreamAlias("ToUserName")
	private String toUserName; 		//开发者微信号
	@XStreamAlias("FromUserName")
	private String fromUserName;	//发送方帐号（一个OpenID）
	@XStreamAlias("CreateTime")
	private Integer createTime;		//消息创建时间 （整型）
	@XStreamAlias("MsgType")
	private String msgType;			//消息类型
	@XStreamAlias("Event")
	private String event;			//事件类型，subscribe(订阅)、unsubscribe(取消订阅)
	
	//----扫描带参数二维码事件
	@XStreamAlias("EventKey")
	private String eventKey;		//事件KEY值
	@XStreamAlias("Ticket")
	private String ticket;			//二维码的ticket，可用来换取二维码图片
	
	
	//----上报地理位置事件
	@XStreamAlias("Latitude")
	private String latitude;		//地理位置纬度
	@XStreamAlias("Longitude")
	private String longitude;		//地理位置经度
	@XStreamAlias("Precision")
	private String precision;		//地理位置精度
	
	//普通消息
	@XStreamAlias("MsgId")
	private String msgId;			//消息ID号 
	//模板消息发送成功后返回的消息ID
	@XStreamAlias("MsgID")
	private String msgID;			//消息ID号 
	//模板消息发送成功后返回的状态
	@XStreamAlias("Status")
	private String status;			//状态
	//普通消息--文本
	@XStreamAlias("Content")
	private String content;			//文本消息内容
	//普通消息--图片
	@XStreamAlias("PicUrl")
	private String picUrl;			//图片消息
	//普通消息--媒体
	@XStreamAlias("MediaId")
	private String mediaId;			//mediaId 可以调用多媒体文件下载接口拉取数据
	//普通消息--语音格式
	@XStreamAlias("Format")
	private String format;			//语音格式
	//普通消息--语音识别
	@XStreamAlias("Recognition")
	private String recognition;		//开通语音识别功能的识别结果
	//普通消息--视频
	@XStreamAlias("ThumbMediaId")
	private String thumbMediaId;	//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	//普通消息--地理位置消息
	@XStreamAlias("Location_X")
	private String location_X;		//地理位置维度
	@XStreamAlias("Location_Y")
	private String location_Y;		//地理位置经度
	@XStreamAlias("Scale")
	private String scale;			//地图缩放大小
	@XStreamAlias("Label")
	private String label;			//地理位置信息
	//普通消息--链接消息
	@XStreamAlias("Title")
	private String title;
	@XStreamAlias("Description")
	private String description;
	@XStreamAlias("Url")
	private String url;
	/**
	 * 企业号独有的应用ID
	 */
	@XmlElement(name = "AgentID")
	private String agentId;
	
	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}
	
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	
	@XmlElement(name="CreateTime")
	public Integer getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	
	@XmlElement(name="MsgType")
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	@XmlElement(name="Event")
	public String getEvent() {
		return event;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
	
	@XmlElement(name="EventKey")
	public String getEventKey() {
		return eventKey;
	}
	
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	
	@XmlElement(name="Ticket")
	public String getTicket() {
		return ticket;
	}
	
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
	@XmlElement(name="Latitude")
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@XmlElement(name="Longitude")
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@XmlElement(name="Precision")
	public String getPrecision() {
		return precision;
	}
	
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	
	@XmlElement(name="MsgId")
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	@XmlElement(name="MsgID")
	public String getMsgID() {
		return msgID;
	}
	public void setMsgID(String msgID) {
		this.msgID = msgID;
	}
	
	@XmlElement(name="Status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@XmlElement(name="Content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@XmlElement(name="PicUrl")
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	@XmlElement(name="Format")
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	@XmlElement(name="Recognition")
	public String getRecognition() {
		return recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	
	@XmlElement(name="ThumbMediaId")
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	@XmlElement(name="Location_X")
	public String getLocation_X() {
		return location_X;
	}
	public void setLocation_X(String locationX) {
		location_X = locationX;
	}
	@XmlElement(name="Location_Y")
	public String getLocation_Y() {
		return location_Y;
	}
	public void setLocation_Y(String locationY) {
		location_Y = locationY;
	}
	@XmlElement(name="Scale")
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	@XmlElement(name="Label")
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@XmlElement(name="Title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement(name="Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement(name="Url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
