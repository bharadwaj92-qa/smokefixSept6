package com.alerehealth.ui.portal.common.pages;

public enum Zone3Constants {

    NurseAdviceLine("Nurse Advice Line"),
    Library("Library"),
    Trackers("Trackers"),
    YourCarePlan("Your Care Plan");

    private String zoneHeader;

     Zone3Constants(String zoneHeader){

        this.zoneHeader = zoneHeader;
    }

    @Override
    public String toString() {
        return zoneHeader.toString();
    }
}
