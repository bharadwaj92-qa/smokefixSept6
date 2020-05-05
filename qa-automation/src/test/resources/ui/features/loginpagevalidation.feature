Feature: Verify the Login Page


   @LoginPageErrorMessagesValidations @Smoke @SmokeUI @UI
    Scenario: Validate various error messages in login page 
    Given Navigating to the Marketing page URL
    Then  Enter invalid credentials and verify error messages
          |username|ttttttt@iii.com|
          |password|asdff|      
          
    And   Enter invalid username and verify error message.
          |username|hhhhh@iii|
          |password|asdff|
          |Error Message|Please choose a login ID in email format (name@company.com).|
    And   without username and password verify error message.
          |Username Error Message|Please enter your login ID.|
          |Password Error Message|Please enter your password.|

    @LoginPageHeaderLinkValidation @Smoke @SmokeUI @UI
    Scenario: Login with invalid user name
    Given Navigating to the Marketing page URL
    Then Validate top links by clicking each link and verifying pages to which navigation
    #Then Click on Espanol link and verify that page translated to spanish language.
    
    @LoginPageWithValidCredentials @Smoke @SmokeUI @UI
    Scenario: Validation of the ogin page with valid credentials
     Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
     And Navigating to the Marketing page URL
     Then Enter the valid credentials and verify that login is susccessfull

  @LegalBrandingVerifications @Smoke @SmokeUI @UI
  Scenario Outline: Valdiate Client name in Privacy Policy page


    Given Launch url of client "<Client Url>"
    When User clicks on Privacy Link and Naivgates to privacy page
    Then validate the "<Client Name>" in Privacy page

    Examples:
      |Client Url|Client Name|
      |http://healthnetwellness.qa.alere.com/mve/login| Optum |
      |http://wellnessaz.qa.alere.com/mve/login|Pronounced Health|
      |https://uat.myquitforlife.com/mve/?client=UHCFI&clientId=11501015|UnitedHealthcare|
      |http://healthnetwellness.qa.alere.com/mve/login|Optum|