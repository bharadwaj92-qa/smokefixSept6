Feature: Verify the Forgot Password  and Reset Password Functionalities

  @ForgotPwd   @Regression
  Scenario: Validate Forgot Password Functionality for HealthnetClient
  
  Given Login to AlerePortal using userName 
      | username | TestHealthnet@gn.com |
    And Click Password tooltip it should be navigated to ResetPassword Page
    And Validate Forgot password heading and its below Message , LoginId and its textBox is displayed
    When User enter invalid LoginId Error Message should be displayed and click on Login Button
      | usernameInvalid | test47081@gn.com         |
      | username        | TestHealthnet@gn.com |
    And Click on Continue Button without entering Login ID Error Message should be displayed
      | username | TestHealthnet@gn.com |
    And Click on Continue Button by entering valid Login Id Security Question Page should be displayed
      | username | TestHealthnet@gn.com |
    And Without entering any data Click on Continue Button Error Message should display
    And Enter invalid input  Click on Continue Button again Security Question page should display
      | securityQuestion1 | film |
    And Enter Valid Input Click on Continue Button then Password screen should display
      | securityQuestion2 | friend1 |
    Then Validate Both Password and confirm Password fields displayed
    And Error message should be displayed if both password and confirm password fields are not same
      | password        | Test1234 |
      | confirmPassword | Test1235 |
    And Error message should be displayed if invalid combination password is provided
      | invalidPassword   | asduiio |
      | invalidConfirmPwd | asduiio |
    And Click on continue Button after Entering valid combination Password and confirm Password
      | password        |  Test1234567 |
      | confirmPassword |  Test1234567 |
    And Enter Login Id and new password credentials Portal Home page should be displayed
      | username | TestHealthnet@gn.com |
      | password |  Test1234567              |

  @ResetPwd  @Regression
  Scenario: Validate Reset Password Functionality for NMQl client
   Given User Navigate to QFL State Client URL
    When User selects "HelpLine" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section  and fills Create your LoginID section click Continue Button to navigate to TOU page
      | firstName    | TestFName |
      | lastName     | TestLName |
      | gender       | Male          |
      | dob          | 08/24/1988    |
      |zipcode|         87108              |
      | loginID       | TestFName                                |
      | password      |   TestState@001                                   |
      | confirmpwd    | TestState@001                                   |
      | securityque1  | What is your favorite film?                  |
      | securityans1  | film1                                         |
      | securityhint1 | film                                          |
      | securityque2  | What is the name of your first childhood friend? |
      | securityans2  | friend1                                         |
      | securityhint2 | friend                                          |
      | securityque3  | What is your favorite book?                  |
      | securityans3  | book1                                        |
      | securityhint3 | book                                         |
    And User enters HelpLine Contact Info details, completes the Helpline Intervention 
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
      | sheetName  |  QFLEnrollStateClient201_NMQL  |
    And Click on ID and Password Link in settings it should display change Password Button
    And Click on Change Password Button it should navigate to Change Password screen
   Then Validate all fields and Buttons are present in Change Password Screen
    And Error msgs should be displayed for empty data, invalid combination and not identical
      |CurrentPassword|    TestState@001       |
      | NewPasswordInvalid             | asdf       |
      |NewPassword|   Test34567         |
      | ConfirmNewPasswordNotIdentical | Test123457 |
    And enter current password, new password ,confirm new password then click on Save changes Button
      | CurrentPassword    |TestState@001  |
      | NewPassword        | TestState@002 |
      | ConfirmNewPassword | TestState@002|
    And click on Signout and enter valid login credentials with changed Password which should be accepted
      | password | TestState@002             |

