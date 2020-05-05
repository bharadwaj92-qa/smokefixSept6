package com.alerehealth.api.pojo.messagecentermessageheaders;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openqa.selenium.support.FindBy;

@XmlRootElement(name="GETMessageHeadersResponse",namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class GETMessageHeadersResponse {
	
	@XmlElement(name="TransactionID")
	private int transactionID;
	
	@XmlElement(name="MemberEligID")
	private int memberEligID;
	
	@XmlElement(name="TargetPresentationLayerID")
	private int targetPresentationLayerID;

	@XmlElement(name="ParticipantID") 
	private int participantID;
	
	@XmlElement(name="MessageList")
	private MessageList messageList;
	
	@XmlElement(name="Message")
	private Message message;

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getMemberEligID() {
		return memberEligID;
	}

	public void setMemberEligID(int memberEligID) {
		this.memberEligID = memberEligID;
	}

	public int getTargetPresentationLayerID() {
		return targetPresentationLayerID;
	}

	public void setTargetPresentationLayerID(int targetPresentationLayerID) {
		this.targetPresentationLayerID = targetPresentationLayerID;
	}

	public int getParticipantID() {
		return participantID;
	}

	public void setParticipantID(int participantID) {
		this.participantID = participantID;
	}

	public MessageList getMessageList() {
		return messageList;
	}

	public void setMessageList(MessageList messageList) {
		this.messageList = messageList;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	} 
	
	
	
	
	
}
