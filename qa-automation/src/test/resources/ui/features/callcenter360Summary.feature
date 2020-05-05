Feature: Summary 360 Tab and validating the primary provider details, External referrals,internal referrals of the participant
    
  @UISummary @Smoke @SmokeUI @UI
  Scenario: Validate primary provider details, External referrals,internal referrals of the participant in Summary page
     Given Login to the CallCenter application with below valid credentials and select specific role
    			| username  	| devivxa					|
      		| password		| Reset!123456		|
      		| role    		| Health Coach   	|
    When User navigates to other page and Search for the participant
    Then Validating primary provider details, External referrals,internal referrals of the participant in Summary page
    

    
  