package com.alerehealth.fwk.api.constants;

public enum APITagIgnore {


    GET_QUESTIONNARE_API("QGroups");




    String tag;

    APITagIgnore(String tag){

        this.tag = tag;
    }

    public String toString(){

        return tag;
    }

}
