package com.alerehealth.api.pojo.unreadmsgcountbyfolder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="UnreadMessages",namespace="http://www.alere.com/xsds/MessageCenter.xsd")
public class UnreadMessages {
	
	@XmlElement(name="Count")
	private int Count;
	
	@XmlElement(name="FolderID")
	private int folderID;
	
	@XmlElement(name="FolderName")
	private String folderName;

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public int getFolderID() {
		return folderID;
	}

	public void setFolderID(int folderID) {
		this.folderID = folderID;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	
	

}
