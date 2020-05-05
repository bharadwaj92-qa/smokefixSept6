package com.alerehealth.api.pojo.readhealthdata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Attributes",namespace="http://www.alere.com/xsds/HealthData.xsd")
public class Attributes {
	
	@XmlElement(name="Attribute")
	private Attribute attribute;

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	
	

}
