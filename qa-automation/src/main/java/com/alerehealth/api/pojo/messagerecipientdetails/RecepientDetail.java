package com.alerehealth.api.pojo.messagerecipientdetails;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="RecipientDetails",namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class RecepientDetail {

	@XmlElement(name="RecipientID")
	private String recipientID;
	
	@XmlElement(name="HealthTopics")
   private List<HealthTopics> healthTpoics; 
	
	
	public List<HealthTopics> getHealthTpoics() {
		return healthTpoics;
	}

	public void setHealthTpoics(List<HealthTopics> healthTpoics) {
		this.healthTpoics = healthTpoics;
	}

	public String getRecepientID(){
		
		return recipientID;
		
	}
	
	public void setRecepientID(String recepientID){
		
		this.recipientID = recepientID;
		
	}
	
	
}
