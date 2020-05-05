Feature: MemberResourceCenter Functionality

@Member
Scenario:  MemberResourceCenter verification for Tufts Client
 Given Create Testuser in C3 tool with gender "Male" Age "72" Client "Tufts Health Plan Commercial (4000111)" and working population "THPC-Program Indicator 6 - TUFTS ASSOCIATED HEALTH PLANS INC (1015395)"
 And Login to AlerePortal using C3 Created userName and Password
 When Click on ViewAll link beside Bulletin Board
 And Verify all the names are displayed correctly under different sections in MemberResourceCenter Page
 And Click on All links under Wellness Resources section which should be navigated to repective pages
 And Click on All links under Smoking Cessation section which should be navigated to respective pages
 Then Click on All links under Diseases and Conditions section which should be navigated to respective pages
 And Click on All links under Having a baby section which should be navigated to respective pages
 
 
 
 @Member1
Scenario:  MemberResourceCenter verification for Healthnet Client
 Given Create Testuser in C3 tool with gender "Male" Age "72" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
 And Login to AlerePortal using C3 Created userName and Password
 When Click on ViewAll link beside Bulletin Board 
Then Validate the Welcome Message displayed in Member Resource Center page
 