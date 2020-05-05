package com.alerehealth.api.pojo.messagecentermessageheaders;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openqa.selenium.support.FindBy;


@XmlRootElement(name="Message",namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class Message {
	
	@XmlElement(name="MessageID")
	private int messageID;
	
	@XmlElement(name="MsgTypeID")
	private int msgTypeID;
	
	@XmlElement(name="SenderID")
	private int senderID;
	
	@XmlElement(name="SenderTypeID")
	private int senderTypeID;
	
	@XmlElement(name="SenderName")
	private String senderName;
	
	@XmlElement(name="RecipientID")
	private int recipientID;
	
	@XmlElement(name="RecipientTypeID")
	private int recipientTypeID;
	
	@XmlElement(name="RecipientName")
	private String recipientName;
	
	@XmlElement(name="ConcernedPartyID")
	private int concernedPartyID;
	
	@XmlElement(name="ConcernedPartyTypeID")
	private int concernedPartyTypeID;
	
	@XmlElement(name="Title")
	private String title;
	
	@XmlElement(name="ConversationID")
	private int conversationID;
	
	@XmlElement(name="SentDate" )
	private String sentDate;
	
	@XmlElement(name="DeliveredDate")
	private String deliveredDate;
	
	@XmlElement(name="ExpiredDate")
	private String expiredDate;
	
	@XmlElement(name="MsgFolderID")
	private int msgFolderID;
	
	@XmlElement(name="HealthTopicID")
	private int healthTopicID;
	
	@XmlElement(name="MsgTemplateID")
	private int msgTemplateID;
	
	@XmlElement(name="TargetPresentationLayerID")
	private int targetPresentationLayerID;

	@XmlElement(name="IsRead")
	private boolean isRead;
	
	@XmlElement(name="IsReplied")
	private boolean isReplied;
	
	@XmlElement(name="IsUrgent")
	private boolean isUrgent;
	
	@XmlElement(name="Priority")
	private String priority;

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public int getMsgTypeID() {
		return msgTypeID;
	}

	public void setMsgTypeID(int msgTypeID) {
		this.msgTypeID = msgTypeID;
	}

	public int getSenderID() {
		return senderID;
	}

	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}

	public int getSenderTypeID() {
		return senderTypeID;
	}

	public void setSenderTypeID(int senderTypeID) {
		this.senderTypeID = senderTypeID;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public int getRecipientID() {
		return recipientID;
	}

	public void setRecipientID(int recipientID) {
		this.recipientID = recipientID;
	}

	public int getRecipientTypeID() {
		return recipientTypeID;
	}

	public void setRecipientTypeID(int recipientTypeID) {
		this.recipientTypeID = recipientTypeID;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public int getConcernedPartyID() {
		return concernedPartyID;
	}

	public void setConcernedPartyID(int concernedPartyID) {
		this.concernedPartyID = concernedPartyID;
	}

	public int getConcernedPartyTypeID() {
		return concernedPartyTypeID;
	}

	public void setConcernedPartyTypeID(int concernedPartyTypeID) {
		this.concernedPartyTypeID = concernedPartyTypeID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getConversationID() {
		return conversationID;
	}

	public void setConversationID(int conversationID) {
		this.conversationID = conversationID;
	}

	public String getSentDate() {
		return sentDate;
	}

	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}

	public String getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(String deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public int getMsgFolderID() {
		return msgFolderID;
	}

	public void setMsgFolderID(int msgFolderID) {
		this.msgFolderID = msgFolderID;
	}

	public int getHealthTopicID() {
		return healthTopicID;
	}

	public void setHealthTopicID(int healthTopicID) {
		this.healthTopicID = healthTopicID;
	}

	public int getMsgTemplateID() {
		return msgTemplateID;
	}

	public void setMsgTemplateID(int msgTemplateID) {
		this.msgTemplateID = msgTemplateID;
	}

	public int getTargetPresentationLayerID() {
		return targetPresentationLayerID;
	}

	public void setTargetPresentationLayerID(int targetPresentationLayerID) {
		this.targetPresentationLayerID = targetPresentationLayerID;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public boolean isReplied() {
		return isReplied;
	}

	public void setReplied(boolean isReplied) {
		this.isReplied = isReplied;
	}

	public boolean isUrgent() {
		return isUrgent;
	}

	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
}
