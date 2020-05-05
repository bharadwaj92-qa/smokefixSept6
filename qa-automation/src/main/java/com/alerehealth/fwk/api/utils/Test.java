package com.alerehealth.fwk.api.utils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) throws Exception {

       String fileName = "GetQuestionnaireInputXML.xml";
        fileName = fileName.contains(".xml")?fileName: fileName+".xml";

       /*// URL url = Test.class.getClassLoader().getResource("/api/request/GetQuestionnaireInputXML.xml");

      //  System.out.println(url);

        String path = System.getProperty("user.dir")+"/src/test/resources/api/requests/"+fileName;

        File file = new File(path);

        System.out.println(file.getAbsolutePath());*/

        HashMap<String ,String> updateParameter = new HashMap<String, String>();

        updateParameter.put("apol:ParticipantID","P-90356");
        updateParameter.put("apol:QuestionnaireID","1021650");

        String content = XMLUtils.getUpdatedXmlFromFile(fileName, updateParameter);

        System.out.println(content);
        //System.getProperty("user.dir")+
    }
}
