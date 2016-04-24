package com.wxhufen.po;

/**
 *  ToUserName 	是 	接收方帐号（收到的OpenID）
	FromUserName 	是 	开发者微信号
	CreateTime 	是 	消息创建时间 （整型）
	MsgType 	是 	text
	Content 	是 	回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示） 
 */
public class Message {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType;
	private String Content;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	@Override
	public String toString() {
		return "Message [ToUserName=" + ToUserName + ", FromUserName="
				+ FromUserName + ", CreateTime=" + CreateTime + ", MsgType="
				+ MsgType + ", Content=" + Content + "]";
	}
	
	
}
