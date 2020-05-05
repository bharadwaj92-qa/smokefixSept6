package com.alerehealth.api.pojo.messagerecipientdetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HealthTopics",namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class HealthTopics {
	
	
	@XmlElement(name="HealthTopic")
	private List<HealthTopic> healthTopic;

	public List<HealthTopic> getHealthTopic() {
		return healthTopic;
	}

	
	public void setHealthTopic(List<HealthTopic> healthTopic) {
		this.healthTopic = healthTopic;
	}
	
	
	

}
