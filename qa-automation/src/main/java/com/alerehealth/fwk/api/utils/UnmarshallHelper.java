
package com.alerehealth.fwk.api.utils;

import java.io.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import com.alerehealth.fwk.api.constants.APITagIgnore;




public class UnmarshallHelper {


    /**
     * Helper method to read from XML and move XML Reader to specified tag
     * @param xml as String
     * @param apiTagIgnore : tag till which XML reader has to move
     * @return XMLStreamReader in desired tag position
     * @throws XMLStreamException
     */
    public static XMLStreamReader getXMLStreamReaderToPointToAppropriateTag(String xml, APITagIgnore apiTagIgnore) throws XMLStreamException {

        XMLInputFactory xif = XMLInputFactory.newFactory();

        StringReader stringReader = new StringReader(xml);

        StreamSource streamSource = new StreamSource(stringReader);

        XMLStreamReader xmlStreamReader = xif.createXMLStreamReader(streamSource);
        xmlStreamReader.nextTag();

        while (xmlStreamReader.hasNext()) {
            if (xmlStreamReader.isStartElement() && xmlStreamReader.getLocalName().equals(apiTagIgnore.toString())) {
                break;
            }
            xmlStreamReader.next();
        }

        return xmlStreamReader;

    }

    /**
     * Helper method to read from XML and move XML Reader to specified tag
     * @param file from which we need to read
     * @param apiTagIgnore : tag till which XML reader has to move
     * @return XMLStreamReader in desired tag position
     * @throws XMLStreamException
     */
    public static XMLStreamReader getXMLStreamReaderToPointToAppropriateTag(File file, String apiTagIgnore) throws XMLStreamException {



        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource(file);
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);
        xsr.nextTag();

        while(xsr.hasNext()) {
            if(xsr.isStartElement() && xsr.getLocalName().equals(apiTagIgnore)) {
                break;
            }
            xsr.next();
        }


        return xsr;

    }


    public static Unmarshaller getUnMarshaller(Class tClass) throws JAXBException {

        JAXBContext jaxbcontext = JAXBContext.newInstance(tClass);

        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();

        return unmarshaller;
    }

    public static JAXBElement getJAXBElement(File file, String tagToIgnore, Class classOfObject) throws Exception{

        XMLStreamReader reader=getXMLStreamReaderToPointToAppropriateTag(file, tagToIgnore);

        Unmarshaller unmarshaller = getUnMarshaller(classOfObject);

        JAXBElement jax= unmarshaller.unmarshal(reader,classOfObject);

        return jax;

    }

}



