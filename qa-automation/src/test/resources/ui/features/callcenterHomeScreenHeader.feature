Feature: Home Screen Header TC_01_04_10_02
    
  @UIHomeScreenHeader @Smoke @SmokeUI @UI @Trail
  Scenario: Validate the Home Screen Header options 
    Given Login to the CallCenter application with below valid credentials and select specific role
    			| username  	| devivxa					|
      		| password		| Reset!123456		|
      		| role    		| Health Coach   	|
      		
    When Verify the client Name with its respective Logo dispaly on header
    Then Verify Logged Clinician name, Phrases, Im Available to work,Get Next ,Report Issue, Logoff on Homescreen header
    And Verify I m Available to work, Get Next check boxs displying in Homescreen header 
  
    
  @UIHomeScreenHeader @Smoke @SmokeUI @UI @Fix
  Scenario: Validate the Home Screen Report Issue functionality  
     Given Login to the CallCenter application with below valid credentials and select specific role
    			| username  	| devivxa					|
      		| password		| Reset!123456		|
      		| role    		| Health Coach   	|
    When Click on the Report Issue link
    And Setting all the fields in the ReportIssue pop up
    	
    	| optumid  					| devivxa				|
      | expectingtohappen	| testing				|
      | exactsequence    	| testing   		|
      | supervisor   			| devivxa			 	|
      | worklocation			| Hyderabad			|
      
    Then Verify report an issue is submitted successfully
    
   
   
   @UIHomeScreenHeader @Smoke @SmokeUI @UI
  Scenario: Validate the Home Screen DueDate and GetNext Checkbox functionality
    Given Login to the CallCenter application with below valid credentials and select specific role
    			| username  	| devivxa					|
      		| password		| Reset!123456		|
      		| role    		| Health Coach   	|
    When Select GetNext CheckBox and navigate to My Work Page  
    And Select Test Cases checkbox in My Work page
    Then Select Q4L Engagement Calls from My work basket
    And Validate the duedate is displayed to that clinician 
