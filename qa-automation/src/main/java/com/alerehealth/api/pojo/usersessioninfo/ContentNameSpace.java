package com.alerehealth.api.pojo.usersessioninfo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ContentNamespace",namespace="http://alerewellnessportal.com/xsds/SessionContentServiceV01.xsd")
public class ContentNameSpace {
	
	@XmlElement(name="ContentNamespaceName")
	private String contentNamespaceName1;
	
	@XmlElement(name="ContentNamespaceValue")
	private String contentNamespaceValue1;

	public String getContentNamespaceName() {
		return contentNamespaceName1;
	}

	public void setContentNamespaceName(String contentNamespaceName) {
		this.contentNamespaceName1 = contentNamespaceName;
	}

	public String getContentNamespaceValue() {
		return contentNamespaceValue1;
	}

	public void setContentNamespaceValue(String contentNamespaceValue) {
		this.contentNamespaceValue1 = contentNamespaceValue;
	}
	
	

}
