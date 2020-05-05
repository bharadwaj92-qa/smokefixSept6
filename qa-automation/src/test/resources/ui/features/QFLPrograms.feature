Feature: QFL Programs Enrollment feature regression using UHCFI client, TECOCL client and WAQL Client


@Regression @QFL @TC5  @UHCFIRegression
Scenario: Verification of QFLD program 1122 enrolled for a participant in UHCFI Client
    Given User Navigate to QFL State Client URL
    When User selects Role and Click on Continue Button
    And User fills insurance card info and Click on Continue Button
      | firstName    | TeststFname |
      | lastName     | NOCDB |
      | dob          | 08/24/1988    |
      | groupNumber|     0008U8579            |
      |subscriberId|      3421509876           |
    And User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms
      | loginID       | TeststFname                               |
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
    And User enters Contact Info details and click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   Then User completes the Enrollment Questionnaire Assessment for this client
   | sheetName| QFLEnrollStateClient_UHCFI |
   And program status should be displayed in DB for the participant
   |programID| 1122|
   
   @Regression @QFLTC1  @TECOCLRegression  @Tecocl1
   Scenario: Verification of Commercial Assumed client registration for Program Id 1088 in TECOCL Client for a participant
    Given User Navigate to QFL State Client URL
     When User navigate to PreSignup page and answer all questions click continue Button
    |      companySponsered           |   Yes       |
    |     benefitEligible            |      Yes     |
    |        union employee         |     Yes      |
    |         contract employee        |     Yes      |
    And User selects  language , Role and Click on Continue Button
    And User fills insurance card info and Click on Continue Button
      | firstName    | TeststFname |
      | lastName     | NOCDB |
      | dob          | 08/24/1988    |
      | groupNumber|     000777785            |
      |subscriberId|     123456789         |
    And User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms
      | loginID       | TeststFname                            |
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
    And User enters Contact Info details such as country residence and click on continue Button
       | CountryResidence|     United States of America             |
       |Country code|  01-USA  |
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   Then User completes the Enrollment Questionnaire Assessment for this client
   | sheetName| QFLEnrollClient_TECOCL |
   And program status should be displayed in DB for the participant
   |programID| 1088|
   
  
    @Regression @QFLTC4  @WAQLRegression @FAgeless18
   Scenario: Verification of State client registration for Program Id 1090 in WAQL Client for a female participant who is pregnant and age is less than 18yrs
     Given User Navigate to QFL State Client URL
     When User navigate to PreSignup page and answer the question click continue Button
    |     Are you 18years of age or older          |   No       |
    And User selects  language Click on Continue Button
    |language |  English  |
    And User fills details Click on Continue Button
     | firstName    | TestWaqlFName |
      | lastName     | TestWaqlLName |
      | gender       | Female          |
      | dob          | 08/24/2003  |
      | zipcode |     99208         |
    And User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms
      | loginID       | TestWaqlFName                          |
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
    Then User enters the Contact Info details such as Address and click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   And User completes the Enrollment Questionnaire Assessment for Female pregnant participant age less than eighteen
   | sheetName| QFLFemaleStateClient_WAQL |
   And program status should be displayed in DB for the participant
   |programID| 1090|
   
   
      @Regression @QFLTC3  @WAQLRegression @FAgeMore18
   Scenario: Verification of State client registration for Program Id 1090 in WAQL Client for a female participant who is pregnant and age is more than 18yrs
     Given User Navigate to QFL State Client URL
     When User navigate to PreSignup page answer the question click continue Button
    |     Are you 18years of age or older          |   Yes       |
    | Do you have Health Insurance| No |
    |What Health plan do you have  | Uninsured   |
    |Do you have access to Tobacco Cessation Counselling| No  |
    | Do you have access to Nicotine Replacement Therapy | Yes  |
    And User selects  language Click on Continue Button
    |language |  English  |
    And User fills details Click on Continue Button
     | firstName    | TestWaqlFName |
      | lastName     | TestWaqlLName |
      | gender       | Female          |
      | dob          | 08/24/1990  |
      | zipcode |     99208         |
    And User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms
      | loginID       | TestWaqlFName                          |
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
    Then User enters the Contact Info details such as Address and click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   And User completes the Enrollment Questionnaire Assessment for Female pregnant participant age less than eighteen
   | sheetName| QFLFemaleAgeMoreThan18_WAQL |
   And program status should be displayed in DB for the participant
   |programID| 1089|
   
   
   @Regression @QFLTC2  @WAQLRegression @MAge1233
   Scenario: Verification of State client registration for Program Id 1088 in WAQL Client for a Male participant 
     Given User Navigate to QFL State Client URL
     When User navigate to PreSignup page answer the question click continue Button
    |     Are you 18years of age or older          |   Yes       |
    | Do you have Health Insurance| No |
    |What Health plan do you have  | Uninsured   |
    |Do you have access to Tobacco Cessation Counselling| No  |
    | Do you have access to Nicotine Replacement Therapy | Yes  |
    When User selects  language Click on Continue Button
    |language |  English  |
    And User fills details Click on Continue Button
     | firstName    | TestWaqlFName |
      | lastName     | TestWaqlLName |
      | gender       | Male         |
      | dob          | 08/24/1990  |
      | zipcode |     99208         |
    And User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms
      | loginID       | TestWaqlFName                          |
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
    Then User enters the Contact Info details such as Address and click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   And User completes the Enrollment Questionnaire Assessment for Male Participant
   | sheetName| QFLMaleStateClient_WAQL |
   And program status should be displayed in DB for the participant
   |programID| 1088|
   
   
   @Regression @QFLTC2  @WAQLRegression @FAge1233
   Scenario: Verification of State client registration for Program Id 1088 in WAQL Client for a female participant who is not pregnant 
     When User navigate to PreSignup page answer the question click continue Button
    |     Are you 18years of age or older          |   Yes       |
    | Do you have Health Insurance| No |
    |What Health plan do you have  | Uninsured   |
    |Do you have access to Tobacco Cessation Counselling| No  |
    | Do you have access to Nicotine Replacement Therapy | Yes  |
    When User selects  language Click on Continue Button
    |language |  English  |
    And User fills details Click on Continue Button
     | firstName    | TestWaqlFName |
      | lastName     | TestWaqlLName |
      | gender       | Female         |
      | dob          | 08/24/1990  |
      | zipcode |     99208         |
    And User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms
      | loginID       | TestWaqlFName                          |
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
    Then User enters the Contact Info details such as Address and click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   And User completes the Enrollment Questionnaire Assessment for Participant
   | sheetName| QFLFemaleNotPregnant_WAQL |
   And program status should be displayed in DB for the participant
   |programID| 1088|
   
   
   @PreEligibilityMale
Scenario: PreEligibility Registration for OKQL Client
  Given User Navigate to QFL State Client URL
     When User navigate to PreSignup page and answer the question click continue Button should navigate to Intervention page
    |     Who is your employer?           |   Dover Group      |
    |    What health insurance or health plan do you have? |   Uninsured |  
    And User selects All Access Intervention and proceed                                  
   And User selects  language Click on Continue Button
    |language |  English  |
      And User fills About you details and Click on Continue Button
     | firstName    | TestUserFName |
      | lastName     | TestUserLName |
      | gender       | Male          |
      | dob          | 08/24/1980    |
    And User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms
      | loginID       | TestWaqlFName                          |
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
    Then User enters the Contact Info details such as Address and click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   And User completes the Enrollment Questionnaire Assessment for Participant
   | sheetName| QFLMaleClient_OKQL |
   And program status should be displayed in DB for the participant
   |programID| 1088|
   
     @PreEligibilityFemale
Scenario: PreEligibility Registration for OKQL Client
  Given User Navigate to QFL State Client URL
     When User navigate to PreSignup page and answer the question click continue Button should navigate to Intervention page
    |     Who is your employer?           |   Dover Group      |
    |    What health insurance or health plan do you have? |   Uninsured |  
    And User selects All Access Intervention and proceed                                  
   And User selects  language Click on Continue Button
    |language |  English  |
      And User fills About you details and Click on Continue Button
     | firstName    | TestUserFName |
      | lastName     | TestUserLName |
      | gender       | Female          |
      | dob          | 08/24/1980    |
    And User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms
      | loginID       | TestWaqlFName                          |
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
    Then User enters the Contact Info details such as Address and click on continue Button
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
   And User completes the Enrollment Questionnaire Assessment for Participant
   | sheetName| QFLFemaleClient_OKQL |
   And program status should be displayed in DB for the participant
   |programID| 1088|
   
     