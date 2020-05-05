package com.alerehealth.api.pojo.usersessioninfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SessionContentResponse" ,namespace = "http://alerewellnessportal.com/xsds/SessionContentServiceV01.xsd")
@XmlAccessorType(XmlAccessType.FIELD)
public class SessionContentResponse {
	
	@XmlElement(name="PID")
	private int pid;
	
	@XmlElement(name="MemberEligID")
	private int memberElgibleId;
	
	@XmlElement(name="FirstName")
	private String firstName;
	
	@XmlElement(name="LastName")
	private String lastName;
	
	@XmlElement(name="DOB")
	private String dob;
	
	@XmlElement(name="Gender")
	private String gender;
	
	@XmlElement(name="TOUAcceptedVersion")
	private int touAcceptedVersion;
	
	@XmlElement(name="ClientID")
	private int clientId;
	
	@XmlElement(name="ClientName")
	private String clientName;
	
	
	@XmlElement(name="ClientAbbreviation")
	private String clientAbbrevation;
	
	@XmlElement(name="WellnessPopulationID")
	private int welnessPopulationId;
	
	@XmlElement(name="EffectiveDate")
	private String effectiveDate;
	
	@XmlElement(name="IncentiveUnavailable")
	private boolean insentiveUnavailable;
	
	@XmlElement(name="Age")
	private int age;
	
	@XmlElement(name="LineOfBusiness")
	private String lineOfBusiness;
	
	@XmlElement(name="GroupNumber")
	private int groupNumber;
	
	@XmlElement(name="ParticipantRelation")
	private String participantRelation;
	
	@XmlElement(name="LanguageID")
	private int languageID;
	
	@XmlElement(name="DependentTOUAcceptedVersion")
	private int DependentTOUAcceptedVersion;
	
	
	private Avatar avatar;
	
	private ContentNamespaces contentNameSpaces;
	
	private FeatureList featureList;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getMemberElgibleId() {
		return memberElgibleId;
	}

	public void setMemberElgibleId(int memberElgibleId) {
		this.memberElgibleId = memberElgibleId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getTouAcceptedVersion() {
		return touAcceptedVersion;
	}

	public void setTouAcceptedVersion(int touAcceptedVersion) {
		this.touAcceptedVersion = touAcceptedVersion;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAbbrevation() {
		return clientAbbrevation;
	}

	public void setClientAbbrevation(String clientAbbrevation) {
		this.clientAbbrevation = clientAbbrevation;
	}

	public int getWelnessPopulationId() {
		return welnessPopulationId;
	}

	public void setWelnessPopulationId(int welnessPopulationId) {
		this.welnessPopulationId = welnessPopulationId;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public boolean isInsentiveUnavailable() {
		return insentiveUnavailable;
	}

	public void setInsentiveUnavailable(boolean insentiveUnavailable) {
		this.insentiveUnavailable = insentiveUnavailable;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public ContentNamespaces getContentNameSpaces() {
		return contentNameSpaces;
	}

	public void setContentNameSpaces(ContentNamespaces contentNameSpaces) {
		this.contentNameSpaces = contentNameSpaces;
	}

	public FeatureList getFeatureList() {
		return featureList;
	}

	public void setFeatureList(FeatureList featureList) {
		this.featureList = featureList;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLineOfBusiness() {
		return lineOfBusiness;
	}

	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getParticipantRelation() {
		return participantRelation;
	}

	public void setParticipantRelation(String participantRelation) {
		this.participantRelation = participantRelation;
	}

	public int getLanguageID() {
		return languageID;
	}

	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}

	public int getDependentTOUAcceptedVersion() {
		return DependentTOUAcceptedVersion;
	}

	public void setDependentTOUAcceptedVersion(int dependentTOUAcceptedVersion) {
		DependentTOUAcceptedVersion = dependentTOUAcceptedVersion;
	}
	
	
	
	
	
	

}
