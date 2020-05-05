package com.alerehealth.api.pojo.getquestionnaire;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Questionnaire",namespace="http://www.alere.com/xsds/ApolloAssessment.xsd")
@XmlAccessorType(XmlAccessType.FIELD)
public class Questionnaire {
	
	
	private String id;
	
	private String PersonalizationActivity;
	

	@XmlElement(name="QGroups")
	private QGroups qgroupsInList;


	public String getId() {
		return id;
	}

    @XmlElement(name="ID")
	public void setId(String id) {
		this.id = id;
	}


	public String getPersonalizationActivity() {
		return PersonalizationActivity;
	}

    @XmlElement(name="PersonalizationActivity")
	public void setPersonalizationActivity(String personalizationActivity) {
		PersonalizationActivity = personalizationActivity;
	}


	public QGroups getQgroups() {
		return qgroupsInList;
	}


	public void setQgroups(QGroups gqropus) {
		this.qgroupsInList = qgroupsInList;
	}
	
	

}
