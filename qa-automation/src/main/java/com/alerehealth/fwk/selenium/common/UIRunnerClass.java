package com.alerehealth.fwk.selenium.common;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, features = { "src/test/resources/ui/features" }, plugin = {
		"json:target/cucumber-parallel/json/1.json", "html:target/cucumber-parallel/html/1",
		"junit:target/cucumber-parallel/junit/1.xml"},

		glue = {"com.alerehealth.ui.stepdefenitions", "com.alerehealth.fwk.common"},


		tags = {"@Smoke,@Regression" }, monochrome = true)







public class UIRunnerClass {

	@BeforeClass
	public static void setupProperties() {
		// value to be set in case , execution is being done on local machine
		// rather through jenkins

		/*System.setProperty("propertyFileName", "local");

		System.setProperty("ClientName", "HealthNet");*/

	}
}