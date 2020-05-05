 Feature:  Enrollment for COOP  Assumed Commercial Client Registration and Contact Info/Enrollment Questionnaire/PgmConfirmationPages Functionality
 
  @EnrollQuestionnaire @Ma @COOPRegression
  Scenario: Verification of Commercial Contact info , Enrollment questionnaire and program Confirmation page
   Given User Navigate to QFL commercial Client URL
    When User selects  language and Click on Continue Button
    |language |  English  |
    And User fills details  and Click on Continue Button
     | firstName    | TestcoclFName |
      | lastName     | NOCDB |
      | gender       | Male          |
      | dob          | 08/24/1988    |
      | relationship |     Employee         |
    And User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms
      | loginID       | TestcoclFName                            |
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
    Then User enters Contact Info details such as Address and click on continue Button
      |state |  New Mexico   |
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |                                
    And   User completes Enrollment Questionnaire for Commercial Client
    | sheetName| QFLEnrollTextQuitClient_ABUS  |
      And program status should be displayed in DB for the participant
   |programID| 1088|
    
     @EnrollQuestionnaire @Fe  @COOPRegression
  Scenario: Verification of Commercial Contact info , Enrollment questionnaire and program Confirmation page
   Given User Navigate to QFL commercial Client URL
    When User selects  language and Click on Continue Button
    |language |  English  |
    And User fills details  and Click on Continue Button
     | firstName    | TestcoclFName |
      | lastName     | NOCDB |
      | gender       | Female          |
      | dob          | 08/24/1988    |
      | relationship |     Employee         |
    And User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms
      | loginID       | TestcoclFName                            |
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
    Then User enters Contact Info details such as Address and click on continue Button
      |state |  New Mexico   |
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |                                
    And   User completes Enrollment Questionnaire for Commercial Client
    | sheetName| QFLABUS_Female  |
     And program status should be displayed in DB for the participant
   |programID| 1088|
   
   
   
    @AssumedCommercialClient @Ma @COOPRegression
  Scenario: Verification of Commercial Contact info 
   Given User Navigate to QFL commercial Client URL
    When User selects  language and Click on Continue Button
    |language |  English  |
    And User fills details  and Click on Continue Button
     | firstName    | TestcoclFName |
      | lastName     | NOCDB |
      | gender       | Male          |
      | dob          | 08/24/1988    |
      | relationship |     Employee         |
    And User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms
      | loginID       | TestcoclFName                            |
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
   
   
    