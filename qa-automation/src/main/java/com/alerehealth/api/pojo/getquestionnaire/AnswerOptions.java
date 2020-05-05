package com.alerehealth.api.pojo.getquestionnaire;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "AnswerOptions" ,namespace = "http://www.alere.com/xsds/ApolloAssessment.xsd")
@XmlAccessorType (XmlAccessType.FIELD)
public class AnswerOptions {
	
	
	
	public List<AnswerOption> getAnswerOptionsList() {
        return answerOptionsList;
    }

    public void setAnswerOptionsList(List<AnswerOption> answerOptionsList) {
        this.answerOptionsList = answerOptionsList;
    }

    @XmlElement(name="AnswerOption")
    List<AnswerOption> answerOptionsList;
	
	 	}
