Feature: Text2Quit Enrollment feature regression for NewMexicoQuitLine client properties


@Regression @T2QM  @T2Q  @NMQLRegression
Scenario: Validating Text2Quit for Smokers enrollment by clicking on Signup button for a male participant
  Given User Navigate to QFL State Client URL
    When User selects "HelpLine" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestFName |
      | lastName     | TestLName |
      | gender       | Male          |
      | dob          | 08/24/1988    |
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
    | sheetName  |  QFLEnrollStateClient201_NMQL  |
    And Click on Settings in Portal Home page and also click on communications
    And validate whether TextToQuit section is displayed with signup button
    And click on signupButton to get enrolled in to TextToQuit for Smokers
    |   How many cigarettes do you smoke per day? |  4   |
    |   How much do you spend on a pack of cigarettes? (USD$) |   20    |  
     And validate whether TextToQuit section is displayed with update button
  |textQuitContent| To get started with Text2Quit, reply to the text message we've sent to your phone.  |   
    
   @Regression @T2QM1  @T2Q  @NMQLRegression
   Scenario: Validating Text2Quit for Smokers enrollment completing in HelpLine Assessment for a male participant
  Given User Navigate to QFL State Client URL
    When User selects "HelpLine" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestFName |
      | lastName     | TestLName |
      | gender       | Male          |
      | dob          | 08/24/1988    |
      |zipcode|         87108              |
    Then User fills Create your Login ID section click Continue Button to navigate to TOU page
      | loginID       | TestFName                                |
      | password      |   TestS30@001                                   |
      | confirmpwd    | TestS30@001                                   |
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
      | sheetName  |  QFLENROLLTEXT2QUIT201_NMQL  |
    And Click on Settings in Portal Home page and also click on communications
    And validate whether TextToQuit section is displayed with update button
  |textQuitContent| To get started with Text2Quit, reply to the text message we've sent to your phone.  |
  
     
     @Regression @T2QF  @T2Q  @NMQLRegression
Scenario: Validating Text2Quit for Smokers enrollment by clicking on Signup button for a female participant
  Given User Navigate to QFL State Client URL
    When User selects "HelpLine" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestFName |
      | lastName     | TestLName |
      | gender       | Female          |
      | dob          | 08/24/1988    |
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
   | sheetName  |  QFLFemEnrollStateClient201_NMQL  |
    And Click on Settings in Portal Home page and also click on communications
    And validate whether TextToQuit section is displayed with signup button
    And click on signupButton to get enrolled in to TextToQuit for Smokers
    |   How many cigarettes do you smoke per day? |  4   |
    |   How much do you spend on a pack of cigarettes? (USD$) |   20    |  
     And validate whether TextToQuit section is displayed with update button
  |textQuitContent| To get started with Text2Quit, reply to the text message we've sent to your phone.  |   
    
    @Regression @T2QF1  @T2Q  @NMQLRegression
   Scenario: Validating Text2Quit for Smokers enrollment completing in HelpLine Assessment for a female participant
  Given User Navigate to QFL State Client URL
    When User selects "HelpLine" Intervention and proceed
    And User selects language options and Click on Continue Button
      | language | English |
    And User fills About You Section and Click on Continue Button
      | firstName    | TestFName |
      | lastName     | TestLName |
      | gender       | Female          |
      | dob          | 08/24/1988    |
      |zipcode|         87108              |
    Then User fills Create your Login ID section click Continue Button to navigate to TOU page
      | loginID       | TestFName                                |
      | password      |   TestQ@001                                   |
      | confirmpwd    | TestQ@001                                   |
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
     | sheetName| QFLFemTextQuitState201_NMQL  |
    And Click on Settings in Portal Home page and also click on communications
    And validate whether TextToQuit section is displayed with update button
  |textQuitContent| To get started with Text2Quit, reply to the text message we've sent to your phone.  |
  
  
  
  
   
    