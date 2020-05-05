#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.

Feature: PHR Search and Add doctor

  @PHR @SmokeUI @Smoke
  Scenario: PHR searching doctor and adding doctor
  Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password
     When Navigating to Health Record Page for doctorsearch
     And Searching for the Doctor with below information
		 
		 |Firstname|Lastname|City|Zipcode|State|
		 |sudhakar|edf|Florida|43567|California|
		 
		 And Adding the doctor with below information
		 
		 |SrcFirstname|SrcLastname|SrcAddress|SrcCity|SrcState|SrcZipCode|SrcPhonenum|
		 |KLK|Testing|TestAdd|Hyd|Arizona|32112|1231231231|
		 
     Then Verifying the Added doctor
     
     
   
     @PHR @SmokeUI @Smoke
  Scenario: PHR Health records validations
     #Given Launch the portal url with Username and Password
     Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
     And Login to AlerePortal using C3 Created userName and Password
     When Navigating to Health Record Page
     Then Validate the Health Record profile
   
 