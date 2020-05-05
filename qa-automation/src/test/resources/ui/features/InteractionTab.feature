Feature: GapHistory Participant Gaps Functionality

  @UIInteractionsTC01 @Smoke @SmokeUI @UI  @UIInteractions
  Scenario: Validate Interaction Tab TC01 Functionality
  
  Given Login to the CallCenter application with below valid credentials and select specific role
     | username | devivxa      |
     | password | Reset!1234567 |
      | role     | Health Coach |
   And Retrieve the Enrolled Participant ID from PRPC DataBase   
   When Other tab loaded successfully enter Participant Id of the client from Db
   And Click on Interactions on three sixty tab to verify the Interaction Logs Search Input Section 
   And Click on Search Button by selecting status, channel, Recipient and Timeperiod
   Then User should be able to see search interactions
    
    
     @UIInteractionsTC02 @Smoke @SmokeUI @UI  @UIInteractions
  Scenario: Validate Interaction Tab TC02 Functionality
  
  Given Login to the CallCenter application with below valid credentials and select specific role
      | username | devivxa      |
      | password | Reset!1234567 |
      | role     | Health Coach |
   And Retrieve the Enrolled Participant ID from PRPC DataBase   
   When Other tab loaded successfully enter Participant Id of the client from Db
     And Click on Interactions on three sixty tab to verify the Interaction Logs Search Input Section 
     And Click on Search Button by selecting status, channel, Recipient and Timeperiod 
     Then User should be able to see search interactions displayed correctly
    
      
      

    
   
    
    