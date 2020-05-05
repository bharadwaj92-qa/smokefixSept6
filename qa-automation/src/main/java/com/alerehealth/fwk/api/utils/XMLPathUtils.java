package com.alerehealth.fwk.api.utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class XMLPathUtils {
	
	
	
	public static String getTextContent(String tagName,Response response)
	{
		
		XmlPath xmlPath=new XmlPath(response.asString());
		
		return xmlPath.get(tagName).toString();
		
	}

}
