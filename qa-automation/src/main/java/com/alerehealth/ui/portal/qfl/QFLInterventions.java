package com.alerehealth.ui.portal.qfl;

public enum QFLInterventions {

    Helpline("Helpline"),
    WebCoach("Web Coach"),
    IndividualServices("Individual Services"),
	MoreQuitTools("More Quit Tools"),
	AllAccess("All Access");

    private String intervention;

    QFLInterventions(String intervention){

        this.intervention = intervention;

    }




    @Override
    public String toString() {
        return intervention;
    }
}
