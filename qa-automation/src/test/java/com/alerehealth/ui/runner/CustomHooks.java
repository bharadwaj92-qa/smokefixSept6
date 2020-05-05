package com.alerehealth.ui.runner;

import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.common.CustomLogger;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.selenium.common.WebDriverManager;
import com.jayway.restassured.RestAssured;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.Collection;

public class CustomHooks {

	@Before
	public void beforeScenario(Scenario scenario) throws Exception{

		System.out.println("Inside before scenario");

		LoggerUtils.intializeCustomLogger(scenario);

	}

	@Before("@API")
	public void beforeScenarioForAPI(){

		System.out.println("Setting API end point URL as "+Configuration.getConfiguration().getApi_endpoint());

		RestAssured.baseURI = Configuration.getConfiguration().getApi_endpoint();

	}


	//@After
	public void afterScenario(Scenario scenario){



		if(scenario.isFailed()){

			Collection<String> tags = scenario.getSourceTagNames();

			boolean isApiScenario = false;
			for(String tag: tags){

				if(tag.toLowerCase().contains("api")){

					isApiScenario = true;
					break;
				}

			}

			if(!isApiScenario){

				WebDriver webDriver = WebDriverManager.getWebDriverInstance();

				try {
					byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
					scenario.embed(screenshot, "image/png" );
				} catch (WebDriverException wde) {
					scenario.write("Embed Failed " + wde.getMessage());
				} catch (ClassCastException cce) {
					cce.printStackTrace();
					}
			}
		}
			WebDriverManager.disposeWebDriver();
			LoggerUtils.info("Disposed the Webdriver");

			LoggerUtils.destroyLogs();
	}
}
