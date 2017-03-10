package com.Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by Piotrek on 2017-03-10.
 */
public  class TransformerXML {



    Transformer transformer;
    DocumentBuilderFactory docFactory;
    DocumentBuilder docBuilder;
    Document doc;
    DOMSource source;
    StreamResult result;


    public static Transformer preparedTransformerInstance() throws TransformerConfigurationException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        return transformer;
    }


    public  void makeFile(String pathName,String rootName) {


        try {
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            // root elements
            doc = docBuilder.newDocument();

            Element rootElement = doc.createElement(rootName);
            doc.appendChild(rootElement);

            // write the content into xml file

            transformer = TransformerXML.preparedTransformerInstance();

            source = new DOMSource(doc);
            result = new StreamResult(new File(pathName));
            transformer.transform(source, result);
//PRINTING
/*
            result =  new StreamResult(System.out);
            transformer.transform(source, result);
*/

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }// public void makeFile()









}
