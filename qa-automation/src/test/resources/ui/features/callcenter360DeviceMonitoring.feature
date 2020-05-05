Feature: Validating 360Tab Device Monitoring functionality
    
  @UIDeviceMonitoring @Smoke @SmokeUI @UI
  Scenario: Validate the Device Monitoring

    Given Login to the CallCenter application with below valid credentials and select specific role
    			| username  	| devivxa					|
      		| password		| Reset!123456		|
      		| role    		| Health Coach   	|
    When Navigating to Others tab and Validating Other tab loaded successfully 
    And Verify the Device Monitoring tab is displaying on 360 View
    And Verify the Graph in Device Monitoring page
    Then Verify the Device Monitoring tab filter fileds Status,Range,Filter button
    And Verify Status drop down options All,Review Completed,Not Useful and Un-reviewed are displaying
    And Verify Range drop down options Select,Period and Date are displaying
    

  
  