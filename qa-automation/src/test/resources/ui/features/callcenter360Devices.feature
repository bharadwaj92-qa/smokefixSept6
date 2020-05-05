Feature: Validating 360Tab Devices functionality
    
  @UIDevices @Smoke @SmokeUI @UI
  Scenario: Validate the 360 Devices Tab Refresh and Devices, Validating all fields OTH sub tab icon,Devices,Device Troubleshooting History,Device List,Device History,Measurement Criteria,Temporary Absences,List Score ,Validic 

    Given Login to the CallCenter application with below valid credentials and select specific role
    			| username  	| devivxa					|
      		| password		| Reset!1234567		|
      		| role    		| Health Coach   	|
    When Navigating to Others tab and Validating Other tab loaded successfully in devices 360 
    And Verify the Devices tab is displaying on 360 View
    And Verify Devices and Refresh button are displaying
    Then Verify the sections under Devices widget

    

  
  