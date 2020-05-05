@UI @V3ClientQFLSmoke @CommercialClientQFLSmoke
Feature: QFL Commercial and V3 Client Enrollment


  @Smoke @QFLCommercialClientEnrollment
  Scenario: Commercial Client Registration and Enrollment
    Given User Navigate to QFL Commercial Client URL
    When User selects language options and Registering as for Commercial Client
      | language | English |
    And User fills About You Section for Commercial Client
      | firstName    | TestUserFName |
      | lastName     | TestUserLName |
      | gender       | Male          |
      | dob          | 08/24/1990    |
      | relationship | Employee      |
    Then User fills Create your Login ID section and agreement to TOU for Commercial Client
      | loginID       | TestUserFName                                |
      | password      | P@ssw0rd                                     |
      | confirmpwd    | P@ssw0rd                                     |
      | securityque1  | What is your city of birth?                  |
      | securityans1  | asdf                                         |
      | securityhint1 | as                                           |
      | securityque2  | What was the name of your elementary school? |
      | securityans2  | qwer                                         |
      | securityhint2 | qw                                           |
      | securityque3  | What is your favorite book?                  |
      | securityans3  | zxcv                                         |
      | securityhint3 | zx                                           |
    And User enters Contact Info details for Commercial Client

      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
    And   User completes the Enrollment Questionnaire for Commercial Client
    And User completes NRT Medication Questionnaire for Commercial Client
    When User clicks I have reached my Goal for Commercial Client
    And User Add Goal "Stay Tobacco-Free" in Managed Goals Page for Commercial Client