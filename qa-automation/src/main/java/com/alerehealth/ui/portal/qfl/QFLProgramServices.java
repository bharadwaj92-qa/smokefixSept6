package com.alerehealth.ui.portal.qfl;

public enum QFLProgramServices {


    TEXT2QUIT("Text2Quit"),
    MEDICATIONS("Medications"),
    WELCOMEKIT("Welcome Kit"),
    EMAILPROGRAM("Email Program");

    String serviceName;

    QFLProgramServices(String serviceName){

        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return serviceName;
    }
}
