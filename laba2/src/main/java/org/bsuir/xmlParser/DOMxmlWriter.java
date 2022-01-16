package org.bsuir.xmlParser;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.bsuir.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DOMxmlWriter {
    public static void saveDocument(StudentList studentList) throws ParserConfigurationException, TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(addDocument(studentList));

        FileChooser saveFile = new FileChooser();
        saveFile.setTitle("Save File");

        StreamResult streamFile = new StreamResult(saveFile.showSaveDialog(new Stage()));

        transformer.transform(source, streamFile);
    }

    private static Document addDocument(StudentList studentList) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        document.appendChild(getRootElement(document, studentList));

        return document;
    }

    private static Element getRootElement(Document document, StudentList studentList){
        Element rootElement = document.createElement("StudentsList");

        for (Student student : studentList.getList()
        ) {
            rootElement.appendChild(getStudent(document, student.getFirstName(),
                    student.getSurname(), student.getSecondName(), student.getGroupNumber(), student.getSocialWork()));
        }

        return rootElement;
    }

    private static Node getStudent(Document doc, String firstName, String surname,
                                   String secondName, String groupNumber, int[] socialWork) {
        Element student = doc.createElement("Student");

        for (int i = 0; i < 10; i++) {
            student.appendChild(getStudentElement(doc, "semester" + i, String.valueOf(socialWork[i])));
        }

        student.appendChild(getStudentElement(doc, "surname", surname));
        student.appendChild(getStudentElement(doc, "firstName", firstName));
        student.appendChild(getStudentElement(doc, "secondName", secondName));
        student.appendChild(getStudentElement(doc, "groupNumber", groupNumber));

        return student;
    }

    private static Node getStudentElement(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
