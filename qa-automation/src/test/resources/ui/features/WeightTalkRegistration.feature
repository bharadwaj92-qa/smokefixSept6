@WeightTalkSmoke
Feature: Weight Talk Registration and Setting Goals Scenario

  @WTSmoke1 @Smoke @SmokeUI @UI
  Scenario: Verification of Weight Talk Registration and Setting Goals 
    
    Given User Navigate to KLGates Client URL
    When Register a user with KeyCode option
    And Fill in all the details in Eligibility Form and Create your login Page
    |lastName|Test|
    |gender|Female|
    |dob|08/24/1990|
    |isPregnant|No|
    |isUnderDialysis|No|
    |diabetesType|Type 1|
    |weightlossSurgeryDone|No|
    |weightlossSurgeryin12Months|No|
    |currentHeightFeet|5|
    |currentHeghtInches|5|
    |currentWeight|200|
    |loginID|test1234@gmail.com|
    |password|Test#123|
    |confirmPassword|Test#123|
    |securityQuestion1|What is your city of birth?|
    |answer1|asdf|
    |hint1|asdf1|
    |securityQuestion2|What school did you attend for sixth grade?|
    |answer2|asdf|
    |hint2|asdf2|
    |securityQuestion3|In what city or town was your first job?|
    |answer3|asdf|
    |hint3|asdf3|
    Then User should be taken to Portal Home page
    When User clicks on Action plan's Active goal and completes mini assessment and navigates to goal set up screen
    |communicationMode|Online|
    |addressText|Greeley Street 3001|
    |cityName|Houston|
    |state|Alabama|
    |zip|12345|
    |country|USA|
    |timezone|CST|
    |primaryPhoneNumberToEnter|1234567890|
    |primaryPhoneTypeToSelect|Home|
    |preferredDay|Weekends|
    |callOption|After|
    |preferredTime|8 AM|
    |language|English|
    And Complete and validate to-dos
    Then Validate Add goal is not present in Manage Goals page and 11 calls are present in wellness page  
    |coachingCalls|11|
    
 @WTSmoke2 @Smoke @SmokeUI @UI
  Scenario: Verification of Ineligibility error message before registration
	
	Given User Navigate to KLGates Client URL
    When Register a user with KeyCode option
    And Fill in all the details in Eligibility Form as a Pregnant Patient
    |lastName|Test|
    |gender|Female|
    |dob|08/24/1990|
    |isPregnant|Yes|
    |isUnderDialysis|No|
    |diabetesType|No|
    |weightlossSurgeryDone|No|
    |weightlossSurgeryin12Months|No|
    |currentHeightFeet|5|
    |currentHeghtInches|5|
    |currentWeight|200|
    Then Pregnancy Ineligibility Error Message should be displayed
    |pregnancyErrorMessage|We're sorry, this program is not intended for people who are pregnant. Talk with your healthcare provider about your nutritional needs during pregnancy, and how to reach the right target weight for you. Come back to us after you've had your baby if you want help managing your weight. Good luck!|
    Given User Navigate to KLGates Client URL
    When Register a user with KeyCode option
    When User Fill in all the details in Eligibility Form as a Dialysis Patient
    |lastName|Test|
    |gender|Female|
    |dob|08/24/1990|
    |isPregnant|No|
    |isUnderDialysis|Yes|
    |diabetesType|No|
    |weightlossSurgeryDone|No|
    |weightlossSurgeryin12Months|No|
    |currentHeightFeet|5|
    |currentHeghtInches|5|
    |currentWeight|200|
    Then Dialysis Ineligibility Error Message should be displayed
    |dialysisErrorMessage|We're sorry, this program is not designed to support the needs of people who are undergoing dialysis. Please contact your Human Resources department to find out if other programs may be available to you.|
    Given User Navigate to KLGates Client URL
    When Register a user with KeyCode option
    When User Fill in all the details in Eligibility Form as a Correct BMI Patient
    |lastName|Test|
    |gender|Female|
    |dob|08/24/1990|
    |isPregnant|No|
    |isUnderDialysis|No|
    |diabetesType|No|
    |weightlossSurgeryDone|No|
    |weightlossSurgeryin12Months|No|
    |currentHeightFeet|5|
    |currentHeghtInches|5|
    |currentWeight|150|
    Then BMI Ineligibility Error Message should be displayed
    |bmiErrorMessage|We're sorry, your body mass index (BMI) is outside the range required to join this program. Please contact your Human Resources department to find out if other programs may be available to you.|
    
    
    
  @WTSmoke3 @Smoke @SmokeUI @UI
  Scenario: Verification of Ineligibility error message from Mini Assessment 
    
    Given User Navigate to KLGates Client URL
    When Register a user with KeyCode option
    And Fill in all the details in Eligibility Form and Create your login Page
    |lastName|Test|
    |gender|Female|
    |dob|08/24/1990|
    |isPregnant|No|
    |isUnderDialysis|No|
    |diabetesType|Type 1|
    |weightlossSurgeryDone|No|
    |weightlossSurgeryin12Months|No|
    |currentHeightFeet|5|
    |currentHeghtInches|5|
    |currentWeight|200|
    |loginID|test1234@gmail.com|
    |password|Test#123|
    |confirmPassword|Test#123|
    |securityQuestion1|What is your city of birth?|
    |answer1|asdf|
    |hint1|asdf1|
    |securityQuestion2|What school did you attend for sixth grade?|
    |answer2|asdf|
    |hint2|asdf2|
    |securityQuestion3|In what city or town was your first job?|
    |answer3|asdf|
    |hint3|asdf3|
    Then User should be taken to Portal Home page
    When User clicks on Action plan's Active goal and completes mini assessment as a Pregnant patient
    Then Pregnancy Ineligibility Error Message should be displayed for mini assessment
    |pregnancyErrorFromMiniAssessment|Weight Talk is a coaching program that helps people reach and maintain a healthy weight. Based on your answers, you may not be eligible to set a new goal. If you think you made an error with any of your answers, choose 'Back' to review.|
    When User completes the mini assessment as a Dialysis patient
    Then Dialysis Ineligibility Error Message should be displayed for mini assessment
    |dialysisErrorFromMiniAssessment|Weight Talk is a coaching program that helps people reach and maintain a healthy weight. Based on your answers, you may not be eligible to set a new goal. If you think you made an error with any of your answers, choose 'Back' to review.|
    When User completes the mini assessment with correct BMI 
    Then BMI Ineligibility Error Message should be displayed for mini assessment
    |bmiErrorFromMiniAssessment|Weight Talk is a coaching program that helps people reach and maintain a healthy weight. Based on your answers, you may not be eligible to set a new goal. If you think you made an error with any of your answers, choose 'Back' to review.|
    
		