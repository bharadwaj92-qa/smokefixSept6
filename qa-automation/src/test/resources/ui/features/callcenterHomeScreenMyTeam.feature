Feature: Validating HomeScreen MyTeam functionality
    
  @UIMyTeam @Smoke @SmokeUI @UI
  Scenario: Validate the Home Screen Header options
    Given Login to the CallCenter application with below valid credentials and select specific role
    			| username  	| devivxa					|
      		| password		| Reset!123456		|
      		| role    		| Health Coach   	|
    When User navigates to My team page and verify My team tab loaded successfully 
    And Verify my team section have drop downs Client,Interaction,Taskdate,User,Team and each drop down has its default value
    Then Verify the list values and check boxes are reset to default values

    

  
  