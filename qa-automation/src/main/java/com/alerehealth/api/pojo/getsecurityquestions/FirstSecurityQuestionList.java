package com.alerehealth.api.pojo.getsecurityquestions;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FirstSecurityQuestionList",namespace="http://www.alere.com/xsds/NextGenPortalServices.xsd")
public class FirstSecurityQuestionList {
	
	@XmlElement(name="SecurityQuestion")
	private List<SecurityQuestion> securityQuestionslist;

	public List<SecurityQuestion> getSecurityQuestions() {
		return securityQuestionslist;
	}

	public void setSecurityQuestions(List<SecurityQuestion> securityQuestions) {
		this.securityQuestionslist = securityQuestions;
	}
	
	
	
	
	

}
