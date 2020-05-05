package com.alerehealth.api.pojo.usersessioninfo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name ="ContentNamespaces" ,namespace = "http://alerewellnessportal.com/xsds/SessionContentServiceV01.xsd")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContentNamespaces {

	@XmlElement(name="ContentNamespace")
	private List<ContentNameSpace> contentNameSpace1;

	public List<ContentNameSpace> getContentNameSpace() {
		return contentNameSpace1;
	}

	public void setContentNameSpace(List<ContentNameSpace> contentNameSpace) {
		this.contentNameSpace1 = contentNameSpace;
	}
	
	
}
