/**
 * Helper file to retrieve values from Property files 
 */

package com.alerehealth.fwk.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertyFileReader {

	private final Properties configProp = new Properties();
	
	public PropertyFileReader(String filePath, String propertyFileName) throws IOException{
		
			String propFilePath = (propertyFileName.contains(".properties"))?propertyFileName:propertyFileName+".properties" ; 
			
			String fullPath = propFilePath;

			System.out.println("Reading property file from: "+propFilePath);

			InputStream propFileStream = PropertyFileReader.class.getClassLoader().getResourceAsStream(fullPath);
			
			try {

				configProp.load(propFileStream);

			} catch (IOException e) {

				System.err.println("Error reading properties file. Please make sure that Properties file is as expected");

				throw e;
			}
			
	}
		
	
	public PropertyFileReader(String propertyFileName) throws IOException{
		
		this("",propertyFileName );
	}
	
	/**
	 * Helper method to get a property value
	 * @param key : property whose value needs to be retrieved
	 * @return value of property
	 */
	public String getPropertyValue(String key){
		
		return	configProp.getProperty(key);
		
	}
		
	/**
	 * Helper method to get all property names
	 * @return Unique set of Property Names
	 */
	public Set getAllPropertyNames() {
		
		return configProp.keySet();
	}

	/**
	 * Helper method to verify if a Property is present in Property file
	 * @param key: Property that should be present in Property file
	 */
	public boolean containsKey(String key) {
		return configProp.containsKey(key);
	}
		
}
	
	

