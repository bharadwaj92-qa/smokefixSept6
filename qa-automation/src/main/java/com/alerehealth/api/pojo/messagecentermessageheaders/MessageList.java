package com.alerehealth.api.pojo.messagecentermessageheaders;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MessageList",namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class MessageList {

	@XmlElement(name="Message")
	private List<Message> message;

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}
	
	
	
	
}
