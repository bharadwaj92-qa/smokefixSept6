Feature: Program Upgrade feature regression

@Regression @QFL @TC1and2 @PrgmUpgrade1 @NMQLRegression
Scenario: Verification of Program Upgrade of Individual Intervention 203 to 202 to 201 using QFLState_NewMexicoQuitLine client properties file
     Given User Navigate to QFL State Client URL
     When User selects "Individual" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestFName |
      | lastName     | TestLName |
      | gender       | Male          |
      | dob          | 08/24/1988    |
      |zipcode|         87108              |
    And User fills Create your Login ID section details and click on accept TOU page
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
    And User enters Contact Info details click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   Then   User completes the Individual Enrollment Questionnaire Assessment
   | sheetName| QFLEnrollStateClient203_NMQL  |
   And Select No option click on continue Button StopMedication screen should be displayed
   And Click on continue Button in pgmcondition and click on Done Button in Options Homepage
   And click on Upgrade Webcoach Button enter Contact Info details
   And Complete Enrollement Questionaire Assessment then select no option click on continue Button
   | sheetName| QFLEnrollStateClient202_NMQL  |
    And Click on settings in portal Homepage and select program from left navigation
    And Click on Upgrade Helpline enter contact info details and complete the enrollment Questionaire
    | sheetName| QFLEnrollStateClient201_NMQL |
    And validate whether TextQuit section is displayed with update button
  |textQuitContent| To get started with Text2Quit, reply to the text message we've sent to your phone.  |
   
   @Regression @QFL @TC3 @PrgmUpgrade3 @NMQLRegression
  Scenario: Verification of Program Upgrade of Individual Intervention 203 to 201 using QFLState_NewMexicoQuitLine client properties file
     Given User Navigate to QFL State Client URL
     When User selects "Individual" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestFName |
      | lastName     | TestLName |
      | gender       | Male          |
      | dob          | 08/24/1986    |
      |zipcode|         87108              |
    And User fills Create your Login ID section details and click on accept TOU page
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
    And User enters Contact Info details click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   Then User completes the Individual Enrollment Questionnaire Assessment
   | sheetName| QFLEnrollStateClient203_NMQL  |
    And Select No option click on continue Button StopMedication screen should be displayed
   And Click on continue Button in pgmcondition and click on Done Button in Options Homepage
    And Click on Upgrade Helpline enter contact info details and complete the enrollment Questionaire
    | sheetName| QFLEnrollStateClient201_NMQL |
     And validate whether TextQuit section is displayed with update button
  |textQuitContent| To get started with Text2Quit, reply to the text message we've sent to your phone.  |
   
   @PrgmUpgrade2 @QFL4  @Regression @TC4  @NMQLRegression
   Scenario: Verification of Program Upgrade of Webcoach Intervention 202 to Helpline 201
        Given User Navigate to QFL State Client URL
     When User selects "WebCoach" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestWCFName |
      | lastName     | TestWCLName |
      | gender       | Male          |
      | dob          | 08/25/1988    |
      |zipcode|         87102              |
     And User fills Create your Login ID section details and click on accept TOU page
      | loginID       | TestWCFName                                |
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
   Then User enters Contact Info details such as Address click on continue Button
  And Complete Enrollement Questionaire Assessment then select no option click on continue Button
   | sheetName| QFLEnrollStateClient202_NMQL  |
   And Click on settings in portal Homepage and select program from left navigation
    And Click on Upgrade Helpline enter contact info details complete the enrollment Questionaire
     | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
      | sheetName| QFLEnrollStateClient201_NMQL  |
      And validate whether TextQuit section is displayed with signup button
    
 
  @Regression @PrgmIntervention1  @NoticeOfEmailpage @TC1and2  @NMQLRegression
  Scenario: Verification of  Notice of Email Communication page accept is checked using NMQL properties file
     Given User Navigate to QFL State Client URL
     When User selects "Individual" Intervention 
     And Select Email service click on continue Button
     Then validate Notice of Email communication page accept checkbox already checked
     
     
     @Regression @PrgmIntervention2  @NoticeOfEmailpage @TC1and2  @NMQLRegression
     Scenario: Verification of  Notice of Email Communication page accept is not checked using NMQL properties file
     Given User Navigate to QFL State Client URL
     When User selects "Individual" Intervention 
     And Select all services except Email service click on continue Button
     Then validate Notice of Email communication page accept checkbox is not checked 
     
    
   