Feature: Validating 360Tab Client functionality
    
  @UIClient360 @Smoke @SmokeUI @UI
  Scenario: Validate the Client Tab, Insurance detail section and Insurance details Edit section 

    Given Login to the CallCenter application with below valid credentials and select specific role
    			| username  	| devivxa					|
      		| password		| Reset!1234567		|
      		| role    		| Health Coach   	|
    When Navigating to Others tab and search for the participant 
    And Verify the Client tab is displaying on 360 View and navigating to client Tab
    Then Verify whether user is able to see the Insurence detail section  
    And Verify Whether Client name and Client ID are displayed in the Insurence details section
    And Verify Whether Client name and Client ID are displayed in the Insurence detail edit section
    

  
  