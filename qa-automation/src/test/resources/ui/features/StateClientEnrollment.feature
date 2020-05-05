@Smoke @UI @StateEnrollmentQFLSmoke
Feature: QFL State Client Enrollment


  @QFLStateClientEnrollment @QFLStateClientEnrollmentHelpline @PreEligibility
  Scenario: State Assumed Eligibility Client Registration in HelpLine Intervention
    Given User Navigate to QFL State Client URL
    When User selects "HelpLine" Intervention and proceed
    When User selects language options
      | language | English |
    When User fills About You Section
      | firstName    | TestUserFName |
      | lastName     | TestUserLName |
      | gender       | Male          |
      | dob          | 08/24/1990    |
    Then User fills Create your Login ID section and agreement to TOU
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
    Then User enters "HelpLine" Contact Info details
#   Contact details are taken from individual Client Properties file except below options.
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
    Then   User completes the "HelpLine" Intervention Enrollment Questionnaire
#    Then User Add Goal "Quit Tobacco" in Managed Goals Page for "HelpLine" Intervention
    Then User completes NRT Medication Questionnaire for "HelpLine" Intervention
    When User clicks I have reached my Goal for "HelpLine" Intervention
    Then User Add Goal "Stay Tobacco-Free" in Managed Goals Page for "HelpLine" Intervention


  @QFLStateClientEnrollmentWebCoach @PreEligibility @QFLStateClientEnrollment
  Scenario: State Assumed Eligibility Client Registration in WebCoach Intervention
    Given User Navigate to QFL State Client URL
    When User selects "WebCoach" Intervention and proceed
    When User selects language options
      | language | English |
    When User fills About You Section
      | firstName    | TestUserFName |
      | lastName     | TestUserLName |
      | gender       | Male          |
      | dob          | 08/24/1990    |
    Then User fills Create your Login ID section and agreement to TOU
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
    Then User enters "WebCoach" Contact Info details
#   Contact details are taken from individual Client Properties file except below options.
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
    Then   User completes the "WebCoach" Intervention Enrollment Questionnaire
    Then User completes NRT Medication Questionnaire for "WebCoach" Intervention
#    Then User Add Goal "Quit Tobacco" in Managed Goals Page for "WebCoach" Intervention
    When User clicks I have reached my Goal for "WebCoach" Intervention
    Then User Add Goal "Stay Tobacco-Free" in Managed Goals Page for "WebCoach" Intervention

    @QFLStateClientEnrollmentIndividual
  Scenario: State Assumed Eligibility Client Registration in Individual Intervention
    Given User Navigate to QFL State Client URL
    When User selects "Individual" Intervention and proceed
    When User selects language options
      | language | English |
    When User fills About You Section
      | firstName    | TestUserFName |
      | lastName     | TestUserLName |
      | gender       | Male          |
      | dob          | 08/24/1990    |
    Then User fills Create your Login ID section and agreement to TOU
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
    Then User enters "Individual" Contact Info details
#   Contact details are taken from individual Client Properties file except below options.
      | May we leave a message at this number               | No                                              |
      | What type of phone is this?                         | Mobile                                          |
      | When is the best time to reach you at this number?  | Any day                                         |
      | When to Call:                                       | Any time                                        |
    Then   User completes the "Individual" Intervention Enrollment Questionnaire
    Then User completes NRT Medication Questionnaire for "Individual" Intervention