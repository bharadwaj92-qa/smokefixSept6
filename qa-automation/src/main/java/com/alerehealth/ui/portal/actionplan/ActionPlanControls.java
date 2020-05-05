package com.alerehealth.ui.portal.actionplan;

public enum ActionPlanControls {

    MULTISELECT,
    FIXEDLIST,
    TEXTFIELD,
    HEADER, SELECT, DATEFIELD, NUMERICFIELD, CHECKBOX;


    public String toString(){

        return this.name();
    }
}
