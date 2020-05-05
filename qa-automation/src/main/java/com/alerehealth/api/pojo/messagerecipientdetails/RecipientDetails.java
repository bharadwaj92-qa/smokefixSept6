package com.alerehealth.api.pojo.messagerecipientdetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="RecipientDetails",namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class RecipientDetails {
	
	@XmlElement(name="RecipientID")
	private String recipientId;

	@XmlElement(name="HealthTopics")
	private HealthTopics healthTopics;

	public String getRecipientId() {
		return recipientId;
	}

	
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public HealthTopics getHealthTopics() {
		return healthTopics;
	}

	public void setHealthTopics(HealthTopics healthTopics) {
		this.healthTopics = healthTopics;
	}
	
	

}
