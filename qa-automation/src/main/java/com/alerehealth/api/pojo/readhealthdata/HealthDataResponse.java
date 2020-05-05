package com.alerehealth.api.pojo.readhealthdata;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HealthDataResponse",namespace="http://www.alere.com/xsds/HealthData.xsd")
public class HealthDataResponse {
	
	@XmlElement(name="HealthDataResponses")
	private HealthDataResponses healthDataResponses;

	public HealthDataResponses getHealthDataResponses() {
		return healthDataResponses;
	}

	public void setHealthDataResponses(HealthDataResponses healthDataResponses) {
		this.healthDataResponses = healthDataResponses;
	}
	
	
	

}
