package com.alerehealth.ui.portal.wba.entities;

public enum WBAQuestionnaireControls {

    RADIOBUTTON,
    FIXEDLIST,
    CHECKBOX,
    TEXTFIELD,
    HEADER;


    public String toString(){

        return this.name();
    }

}
