package com.alerehealth.api.pojo.messagerecipientdetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RecipientDetails",namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class HealthTopic {
	
	@XmlElement(name="HealthTopicID")
	private String HealthTopicID;
	
	@XmlElement(name="HealthTopicName")
	private String HealthTopicName;

	public String getHealthTopicID() {
		return HealthTopicID;
	}

	
	
	public void setHealthTopicID(String healthTopicID) {
		HealthTopicID = healthTopicID;
	}

	public String getHealthTopicName() {
		return HealthTopicName;
	}

	
	
	public void setHealthTopicName(String healthTopicName) {
		HealthTopicName = healthTopicName;
	}
	
	

}
