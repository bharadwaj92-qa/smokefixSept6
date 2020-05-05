Feature: Registration Regression 

@RegistrationReg  @Regression  @FLQLRegression
Scenario: Validate Portal Sign up Process - Email for FLQL State Client
 Given User Navigate to QFL State Client URL
 And User select More Quit Tools Intervention 
 And click on continue Button after selecting only Email Service
 When User selects language options and Click on Continue Button
      | language | English |
 And User fills About You Section and Click on Continue Button
      | firstName    | TestFlqlFName |
      | lastName     | TestFlqlLName |
      | gender       | Male          |
      | dob          | 08/24/1988    |
  And User fills Create your Login ID section click Continue Button to navigate to TOU page
      | loginID       | TestFlqlFName                                |
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
    And User enters More Quick Tools Contact Info details and click on continue Button
   And User completes the Intervention Enrollment Questionnaire Assessment
    | sheetName  |  QFLEnrollStateClient_FLQL  | 
    And Validate Enrolled button which is displayed is disabled for Email Program
    | Intervention|      More Quit Tools       | 
    And Click Add Button beside TextQuit Service it should be navigated to Contact Info Page
    Then Click on Continue Button after entering Contact Info details 
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
      And User completes the Intervention Enrollment Questionnaire Assessment
      | sheetName  |  QFLTextQuitEnroll_FLQL  | 
       And Validate Enrolled button which is displayed is disabled for TextQuit and Email Program
    | Intervention|      More Quit Tools       | 
    And Click on Medications Add this Button enter contact info Details click on continue
     | May we leave a message at this number               | No                                              |
    And User completes the Medications Intervention Enrollment Questionnaire Assessment
     | sheetName  |  QFLMedicationEnroll_FLQL  | 
     And Validate Enrolled button which is displayed is disabled for TextQuit, Email Program , Medications
    | Intervention|      More Quit Tools       | 
     And Click on Welcome Kit Add this Button enter contact info Details click on continue
     And User completes the Intervention Enrollment Questionnaire Assessment
    | sheetName  |  QFLWelcomeKitEnroll_FLQL  | 
    And Validate Enrolled button which is displayed is disabled for TextQuit, Email Program , Medications,WelcomeKit
    | Intervention|      More Quit Tools       |  
    
    @RegistrationReg1  @Regression  @FLQLRegression
Scenario: Validate Portal Sign up Process for all services
  Given User Navigate to QFL State Client URL
 And User select More Quit Tools Intervention 
 And click on continue Button after selecting all services
 When User selects language options and Click on Continue Button
      | language | English |
 And User fills About You Section and Click on Continue Button
      | firstName    | TestFlqlFName |
      | lastName     | TestFlqlLName |
      | gender       | Male          |
      | dob          | 08/24/1988    |
  And User fills Create your Login ID section click Continue Button to navigate to TOU page
      | loginID       | TestFlqlFName                                |
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
   Then Enter Contact info details and click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   And User completes the Medications Intervention Enrollment Questionnaire Assessment
    | sheetName  | QFLAllServices_FLQL  | 
    And Validate Enrolled button which is displayed is disabled for TextQuit, Email Program , Medications,WelcomeKit
    | Intervention|      More Quit Tools       |  
    
 
    
    