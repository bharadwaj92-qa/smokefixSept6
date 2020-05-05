Feature: Medications 360 Tab - Adding the medication, validating the added medication and status of it.
    
  @UIMedications @Smoke @SmokeUI @UI
  Scenario: Validate primary provider details, External referrals,internal referrals of the participant in Summary page
     Given Login to the CallCenter application with below valid credentials and select specific role
    			| username  	| devivxa					|
      		| password		| Reset!123456		|
      		| role    		| Health Coach   	|
    When User navigates to other page and Search for the medications participant
    And Navigates to Medications tab and click on Add Medication
    And Search for Medication and add the medication,set the frequency
    			| medication | Accu  |
    			| frequency  | Daily |
    And Validate the Added medication in the medication page
    Then Update the medication status and save,Refresh the page and verify the saved status details
    			|medicationstatus|Not Validated|
    And Navigate to Gaps tab and Verify the Calculate Medication Gaps button
    And Navigates back to List tab and verify the added medication
    And Discontinue the added Medications
    
    

    
  