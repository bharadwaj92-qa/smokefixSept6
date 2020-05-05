Feature: Verfiy Marketing page Regression Functionality

@Market  @TC0306
Scenario: Marketing page header verification
Given Launch the Marketing page
And i verify the headers"The smart way to practice healthy living.","Sign Up","Log In","Health Net" in marketing page 
When User validating the Header Logo and links navigation
And Click on clientLogo it should be navigated to Login page

@Market1  @TC0709141517
Scenario: Validating Zone1, Focus Areas,  How this works,  DoMore Sections 
Given Launch the Marketing page
And Validate the content and button displayed in Zone1 in Marketing page
When Click on GetStarted Button in Zone1 it should navigate to Signup page
And Validate the content, labels and click on GetStarted Button of each Focus Area which should be navigated to Signup page
And Validate the content and labels in How this works section
Then Click on GetStarted Button in How this works section which should be navigated to Signup page
And Validate the content and Titles in Do More section
And Click on GetStarted Button in Do More section which should be navigated to Signup page

 



