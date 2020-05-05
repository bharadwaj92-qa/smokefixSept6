package com.alerehealth.api.pojo.getquestionnaire;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AnswerOption" ,namespace = "http://www.alere.com/xsds/ApolloAssessment.xsd")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnswerOption {
	
	   @XmlElement(name= "ID")
	    private Integer id;

	    @XmlElement(name= "LabelID")
	    private String LabelID;

	    @XmlElement(name= "Seq")
	    private String Seq;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getLabelID() {
	        return LabelID;
	    }

	    public void setLabelID(String labelID) {
	        LabelID	= labelID;
	    }

	    public String getAdditionalInfo() {
	        return AdditionalInfo;
	    }

	    public void setAdditionalInfo(String additionalInfo) {
	        AdditionalInfo = additionalInfo;
	    }

	    @XmlElement(name= "Label")
	    private String Label;

	    @XmlElement(name= "AdditionalInfo")
	    private String AdditionalInfo;




}
