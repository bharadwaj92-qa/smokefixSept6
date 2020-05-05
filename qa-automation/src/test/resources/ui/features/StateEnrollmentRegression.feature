Feature: State Client NMQL Enrollement Questionaire for Male and female Particpants Regression

@StateEnroll @Regression  @MInd  @NMQLRegression
Scenario: Verification of Program confirmation of Intervention 203 using QFLState_NewMexicoQuitLine client properties file
     Given User Navigate to QFL State Client URL
     When User selects "Individual" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestNMQLFName |
      | lastName     | TestNMQLLName |
      | gender       | Male          |
      | dob          | 08/24/1988    |
      |zipcode|         87108              |
    And User fills Create your Login ID section details and click on accept TOU page
      | loginID       | TestNMQLFName                                |
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
 And Validate whether Program confirmation page for enrolled service is displayed
   | Intervention |   Individual Services |
   
   
    @StateEnroll @Regression  @MWeb @NMQLRegression
   Scenario: Verification of Program confirmation of Intervention 202
        Given User Navigate to QFL State Client URL
     When User selects "WebCoach" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestNMQLFName |
      | lastName     | TestNMQLLName |
      | gender       | Male          |
      | dob          | 08/25/1989    |
      |zipcode|         87102              |
     And User fills Create your Login ID section details and click on accept TOU page
      | loginID       | TestNMQLFName                                |
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
    And Validate whether Program confirmation page for enrolled service is displayed
   | Intervention |    Web Coach |
   
   
  @StateEnroll @Regression @MHelp  @NMQLRegression
  Scenario: Verification of Program confirmation of Intervention 201
   Given User Navigate to QFL State Client URL
    When User selects "HelpLine" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestFName |
      | lastName     | TestLName |
      | gender       | Male          |
      | dob          | 08/24/1990    |
      |zipcode|         87108              |
    Then User fills Create your Login ID section click Continue Button to navigate to TOU page
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
    And User enters HelpLine Contact Info details and click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   And User completes the HelpLine Intervention Enrollment Questionnaire Assessment
    | sheetName| QFLEnrollStateClient201_NMQL  |
 
   
  @StateEnroll @Regression  @FInd  @NMQLRegression
Scenario: Verification of Program Upgrade of Individual Intervention 203 using QFLState_NewMexicoQuitLine client properties file
     Given User Navigate to QFL State Client URL
     When User selects "Individual" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestFName |
      | lastName     | TestLName |
      | gender       | Female          |
      | dob          | 08/24/1991    |
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
    | sheetName| QFLFemaleEnroll203_NMQL  |
    And Select No option click on continue Button StopMedication screen should be displayed
   And Click on continue Button in pgmcondition and click on Done Button in Options Homepage
 And Validate whether Program confirmation page for enrolled service is displayed
   | Intervention |   Individual Services |
   
    @StateEnroll @Regression @FHelp  @NMQLRegression
Scenario: Validating Helpline Enrollment for female Participant
  Given User Navigate to QFL State Client URL
    When User selects "HelpLine" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestFName |
      | lastName     | TestLName |
      | gender       | Female          |
      | dob          | 08/24/1992    |
      |zipcode|         87108              |
    Then User fills Create your Login ID section click Continue Button to navigate to TOU page
      | loginID       | TestFName                                |
      | password      |   Testat@001                                   |
      | confirmpwd    | Testat@001                                   |
      | securityque1  | What is your favorite film?                  |
      | securityans1  | film1                                         |
      | securityhint1 | film                                          |
      | securityque2  | What is the name of your first childhood friend? |
      | securityans2  | friend1                                         |
      | securityhint2 | friend                                          |
      | securityque3  | What is your favorite book?                  |
      | securityans3  | book1                                        |
      | securityhint3 | book                                         |
    And User enters HelpLine Contact Info details and click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
  And User completes the HelpLine Intervention Enrollment Questionnaire Assessment
   | sheetName| QFLFemEnrollStateClient201_NMQL  |
   
   
    @StateEnroll @Regression  @FWeb   @NMQLRegression
   Scenario: Verification of Program confirmation of Intervention 202
        Given User Navigate to QFL State Client URL
     When User selects "WebCoach" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestNMQLFName |
      | lastName     | TestNMQLLName |
      | gender       | Female          |
      | dob          | 08/25/1987    |
      |zipcode|         87102              |
     And User fills Create your Login ID section details and click on accept TOU page
      | loginID       | TestNMQLFName                                |
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
   | sheetName| QFLFemaleEnroll202_NMQL  |
    And Click on settings in portal Homepage and select program from left navigation
    And Validate whether Program confirmation page for enrolled service is displayed
   | Intervention |    Web Coach |
   