package com.alerehealth.api.pojo.usersessioninfo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FeatureList",namespace="http://alerewellnessportal.com/xsds/SessionContentServiceV01.xsd")
public class FeatureList {
	
	@XmlElement(name="FeatureName")
	private List<String> featureName;

	public List<String> getFeatureName() {
		return featureName;
	}

	public void setFeatureName(List<String> featureName) {
		this.featureName = featureName;
	}
	
	
	

}
