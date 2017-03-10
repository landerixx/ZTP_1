package com.Model.DAO;

import com.Model.Entity.Student;
import com.Model.Entity.Zapisany;
import com.Model.TransformerXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 2017-03-10.
 */
public class ZapisanyDaoXML implements ZapisanyDao {


    String filePathString = "zapisani.xml";


    TransformerXML transformerXML;
    Transformer transformer;
    DocumentBuilderFactory docFactory;
    DocumentBuilder docBuilder;
    Document doc;
    DOMSource source;
    StreamResult result;


    public List<Zapisany> getAllZapisany() {

        List<Zapisany> zapisani = new ArrayList<Zapisany>();

        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(fXmlFile);

            NodeList nodes = doc.getElementsByTagName("zapisany");
            for (int i = 0; i < nodes.getLength(); i++) {

                Node node = nodes.item(i);
                Element eElement = (Element) node;
                int kursId = Integer.parseInt(eElement.getElementsByTagName("kursId").item(0).getTextContent());
                int studentId = Integer.parseInt(eElement.getElementsByTagName("studentId").item(0).getTextContent());
                zapisani.add(new Zapisany(kursId, studentId));


            }//  for (int i = 0; i < nodes.getLength(); i++)


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


        return zapisani;

    }//public List<Zapisany> getAllZapisany()


    public void addZapisany(Zapisany zapisany) {


        transformerXML = new TransformerXML();
        File file = new File(filePathString);
        if (!(file.exists() && !file.isDirectory())) {
            transformerXML.makeFile(filePathString, "zapisani");
        }


        docFactory = DocumentBuilderFactory.newInstance();

        try {

            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(file);
            Element nList = doc.getDocumentElement();

            //root a kurs
            Element newZapisany = doc.createElement("zapisany");

            //kurs id
            Element kursId = doc.createElement("kursId");
            kursId.appendChild(doc.createTextNode(Integer.toString(zapisany.getKursId())));
            newZapisany.appendChild(kursId);

            //kursname element
            Element studentId = doc.createElement("studentId");
            studentId.appendChild(doc.createTextNode(Integer.toString(zapisany.getStudentId())));
            newZapisany.appendChild(studentId);

            nList.appendChild(newZapisany);

            transformer = TransformerXML.preparedTransformerInstance();
            result = new StreamResult(file);
            source = new DOMSource(doc);
            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }// public void addZapisany(Zapisany zapisany)


    public Zapisany getZapisany(int kursId, int studentId) {


        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        Zapisany zapisanyObj=null;

        try {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(fXmlFile);


            NodeList nodes = doc.getElementsByTagName("zapisany");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element zapisany = (Element) nodes.item(i);
                Element studentIdEl = (Element) zapisany.getElementsByTagName("studentId").item(0);
                Element kursIdEl = (Element) zapisany.getElementsByTagName("kursId").item(0);
                int studIndx = Integer.parseInt(studentIdEl.getTextContent());
                int kursIndx = Integer.parseInt(kursIdEl.getTextContent());
                if (studIndx == studentId && kursId == kursIndx) {

                   zapisanyObj=new Zapisany(kursIndx,studIndx);
                }


            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zapisanyObj;

    }//public Zapisany getZapisany(int kursId, int studentId)

    //puste
    public void updateZapisany(Zapisany zapisany) {

    }


    public void deleteZapisany(int kursId, int studentId) {

        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        Zapisany zapisanyObj=null;

        try {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(fXmlFile);


            NodeList nodes = doc.getElementsByTagName("zapisany");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element zapisany = (Element) nodes.item(i);
                Element studentIdEl = (Element) zapisany.getElementsByTagName("studentId").item(0);
                Element kursIdEl = (Element) zapisany.getElementsByTagName("kursId").item(0);
                int studIndx = Integer.parseInt(studentIdEl.getTextContent());
                int kursIndx = Integer.parseInt(kursIdEl.getTextContent());
                if (studIndx == studentId && kursId == kursIndx) {

                    zapisany.getParentNode().removeChild(zapisany);
                }


            }

            //DELETE EMPTY LINES AFTER DELETE
            XPath xp = XPathFactory.newInstance().newXPath();
            NodeList nl = (NodeList) xp.evaluate("//text()[normalize-space(.)='']", doc, XPathConstants.NODESET);

            for (int i=0; i < nl.getLength(); ++i) {
                Node node = nl.item(i);
                node.getParentNode().removeChild(node);
            }


            // write the content into xml file
            transformer = TransformerXML.preparedTransformerInstance();
            source = new DOMSource(doc);
            result = new StreamResult(new File(filePathString));
            transformer.transform(source, result);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

    }//  public void deleteZapisany(int kursId, int studentId)



    /**
     *
     * WHEN whichOne is TRUE
     *  THEN ID=studentID, usuwamy wszystkie KURSY na ktore zapisal sie STUDENT
     *
     *  WHEN whichOne is FALSE
     *  THEN ID=kursID, usuwamy wszystkich STUDENTOW zapisanych na ten KURS
     *
     *
     * @param ID: Student or kurs id
     * @param whichOne: BOOLEAN, if equals  TRUE: ID=studentID, kursId otherwise
     *
     *
     */

    public void deleteAllZapisany(int ID, boolean whichOne) {

        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();



        try {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(fXmlFile);

            docFactory.setValidating(true);
            docFactory.setIgnoringElementContentWhitespace(true);



            NodeList nodes = doc.getElementsByTagName("zapisany");




            for (int i = 0; i < nodes.getLength(); i++) {
                Node zapisany =nodes.item(i);
                Element zapisanyEl = (Element) zapisany;
                Element studentIdEl = (Element) zapisanyEl.getElementsByTagName("studentId").item(0);
                Element kursIdEl = (Element) zapisanyEl.getElementsByTagName("kursId").item(0);
                int studIndx = Integer.parseInt(studentIdEl.getTextContent());
                int kursIndx = Integer.parseInt(kursIdEl.getTextContent());

                Node parent= zapisanyEl.getParentNode();
                if(whichOne){
                    if(ID==studIndx) {
                        parent.removeChild(zapisanyEl);
                        i--;
                    }
                }
                else{
                    if(ID==kursIndx) {
                        parent.removeChild(zapisanyEl);
                        i--;


                    }
                }


            }//  for (int i = 0; i < nodes.getLength(); i++)



            //DELETE EMPTY LINES AFTER DELETE
            XPath xp = XPathFactory.newInstance().newXPath();
            NodeList nl = (NodeList) xp.evaluate("//text()[normalize-space(.)='']", doc, XPathConstants.NODESET);

            for (int i=0; i < nl.getLength(); ++i) {
                Node node = nl.item(i);
                node.getParentNode().removeChild(node);
            }

            // write the content into xml file
            transformer = TransformerXML.preparedTransformerInstance();
            source = new DOMSource(doc);
            result = new StreamResult(new File(filePathString));
            transformer.transform(source, result);


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }


    }// public void deleteAllZapisany(int ID, boolean whichOne)
}
