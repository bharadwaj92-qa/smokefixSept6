package com.alerehealth.api.stepdefenitions;

import com.alerehealth.api.pojo.getquestionnaire.Question;
import com.alerehealth.fwk.api.constants.APIPaths;
import com.alerehealth.fwk.api.constants.APITagIgnore;
import com.alerehealth.fwk.api.utils.RequestSender;
import com.alerehealth.fwk.api.utils.UnmarshallHelper;
import com.alerehealth.fwk.api.utils.XMLPathUtils;
import com.alerehealth.fwk.api.utils.XMLUtils;
import com.alerehealth.api.pojo.getquestionnaire.QGroups;
import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.common.CustomLogger;
import com.alerehealth.fwk.common.LoggerUtils;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import org.apache.http.util.Asserts;
import org.junit.Assert;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.util.*;

public class GetQuestionnaireStepDef {

    String body;

    Response response;

    File loggedResponse ;

    @Given("^QuestionnaireID and ParticipantID$")
    public void questionnaireid_and_ParticipantID(DataTable arg1) throws Throwable {

        Map<String, String> data= arg1.asMap(String.class, String.class);

        HashMap<String ,String> updateParameter = new HashMap<String, String>(data);

        LoggerUtils.info("Setting base URL for Endpoints as "+Configuration.getConfiguration().getApi_endpoint());
        RestAssured.baseURI = Configuration.getConfiguration().getApi_endpoint();

        body=XMLUtils.getUpdatedXmlFromFile("GetQuestionnaireInputXML.xml", updateParameter);

        LoggerUtils.info("Calling API with body" );
        LoggerUtils.info(body );

    }

    @When("^i send post request to getQuestionarrie$")
    public void i_send_post_request_to_getQuestionarrie() throws Throwable {

        response=RequestSender.sendPostRequest(APIPaths.GET_QUESTIONNAIRE_API_PATH, body);

        String responseInValidXMLFormat = XMLUtils.format(response.asString());

        LoggerUtils.debug("Response obtained is "+responseInValidXMLFormat);

        loggedResponse = CustomLogger.logResponse(responseInValidXMLFormat, "GetQuestionnairreResponse");

    }

    @Then("^i validate the response$")
    public void i_validate_the_response() throws Throwable {

        LoggerUtils.warning("Validation of API is pending");

        JAXBElement<QGroups> element1= UnmarshallHelper.getJAXBElement(loggedResponse, APITagIgnore.GET_QUESTIONNARE_API.toString(), QGroups.class);


        QGroups qgroups= (QGroups) element1.getValue();

        List<Question> questionsUnder1stQgroup = qgroups.getQgroup().get(0).getQuestions().getQuestions();

        String answerTypeOf1stQuestion = questionsUnder1stQgroup.get(0).getAnswerType();

        LoggerUtils.info("AnswerType of 1st Question in 1st Qgroup"+ answerTypeOf1stQuestion);

        Assert.assertEquals("Answer option of 1st QGroup is valid", "FixedListSingleSelect",answerTypeOf1stQuestion );

    }


    @Given("^invalid QuestionnaireID and valid ParticipantID$")
    public void invalid_QuestionnaireID_and_valid_ParticipantID(DataTable arg1) throws Throwable {

        HashMap<String,String> queryParameters= generateQueryParameters(arg1);

        LoggerUtils.info("Setting base URL for Endpoints as "+Configuration.getConfiguration().getApi_endpoint());
        RestAssured.baseURI = Configuration.getConfiguration().getApi_endpoint();

        body=XMLUtils.getUpdatedXmlFromFile("GetQuestionnaireInputXML.xml", queryParameters);

        LoggerUtils.info("Calling API with body" );
        LoggerUtils.info(body );



    }


    @Then("^i validate the Error message in response \"([^\"]*)\"$")
    public void i_validate_the_Error_message_in_response(String arg1) throws Throwable {

        String errorMessageFromAPI = XMLPathUtils.getTextContent("GETQuestionnaireTemplateRes.ErrorMessage", response);

        Assert.assertEquals("Valid error messages are obtained",arg1,errorMessageFromAPI);

    }



    public HashMap<String,String> generateQueryParameters(DataTable arg1)
    {
        List<Map<String, String>> data= arg1.asMaps(String.class, String.class);

        HashMap<String ,String> updateParameter = new HashMap<String, String>();

        Map.Entry<String, String> entries;

        Set set;

        for(Map<String, String> list:data)
        {
            set=list.entrySet();

            Iterator itr= set.iterator();

            while(itr.hasNext())
            {

                entries=(Map.Entry<String, String>) itr.next();

                updateParameter.put(entries.getKey(),entries.getValue());
            }
        }

        return updateParameter;
    }



    @Given("^ParticipantID \"([^\"]*)\" and  QuestionnaireID \"([^\"]*)\"$")
    public void participantid_and_QuestionnaireID(String arg1, String arg2) throws Throwable {

        HashMap<String,String> queryParameters= new HashMap<String, String>();
        queryParameters.put("apol:ParticipantID",arg1);
        queryParameters.put("apol:QuestionnaireID",arg2);

        LoggerUtils.info("Setting base URL for Endpoints as "+Configuration.getConfiguration().getApi_endpoint());
        RestAssured.baseURI = Configuration.getConfiguration().getApi_endpoint();

        body=XMLUtils.getUpdatedXmlFromFile("GetQuestionnaireInputXML.xml", queryParameters);

        LoggerUtils.info("Calling API with body" );
        LoggerUtils.info(body );

    }

    @Then("^i validate the \"([^\"]*)\" in response$")
    public void i_validate_the_in_response(String arg1) throws Throwable {

        String errorMessageFromAPI = XMLPathUtils.getTextContent("ns1:ErrorMessage", response);

        LoggerUtils.info("errorMessageFromAPI"+errorMessageFromAPI);

        Assert.assertTrue("",errorMessageFromAPI.contains(arg1) );


    }




}
