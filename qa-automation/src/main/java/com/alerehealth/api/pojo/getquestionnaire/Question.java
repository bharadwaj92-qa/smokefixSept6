package com.alerehealth.api.pojo.getquestionnaire;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Question" ,namespace = "http://www.alere.com/xsds/ApolloAssessment.xsd")
@XmlAccessorType (XmlAccessType.FIELD)
public class Question {
	
	    @XmlAttribute(name = "isRequired")
	    Boolean isRequired;

	    @XmlAttribute(name = "isReadOnly")
	    Boolean isReadOnly;

	    @XmlElement(name = "ID")
	    String id;

	    @XmlElement(name = "QuestionType")
	    String questionType;

	    @XmlElement(name = "AdditionalInfo", required = false)
	    String additionalInfo;


	    @XmlElement(name = "LabelID")
	    String labelID;

	    @XmlElement(name = "QuestionText")
	    String QuestionText;

	    public Boolean getRequired() {
	        return isRequired;
	    }

	    public void setRequired(Boolean required) {
	        isRequired = required;
	    }

	    public Boolean getReadOnly() {
	        return isReadOnly;
	    }

	    public void setReadOnly(Boolean readOnly) {
	        isReadOnly = readOnly;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getQuestionType() {
	        return questionType;
	    }

	    public void setQuestionType(String questionType) {
	        this.questionType = questionType;
	    }

	    public String getAdditionalInfo() {
	        return additionalInfo;
	    }

	    public void setAdditionalInfo(String additionalInfo) {
	        this.additionalInfo = additionalInfo;
	    }

	    public String getLabelID() {
	        return labelID;
	    }

	    public void setLabelID(String labelID) {
	        this.labelID = labelID;
	    }

	    public String getQuestionText() {
	        return QuestionText;
	    }

	    public void setQuestionText(String questionText) {
	        QuestionText = questionText;
	    }

	    public String getUIHint() {
	        return UIHint;
	    }

	    public void setUIHint(String UIHint) {
	        this.UIHint = UIHint;
	    }

	    public String getAnswerType() {
	        return AnswerType;
	    }

	    public void setAnswerType(String answerType) {
	        AnswerType = answerType;
	    }

	    public String getDefaultAnswer() {
	        return DefaultAnswer;
	    }

	    public void setDefaultAnswer(String defaultAnswer) {
	        DefaultAnswer = defaultAnswer;
	    }

	    public AnswerOptions getAnswerOptions() {
	        return answerOptions;
	    }

	    public void setAnswerOptions(AnswerOptions answerOptions) {
	        this.answerOptions = answerOptions;
	    }

	    @XmlElement(name = "UIHint" , required = false)
	    String UIHint;

	    @XmlElement(name = "AnswerType")
	    String AnswerType;

	    @XmlElement(name = "DefaultAnswer" , required = false)
	    String DefaultAnswer;

	    @XmlElement(name = "AnswerOptions")
	    AnswerOptions answerOptions;



	}


