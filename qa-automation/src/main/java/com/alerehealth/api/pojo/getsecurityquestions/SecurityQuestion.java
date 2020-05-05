package com.alerehealth.api.pojo.getsecurityquestions;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SecurityQuestion",namespace="http://www.alere.com/xsds/NextGenPortalServices.xsd")
public class SecurityQuestion {
	
	
	@XmlElement(name="PromptValue")
	private String spromptValue;
	
	
	@XmlElement(name="Value")
	private String svalue;


	public String getPromptValue() {
		return spromptValue;
	}


	public void setPromptValue(String promptValue) {
		this.spromptValue = promptValue;
	}


	public String getValue() {
		return svalue;
	}


	public void setValue(String value) {
		this.svalue = value;
	}
	
	

}
