package com.alerehealth.api.pojo.readhealthdata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Attribute",namespace="http://www.alere.com/xsds/HealthData.xsd")
public class Attribute {
	
	@XmlElement(name="ID" )
	private int id;
	
	@XmlElement(name="Value")
	private String value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
