package com.alerehealth.api.pojo.readhealthdata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HealthDataResponses",namespace="http://www.alere.com/xsds/HealthData.xsd")
public class HealthDataResponses {
	
	@XmlElement(name="HealthDataID")
	private int healthDataID;
	
	@XmlElement(name="ParticipantID")
	private String participantID;
	
	@XmlElement(name="AlereID")
	private int alereID;

	@XmlElement(name="GroupID" )
	private int groupID;
	
	@XmlElement(name="HealthDataType")
	private String healthDataType;
	
	@XmlElement(name="MeasurementDate")
	private String measurementDate;
	
	@XmlElement(name="CollectedDate")
	private String CollectedDate;
	
	@XmlElement(name="MeasurementDateLocal")
	private String measurementDateLocal;
	
	@XmlElement(name="CollectedDateLocal")
	private String collectedDateLocal;
	
	@XmlElement(name="InsertDate")
	private String insertDate;
	
	@XmlElement(name="Value")
	private int value;
	
	@XmlElement(name="BMI")
	private int bmi;
	
	@XmlElement(name="Unit")
	private String Unit;
	
	@XmlElement(name="Source")
	private int source;
	
	@XmlElement(name="AppSource")
	private int appSource;
	
	@XmlElement(name="Comments")
	private String comments;
	
	@XmlElement(name="Longitude")
	private String longitude;
	
	@XmlElement(name="Latitude")
	private String latitude;
	
	@XmlElement(name="Attributes;")
	private Attributes attributes;

	public int getHealthDataID() {
		return healthDataID;
	}

	public void setHealthDataID(int healthDataID) {
		this.healthDataID = healthDataID;
	}

	public String getParticipantID() {
		return participantID;
	}

	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}

	public int getAlereID() {
		return alereID;
	}

	public void setAlereID(int alereID) {
		this.alereID = alereID;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getHealthDataType() {
		return healthDataType;
	}

	public void setHealthDataType(String healthDataType) {
		this.healthDataType = healthDataType;
	}

	public String getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(String measurementDate) {
		this.measurementDate = measurementDate;
	}

	public String getCollectedDate() {
		return CollectedDate;
	}

	public void setCollectedDate(String collectedDate) {
		CollectedDate = collectedDate;
	}

	public String getMeasurementDateLocal() {
		return measurementDateLocal;
	}

	public void setMeasurementDateLocal(String measurementDateLocal) {
		this.measurementDateLocal = measurementDateLocal;
	}

	public String getCollectedDateLocal() {
		return collectedDateLocal;
	}

	public void setCollectedDateLocal(String collectedDateLocal) {
		this.collectedDateLocal = collectedDateLocal;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getBmi() {
		return bmi;
	}

	public void setBmi(int bmi) {
		this.bmi = bmi;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getAppSource() {
		return appSource;
	}

	public void setAppSource(int appSource) {
		this.appSource = appSource;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	
	
}
