Feature: Get questionnaire API scenarios

  @Smoke
  Scenario: GetQuestionarrieDetails
    Given QuestionnaireID and ParticipantID
      | apol:ParticipantID   | P-90356 |
      | apol:QuestionnaireID | 1021650 |
    When i send post request to getQuestionarrie
    Then i validate the response


  @Regression
  Scenario Outline: Validate the proper error message for GetQuestionarrieDetails API by passing invalid QuestionnaireID
    Given ParticipantID "<apol:ParticipantID>" and  QuestionnaireID "<apol:QuestionnaireID>"
    When i send post request to getQuestionarrie
    Then i validate the "<Error message>" in response

    Examples:
      | apol:ParticipantID | apol:QuestionnaireID | Error message                                                                              |
      | P-90356            | skdjf                | PropertyValueInvalid	null	.pegaToInteger()	Invalid number format (was skdjf)null           |
      | P-90356            | 0000                 | Could not get the QuestionnaireXML with the input paramers QuestionnaireID:0, LanguageID:1 |