package com.alerehealth.api.pojo.unreadmsgcountbyfolder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="UnreadMessagesList",namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class UnreadMessagesList {
	
	
	@XmlElement(name="UnreadMessages")
	private UnreadMessages unreadMessages;

	public UnreadMessages getUnreadMessages() {
		return unreadMessages;
	}

	public void setUnreadMessages(UnreadMessages unreadMessages) {
		this.unreadMessages = unreadMessages;
	}
	
	

}
