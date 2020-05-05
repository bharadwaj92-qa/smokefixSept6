package com.alerehealth.fwk.common;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.alerehealth.fwk.exceptions.PropertyFileMissingException;

public class ClientConfiguration {
	
	public static ClientConfiguration clientConfiguration;
	
	private String clientName;
	private String clientURL;
	private String WBAName;
	private String WBARequiredforIncentive;
	private String WBACredits;
	private String requiredBiometrics;
	private String spanishOption;
	private String WBALandingPageText;
	private String ActionPlan;
	private String Progress;
	private String Rewards;
	private String Coaching;
	private String Library;
	private String MemberResourceCenter;
	private String Community;
	private String Credits;
	private String WBANonRquiredQuestions;
	private String WBAQuestionExclusionList;
	private String WBARequiredBioFields;
	private String ClientLogo;
	private String C3toolURL;
	private String History;
	private String challengesNavigation;
	private String creditsPageNavigation;
	private String historyPageNavigation;
	private String trackesPageNavigation;
	private String activeGoalsNavigation;
	private String manageGoalsNavigation;
	private String marketingPageTitle;
	private List<String> coachingMenuItems;
	private  String portal_url_qfl;
	private String AddressLine1Label;
	private String AddressLine1Value;
	private String StateLabel;
	private String StateValue;
	private String CityLabel;
	private String CityValue;
	private String ZipCodeLabel;
	private String ZipCodeValue;
	private String PrimaryPhonePrefixLabel;
	private String PrimaryPhonePrefixValue;
	private String LeaveMesasgeLabel;
	private String LeaveMesasgeValue;
	private String TypeOfPhoneLabel;
	private String TypeOfPhoneValue;
	private String DayToCallLabel;
	private String DayToCallValue;
	private String TimeToCallLabel;
	private String TimeToCallValue;
	private String QFLEnrollmentHelpLineSheetName;
	private String QFLEnrollmentTextQuitSmokeHelpLineSheetName;
	private String QFLEnrollFemaleHelpLineSheetName;
	private String QFLFemaleEnrollmentTextQuitSmokeHelpLineSheetName;
	private String QFLEnrollmentUHCFIClientSheetName;
	private String QFLEnrollmentWebCoachSheetName;
	private String QFLEnrollmentIndividualSheetName;
	private String QFLEnrollmentTECOCLSheetName;
	private String QFLEnrollmentABUSSheetName;
	private String QFLEnrollmentABUSFemaleSheetName;
	private String QFLEnrollmentABUSFemalePregSheetName;
	private String FirstName;
	private String LastName;
	private String Gender;
	private String DOB;
	private String ZipCode;
	private String QFLKeyCode;
	private String Medicaid;
	private String MedicaidID;
	private String QFLkeycodeValue;
	private String ClientType;
	private String registeringAs;
	private String GroupNumber;
	private String SubscriberID;
	private String QFLNRTFromActionPlanSheetName;
	private String QFLNRTDirectSheetName;
	public String getActivityFeedPageNavigation() {
		return activityFeedPageNavigation;
	}

	public void setActivityFeedPageNavigation(String activityFeedPageNavigation) {
		this.activityFeedPageNavigation = activityFeedPageNavigation;
	}

	private String activityFeedPageNavigation;
	private String nurseAdviceLineNavigation;
	private String libraryWellnessNavigation;
	private String libraryConditionsNavigation;
	private String libraryPregnancyAndBabyNavigation;
	private String libraryTobaccoFreeNavigation;
	private String keyCode;
	private List<String> missedChallenges;
	private String nurse24LandingPageWelcomeText;
	private String nurse24starChatValidationMessage;
	private String qflClientCode;
	private String qflClientID;
/*	public String getClientLogo() {
		return ClientLogo;
	}
	public void setClientLogo(String clientLogo) {
		ClientLogo = clientLogo;
	}*/



	public static ClientConfiguration getClientConfiguration() {
		 if(clientConfiguration==null){


			 clientConfiguration = createClientConfiguration();


	        }
	        return clientConfiguration;
	}
	private static ClientConfiguration createClientConfiguration() {
		ClientConfiguration clientConfiguration = new ClientConfiguration();

        String propertyFileName = System.getProperty("ClientName");

        if(propertyFileName==null){

            propertyFileName = System.getenv("ClientName");
        }
        if(propertyFileName==null){

            propertyFileName = "QFLState_NewMexicoQuitLine";
        }

        PropertyFileReader propertyFileReader;
        try {
            propertyFileReader = new PropertyFileReader(propertyFileName);

        }catch (IOException e){

            throw new PropertyFileMissingException(propertyFileName);
        }
        
        
        clientConfiguration.setClientName(propertyFileReader.getPropertyValue("ClientName"));
        clientConfiguration.setClientURL(propertyFileReader.getPropertyValue("ClientURL"));
        clientConfiguration.setWBAName(propertyFileReader.getPropertyValue("WBAName"));
        clientConfiguration.setWBARequiredforIncentive(propertyFileReader.getPropertyValue("WBARequiredforIncentive"));
        
        clientConfiguration.setWBACredits(propertyFileReader.getPropertyValue("WBACredits"));
        clientConfiguration.setRequiredBiometrics(propertyFileReader.getPropertyValue("RequiredBiometricsbesidesHT&WT"));
        clientConfiguration.setSpanishOption(propertyFileReader.getPropertyValue("TurnonSpanishOption"));
        clientConfiguration.setWBALandingPageText(propertyFileReader.getPropertyValue("WBALandingPageText"));
        
        clientConfiguration.setActionPlan(propertyFileReader.getPropertyValue("ActionPlan"));
        clientConfiguration.setProgress(propertyFileReader.getPropertyValue("Progress"));
        clientConfiguration.setRewards(propertyFileReader.getPropertyValue("Rewards"));
        clientConfiguration.setCoaching(propertyFileReader.getPropertyValue("Coaching"));
        clientConfiguration.setLibrary(propertyFileReader.getPropertyValue("Library"));
        clientConfiguration.setMemberResourceCenter(propertyFileReader.getPropertyValue("MemberResourceCenter"));
        clientConfiguration.setCommunity(propertyFileReader.getPropertyValue("Community"));
        clientConfiguration.setCredits(propertyFileReader.getPropertyValue("Credits"));
        clientConfiguration.setMarketingPageTitle(propertyFileReader.getPropertyValue("MarketingPageTitle"));
        clientConfiguration.setWBANonRquiredQuestions(propertyFileReader.getPropertyValue("WBANonRquiredQuestions"));
        clientConfiguration.setWBAQuestionExclusionList(propertyFileReader.getPropertyValue("WBAQuestionExclusionList"));
        clientConfiguration.setWBARequiredBioFields(propertyFileReader.getPropertyValue("WBARequiredBioFields"));
        clientConfiguration.setClientLogo(propertyFileReader.getPropertyValue("ClientLogo"));
        clientConfiguration.setC3ClientURL(propertyFileReader.getPropertyValue("C3toolURL"));
        clientConfiguration.setHistory(propertyFileReader.getPropertyValue("History"));
        clientConfiguration.setMissedChallenges(propertyFileReader.getPropertyValue("missedchallenges"));
		clientConfiguration.setKeyCode(propertyFileReader.getPropertyValue("keycode"));
		clientConfiguration.setChallengesNavigation(propertyFileReader.getPropertyValue("challengesnavigation"));
		clientConfiguration.setCreditsPageNavigation(propertyFileReader.getPropertyValue("creditspagenavigation"));
		clientConfiguration.setHistoryPageNavigation(propertyFileReader.getPropertyValue("historypagenavigation"));
		clientConfiguration.setTrackesPageNavigation(propertyFileReader.getPropertyValue("trackerpagenavigation"));
		clientConfiguration.setNurseAdviceLineNavigation(propertyFileReader.getPropertyValue("nurseAdviceLineNavigation"));
		clientConfiguration.setActivityFeedPageNavigation(propertyFileReader.getPropertyValue("ActivityFeedPageNavigation"));
		clientConfiguration.setLibraryWellnessNavigation(propertyFileReader.getPropertyValue("libraryWellnessNavigation"));
		clientConfiguration.setLibraryConditionsNavigation(propertyFileReader.getPropertyValue("libraryConditionsNavigation"));
		clientConfiguration.setLibraryPregnancyAndBabyNavigation(propertyFileReader.getPropertyValue("libraryPregnancyAndBabyNavigation"));
		clientConfiguration.setLibraryTobaccoFreeNavigation(propertyFileReader.getPropertyValue("libraryTobaccoFreeNavigation"));
		clientConfiguration.setNurse24LandingPageWelcomeText(propertyFileReader.getPropertyValue("nurse24LandingPageWelcomeText"));
		clientConfiguration.setCoachingMenuItems(propertyFileReader.getPropertyValue("CoachingMenuItems"));
		clientConfiguration.setStartChatValidationMessage(propertyFileReader.getPropertyValue("nurse24starChatValidationMessage"));
		clientConfiguration.setActiveGoalsNavigation(propertyFileReader.getPropertyValue("actionPlanNavigation"));
		clientConfiguration.setManageGoalsNavigation(propertyFileReader.getPropertyValue("manageGoalsNavigation"));
		clientConfiguration.setAddressLine1Label(propertyFileReader.getPropertyValue("AddressLine1Label"));
		clientConfiguration.setAddressLine1Value(propertyFileReader.getPropertyValue("AddressLine1Value"));
		clientConfiguration.setCityLabel(propertyFileReader.getPropertyValue("CityLabel"));
		clientConfiguration.setCityValue(propertyFileReader.getPropertyValue("CityValue"));
		clientConfiguration.setZipCodeLabel(propertyFileReader.getPropertyValue("ZipCodeLabel"));
		clientConfiguration.setZipCodeValue(propertyFileReader.getPropertyValue("ZipCodeValue"));
		clientConfiguration.setPrimaryPhonePrefixLabel(propertyFileReader.getPropertyValue("PrimaryPhonePrefixLabel"));
		clientConfiguration.setPrimaryPhonePrefixValue(propertyFileReader.getPropertyValue("PrimaryPhonePrefixValue"));
		clientConfiguration.setLeaveMesasgeLabel(propertyFileReader.getPropertyValue("LeaveMesasgeLabel"));
		clientConfiguration.setLeaveMesasgeValue(propertyFileReader.getPropertyValue("LeaveMesasgeValue"));
		clientConfiguration.setTypeOfPhoneLabel(propertyFileReader.getPropertyValue("TypeOfPhoneLabel"));
		clientConfiguration.setTypeOfPhoneValue(propertyFileReader.getPropertyValue("TypeOfPhoneValue"));
		clientConfiguration.setDayToCallLabel(propertyFileReader.getPropertyValue("DayToCallLabel"));
		clientConfiguration.setDayToCallValue(propertyFileReader.getPropertyValue("DayToCallValue"));
		clientConfiguration.setTimeToCallLabel(propertyFileReader.getPropertyValue("TimeToCallLabel"));
		clientConfiguration.setTimeToCallValue(propertyFileReader.getPropertyValue("TimeToCallValue"));
		clientConfiguration.setQFLEnrollmentHelpLineSheetName(propertyFileReader.getPropertyValue("QFLEnrollmentHelpLineSheetName"));
		clientConfiguration.setQFLEnrollmentTextQuitHelpLineSheetName(propertyFileReader.getPropertyValue("QFLEnrollmentTextQuitSmokeHelpLineSheetName"));
		clientConfiguration.setQFLFemaleEnrollmentHelpLineSheetName(propertyFileReader.getPropertyValue("QFLEnrollFemaleHelpLineSheetName"));
		clientConfiguration.setQFLFemaleEnrollmentTextQuitHelpLineSheetName(propertyFileReader.getPropertyValue("QFLFemaleEnrollmentTextQuitSmokeHelpLineSheetName"));
		clientConfiguration.setQFLEnrollmentWebCoachSheetName(propertyFileReader.getPropertyValue("QFLEnrollmentWebCoachSheetName"));
		clientConfiguration.setQFLEnrollmentIndividualSheetName(propertyFileReader.getPropertyValue("QFLEnrollmentIndividualSheetName"));
		clientConfiguration.setQFLEnrollmentUHCFIClientSheetName(propertyFileReader.getPropertyValue("QFLEnrollmentUHCFIClientSheetName"));
		clientConfiguration.setQFLEnrollmentABUSSheetName(propertyFileReader.getPropertyValue("QFLEnrollmentABUSSheetName"));
		clientConfiguration.setQFLEnrollmentFemaleABUSSheetName(propertyFileReader.getPropertyValue("QFLEnrollmentABUSFemaleSheetName"));
		clientConfiguration.setQFLEnrollmentFemalePregABUSSheetName(propertyFileReader.getPropertyValue("QFLEnrollmentABUSFemalePregSheetName"));
		clientConfiguration.setQFLEnrollmentTECOCLClientSheetName(propertyFileReader.getPropertyValue("QFLEnrollmentTECOCLSheetName"));
		clientConfiguration.setFirstName(propertyFileReader.getPropertyValue("FirstName"));
		clientConfiguration.setLastName(propertyFileReader.getPropertyValue("LastName"));
		clientConfiguration.setGender(propertyFileReader.getPropertyValue("Gender"));
		clientConfiguration.setDOB(propertyFileReader.getPropertyValue("DOB"));
		clientConfiguration.setZipCode(propertyFileReader.getPropertyValue("ZipCode"));
		clientConfiguration.setQFLKeyCode(propertyFileReader.getPropertyValue("QFLKeyCode"));
		clientConfiguration.setMedicaid(propertyFileReader.getPropertyValue("Medicaid"));
		clientConfiguration.setMedicaidID(propertyFileReader.getPropertyValue("MedicaidID"));
		clientConfiguration.setQFLkeycodeValue(propertyFileReader.getPropertyValue("QFLkeycodeValue"));
		clientConfiguration.setClientType(propertyFileReader.getPropertyValue("ClientType"));
		clientConfiguration.setregisteringAs(propertyFileReader.getPropertyValue("registeringAs"));
		clientConfiguration.setStateLabel(propertyFileReader.getPropertyValue("StateLabel"));
		clientConfiguration.setStateValue(propertyFileReader.getPropertyValue("StateValue"));
		clientConfiguration.setGroupNumber(propertyFileReader.getPropertyValue("GroupNumber"));
		clientConfiguration.setSubscriberID(propertyFileReader.getPropertyValue("SubscriberID"));
		clientConfiguration.setPortal_url_qfl(propertyFileReader.getPropertyValue("portal_ui_url_qfl"));
		clientConfiguration.setQflClientCode(propertyFileReader.getPropertyValue("QFLClientCode"));
		clientConfiguration.setQflClientID(propertyFileReader.getPropertyValue("QFLClientId"));
		clientConfiguration.setQFLNRTFromActionPlanSheetName(propertyFileReader.getPropertyValue("QFLNRTFromActionPlanSheetName"));
		clientConfiguration.setQFLNRTDirectSheetName(propertyFileReader.getPropertyValue("QFLNRTDirectSheetName"));

		return clientConfiguration;
	}
	public static void setClientConfiguration(ClientConfiguration clientConfiguration) {
		ClientConfiguration.clientConfiguration = clientConfiguration;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientURL() {
		return clientURL;
	}
	public void setClientURL(String clientURL) {
		this.clientURL = clientURL;
	}
	
	public String getC3ClientURL() {
		return C3toolURL;
	}
	public void setC3ClientURL(String C3toolURL) {
		this.C3toolURL = C3toolURL;
	}
	
	public String getWBAName() {
		return WBAName;
	}
	public void setWBAName(String wBAName) {
		WBAName = wBAName;
	}
	public String getWBARequiredforIncentive() {
		return WBARequiredforIncentive;
	}
	public void setWBARequiredforIncentive(String wBARequiredforIncentive) {
		WBARequiredforIncentive = wBARequiredforIncentive;
	}
	public String getWBACredits() {
		return WBACredits;
	}
	public void setWBACredits(String wBACredits) {
		WBACredits = wBACredits;
	}
	public String getRequiredBiometrics() {
		return requiredBiometrics;
	}
	public void setRequiredBiometrics(String requiredBiometrics) {
		this.requiredBiometrics = requiredBiometrics;
	}
	public String getSpanishOption() {
		return spanishOption;
	}
	public void setSpanishOption(String spanishOption) {
		this.spanishOption = spanishOption;
	}
	public String getWBALandingPageText() {
		return WBALandingPageText;
	}
	public void setWBALandingPageText(String wBALandingPageText) {
		WBALandingPageText = wBALandingPageText;
	}
	public String getActionPlan() {
		return ActionPlan;
	}
	public void setActionPlan(String actionPlan) {
		ActionPlan = actionPlan;
	}
	public String getProgress() {
		return Progress;
	}
	public void setProgress(String progress) {
		Progress = progress;
	}
	public String getRewards() {
		return Rewards;
	}
	public void setRewards(String rewards) {
		Rewards = rewards;
	}
	public String getCoaching() {
		return Coaching;
	}
	public void setCoaching(String coaching) {
		Coaching = coaching;
	}
	public String getLibrary() {
		return Library;
	}
	public void setLibrary(String library) {
		Library = library;
	}
	public String getMemberResourceCenter() {
		return MemberResourceCenter;
	}
	public void setMemberResourceCenter(String memberResourceCenter) {
		MemberResourceCenter = memberResourceCenter;
	}
	public String getCommunity() {
		return Community;
	}
	public void setCommunity(String community) {
		Community = community;
	}
	public String getCredits() {
		return Credits;
	}
	public void setCredits(String credits) {
		Credits = credits;
	}
	public String getWBANonRquiredQuestions() {
		return WBANonRquiredQuestions;
	}
	public void setWBANonRquiredQuestions(String wBANonRquiredQuestions) {
		WBANonRquiredQuestions = wBANonRquiredQuestions;
	}
	public String getWBAQuestionExclusionList() {
		return WBAQuestionExclusionList;
	}
	public void setWBAQuestionExclusionList(String wBAQuestionExclusionList) {
		WBAQuestionExclusionList = wBAQuestionExclusionList;
	}
	public String getWBARequiredBioFields() {
		return WBARequiredBioFields;
	}
	public void setWBARequiredBioFields(String wBARequiredBioFields) {
		WBARequiredBioFields = wBARequiredBioFields;
	}
	public String getHistory()
	{
	             return History;
	}

	public void setHistory(String history)
	{
	             History=history;
	}


	public List<String> getMissedChallenges() {
		return missedChallenges;
	}

	public void setMissedChallenges(String missedChallenges) {

		String missedChallengesAr[] = missedChallenges.split(",");

		this.missedChallenges = Arrays.asList(missedChallengesAr);
	}
	public String getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getChallengesNavigation() { return challengesNavigation; }

	public void setChallengesNavigation(String challengesNavigation) { this.challengesNavigation = challengesNavigation; }
	public String getCreditsPageNavigation() {
		return creditsPageNavigation;
	}

	public void setCreditsPageNavigation(String creditsPageNavigation){this.creditsPageNavigation = creditsPageNavigation; }
    
	public void setHistoryPageNavigation(String historyPageNavigation){this.historyPageNavigation = historyPageNavigation; }
     
	public String getHistoryPageNavigation() {
		return historyPageNavigation;
	}
     
	public String getTrackesPageNavigation() {
		return trackesPageNavigation;
	}

	public void setTrackesPageNavigation(String trackesPageNavigation){this.trackesPageNavigation = trackesPageNavigation; }

	public String getNurseAdviceLineNavigation() {
		return nurseAdviceLineNavigation;
	}

	public void setNurseAdviceLineNavigation(String nurseAdviceLineNavigation) {
		this.nurseAdviceLineNavigation = nurseAdviceLineNavigation;
	}

	public String getLibraryWellnessNavigation() {
		return libraryWellnessNavigation;
	}

	public void setLibraryWellnessNavigation(String libraryWellnessNavigation) {
		this.libraryWellnessNavigation = libraryWellnessNavigation;
	}

	public String getLibraryConditionsNavigation() {
		return libraryConditionsNavigation;
	}

	public void setLibraryConditionsNavigation(String libraryConditionsNavigation) {
		this.libraryConditionsNavigation = libraryConditionsNavigation;
	}

	public String getLibraryPregnancyAndBabyNavigation() {
		return libraryPregnancyAndBabyNavigation;
	}

	public void setLibraryPregnancyAndBabyNavigation(String libraryPregnancyAndBabyNavigation) {
		this.libraryPregnancyAndBabyNavigation = libraryPregnancyAndBabyNavigation;
	}

	public String getLibraryTobaccoFreeNavigation() {
		return libraryTobaccoFreeNavigation;
	}

	public void setLibraryTobaccoFreeNavigation(String libraryTobaccoFreeNavigation) {
		this.libraryTobaccoFreeNavigation = libraryTobaccoFreeNavigation;
	}

	public String getMarketingPageTitle() {
		return marketingPageTitle;
	}

	public void setMarketingPageTitle(String marketingPageTitle) {
		this.marketingPageTitle = marketingPageTitle;
	}
	public String getNurse24LandingPageWelcomeText() { return nurse24LandingPageWelcomeText; }

	public void setNurse24LandingPageWelcomeText(String nurse24LandingPageWelcomeText) { this.nurse24LandingPageWelcomeText = nurse24LandingPageWelcomeText; }

	public List<String> getCoachingMenuItems(){ return coachingMenuItems; }

	public void setCoachingMenuItems(String coachingMenus){

		String coachingMenuItems[] = coachingMenus.split(",");
		this.coachingMenuItems = Arrays.asList(coachingMenuItems);

	}

	public String getClientLogo() {
		return ClientLogo;
	}
	public void setClientLogo(String clientLogo) {
		ClientLogo = clientLogo;
	}
	
	public void setStartChatValidationMessage(String validationMessage){
		nurse24starChatValidationMessage=validationMessage;
		}
	
	public String getStartChatValidationMessage(){
		return nurse24starChatValidationMessage;
		}
	
	public String getQflClientCode() {
		return qflClientCode;
	}

	public void setQflClientCode(String qflClientCode) {
		this.qflClientCode = qflClientCode;
	}

	public String getQflClientID() {
		return qflClientID;
	}

	public void setQflClientID(String qflClientID) {
		this.qflClientID = qflClientID;
	}
	public String getActionPlanNavigation() {
		return activeGoalsNavigation;
	}

	public void setActiveGoalsNavigation(String activeGoalsNavigation) {
		this.activeGoalsNavigation = activeGoalsNavigation;
	}

	public String getManageGoalsNavigation() {
		return manageGoalsNavigation;
	}

	public void setManageGoalsNavigation(String manageGoalsNavigation) {
		this.manageGoalsNavigation = manageGoalsNavigation;
	}

	public String getPortal_url_qfl() {
		return portal_url_qfl;
	}

	public void setPortal_url_qfl(String portal_url_qfl) {
		this.portal_url_qfl = portal_url_qfl;
	}

	public String getAddressLine1Label() {
		return AddressLine1Label;
	}

	public void setAddressLine1Label(String AddressLine1Label) {
		this.AddressLine1Label = AddressLine1Label;
	}

	public String getAddressLine1Value() {
		return AddressLine1Value;
	}

	public void setAddressLine1Value(String AddressLine1Value) {
		this.AddressLine1Value = AddressLine1Value;
	}

	public String getCityLabel() {
		return CityLabel;
	}

	public void setCityLabel(String CityLabel) {
		this.CityLabel = CityLabel;
	}

	public String getCityValue() {
		return CityValue;
	}

	public void setCityValue(String CityValue) {
		this.CityValue = CityValue;
	}

	public String getZipCodeLabel() {
		return ZipCodeLabel;
	}

	public void setZipCodeLabel(String ZipCodeLabel) {
		this.ZipCodeLabel = ZipCodeLabel;
	}

	public String getZipCodeValue() {
		return ZipCodeValue;
	}

	public void setZipCodeValue(String ZipCodeValue) {
		this.ZipCodeValue = ZipCodeValue;
	}

	public String getPrimaryPhonePrefixLabel() {
		return PrimaryPhonePrefixLabel;
	}

	public void setPrimaryPhonePrefixLabel(String PrimaryPhonePrefixLabel) {
		this.PrimaryPhonePrefixLabel = PrimaryPhonePrefixLabel;
	}

	public String getPrimaryPhonePrefixValue() {
		return PrimaryPhonePrefixValue;
	}

	public void setPrimaryPhonePrefixValue(String PrimaryPhonePrefixValue) {
		this.PrimaryPhonePrefixValue = PrimaryPhonePrefixValue;
	}

	public String getLeaveMesasgeLabel() {
		return LeaveMesasgeLabel;
	}

	public void setLeaveMesasgeLabel(String LeaveMesasgeLabel) {
		this.LeaveMesasgeLabel = LeaveMesasgeLabel;
	}

	public String getLeaveMesasgeValue() {
		return LeaveMesasgeValue;
	}

	public void setLeaveMesasgeValue(String LeaveMesasgeValue) {
		this.LeaveMesasgeValue = LeaveMesasgeValue;
	}

	public String getTypeOfPhoneLabel() {
		return TypeOfPhoneLabel;
	}

	public void setTypeOfPhoneLabel(String TypeOfPhoneLabel) {
		this.TypeOfPhoneLabel = TypeOfPhoneLabel;
	}

	public String getTypeOfPhoneValue() {
		return TypeOfPhoneValue;
	}

	public void setTypeOfPhoneValue(String TypeOfPhoneValue) {
		this.TypeOfPhoneValue = TypeOfPhoneValue;
	}

	public String getDayToCallLabel() {
		return DayToCallLabel;
	}

	public void setDayToCallLabel(String DayToCallLabel) {
		this.DayToCallLabel = DayToCallLabel;
	}

	public String getDayToCallValue() {
		return DayToCallValue;
	}

	public void setDayToCallValue(String DayToCallValue) {
		this.DayToCallValue = DayToCallValue;
	}

	public String getTimeToCallLabel() {
		return TimeToCallLabel;
	}

	public void setTimeToCallLabel(String TimeToCallLabel) {
		this.TimeToCallLabel = TimeToCallLabel;
	}

	public String getTimeToCallValue() {
		return TimeToCallValue;
	}

	public void setTimeToCallValue(String TimeToCallValue) {
		this.TimeToCallValue = TimeToCallValue;
	}

	public String getQFLEnrollmentHelpLineSheetName() {
		return QFLEnrollmentHelpLineSheetName;
	}

	public void setQFLEnrollmentHelpLineSheetName(String QFLEnrollmentHelpLineSheetName) {
		this.QFLEnrollmentHelpLineSheetName = QFLEnrollmentHelpLineSheetName;
	}
	
	public String getQFLEnrollmentUHCFIClientSheetName() {
		return QFLEnrollmentUHCFIClientSheetName;
	}

	public void setQFLEnrollmentUHCFIClientSheetName(String QFLEnrollmentUHCFIClientSheetName) {
		this.QFLEnrollmentUHCFIClientSheetName = QFLEnrollmentUHCFIClientSheetName;
	}
	
	public String getQFLEnrollmentTECOCLClientSheetName() {
		return QFLEnrollmentTECOCLSheetName;
	}

	public void setQFLEnrollmentTECOCLClientSheetName(String QFLEnrollmentTECOCLSheetName) {
		this.QFLEnrollmentTECOCLSheetName = QFLEnrollmentTECOCLSheetName;
	}

	public String getQFLEnrollmentWebCoachSheetName() {
		return QFLEnrollmentWebCoachSheetName;
	}

	public void setQFLEnrollmentWebCoachSheetName(String QFLEnrollmentWebCoachSheetName) {
		this.QFLEnrollmentWebCoachSheetName = QFLEnrollmentWebCoachSheetName;
	}

	public String getQFLEnrollmentIndividualSheetName() {
		return QFLEnrollmentIndividualSheetName;
	}

	public void setQFLEnrollmentIndividualSheetName(String QFLEnrollmentIndividualSheetName) {
		this.QFLEnrollmentIndividualSheetName = QFLEnrollmentIndividualSheetName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public void setZipCode(String ZipCode) {
		this.ZipCode = ZipCode;
	}

	public String getQFLKeyCode() {
		return QFLKeyCode;
	}

	public void setQFLKeyCode(String QFLKeyCode) {
		this.QFLKeyCode = QFLKeyCode;
	}

	public String getMedicaid() {
		return Medicaid;
	}

	public void setMedicaid(String Medicaid) {
		this.Medicaid = Medicaid;
	}

	public String getMedicaidID() {
		return MedicaidID;
	}

	public void setMedicaidID(String MedicaidID) {
		this.MedicaidID = MedicaidID;
	}

	public String getQFLkeycodeValue() {
		return QFLkeycodeValue;
	}

	public void setQFLkeycodeValue(String QFLkeycodeValue) {
		this.QFLkeycodeValue = QFLkeycodeValue;
	}

	public String getClientType() {
		return ClientType;
	}

	public void setClientType(String ClientType) {
		this.ClientType = ClientType;
	}

	public String getregisteringAs() {
		return registeringAs;
	}

	public void setregisteringAs(String registeringAs) {
		this.registeringAs = registeringAs;
	}

	public String getStateLabel() {
		return StateLabel;
	}

	public void setStateLabel(String StateLabel) {
		this.StateLabel = StateLabel;
	}

	public String getStateValue() {
		return StateValue;
	}

	public void setStateValue(String StateValue) {
		this.StateValue = StateValue;
	}

	public String getGroupNumber() {
		return GroupNumber;
	}

	public void setGroupNumber(String GroupNumber) {
		this.GroupNumber = GroupNumber;
	}

	public String getSubscriberID() {
		return SubscriberID;
	}

	public void setSubscriberID(String SubscriberID) {
		this.SubscriberID = SubscriberID;
	}

	public String getQFLNRTFromActionPlanSheetName() {
		return QFLNRTFromActionPlanSheetName;
	}

	public void setQFLNRTFromActionPlanSheetName(String QFLNRTFromActionPlanSheetName) {
		this.QFLNRTFromActionPlanSheetName = QFLNRTFromActionPlanSheetName;
	}

	public String getQFLNRTDirectSheetName() {
		return QFLNRTDirectSheetName;
	}

	public void setQFLNRTDirectSheetName(String QFLNRTDirectSheetName) {
		this.QFLNRTDirectSheetName = QFLNRTDirectSheetName;
	}
	
	public String getQFLEnrollmentTextQuitSmokeHelpLineSheetName() {
		return QFLEnrollmentTextQuitSmokeHelpLineSheetName;
	}

	public void setQFLEnrollmentTextQuitHelpLineSheetName(String QFLEnrollmentTextQuitSmokeHelpLineSheetName) {
		this.QFLEnrollmentTextQuitSmokeHelpLineSheetName = QFLEnrollmentTextQuitSmokeHelpLineSheetName;
	}
	
	public String getQFLFemaleEnrollmentHelpLineSheetName() {
		return QFLEnrollFemaleHelpLineSheetName;
	}

	public void setQFLFemaleEnrollmentHelpLineSheetName(String QFLEnrollFemaleHelpLineSheetName) {
		this.QFLEnrollFemaleHelpLineSheetName = QFLEnrollFemaleHelpLineSheetName;
	}
	
	public String getQFLFemaleEnrollmentTextQuitHelpLineSheetName() {
		return QFLFemaleEnrollmentTextQuitSmokeHelpLineSheetName;
	}

	public void setQFLFemaleEnrollmentTextQuitHelpLineSheetName(String QFLFemaleEnrollmentTextQuitSmokeHelpLineSheetName) {
		this.QFLFemaleEnrollmentTextQuitSmokeHelpLineSheetName = QFLFemaleEnrollmentTextQuitSmokeHelpLineSheetName;
	}
	
	public String getQFLEnrollmentABUSSheetName() {
		return QFLEnrollmentABUSSheetName;
	}

	public void setQFLEnrollmentABUSSheetName(String QFLEnrollmentABUSSheetName) {
		this.QFLEnrollmentABUSSheetName = QFLEnrollmentABUSSheetName;
	}
	
	public String getQFLEnrollmentFemalePregABUSSheetName() {
		return QFLEnrollmentABUSFemalePregSheetName;
	}

	public void setQFLEnrollmentFemalePregABUSSheetName(String QFLEnrollmentABUSFemalePregSheetName) {
		this.QFLEnrollmentABUSFemalePregSheetName = QFLEnrollmentABUSFemalePregSheetName;
	}
	
	public String getQFLEnrollmentFemaleABUSSheetName() {
		return QFLEnrollmentABUSFemaleSheetName;
	}

	public void setQFLEnrollmentFemaleABUSSheetName(String QFLEnrollmentABUSFemaleSheetName) {
		this.QFLEnrollmentABUSFemaleSheetName = QFLEnrollmentABUSFemaleSheetName;
	}
}
