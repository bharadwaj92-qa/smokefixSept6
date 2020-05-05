package com.alerehealth.api.pojo.getparticipantprograms;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PartProgramList",namespace="http://www.alere.com/xsds/Programs.xsd")
public class PartProgramList {
	
	@XmlElement(name="PartProgram")
	private List<PartProgram> partProgram;

	public List<PartProgram> getPartProgram() {
		return partProgram;
	}

	public void setPartProgram(List<PartProgram> partProgram) {
		this.partProgram = partProgram;
	}
	
	
	
	
	

}
