package com.alerehealth.api.pojo.getquestionnaire;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="QGroups",namespace="http://www.alere.com/xsds/ApolloAssessment.xsd")
@XmlAccessorType (XmlAccessType.FIELD)
public class QGroups {
	
	@XmlElement(name="QGroup")
	private List<QGroup> qgroups;

	public List<QGroup> getQgroup() {
		return qgroups;
	}

	
	public void setQgroup(List<QGroup> qgroup) {
		this.qgroups = qgroup;
	}
	
	
}
