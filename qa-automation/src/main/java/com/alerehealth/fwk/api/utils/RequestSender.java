package com.alerehealth.fwk.api.utils;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class RequestSender {


    public static Response sendGetRequest(String apiPath){

        Response response = given()
                .when()
                .get(apiPath);

        return response;
    }


    public static Response sendPostRequest(String apiPath, String body){

        Response response = given().body(body).when().post(apiPath);

        return response;

    }

}
