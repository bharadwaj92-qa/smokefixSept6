Feature: Normal registration smoke test scenarios

 @Smoke @SmokeUI @UI @NormalRegistration
  Scenario: Register a new user into portal
    Given Create an unregistered user  in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Obtain unregistered user details from DB
    When User proceeds with registration using below details
          | language        | English                       |
          | affiliation     | as a Subscriber               |
          | firstName       | firstname@gn.com              |
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
    Then user is successfully registered and able to sigin and signout of portal

   @Smoke @SmokeUI @UI @NormalRegistration
   Scenario: Register a new user into portal along with validation of error messages
     Given Create an unregistered user  in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
     And Obtain unregistered user details from DB
     When User proceeds with registration by validating error messages and using below details
       | language        | English                       |
       | affiliation     | as a Subscriber               |
       | firstName       | firstname@gn.com              |
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
     Then user is successfully registered and able to sigin and signout of portal

  @Smoke @SmokeUI @UI @NormalRegistration
  Scenario: Validation of error messages of unique ID and age
    Given Create an unregistered user  in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Obtain unregistered user details from DB
    Then validate error messages of Age and uniqued ID

  @Smoke @SmokeUI @UI @SSORegistration
  Scenario: Register an unregistered user into portal with SSOFile
    Given Create an unregistered user  in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Obtain unregistered user details from DB
    When User proceeds with SSO file form using below details
      | targetUrl       | https://healthnetwellness.uat.pronouncedhealth.com/mve/ |
      | client        | HealthNet                                               |
      | fileName       | UAT-T001                    |
    Then user is successfully registered from SSO file and able to see home page of portal










