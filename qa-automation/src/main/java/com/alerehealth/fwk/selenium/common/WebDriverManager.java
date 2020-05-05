package com.alerehealth.fwk.selenium.common;


import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.common.OperatingSystem;
import com.alerehealth.fwk.exceptions.InvalidExecutionModeSpecified;
import com.alerehealth.fwk.selenium.constants.Browser;
import com.alerehealth.fwk.selenium.constants.ExecutionMode;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.ConcurrentParameterized;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WebDriverManager {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

   // private static WebDriver webDriver;

    public static WebDriver getWebDriverInstance() {

        if(threadDriver.get()==null) {

            String browserFromPropertyFile = Configuration.getConfiguration().getBrowser();
            String executionFromPropertyFile = Configuration.getConfiguration().getModeofExecution();

            Browser browser = Browser.valueOf(browserFromPropertyFile.toUpperCase());

            ExecutionMode executionMode = ExecutionMode.valueOf(executionFromPropertyFile.toUpperCase());

            WebDriver webDriver = createWebDriver(browser, executionMode);

            webDriver.manage().deleteAllCookies();

            webDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

            webDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

            webDriver.manage().window().maximize();

            threadDriver.set(webDriver);
        }

        return threadDriver.get();
    }

    public static WebDriver createWebDriver(){

        return createWebDriver(Browser.IE, ExecutionMode.LOCAL);

    }

    public static WebDriver createWebDriver(Browser browser, ExecutionMode executionMode){


        switch (executionMode){

            case LOCAL:{


                WebDriver webDriver = createWebDriverForLocalExecution(browser);


                return webDriver;

            }
            case REMOTE:{

                    DesiredCapabilities capabilities = getRemoteDesiredCapabilities(browser);

                    String jobName = "Alere Health UI Test Execution " + DateTimeUtils.getCurrentTimeStamp() + ":"
                            + "] - Using " + capabilities.getBrowserName();

                    capabilities.setCapability("name", jobName);

                    String USERNAME = System.getenv("SAUCE_USERNAME");
                    String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
                    //"http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:4450/wd/hub";
                    String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

                    WebDriver webDriver = null;
                    try {
                        webDriver = new RemoteWebDriver(new URL(URL), capabilities);
                    } catch (MalformedURLException e) {
                        LoggerUtils.info("Invalid SauceLabs URL: [" + URL + "]");
                    }

                return webDriver;

            }
            default: {

                throw new InvalidExecutionModeSpecified(executionMode.name()+ " is an invalid execution mode");
            }
        }

    }

    private static DesiredCapabilities getRemoteDesiredCapabilities(Browser browser) {

        DesiredCapabilities capabilities = null;
        switch (browser){

            case EDGE:{

                capabilities = DesiredCapabilities.edge();


            }
            case CHROME:{

                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                capabilities.setCapability("chromedriverVersion", "2.28");
                capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Windows 7");
                capabilities.setCapability("screenResolution", "1280x1024");

            }
            case FIREFOX:{

                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Windows 7");
                //capabilities.setCapability("screenResolution", "1280x1024");


            }
            //TODO: Safari browser support is not needed so it isnt included. If needed implement capabilities creation here
            default:{

                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability("iedriverVersion", "2.46.0");
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
                capabilities.setCapability("platform", "Windows 7");
                capabilities.setCapability("version", "11.0");
                capabilities.setCapability("screenResolution", "1280x1024");

            }


        }

        capabilities.setCapability("autoAcceptsAlerts", true);
        capabilities.setCapability("parent-tunnel", "sauce_admin");
        capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");

        return capabilities;

    }




    /**
     * Helper method to create WebDriver for Scripts execution in Local machines
     * @param browser
     * @return
     */
    public static WebDriver createWebDriverForLocalExecution(Browser browser){

        switch (browser){

            case CHROME:{

                String path = getDriverExecutablePath(browser);

                System.setProperty("webdriver.chrome.driver",path);

                ChromeOptions chromeOptions=  getChromeOptions();

                return new ChromeDriver(chromeOptions);

            }
            case EDGE:{

                String path = getDriverExecutablePath(browser);

                System.setProperty("webdriver.edge.driver", path);

                EdgeOptions edgeOptions = getEdgeOptions();

                return new EdgeDriver(edgeOptions);


            }
            case FIREFOX:{

                String path = getDriverExecutablePath(browser);

                System.setProperty("webdriver.gecko.driver",path);

                FirefoxOptions firefoxOptions = getFirefoxOptions();

                return new FirefoxDriver(firefoxOptions);
            }
            //TODO: As of now Safari isnt needed. If needed implement Safari browser creation here

            default:{

                String path = getDriverExecutablePath(browser);

                System.setProperty("webdriver.ie.driver", path);

                InternetExplorerOptions internetExplorerOptions = getIEOptions();

                return new InternetExplorerDriver(internetExplorerOptions);

            }
        }

    }

    /**
     * Helper method to get Driver path to set for execution
     * @param browser
     * @return path of the driver
     */
    private static String getDriverExecutablePath(Browser browser) {


        String resource  = osSpecificDriver(browser);

        File file = new File(".\\src\\main\\resources\\drivers\\"+resource);

        return  file.getAbsolutePath();

    }

    /**
     * Helper method to get OS specific driver
     * @param browser
     * @return driver name;
     */
    private static String osSpecificDriver(Browser browser) {

        String arch = System.getProperty("os.arch");

        OperatingSystem operatingSystem = getCurrentOperatingSystem();

        String resourceName = "";

        switch (browser){

            case IE:{

                resourceName="IEDriverServer_"+(arch.contains("64")? "64":"32")+".exe";

                break;
            }

            case EDGE:{

                resourceName="MicrosoftWebDriver.exe";

                break;

            }
            case CHROME:{

                resourceName="chromedriver_"+operatingSystem.name().toLowerCase()+((operatingSystem!= OperatingSystem.WINDOWS)? "" : ".exe");

                break;
            }
            case FIREFOX:{

                // linux_32

                resourceName = "geckodriver_"+operatingSystem.name().toLowerCase();

                resourceName += ((operatingSystem==OperatingSystem.MAC)?"": (arch.contains("64")? "64":"32"));

                resourceName +=((operatingSystem!= OperatingSystem.WINDOWS)? "" : ".exe");

                break;

            }
        }

        return resourceName;

    }


    /**
     * Helper method to construct needed ChromeOptions
     * @return chromeoptions to be used
     */
    private static ChromeOptions getChromeOptions(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--js-flags=--expose-gc");
        chromeOptions.addArguments("--enable-precise-memory-info");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-default-apps");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setExperimentalOption("useAutomationExtension", false);

        return chromeOptions;
    }

    /**
     * Helper method to construct needed Firefox Options for Webdriver object creation
     * @return firefoxoptions
     */
    private static FirefoxOptions getFirefoxOptions(){


        ProfilesIni profilesIni = new ProfilesIni();
        FirefoxProfile profile = profilesIni.getProfile("default");
        profile.setAssumeUntrustedCertificateIssuer(true);
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("browser.helperApps.neverAsk.openFile", "application/pdf");
        profile.setPreference("plugin.disable_full_page_plugin_for_types", "");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(profile);

        return firefoxOptions;
    }


    /**
     * Helper method to construct needed IE options for WebDriver object creation
     *
     * @return IEOptions
     */
    private static InternetExplorerOptions getIEOptions(){

        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();

		internetExplorerOptions.ignoreZoomSettings();
		internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
//		internetExplorerOptions.useCreateProcessApiToLaunchIe();
//		internetExplorerOptions.elementScrollTo(ElementScrollBehavior.TOP);
//		internetExplorerOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        return internetExplorerOptions;

    }

    /**
     * Helper method to construct Edge browser options for WebDriver object creation
     * @return Edge Briwser options
     */
    private static EdgeOptions getEdgeOptions(){

        EdgeOptions edgeOptions = new EdgeOptions();

        //TODO: Include more options on need. Initially Edge browser support is not of Priority
        return edgeOptions;
    }


    private static OperatingSystem getCurrentOperatingSystem(){

        String os = System.getProperty("os.name").toLowerCase();

        if(os.contains("win")){
            return OperatingSystem.WINDOWS;
        }else if(os.contains("mac")){

            return OperatingSystem.MAC;
        }else if(os.contains("linux")){

            return OperatingSystem.LINUX;
        }else{

            return null;
        }

    }


    public static void disposeWebDriver(){

        threadDriver.get().quit();

        threadDriver.set(null);
        /*webDriver.quit();

        webDriver = null;
*/

    }
}