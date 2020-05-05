package com.alerehealth.ui.portal.progress.trackers.PeakFlow;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class TrackersPeakFlowProgressBasePage extends TrackersPeakFlowBasePage {
	
	
	@FindBy(id="FitbitTrackerDiv")
	private WebElement progressPage;
	
	@FindBy(xpath="//*[name()='svg']//*[name()='g' and @class='highcharts-grid'][2]")
	private WebElement graph;
	
	public boolean isGraphDisplayed(){
		
		try{
			
			return graph.isDisplayed();
			
		} catch(NoSuchElementException e){
			
			System.out.println("No such Element found error for graph");
			return false;
		}
		
		
	}
	
	@Override
	public boolean isDisplayed(){
		
		return progressPage.isDisplayed();
	}

}
