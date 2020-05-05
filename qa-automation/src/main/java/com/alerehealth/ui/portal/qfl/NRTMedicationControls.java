package com.alerehealth.ui.portal.qfl;

public enum NRTMedicationControls {

        FIXEDLIST,
        NUMERICFIELD,
        MULTISELECT,
        CHECKBOX,
        HEADER;


        public String toString(){

            return this.name();
        }
}
