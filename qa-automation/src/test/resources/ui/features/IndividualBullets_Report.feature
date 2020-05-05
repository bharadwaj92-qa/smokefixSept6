@IndividualBullets
Feature: Individual bullets for wba results details report in different domains

  @UI @UIRegression @Regression @WBARegression @IndividualBullets_Spiritual
  Scenario: Verification of individual bullets for wba results details report in Spiritual
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | IndividualBullets-Report |
   And I click on view report button
   Then Click on "Spiritual" on left nav in wba results details page
   # And Verify domain summary name and individual bullets under "spiritual" section and display it
   Then Verify the bullet points as per sheet for "spiritual"
       | sheetname | IndiviualBulletsSpiritualDomain |
       

  @UI @UIRegression @Regression @WBARegression @IndividualBullets_Financial
  Scenario: Verification of individual bullets for wba results details report in Spiritual
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | IndividualBullets-Report |
    And I click on view report button
    Then Click on "Financial" on left nav in wba results details page
    #And Verify domain summary name and individual bullets under "financial" section and display it
    Then Verify the bullet points as per sheet for "financial"
       | sheetname | IndiviualBulletsFinancialDomain |

  @UI @UIRegression @Regression @WBARegression @IndividualBullets_Emotional
  Scenario: Verification of individual bullets for wba results details report in Spiritual
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | IndividualBullets-Report |
    And I click on view report button
    Then Click on "Emotional" on left nav in wba results details page
   # And Verify domain summary name and individual bullets under "emotional" section and display it
   Then Verify the bullet points as per sheet for "emotional"
       | sheetname | IndiviualBulletsEmotionalDomain |
       

  @UI @UIRegression @Regression @WBARegression @IndividualBullets_Social
  Scenario: Verification of individual bullets for wba results details report in Spiritual
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | IndividualBullets-Report |
    And I click on view report button
    Then Click on "Social" on left nav in wba results details page
    #And Verify domain summary name and individual bullets under "social" section and display it
    Then Verify the bullet points as per sheet for "social"
       | sheetname | IndiviualBulletsSocialDomain |



  ## Below are Additional Resources TC's for all domains
  @UI @UIRegression @Regression @WBARegression @AdditionalResource_Spiritual
  Scenario: Verification of additional resource under spiritual
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | IndividualBullets-Report |
    And I click on view report button
    Then Click on "Spiritual" on left nav in wba results details page
    And Verify and Click on "Spirituality and Your Health" link under "spiritual" section
    And Verify and Click on "Prayer" link under "spiritual" section
    
  @UI @UIRegression @Regression @WBARegression @AdditionalResource_Financial
  Scenario: Verification of additional resource under financial
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | IndividualBullets-Report |
    And I click on view report button
    Then Click on "Financial" on left nav in wba results details page
    And Verify and Click on "Saving Money on Medicine" link under "financial" section
    And Verify and Click on "Practical Money Skills" link under "financial" section new
    And Verify and Click on "Consumer Financial Protection Bureau" link under "financial" section new
    And Verify and Click on "Federal Trade Commission" link under "financial" section new
    And Verify and Click on "America Saves" link under "financial" section new
    And Verify and Click on "USA.Gov" link under "financial" section new
    And Verify and Click on "FINRA Investor Education Foundation" link under "financial" section new

 @UI @UIRegression @Regression @WBARegression @AdditionalResource_Emotional
  Scenario: Verification of additional resource under emotional
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | IndividualBullets-Report |
    And I click on view report button
    Then Click on "Emotional" on left nav in wba results details page
    And Verify and Click on "Healthy Thinking: Stop, Act, Choose" link under "emotional" section
    And Verify and Click on "Dealing With Stress" link under "emotional" section
    And Verify and Click on "What Is Your Stress Level?" link under "emotional" section
    And Verify and Click on "How Well Do You Bounce Back?" link under "emotional" section
    And Verify and Click on "Practicing Gratitude" link under "emotional" section
    And Verify and Click on "National Institutes of Health" link under "emotional" section new

  @UI @UIRegression @Regression @WBARegression @AdditionalResource_Social
  Scenario: Verification of additional resource under social
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | IndividualBullets-Report |
    And I click on view report button
    Then Click on "Social" on left nav in wba results details page
    And Verify and Click on "Social Connections" link under "social" section
    And Verify and Click on "Importance of Personal Relationships for Lowering Stress" link under "social" section
    And Verify and Click on "National Resource Center for Healthy Marriage and Families" link under "social" section new
    And Verify and Click on "Volunteer.gov" link under "social" section new
    And Verify and Click on "Do Something" link under "social" section new
