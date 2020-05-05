#Author: Mohammed Najeebuddin
@PhysicalReporting
Feature: WBA DomainReportPhysical scenarios

@UI @UIRegression @Regression @PhysicalScore=(66-100)
  Scenario: Verification of report for Physical category - Strong in Range (66-100)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(66-100)|
    And I click on view report button
    Then I validate the "physical"domain score "77" and description
    
@UI @UIRegression @Regression @PhysicalScore=(33-65)
  Scenario: Verification of report for Physical category - Average in Range (33-65)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(33-65)|
    And I click on view report button
    Then I validate the "physical"domain score "46" and description
    
@UI @UIRegression @Regression @PhysicalScore=(0-32)
  Scenario: Verification of report for Physical category - Poor in Range (0-32)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(0-32)|
    And I click on view report button
    Then I validate the "physical"domain score "5" and description
    
@UI @UIRegression @Regression @WeightBulletInRange
  Scenario: Verification of weight Bullet and Content when BMI (18.5 <= BMI < 25.0) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCheckedBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Weight" bullet
     Then Verify the "Weight" bullet Content when "BMI_in_Range" range
     
@UI @UIRegression @Regression @WeightBulletBelowRange
  Scenario: Verification of weight Bullet and Content when BMI (< 18.5) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | BMI < 18.5|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Weight" bullet
     Then Verify the "Weight" bullet Content when "BMI_below_Range" range
     
@UI @UIRegression @Regression @WeightBulletAboveRange
  Scenario: Verification of weight Bullet and Content when BMI (BMI >=25 and < 30) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | 25 <= BMI < 30|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Weight" bullet
     Then Verify the "Weight" bullet Content when "BMI_above_Range" range
     
@UI @UIRegression @Regression @WeightBulletVeryHighRange
  Scenario: Verification of weight Bullet and Content when BMI (BMI >= 30) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | BMI >= 30|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Weight" bullet
     Then Verify the "Weight" bullet Content when "BMI_Very_High" range
     
@UI @UIRegression @Regression @CholesterolBulletInRange
  Scenario: Verification of Cholesterol Bullet and Content when CholesterolRiskValue (=3) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCheckedBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Cholesterol" bullet
     Then Verify the "Cholesterol" bullet Content when "CholesterolRiskValue = 3" range
    
@UI @UIRegression @Regression @CholesterolBulletBelowRange
  Scenario: Verification of Cholesterol Bullet and Content when CholesterolRiskValue (<3) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCircledBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Cholesterol" bullet
     Then Verify the "Cholesterol" bullet Content when "CholesterolRiskValue < 3" range

#Faced some issues while executing     
@UI @UIRegression @Regression @CholesterolBulletMissingData
  Scenario: Verification of Cholesterol Bullet and Content when CholesterolRiskValue (Cholesterol_MissingData) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | CholesterolMissingData|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Cholesterol" bullet
     Then Verify the "Cholesterol" bullet Content when "Cholesterol_MissingData" range
     
@UI @UIRegression @Regression @MedicalConditionsBulletInRange
  Scenario: Verification of MedicalConditions Bullet and Content when MedicalConditions (ChronicCondCount = 0) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCheckedBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Medical Conditions" bullet
     Then Verify the "Medical Conditions" bullet Content when "MedicalConditions_In_Range" range
     
@UI @UIRegression @Regression @MedicalConditionsBulletAboveRange
  Scenario: Verification of MedicalConditions Bullet and Content when MedicalConditions (ChronicCondCount > 0) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCircledBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Medical Conditions" bullet
     Then Verify the "Medical Conditions" bullet Content when "MedicalConditions_Above_Range" range
     
@UI @UIRegression @Regression @TobaccouseBulletInRange
  Scenario: Verification of Tobaccouse Bullet and Content when TobaccoRiskValue (= 3) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCheckedBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Tobacco use" bullet
     Then Verify the "Tobacco use" bullet Content when "Tobacco_In_Range" range
    
@UI @UIRegression @Regression @TobaccouseBulletAboveRange
  Scenario: Verification of Tobaccouse Bullet and Content when TobaccoRiskValue (< 3) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCircledBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Tobacco use" bullet
     Then Verify the "Tobacco use" bullet Content when "Tobacco_Above_Range" range
     
@UI @UIRegression @Regression @AlcoholuseBulletInRange
  Scenario: Verification of Alcoholuse Bullet and Content when Alcohol (AlcoholRiskValue = 3) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCheckedBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Alcohol use" bullet
     Then Verify the "Alcohol use" bullet Content when "Alcohol_In_Range" range
    
@UI @UIRegression @Regression @AlcoholuseBulletAboveRange
  Scenario: Verification of Alcoholuse Bullet and Content when Alcohol (AlcoholRiskValue <= 2) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCircledBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Alcohol use" bullet
     Then Verify the "Alcohol use" bullet Content when "Alcohol_Above_Range" range
     
@UI @UIRegression @Regression @PhysicalActivityBulletAlways
  Scenario: Verification of PhysicalActivity Bullet and Content in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCheckedBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Physical Activity" bullet
     Then Verify the "Physical Activity" bullet Content when "Physical_Activity_Always" range
     
@UI @UIRegression @Regression @DietBulletAlways
  Scenario: Verification of Diet Bullet and Content in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCheckedBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Diet" bullet
     Then Verify the "Diet" bullet Content when "Diet_Always" range
     
@UI @UIRegression @Regression @SafetyBulletAlways
  Scenario: Verification of Safety Bullet and Content in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCheckedBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Safety" bullet
     Then Verify the "Safety" bullet Content when "Safety_Always" range
     
@UI @UIRegression @Regression @PregnancyBullet
  Scenario: Verification of Pregnancy Bullet and Content when (WBA_PS10 = 1) in WBA Report -** create user with age 40 gender - Female
    Given Create Testuser in C3 tool with gender "Female" Age "40" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Pregnancy|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Pregnancy" bullet
     Then Verify the "Pregnancy" bullet Content when "Pregnancy" range
     
@UI @UIRegression @Regression @SleepBulletInRange
  Scenario: Verification of Sleep Bullet and Content when (SleepRiskValue = 3) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCheckedBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Sleep" bullet
     Then Verify the "Sleep" bullet Content when "Sleep_In_Range" range
     
@UI @UIRegression @Regression @SleepBulletBelowRange
  Scenario: Verification of Sleep Bullet and Content when (SleepRiskValue < 3) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCircledBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Sleep" bullet
     Then Verify the "Sleep" bullet Content when "Sleep_Below_Range" range
     
@UI @UIRegression @Regression @Screenings/ImmunizationsBulletInRange
  Scenario: Verification of Screenings/Immunizations Bullet and Content when (ScrImmRiskValue = 3 ) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | ScreeningsImmunizationsInRange|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Screenings/Immunizations" bullet
     Then Verify the "Screenings/Immunizations" bullet Content when "Screenings/Immunizations_In_Range" range
     
@UI @UIRegression @Regression @Screenings/ImmunizationsBulletBelowRange
  Scenario: Verification of Screenings/Immunizations Bullet and Content when (ScrImmRiskValue < 3 ) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | ScreeningsImmunizationsBlwRange|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Screenings/Immunizations" bullet
     Then Verify the "Screenings/Immunizations" bullet Content when "Screenings/Immunizations_Below_Range" range
     
@UI @UIRegression @Regression @BloodPressureInRange
  Scenario: Verification of Blood Pressure Bullet and Content when (WBA_PS13A < 120 OR WBA_PS13B < 80 ) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCheckedBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Blood Pressure" bullet
     Then Verify the "Blood Pressure" bullet Content when "BloodPressure_In_Range" range
     
@UI @UIRegression @Regression @BloodPressureAboveRange
  Scenario: Verification of Blood Pressure Bullet and Content when ((WBA_PS13A <> NULL AND WBA_PS13B <> NULL) AND (WBA_PS13A >= 120 OR WBA_PS13B >= 80) ) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | PhysicalAllCircledBullet|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Blood Pressure" bullet
     Then Verify the "Blood Pressure" bullet Content when "BloodPressure_Above_Range" range
     
@UI @UIRegression @Regression @BloodPressureMissingData
  Scenario: Verification of Blood Pressure Bullet and Content when (WBA_PS13A = NULL AND WBA_PS13B = NULL) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | BloodPressureMissingData|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Blood Pressure" bullet
     Then Verify the "Blood Pressure" bullet Content when "BloodPressure_MissingData" range
     
     
@UI @UIRegression @Regression @BloodSugarNonDiabeticInRange
  Scenario: Verification of Blood Sugar Bullet and Content when (BGRiskValue = 3  and Non-Diabetic(WBA_PS5 = 3)) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | BloodSugarNonDiabeticInRange|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Blood sugar" bullet
     Then Verify the "Blood sugar" bullet Content when "BloodSugar_NonDiabetic_In_Range" range
     
@UI @UIRegression @Regression @BloodSugarNonDiabeticAboveRange
  Scenario: Verification of Blood Sugar Bullet and Content when (BGRiskValue < 3 and WBA_PS5 = 3 AND WBA_PS17 <> NULL) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | BloodSugarNonDiabeticAboveRange|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Blood sugar" bullet
     Then Verify the "Blood sugar" bullet Content when "BloodSugar_NonDiabetic_Above_Range" range
     
@UI @UIRegression @Regression @BloodSugarNonDiabeticMissingData
  Scenario: Verification of Blood Sugar Bullet and Content when (BGRiskValue < 3 and (If WBA_PS5 = 3 AND WBA_PS17 = NULL) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | BloodSugarNonDiabeticMissngData|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Blood sugar" bullet
     Then Verify the "Blood sugar" bullet Content when "BloodSugar_NonDiabetic_MissingData" range
     
@UI @UIRegression @Regression @BloodSugarDiabeticInRange
  Scenario: Verification of Blood Sugar Bullet and Content when (BGRiskValue = 3  and Diabetic (If  WBA_PS5 <3)) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | BloodSugarDiabeticInRange|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "check" bullet Icon and Click on "Blood sugar" bullet
     Then Verify the "Blood sugar" bullet Content when "BloodSugar_Diabetic_In_Range" range
     
@UI @UIRegression @Regression @BloodSugarDiabeticAboveRange
  Scenario: Verification of Blood Sugar Bullet and Content when (WBA_PS5 < 3 AND WBA_PS17 <> NULL - Diabetic - Too High) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | BloodSugarDiabeticAboveRange|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Blood sugar" bullet
     Then Verify the "Blood sugar" bullet Content when "BloodSugar_Diabetic_Above_Range" range
     
@UI @UIRegression @Regression @BloodSugarDiabeticMissingData
  Scenario: Verification of Blood Sugar Bullet and Content when (WBA_PS17 = NULL AND WBA_PS18 = NULL) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | BloodSugarDiabeticMissingData|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Blood sugar" bullet
     Then Verify the "Blood sugar" bullet Content when "BloodSugar_Diabetic_MissingData" range
     
@UI @UIRegression @Regression @BloodSugarBelowRange
  Scenario: Verification of Blood Sugar Bullet and Content when (WBA_PS17 < 70(Diabetic or not - Low Glucose)) in WBA Report
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | BloodSugarBelowRange|
    And I click on view report button
    Then Click on "Physical" on left nav in wba results details page
    Then Verify "circle" bullet Icon and Click on "Blood sugar" bullet
     Then Verify the "Blood sugar" bullet Content when "BloodSugar_Below_Range" range