package com.Model.DAO;

import com.Model.Entity.Kurs;
import com.Model.TransformerXML;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
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
public class KursDaoXML implements KursDao {

    String filePathString = "kursy.xml";


    Transformer transformer;
    DocumentBuilderFactory docFactory;
    DocumentBuilder docBuilder;
    Document doc;
    DOMSource source;
    StreamResult result;

    TransformerXML transformerXML;


    public KursDaoXML(){

        transformerXML= new TransformerXML();
        File file = new File(filePathString);
        if (!(file.exists() && !file.isDirectory())) {
            transformerXML.makeFile(filePathString,"courses");
        }
    }



    public List<Kurs> getAllCourses() {

        List<Kurs> kursy = new ArrayList<Kurs>();

        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(fXmlFile);

            NodeList nodes = doc.getElementsByTagName("kurs");
            for (int i = 0; i < nodes.getLength(); i++) {

                Node node = nodes.item(i);
                Element eElement = (Element) node;
                int kursId = Integer.parseInt(eElement.getElementsByTagName("kursId").item(0).getTextContent());
                String kursName = eElement.getElementsByTagName("kursName").item(0).getTextContent();
                kursy.add(new Kurs(kursId, kursName));


            }//  for (int i = 0; i < nodes.getLength(); i++)


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


        return kursy;
    }// public List<Kurs> getAllCourses()


    public void addKurs(Kurs kurs) {


        File file = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        try {

            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(file);
            Element nList = doc.getDocumentElement();

            //root a kurs
            Element newKurs = doc.createElement("kurs");

            //kurs id
            Element kursId = doc.createElement("kursId");
            kursId.appendChild(doc.createTextNode(Integer.toString(kurs.getKursId())));
            newKurs.appendChild(kursId);

            //kursname element
            Element kursname = doc.createElement("kursName");
            kursname.appendChild(doc.createTextNode(kurs.getKursName()));
            newKurs.appendChild(kursname);

            nList.appendChild(newKurs);

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


    }// public void addKurs(Kurs kurs)


    public Kurs getKurs(int KursId) {


        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(fXmlFile);

            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();

            // This XPath query will give you a list of only those <staff> elements
            // which contain a <salary>200000</salary> element
            XPathExpression expr = xpath.compile("/courses/kurs/kursId[text()=" + Integer.toString(KursId) + "]/..");

            NodeList result = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;
            Element eElement = (Element) nodes.item(0);


            String kursName = eElement.getElementsByTagName("kursName").item(0).getTextContent();

            return new Kurs(KursId, kursName);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return null;
    }//public Kurs getKurs(int KursId)


    public void updateKurs(Kurs kurs) {

        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(fXmlFile);


            NodeList nodes = doc.getElementsByTagName("kurs");
           // System.out.println(nodes.getLength());
            for (int i = 0; i < nodes.getLength(); i++) {

                Node kursNode = nodes.item(i);
                Element eElement = (Element) kursNode;
                int kursId = Integer.parseInt(eElement.getElementsByTagName("kursId").item(0).getTextContent());


                NodeList list = kursNode.getChildNodes();
              //  System.out.println(list.getLength());

                if (kursId == kurs.getKursId()) {

                    for (int j = 0; i < list.getLength(); i++) {

                        Node nodek = list.item(i);

                        // get the salary element, and update the value
                        if ("kursName".equals(nodek.getNodeName())) {
                            nodek.setTextContent(kurs.getKursName());
                            break;
                        }
                    }
                }
            }//  for (int i = 0; i < nodes.getLength(); i++)


            // write the content into xml file
            transformer = TransformerXML.preparedTransformerInstance();
            source = new DOMSource(doc);
            result = new StreamResult(new File(filePathString));
            transformer.transform(source, result);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }// public void updateKurs(Kurs kurs)


    //http://stackoverflow.com/questions/7029427/java-xml-remove-item

    public void deleteKurs(int KursId) {

        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(fXmlFile);


            NodeList nodes = doc.getElementsByTagName("kurs");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element kurs = (Element) nodes.item(i);
                Element kursIdEl = (Element) kurs.getElementsByTagName("kursId").item(0);
                int kursId = Integer.parseInt(kursIdEl.getTextContent());
                if (kursId == KursId)
                    kurs.getParentNode().removeChild(kurs);

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


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }


    }// public void deleteKurs(int KursId) {
}
