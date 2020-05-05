package com.alerehealth.api.pojo.messagerecipientdetails;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RecipientDetailsList" ,namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class RecipientDetailsList {
	
	@XmlElement(name="RecipientDetails")
	private List<RecipientDetails> recipientDetails;
	
	
    public List<RecipientDetails> getRecipientDetails() {
		return recipientDetails;
	}

    
  
	public void setRecipientDetails(List<RecipientDetails> recipientDetails) {
		this.recipientDetails = recipientDetails;
	}

		
	

}
