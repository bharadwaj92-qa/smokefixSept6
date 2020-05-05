package com.alerehealth.api.pojo.unreadmsgcountbyfolder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="GETUnreadMessagesCountByFolderResponse",namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class GETUnreadMessagesCountByFolderResponse {

	@XmlElement(name="TransactionID")
	private String transactionID;
	
	@XmlElement(name="ParticipantID")
	private String participantID;

	@XmlElement(name="MemberEligID")
    private String memberEligID;
	
	@XmlElement(name="TargetPresentationLayerID")
	private int targetPresentationLayerID;
	
	@XmlElement(name="UnreadMessagesList")
	private UnreadMessagesList unreadMessageList;
	
	@XmlElement(name="ErrorMessage")
	private String errorMessage;

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getParticipantID() {
		return participantID;
	}

	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}

	public String getMemberEligID() {
		return memberEligID;
	}

	public void setMemberEligID(String memberEligID) {
		this.memberEligID = memberEligID;
	}

	public int getTargetPresentationLayerID() {
		return targetPresentationLayerID;
	}

	public void setTargetPresentationLayerID(int targetPresentationLayerID) {
		this.targetPresentationLayerID = targetPresentationLayerID;
	}

	public UnreadMessagesList getUnreadMessageList() {
		return unreadMessageList;
	}

	public void setUnreadMessageList(UnreadMessagesList unreadMessageList) {
		this.unreadMessageList = unreadMessageList;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
