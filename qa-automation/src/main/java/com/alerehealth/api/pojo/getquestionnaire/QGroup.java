package com.alerehealth.api.pojo.getquestionnaire;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="QGroup",namespace="http://www.alere.com/xsds/ApolloAssessment.xsd")
@XmlAccessorType(XmlAccessType.FIELD)
public class QGroup {

	@XmlElement(name="ID")
   	private String id;

	@XmlElement(name="Seq")
	private String Seq;

	@XmlElement(name="Title")
	private String Title;
	
	@XmlElement(name="Questions")
	private Questions questionsInGroup;

	public String getId() {
		return id;
	}

	

	public void setId(String id) {
		this.id = id;
	}

	public String getSeq() {
		return Seq;
	}

	

	public void setSeq(String seq) {
		Seq = seq;
	}

	public String getTitle() {
		return Title;
	}

	

	public void setTitle(String title) {
		Title = title;
	}


	public Questions getQuestions() {
		return questionsInGroup;
	}

	public void setQuestions(Questions questions) {
		this.questionsInGroup = questions;
	}
	
	
	


}
