Feature: LegalBranding feature functionality
     
    
   @LegalBranding1 @Regression
   Scenario: Validate Optum keyword is displaying in Privacy policy,  Text2Quit, MobileTextMessaging, Terms page
   
    Given Create Testuser in C3 tool with gender "Male" Age "72" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password
    And Click on Privacy link from Footer section, optum keyword should be displayed
    #When Click on HIPAA Notice of Privacy link from Privacy page, optum keyword should be displayed
    When Click on Terms link from Footer section, optum keyword should be displayed
    Then Click on Mobile Text Messaging from  TOU page, optum keyword should be displayed
    And Click on Text Messaging link from TOU page, optum keyword should be displayed
    And Click on Text Quit link from TOU page, optum keyword should be displayed
    
    
     @LegalBranding2  @Regression
   Scenario: Validate Pronounced Health keyword is displaying in Privacy policy,  Text2Quit, MobileTextMessaging, Terms page
    Given Launch the Marketing page
    And Click on Privacy link from Footer section, PronoucedHealth keyword should be displayed
    When Click on HIPAA Notice of Privacy link from Privacy page, Pronounced Health keyword should be displayed
    And Click on Terms link from Footer section, Pronounced Health keyword should be displayed
    Then Click on Mobile Text Messaging from  TOU page, Pronounced Health keyword should be displayed
    And Click on Text Messaging link from TOU page, Pronounced Health keyword should be displayed
    And Click on Text Quit link from TOU page, Pronounced Health keyword should be displayed
    
    
         @LegalBranding3   @Regression
   Scenario: Validate United Health care keyword is displaying in Privacy policy,  Text2Quit, MobileTextMessaging, Terms page
    Given Launch the Marketing page
    And Click on Privacy link from Footer section, United Health care keyword should be displayed
    When Click on HIPAA Notice of Privacy link from Privacy page, United Health care keyword should be displayed
    And Click on Terms link from Footer section, United Health care keyword should be displayed
     Then Click on Mobile Text Messaging from  TOU page, United Health care keyword should be displayed
    And Click on Text Messaging link from TOU page, United Health care keyword should be displayed
    And Click on Text Quit link from TOU page, United Health care keyword should be displayed
    
    
    
    