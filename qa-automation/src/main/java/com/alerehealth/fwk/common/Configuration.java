package com.alerehealth.fwk.common;

import com.alerehealth.fwk.exceptions.PropertyFileMissingException;

import java.io.IOException;

public class Configuration {

    public static Configuration configuration;

    private  String portal_url;
    private  String callcenter_url;
    private  String api_endpoint;
    private  String cdr_db_host;
    private  String cdr_db;
    private  String cdr_db_username;
    private  String cdr_db_password;
    private  String prpc_db_host;
    private  String prpc_db;
    private  String prpc_db_username;
    private  String prpc_db_password;
    private String C3UserName;
    private String C3Password;
    private String sso_file_url;
    private String C3UserDisplayName;


    public String getC3UserDisplayName() {
		return C3UserDisplayName;
	}

	public void setC3UserDisplayName(String c3UserDisplayName) {
		C3UserDisplayName = c3UserDisplayName;
	}

	public String getC3UserName() {
		return C3UserName;
	}

	public void setC3UserName(String c3UserName) {
		C3UserName = c3UserName;
	}

	public String getC3Password() {
		return C3Password;
	}

	public void setC3Password(String c3Password) {
		C3Password = c3Password;
	}

	private  String modeofExecution;


    private String browser;


    private String c3PO_Url;



    public static void setConfiguration(Configuration configuration) {
        Configuration.configuration = configuration;
    }

    public static Configuration getConfiguration() {

        if(configuration==null){


            configuration = createConfiguation();


        }
        return configuration;
    }

    private static Configuration createConfiguation() {

        Configuration configuration = new Configuration();

        String propertyFileName = System.getProperty("propertyFileName");

        if(propertyFileName==null){

            propertyFileName = System.getenv("propertyFileName");
        }
        if(propertyFileName==null){

            propertyFileName = "uat";
        }

        PropertyFileReader propertyFileReader;
        try {
            propertyFileReader = new PropertyFileReader(propertyFileName);

        }catch (IOException e){

            throw new PropertyFileMissingException(propertyFileName);
        }

        configuration.setApi_endpoint(propertyFileReader.getPropertyValue("api_endpoint"));
        configuration.setCallcenter_url(propertyFileReader.getPropertyValue("callcenter_ui_url"));
        configuration.setPortal_url(propertyFileReader.getPropertyValue("portal_ui_url"));
        configuration.setC3PO_Url(propertyFileReader.getPropertyValue("c3PO_portal_url"));
        configuration.setModeofExecution(propertyFileReader.getPropertyValue("modeofExecution"));
        configuration.setBrowser(propertyFileReader.getPropertyValue("browser"));
        //CDR DB data
        configuration.setCdr_db(propertyFileReader.getPropertyValue("cdr_db"));
        configuration.setCdr_db_password(propertyFileReader.getPropertyValue("cdr_db_password"));
        configuration.setCdr_db_host(propertyFileReader.getPropertyValue("cdr_db_host"));
        configuration.setCdr_db_username(propertyFileReader.getPropertyValue("cdr_db_username"));

        //PRPC DB data
        configuration.setPrpc_db_host(propertyFileReader.getPropertyValue("prpc_db_host"));
        configuration.setPrpc_db(propertyFileReader.getPropertyValue("prpc_db"));
        configuration.setPrpc_db_username(propertyFileReader.getPropertyValue("prpc_db_username"));
        configuration.setPrpc_db_password(propertyFileReader.getPropertyValue("prpc_db_password"));
        //C3 login 
        configuration.setC3UserName(propertyFileReader.getPropertyValue("C3UserName"));
        configuration.setC3Password(propertyFileReader.getPropertyValue("C3Password"));
        configuration.setSso_file_url(propertyFileReader.getPropertyValue("sso_file_url"));
        configuration.setC3UserDisplayName(propertyFileReader.getPropertyValue("C3UserDisplayName"));



        return configuration;
    }

    public String getPortal_url() {
        return portal_url;
    }

    public void setPortal_url(String portal_url) {
        this.portal_url = portal_url;
    }

    public String getCallcenter_url() {
        return callcenter_url;
    }

    public void setCallcenter_url(String callcenter_url) {
        this.callcenter_url = callcenter_url;
    }

    public String getApi_endpoint() {
        return api_endpoint;
    }

    public void setApi_endpoint(String api_endpoint) {
        this.api_endpoint = api_endpoint;
    }

    public String getCdr_db_host() {
        return cdr_db_host;
    }

    public void setCdr_db_host(String cdr_db_host) {
        this.cdr_db_host = cdr_db_host;
    }

    public String getCdr_db() {
        return cdr_db;
    }

    public void setCdr_db(String cdr_db) {
        this.cdr_db = cdr_db;
    }

    public String getCdr_db_username() {
        return cdr_db_username;
    }

    public void setCdr_db_username(String cdr_db_username) {
        this.cdr_db_username = cdr_db_username;
    }

    public String getCdr_db_password() {
        return cdr_db_password;
    }

    public void setCdr_db_password(String cdr_db_password) {
        this.cdr_db_password = cdr_db_password;
    }

    public String getPrpc_db_host() {
        return prpc_db_host;
    }

    public void setPrpc_db_host(String prpc_db_host) {
        this.prpc_db_host = prpc_db_host;
    }

    public String getPrpc_db() {
        return prpc_db;
    }

    public void setPrpc_db(String prpc_db) {
        this.prpc_db = prpc_db;
    }

    public String getPrpc_db_username() {
        return prpc_db_username;
    }

    public void setPrpc_db_username(String prpc_db_username) {
        this.prpc_db_username = prpc_db_username;
    }

    public String getPrpc_db_password() {
        return prpc_db_password;
    }

    public void setPrpc_db_password(String prpc_db_password) {
        this.prpc_db_password = prpc_db_password;
    }



    public String getModeofExecution() {
        return modeofExecution;
    }

    public void setModeofExecution(String modeofExecution) {
        this.modeofExecution = modeofExecution;
    }


    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getC3PO_Url() {
        return c3PO_Url;
    }

    public void setC3PO_Url(String c3PO_Url) {
        this.c3PO_Url = c3PO_Url;
    }

    public String getSso_file_url() {
        return sso_file_url;
    }

    public void setSso_file_url(String sso_file_url) {
        this.sso_file_url = sso_file_url;
    }

}
