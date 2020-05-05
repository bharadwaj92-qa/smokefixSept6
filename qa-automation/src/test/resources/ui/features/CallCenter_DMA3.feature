Feature: Validating config Option Monitoring Mobile App (ID 497) and Monitoring Mobile App Delivery (ID 498)

  @UIDMA3 @Smoke @SmokeUI @UI
  Scenario: Validate config Option Monitoring Mobile App (ID 497) and Monitoring Mobile App Delivery (ID 498) for HCCMCA-Alaska Laborers
    Given Login to the CallCenter application with below valid credentials and select specific role
     | username | devivxa      |
     | password | Reset!1234567 |
     | role     | Health Coach |
   And Retrieve the Enrolled Participant ID from PRPC DataBase   
   When Other tab loaded successfully enter Participant Id of the client from Db
    And Verify the Clients tab is displaying on 360 View
    And Expand the Config Options section
    Then Config Options Names Monitoring Mobile App should be displayed
    |optionName |Monitoring Mobile App |
    |optionValue | Y |
    And Config Options Names Monitoring Mobile App Delivery should be displayed
    |optionName |Monitoring Mobile App Delivery |
    |optionValue | Text and Email |
    
   
    
    
