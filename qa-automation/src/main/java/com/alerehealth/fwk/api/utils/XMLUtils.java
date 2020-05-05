package com.alerehealth.fwk.api.utils;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class XMLUtils {

    public static String getUpdatedXml(String inputXML,String tagName,String value) throws Exception {
         Document document= getDocument(inputXML);

         updateNodeValue(document, tagName, value);

        return getXMLAsString(document);

    }

    public static String getUpdatedXmlFromFile(String inputXML, HashMap<String,String> nodeKeyValues) throws Exception {

        Document document= getDocumentFromXMLFile(inputXML);

        Set<String> nodes = nodeKeyValues.keySet();

        for(String nodeKey : nodes){

            updateNodeValue(document, nodeKey, nodeKeyValues.get(nodeKey));

        }

        return getXMLAsString(document);
    }

    public static String getUpdatedXml(String inputXML, HashMap<String,String> nodeKeyValues ) throws Exception {

        Document document= getDocument(inputXML);

        Set<String> nodes = nodeKeyValues.keySet();

        for(String nodeKey : nodes){

            updateNodeValue(document, nodeKey, nodeKeyValues.get(nodeKey));

        }

        return getXMLAsString(document);

    }

    private static Document getDocument(String xmlBody) throws ParserConfigurationException {

        DocumentBuilderFactory dbfactory =DocumentBuilderFactory.newInstance();

        Document document=null;



        DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();

        try {
            InputSource inputSource = new InputSource(new StringReader(xmlBody));

            document = dbuilder.parse(inputSource);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return document;


    }


    public static Document getDocumentFromXMLFile(String fileName) throws ParserConfigurationException {

        fileName = fileName.contains(".xml")?fileName: fileName+".xml";

        File file = new File("./src/test/resources/api/requests/"+fileName);

        /*String filePath = XMLUtils.class.getResource(fileName).getFile();

        System.out.println(filePath);

        File file = new File(filePath);*/

        DocumentBuilderFactory dbfactory =DocumentBuilderFactory.newInstance();

        Document document=null;

        DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();

        try {

            document = dbuilder.parse(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return document;


    }

    private static void updateNodeValue(Document document, String tagName, String value){


        Node n=document.getElementsByTagName(tagName).item(0).getFirstChild();

        n.setNodeValue(value);

    }

    private static String getXMLAsString(Document document) throws TransformerException {

        DOMSource domSource = new DOMSource(document);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();

        transformer.transform(domSource, result);

        return writer.toString();

    }

    public static String format(String unformattedXml) throws ParserConfigurationException {
        try {

             Document document = getDocument(unformattedXml);

            OutputFormat format = new OutputFormat(document);
            format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(2);
            Writer out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(document);

            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
