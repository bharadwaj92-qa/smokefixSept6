package com.alerehealth.api.pojo.getuserattributes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="GetUserAttributeRes",namespace="http://www.alere.com/xsds/NextGenPortalServices.xsd")
public class GetUserAttributeRes {
	
	@XmlElement(name="FName")
	private String fName;
	
	@XmlElement(name="LName")
	private String lName;
	
	@XmlElement(name="DOB")
	private String dob;
	
	@XmlElement(name="Gender")
	private String gender;
	
	@XmlElement(name="AddressID" )
	private int addressID;
	
	@XmlElement(name="AddressLine1")
	private String addressLine1;
	
	@XmlElement(name="AddressLine2")
	private String addressLine2;
	
	@XmlElement(name="City")
	private String city;
	
	@XmlElement(name="State")
	private String state;
	
	@XmlElement(name="ZipCode")
	private long zipCode;
	
	@XmlElement(name="PrimaryPhoneID" )
	private long primaryPhoneID;
	
	@XmlElement(name="PrimaryPhone")
	private long primaryPhone;
	
	@XmlElement(name="BackUpPhone")
	private long backUpPhone;
	
	@XmlElement(name="BackUpPhoneID")
	private int backUpPhoneID;
	
	@XmlElement(name="PrimaryPhoneType")
	private int primaryPhoneType;
	
	@XmlElement(name="BackUpPhoneType")
	private int backUpPhoneType;
	
	@XmlElement(name="Email")
	private String email;
	
	@XmlElement(name="ParticipantEmailID")
	private String participantEmailID;
	
	@XmlElement(name="PrimaryPhoneExt" )
	private long primaryPhoneExt;

	@XmlElement(name="BackUpPhoneExt")
	private long backUpPhoneExt;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public long getPrimaryPhoneID() {
		return primaryPhoneID;
	}

	public void setPrimaryPhoneID(long primaryPhoneID) {
		this.primaryPhoneID = primaryPhoneID;
	}

	public long getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(long primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public long getBackUpPhone() {
		return backUpPhone;
	}

	public void setBackUpPhone(long backUpPhone) {
		this.backUpPhone = backUpPhone;
	}

	public int getBackUpPhoneID() {
		return backUpPhoneID;
	}

	public void setBackUpPhoneID(int backUpPhoneID) {
		this.backUpPhoneID = backUpPhoneID;
	}

	public int getPrimaryPhoneType() {
		return primaryPhoneType;
	}

	public void setPrimaryPhoneType(int primaryPhoneType) {
		this.primaryPhoneType = primaryPhoneType;
	}

	public int getBackUpPhoneType() {
		return backUpPhoneType;
	}

	public void setBackUpPhoneType(int backUpPhoneType) {
		this.backUpPhoneType = backUpPhoneType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParticipantEmailID() {
		return participantEmailID;
	}

	public void setParticipantEmailID(String participantEmailID) {
		this.participantEmailID = participantEmailID;
	}

	public long getPrimaryPhoneExt() {
		return primaryPhoneExt;
	}

	public void setPrimaryPhoneExt(long primaryPhoneExt) {
		this.primaryPhoneExt = primaryPhoneExt;
	}

	public long getBackUpPhoneExt() {
		return backUpPhoneExt;
	}

	public void setBackUpPhoneExt(long backUpPhoneExt) {
		this.backUpPhoneExt = backUpPhoneExt;
	}
	
	
}
