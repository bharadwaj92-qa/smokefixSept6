package com.alerehealth.api.pojo.readhealthdata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="GETHealthDataResponse",namespace="http://www.alere.com/xsds/HealthData.xsd")
public class GETHealthDataResponse {
	
	@XmlElement(name="HealthDataResponse")
	private HealthDataResponse healthDataResponse;

	public HealthDataResponse getHealthDataResponse() {
		return healthDataResponse;
	}

	public void setHealthDataResponse(HealthDataResponse healthDataResponse) {
		this.healthDataResponse = healthDataResponse;
	}
	
	
	
	

}
