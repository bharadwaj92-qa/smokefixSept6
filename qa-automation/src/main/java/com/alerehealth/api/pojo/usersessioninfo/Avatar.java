package com.alerehealth.api.pojo.usersessioninfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Avatar",namespace="http://alerewellnessportal.com/xsds/SessionContentServiceV01.xsd")
@XmlAccessorType(XmlAccessType.FIELD)
public class Avatar {
	
	@XmlElement(name="ScreenName")
	private String screenName;
	
	@XmlElement(name="AvatarHair")
	private String avatarHair;
	
	@XmlElement(name="AvatarExpression")
	private String avatarExpression;
	
	@XmlElement(name="AvatarColor")
	private String avatarColor;

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getAvatarHair() {
		return avatarHair;
	}

	public void setAvatarHair(String avatarHair) {
		this.avatarHair = avatarHair;
	}

	public String getAvatarExpression() {
		return avatarExpression;
	}

	public void setAvatarExpression(String avatarExpression) {
		this.avatarExpression = avatarExpression;
	}

	public String getAvatarColor() {
		return avatarColor;
	}

	public void setAvatarColor(String avatarColor) {
		this.avatarColor = avatarColor;
	}
	
	

}
