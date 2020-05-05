Feature: Keycode registration smoke test scenarios

  @Smoke @SmokeUI @UI @KeycodeRegistration @KeycodeRegistrationNormal
  Scenario: Register a new user into portal with keycode
    Given Create an unregistered user  in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Obtain unregistered user details from DB
    
    And Language and affiliation option
      | affiliation     |with a keycode|
    When User proceeds with LoginID form using below details
      | loginId       | firstname             |
      
      | confirmloginID|firstname|
     | emailaddr|xyz@xx.com|
      |confirmemailaddr|xyz@xx.com|
      
      | password        |Password@1                       |
      | confirmpwd      | Password@1              |
      | securityque1    | What is your city of birth?|
      | securityans1    | asdf                   |
      | securityhint1   | as                |
      | securityque2    |What was the name of your elementary school?|
      | securityans2    | qwer                   |
      | securityhint2   | qw                |
      | securityque3    |What is your favorite book?|
      | securityans3    | zxcv                  |
      | securityhint3   | zx               |
    Then user is successfully registered and able to see home page of portal


  @Smoke @SmokeUI @UI @KeycodeRegistration @KeycodeRegistrationError
  Scenario: Register a new user into portal with keycode along with validation of error messsages
   Given Create an unregistered user  in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Obtain unregistered user details from DB
    And Affiliation as keycode
      | affiliation     |with a keycode|
    When User proceeds with Validation of error messages and filling loginId form using below details
   
      | loginId       | firstname              |
      
     | confirmloginID|firstname|
     | emailaddr|xyz@xx.com|
      |confirmemailaddr|xyz@xx.com|
      
      | password        |Password@1                       |
      | confirmpwd      | Password@1              |
      | securityque1    | What is your city of birth?|
      | securityans1    | asdf                   |
      | securityhint1   | as                |
      | securityque2    |What was the name of your elementary school?|
      | securityans2    | qwer                   |
      | securityhint2   | qw                |
      | securityque3    |What is your favorite book?|
      | securityans3    | zxcv                  |
      | securityhint3   | zx               |
    Then user is successfully registered and able to see home page of portal

