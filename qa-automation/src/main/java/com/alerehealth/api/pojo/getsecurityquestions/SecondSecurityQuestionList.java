package com.alerehealth.api.pojo.getsecurityquestions;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SecondSecurityQuestionList",namespace="http://www.alere.com/xsds/NextGenPortalServices.xsd")
public class SecondSecurityQuestionList {
	
	
	@XmlElement(name="SecurityQuestion")
	private List<SecurityQuestion> securityQuestions;

	public List<SecurityQuestion> getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(List<SecurityQuestion> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}
	
	

}
