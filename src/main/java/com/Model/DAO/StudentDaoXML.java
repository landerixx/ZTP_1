package com.Model.DAO;

import com.Model.Entity.Kurs;
import com.Model.Entity.Student;
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
public class StudentDaoXML implements StudentDao{


    String filePathString = "studenci.xml";


    TransformerXML transformerXML;
    Transformer transformer;
    DocumentBuilderFactory docFactory;
    DocumentBuilder docBuilder;
    Document doc;
    DOMSource source;
    StreamResult result;


    public List<Student> getAllStudents() {

        List<Student> studenci = new ArrayList<Student>();

        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(fXmlFile);

            NodeList nodes = doc.getElementsByTagName("student");
            for (int i = 0; i < nodes.getLength(); i++) {

                Node node = nodes.item(i);
                Element eElement = (Element) node;
                int studentId = Integer.parseInt(eElement.getElementsByTagName("studentId").item(0).getTextContent());
                String studentName = eElement.getElementsByTagName("studentName").item(0).getTextContent();
                studenci.add(new Student(studentId, studentName));


            }//  for (int i = 0; i < nodes.getLength(); i++)


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


        return studenci;
    }// public List<Student> getAllStudents()

    public void addStudent(Student student) {


        transformerXML= new TransformerXML();
        File file = new File(filePathString);
        if (!(file.exists() && !file.isDirectory())) {
            transformerXML.makeFile(filePathString,"students");
        }


        docFactory = DocumentBuilderFactory.newInstance();

        try {

            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(file);
            Element nList = doc.getDocumentElement();

            //root a kurs
            Element newStudent = doc.createElement("student");

            //kurs id
            Element studentId = doc.createElement("studentId");
            studentId.appendChild(doc.createTextNode(Integer.toString(student.getStudentId())));
            newStudent.appendChild(studentId);

            //kursname element
            Element studentName = doc.createElement("studentName");
            studentName.appendChild(doc.createTextNode(student.getStudentName()));
            newStudent.appendChild(studentName);

            nList.appendChild(newStudent);

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


    }// public void addStudent(Student student)

    public Student getStudent(int studentId) {

        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(fXmlFile);

            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();

            // This XPath query will give you a list of only those <staff> elements
            // which contain a <salary>200000</salary> element
            XPathExpression expr = xpath.compile("/students/student/studentId[text()=" + Integer.toString(studentId) + "]/..");

            NodeList result = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;
            Element eElement = (Element) nodes.item(0);


            String studentName = eElement.getElementsByTagName("studentName").item(0).getTextContent();

            return new Student(studentId, studentName);

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

    }// public Student getStudent(int studentId)

    public void updateStudent(Student student) {

        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(fXmlFile);


            NodeList nodes = doc.getElementsByTagName("student");

            for (int i = 0; i < nodes.getLength(); i++) {

                Node studentNode = nodes.item(i);
                Element eElement = (Element) studentNode;
                int kursId = Integer.parseInt(eElement.getElementsByTagName("studentId").item(0).getTextContent());


                NodeList list = studentNode.getChildNodes();

                if (kursId == student.getStudentId()) {

                    for (int j = 0; i < list.getLength(); i++) {

                        Node nodek = list.item(i);

                        // get the salary element, and update the value
                        if ("studentName".equals(nodek.getNodeName())) {
                            nodek.setTextContent(student.getStudentName());
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

    }// public void updateStudent(Student student) {

    public void deleteStudent(int studentId) {

        File fXmlFile = new File(filePathString);
        docFactory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(fXmlFile);


            NodeList nodes = doc.getElementsByTagName("student");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element student = (Element) nodes.item(i);
                Element studentIdEl = (Element) student.getElementsByTagName("studentId").item(0);
                int studId = Integer.parseInt(studentIdEl.getTextContent());
                if (studId == studentId)
                    student.getParentNode().removeChild(student);

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


    }// public void deleteStudent(int studentId)
}
