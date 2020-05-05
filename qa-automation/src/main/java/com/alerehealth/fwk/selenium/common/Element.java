package com.alerehealth.fwk.selenium.common;

import java.awt.Frame;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class for all element objects in the test.
 */
public abstract class Element {
    private static final long DEFAULT_WAIT_DURATION_SECONDS = 30L;
    protected long waitDuration = DEFAULT_WAIT_DURATION_SECONDS;
    private static final long FRAMES_WAIT_DURATION_SECONDS = 45;

    /**
     */
    public Element() {

        PageFactory.initElements(getWebDriver(), this);
    }

    public long WaitDuration()
    {
        //TODO: Read from config file default duration
    	return DEFAULT_WAIT_DURATION_SECONDS;
    }
    /**
     * All pages and elements will get {@link WebDriver} from this location to ensure that we have the same web driver
     * across a given test. This will enable future expansion to parallel execution of tests in a single JVM.
     * @return WebDriver instance for this test.
     */
    protected WebDriver getWebDriver() {
        return WebDriverManager.getWebDriverInstance();
    }

    /**
     * Use this method to ensure that this component has loaded.
     * @return true if element was found.
     */
    public void waitForElementToBeDisplayed() {
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), WaitDuration(), WaitDuration()/10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                try {
                    return isDisplayed();
                } catch (final NoSuchElementException e) {
                    return false;
                }
            }
        });
    }




    /**
     * Use this method to ensure that this component has loaded.
     * @param element to check if is displayed
     */
    public void waitForElementToBeDisplayed(WebElement element) {

    	final WebElement element2 = element;
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), WaitDuration(), WaitDuration()/10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                try {
                    return element2.isDisplayed();
                } catch (final NoSuchElementException e) {
                    return false;
                }
            }
        });
    }

    /**
     * Use this method to ensure that this component has unloaded.
     */
    public void waitForElementToGoAway() {
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), WaitDuration(), WaitDuration()/10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                try {
                    return !isDisplayed();
                } catch (final NoSuchElementException e) {
                    return true;
                }
            }
        });
    }

    /**
     * Use this method to ensure that this component has unloaded.
     * @param element
     */
    public void waitForElementToGoAway(final WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), WaitDuration(), WaitDuration()/10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                try {
                    return !element.isDisplayed();
                } catch (final NoSuchElementException e) {
                    return true;
                }
            }
        });
    }

    /**
     * Use this method to ensure that a component has loaded properly.
     * @param selector to used to find the element.
     * @return true if element was found.
     */
    public void waitForComponentTobDisplayed(final By selector) {
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), WaitDuration());
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                try {
                    getWebDriver().findElement(selector);
                    return true;
                } catch (final NoSuchElementException e) {
                    return false;
                }
            }
        });
    }



    /**
     * Use this method to ensure that this component has loaded.
     * @param element to check if is displayed
     */
    public void waitForElementToBeEnabled(WebElement element) {

        final WebElement element2 = element;
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), WaitDuration(), WaitDuration()/10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                try {
                    return element2.isEnabled();
                } catch (final NoSuchElementException e) {
                    return false;
                }
            }
        });
    }

    public void scrollElementIntoView(WebElement element){

        ((JavascriptExecutor) getWebDriver())
                .executeScript("arguments[0].scrollIntoView()", element);
    }
    
   
    public void javaScriptClick(WebElement element){

    	JavascriptExecutor executor = (JavascriptExecutor)getWebDriver();
        executor.executeScript("arguments[0].click();", element);
    }
   
    public WebElement getWebElementWithDynamicXpath (String xpath, String substituteValue ) {

        return getWebDriver().findElement(By.xpath(xpath.replace("XXXX", substituteValue)));
    }
    
    
    public void explictwaitForTitle(String title) {
		
		WebDriverWait WDwait = new WebDriverWait(getWebDriver(), 20);
		WDwait.until(ExpectedConditions.titleIs(title));
	}
    
    
    public void explictwaitForAlert() {
		
		WebDriverWait WDwait = new WebDriverWait(getWebDriver(), 20);
		WDwait.until(ExpectedConditions.alertIsPresent());
	}


    public void waitForNewWindowToOpen(final int initialWindowsCount) {
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), WaitDuration(), WaitDuration()/10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                try {

                    Set<String> windowHandles = getWebDriver().getWindowHandles();

                    if(windowHandles.size()>initialWindowsCount){

                        return true;
                    }

                    return false;
                } catch (final NoSuchElementException e) {
                    return true;
                }
            }
        });
    }

    /**
     * Note: This method will work when user has to switch from Parent window to a new window. It wont work when
     * nultiple windows are open initialy
     * @param parentWindow to ignore
     */
    public void switchToNewWindow(String parentWindow){

        Set<String> winHandles = getWebDriver().getWindowHandles();

        for(String winHandle : winHandles){

            if(!winHandle.equals(parentWindow)) {
                getWebDriver().switchTo().window(winHandle);
            }
        }

    }



    public WebElement getModalDialogWebElement(){

        String xpath = "//*[contains(@id,'myModal') and contains(@style,'display: block;')]";

        WebElement modalDialog = getWebDriver().findElement(By.xpath(xpath));

        return modalDialog;

    }

    public void closeModalDialog(){

        WebElement modalDialogElement = getModalDialogWebElement();

        String buttonXpath = ".//button[@class='close']";

        modalDialogElement.findElement(By.xpath(buttonXpath)).click();
        
        waitForElementToGoAway(modalDialogElement);
    }

    public void waitForModelDialogToOpen(){

        String xpath = "//*[contains(@id,'myModal') and contains(@style,'display: block;')]";

        waitForComponentTobDisplayed(By.xpath(xpath));
    }

    public void javaScriptSendKeys(WebElement element,String value)
    {
        ((JavascriptExecutor) getWebDriver())
                .executeScript("arguments[0].value='"+value+"';", element);

    }

    public String getModalDialogTitle(){

        WebElement modalDialogEle = getModalDialogWebElement();

        String xpath = ".//*[@class='header']";

        WebElement modalDialogTitle = modalDialogEle.findElement(By.xpath(xpath));

        return modalDialogTitle.getText().trim();

    }

    public void waitForModalDialogTitleToChange(String titleExpected){

        String xpath = "//*[contains(@id,'myModal') and contains(@style,'display: block;')]//*[contains(@class,'header') and contains(text(),'"+titleExpected+"')]";

        waitForComponentTobDisplayed(By.xpath(xpath));

    }
    public void navigateToBackPage(){
        getWebDriver().navigate().back();
    }

    public void actionSendKeys(Keys key,WebElement element)
    {
        intializeAction(getWebDriver()).sendKeys(element,key).build().perform();;
    }

    public  void actionSendKeys(Keys key)
    {
        intializeAction(getWebDriver()).sendKeys(key).build().perform();

    }

    public  void actionSendKeys(String key,WebElement element)
    {

        intializeAction(getWebDriver()).sendKeys(element,key).build().perform();
    }
    private Actions intializeAction(WebDriver driver)
    {
        return new Actions(driver);
    }

    public void waitForSpecifiedTime(int secs){

        Actions actions = new Actions(getWebDriver());

        actions.pause(secs*1000).perform();


    }

    public void closeCurrentPage(){

        getWebDriver().close();

    }

    /**
     * Note: This method will work when user has to switch from Parent window to a new window. It wont work when
     * nultiple windows are open initialy
     * @param parentWindows to ignore
     */
    public void switchToNewWindow(List<String> parentWindows){

        Set<String> winHandles = getWebDriver().getWindowHandles();

        for(String winHandle : winHandles){

            if(!parentWindows.contains(winHandle)) {
                getWebDriver().switchTo().window(winHandle);
                break;
            }
        }

    }

    public void waitForPageToLoad(){

        System.out.println("Inside wait");
        long startTime = System.currentTimeMillis();

        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), FRAMES_WAIT_DURATION_SECONDS);

        try {
            webDriverWait.until(new ExpectedCondition<Boolean>() {

                public Boolean apply(WebDriver d) {
                    JavascriptExecutor js = (JavascriptExecutor) d;
                    String readyState = js.executeScript("return document.readyState").toString();
                    System.out.println("Ready State: " + readyState);

                    Boolean isPageInReadyState = readyState.equals("complete");
                    if (isPageInReadyState) {
                        Boolean isJQueryActive = (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
                        System.out.println("Is JQueryActive" + isJQueryActive);
                        return isJQueryActive;
                    }
                    return isPageInReadyState;

                }
            });

        }catch (Exception e){

            waitForSpecifiedTime((int)FRAMES_WAIT_DURATION_SECONDS);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("waiting for "+((endTime-startTime)/1000));


    }

    public void switchToFrame(WebElement frameElement){


        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), FRAMES_WAIT_DURATION_SECONDS);

        webDriverWait.until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(frameElement));

    }
    
    /*
     * Switch to default content in frames
     */
    public void switchToDefault() {
		try {
			getWebDriver().switchTo().defaultContent();
	
		} catch (NoSuchElementException nse) {
		
			System.out.println("Unable to switch to default frame" + nse);
			
		} 

	}
    
    
    public void Implicitwait(int secs) {
		
		getWebDriver().manage().timeouts().implicitlyWait(secs*1000, TimeUnit.SECONDS);
		
	} 

    
    public void staleIssue(WebElement element){
    
    	
    for(int i=0;i<=2;i++)

    {

    try{

    	//element.click();
    	javaScriptClick(element);
    	break;
    	
    }catch(Exception e){

      System.out.println(e.getMessage());

      }

     }
    
   }
    
  public boolean isAlertPresent() {
		try 
		{
			getWebDriver().switchTo().alert();
		
			System.out.println("Alert is present");
			
			return true;
		}catch (org.openqa.selenium.NoAlertPresentException e) {
			
			System.out.println("Exception in isAlertPresent  ");
			
			return false;
		}
	}// End of isAlertPresent

    
  public void alertAcceptPopup() {
		if (isAlertPresent()) {
			
			//System.out.println("Alert Text: " +getWebDriver().switchTo().alert().getText());
			
			getWebDriver().switchTo().alert().accept();
			
		} else {
			
			System.out.println("Alert Present: " + isAlertPresent());
			
		}
	}// End of Alertaccept

	
  /*
   * To get our system date
   */
	public String getCurrentDate(){
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH::MM PM");
		LocalDate localDate = LocalDate.now(ZoneId.of("CST"));
		System.out.println(dtf.format(localDate));
		return dtf.format(localDate); 
		
	}
	
	//Get The Current Day
	public static String getCurrentDay(){
			    
	    //Create a Calendar Object
		        
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		 
		//Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		   
		System.out.println("Today Int: " + todayInt +"\n");
		 
		//Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		        
		System.out.println("Today Str: " + todayStr + "\n");
		 
		return todayStr;
	}
	
	public static void getsubtractDate(){
		
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        
        calendar.add(Calendar.DAY_OF_MONTH,-2);
        
        System.out.println("Days after subtracting " +calendar.get(Calendar.DATE));
		
     
    }
	
   /*
    * Select dropdown based on webElement and visible text
    */
	
   public void selectDropDwn(String element,String value) throws Exception{
		
	 //  JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
	   
		WebElement ele = getWebDriver().findElement(By.xpath(element));
		
		Select se = new Select(ele);
		
		Thread.sleep(2000);
		
		se.selectByVisibleText(value);
		
	//	js.executeScript("$(arguments[0]).fireEvent('change');", ele);
		
		Thread.sleep(2000);
		
		System.out.println("Selected dropdown value is: " +se.getAllSelectedOptions().get(0).getText());
	}
   
   
   public void JavascriptscrollUP() {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
			jse.executeScript("scroll(-100,0)");
		} catch (NoSuchElementException nse) {
			System.out.println("Element Not Found | Error - " + nse);
			
		}
	}
   
   public void JavascriptscrollDown() {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
			jse.executeScript("scroll(100, 0)");
		} catch (NoSuchElementException nse) {
			System.out.println("Element Not Found | Error - " + nse);
		}
	}
   
   public void fireSpecifiedEvent(WebElement webElement , String evenToFire){
	   
	   String javascript = "arguments[0]."+evenToFire+";"; 
	   try{
	   ((JavascriptExecutor) getWebDriver()).executeScript(javascript,webElement);
	   }catch(JavascriptException jse){
		   
		   if(!evenToFire.contains("()")){
			   try{
			   javascript = "arguments[0]."+evenToFire+"();"; 
			   ((JavascriptExecutor) getWebDriver()).executeScript(javascript,webElement);
			   }catch(Exception e){
				   
				   e.printStackTrace();
			   }
		   }
		  
		   
	   }
   }
   
   public void javaScriptHover(WebElement element){

	     String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) getWebDriver()).executeScript(mouseOverScript,element);
	    }
   
   
   public void MouseHoverByJavaScript(WebElement element)
   {

   String javaScript = "var evObj = document.createEvent(‘MouseEvents’);" +
   "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
   "arguments[0].dispatchEvent(evObj);";
   JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
   js.executeScript(javaScript, element);
   }
	
   
   public void javaScriptFocusWebElement(WebElement webElementToFocus){

       try{

           JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();

           javascriptExecutor.executeScript("arguments[0].focus();", webElementToFocus);

       }catch(StaleElementReferenceException|JavascriptException|NoSuchElementException exception){

           javaScriptClick(webElementToFocus);
       }
   }
   
   
   public void javaScriptFocusClick(WebElement webElementToFocus){

       try{

           JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();

           javascriptExecutor.executeScript("arguments[0].focus();", webElementToFocus);

           javascriptExecutor.executeScript("arguments[0].click();", webElementToFocus);

       }catch(StaleElementReferenceException|JavascriptException|NoSuchElementException exception){

           javaScriptClick(webElementToFocus);
       }
   }
   
   public boolean isLabelExpand(String expandLabel) {

 		String clientExpandXpath = "//*[contains(@class,'titleBarLabelStyle') and contains(text(),'"+expandLabel+"')]/ancestor::td[contains(@class,'titleBarBackground')]/preceding-sibling::td[@class='titleBarIconExpanded']";

 		try {
 			WebElement elementclientExpand = getWebDriver().findElement(By.xpath(clientExpandXpath));
 			return elementclientExpand.isDisplayed();
 		} catch (NoSuchElementException e) {

 			return false;
 		}
 	}
 	
 	
 	public boolean isLabelCollapse(String collapseLabel) {

 		String clientCollapseXpath = "//*[contains(@class,'titleBarLabelStyle') and contains(text(),'"+collapseLabel+"')]/ancestor::td[contains(@class,'titleBarBackground')]/preceding-sibling::td[@class='titleBarIconCollapsed']";

 		try {
 			WebElement elementclientCollapse = getWebDriver().findElement(By.xpath(clientCollapseXpath));
 			return elementclientCollapse.isDisplayed();
 		} catch (NoSuchElementException e) {

 			return false;
 		}
 	}
 	
 	/**
 	 * Method to expand or collapse a Section in Clients tab. 
 	 * @param sectionLabel to expand
 	 * @param action: pass expand to expand the section, collapse to collapse 
 	 */
 	
 	public void expandOrCollapseSection(String sectionLabel, String action){
 				
 		boolean labelExpand = isLabelExpand(sectionLabel); 
 		
 		if(action.toLowerCase().contains("expand")){
 			
 			if(!labelExpand){
 				
 				String clientcollapseXpath = "//*[contains(@class,'titleBarLabelStyle') and contains(text(),'"+sectionLabel+"')]/ancestor::td[contains(@class,'titleBarBackground')]/preceding-sibling::td[@class='titleBarIconCollapsed']";
 				WebElement elementclientcollapse = getWebDriver().findElement(By.xpath(clientcollapseXpath));
 				System.out.println("Clicking collapse of " + sectionLabel );
 				javaScriptClick(elementclientcollapse);
 				
 			}
 			
 		}
 		else{
 			
 			if(labelExpand){
 				
 				String clientexpandXpath = "//*[contains(@class,'titleBarLabelStyle') and contains(text(),'"+sectionLabel+"')]/ancestor::td[contains(@class,'titleBarBackground')]/preceding-sibling::td[@class='titleBarIconExpanded']";
 				WebElement elementclientexpand = getWebDriver().findElement(By.xpath(clientexpandXpath));
 				System.out.println("Clicking expand of " + sectionLabel );
 				javaScriptClick(elementclientexpand);
 			}
 			
 			
 		}
 		
 		
 	}
 	
   
    /** @return true if the object(s) of importance on the component or the entire component has loaded. */
    public abstract boolean isDisplayed();

}
