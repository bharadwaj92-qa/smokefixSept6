Feature: Home Screen Search Smart and Advanced search
    
  @UIHomeScreenSearch @Smoke @SmokeUI @UI
  Scenario: Validate the Home Screen Header options
     Given Login to the CallCenter application with below valid credentials and select specific role
    			| username  	| devivxa					|
      		| password		| Reset!123456		|
      		| role    		| Health Coach   	|
    When User navigates to search page and click on Smart Search
    And Setting the PID and doing the smart search
    And Validating the PID search results
    Then User navigates to search page and click on Advanced Search
    And Setting the OptumID and performing the search
    

    
  