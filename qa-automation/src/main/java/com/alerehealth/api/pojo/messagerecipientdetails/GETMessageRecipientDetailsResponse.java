package com.alerehealth.api.pojo.messagerecipientdetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="GETMessageRecipientDetailsResponse",namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class GETMessageRecipientDetailsResponse {
	
	@XmlElement(name="TransactionID")
	private String TransactionID;
	
	@XmlElement(name="RecipientDetailsList")
	private RecipientDetailsList recipientDetails;

	public String getTransactionID() {
		return TransactionID;
	}

	
	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}

	public RecipientDetailsList getRecipientDetailsTO() {
		return recipientDetails;
	}

	public void setRecipientDetailsTO(RecipientDetailsList recipientDetailsTO) {
		this.recipientDetails = recipientDetailsTO;
	}
	
	
	

}
