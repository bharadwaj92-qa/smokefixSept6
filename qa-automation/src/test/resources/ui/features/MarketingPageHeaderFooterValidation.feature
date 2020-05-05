Feature: Verfiy Marketing page headers and footers

@Smoke @SmokeUI @UI
Scenario: Marketing page footer verification
Given Launch the Marketing page
Then i verify the footers "Contact","Privacy","Terms","Accessibility" in marketing page 


@Smoke @SmokeUI @UI 
Scenario: Marketing page header verification
Given Launch the Marketing page
Then i verify the headers"The smart way to practice healthy living.","Sign Up","Log In","Health Net" in marketing page 





