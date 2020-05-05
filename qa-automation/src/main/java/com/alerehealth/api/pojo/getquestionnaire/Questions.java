package com.alerehealth.api.pojo.getquestionnaire;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Questions" ,namespace = "http://www.alere.com/xsds/ApolloAssessment.xsd")
@XmlAccessorType (XmlAccessType.FIELD)

public class Questions {


	        @XmlElement(name="Question")
		    private List<Question> questions;

			public List<Question> getQuestions() {
				return questions;
			}

			public void setQuestions(List<Question> questions) {
				this.questions = questions;
			}
	        
	        
	        
	        
		    

		}


	

