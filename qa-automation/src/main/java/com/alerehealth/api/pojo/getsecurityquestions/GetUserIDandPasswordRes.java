package com.alerehealth.api.pojo.getsecurityquestions;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="GetUserIDandPasswordRes",namespace="http://www.alere.com/xsds/NextGenPortalServices.xsd")
public class GetUserIDandPasswordRes {
	
	@XmlElement(name="UserID")
	private String userId;
	
	@XmlElement(name="SecondSecurityQuestionValue")
	private String SecondSecurityQuestionValue;
	
	@XmlElement(name="FirstSecurityQuestionValue")
	private String FirstSecurityQuestionValue;
	
	@XmlElement(name="FirstSecurityQuestionList")
	private FirstSecurityQuestionList firstSecurityQuestionList;
	
	@XmlElement(name="SecondSecurityQuestionList")
	private SecondSecurityQuestionList secondSecurityQuestionList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSecondSecurityQuestionValue() {
		return SecondSecurityQuestionValue;
	}

	public void setSecondSecurityQuestionValue(String secondSecurityQuestionValue) {
		SecondSecurityQuestionValue = secondSecurityQuestionValue;
	}

	public String getFirstSecurityQuestionValue() {
		return FirstSecurityQuestionValue;
	}

	public void setFirstSecurityQuestionValue(String firstSecurityQuestionValue) {
		FirstSecurityQuestionValue = firstSecurityQuestionValue;
	}

	public FirstSecurityQuestionList getFirstSecurityQuestionList() {
		return firstSecurityQuestionList;
	}

	public void setFirstSecurityQuestionList(FirstSecurityQuestionList firstSecurityQuestionList) {
		this.firstSecurityQuestionList = firstSecurityQuestionList;
	}

	public SecondSecurityQuestionList getSecondSecurityQuestionList() {
		return secondSecurityQuestionList;
	}

	public void setSecondSecurityQuestionList(SecondSecurityQuestionList secondSecurityQuestionList) {
		this.secondSecurityQuestionList = secondSecurityQuestionList;
	}
	
	

}
