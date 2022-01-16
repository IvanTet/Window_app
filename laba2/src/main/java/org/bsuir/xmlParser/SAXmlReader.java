package org.bsuir.xmlParser;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.bsuir.model.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXmlReader {

    private static final List<Student> studentList = new ArrayList<>();

    public static List<Student> openFile() throws ParserConfigurationException, SAXException, IOException {
        studentList.clear();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        FileChooser openFile = new FileChooser();
        openFile.setTitle("Open File");

        AdvancedXMLHandler handler = new AdvancedXMLHandler();
        parser.parse(openFile.showOpenDialog(new Stage()), handler);

        System.out.println(studentList.size());

        return studentList;
    }

    private static class AdvancedXMLHandler extends DefaultHandler {
        private String surname, firstName, secondName, groupNumber, lastElementName;
        private final int[] socialWork = new int[10];

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes){
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length){
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                System.out.println(lastElementName);
                switch (lastElementName) {
                    case "surname":
                        surname = information;
                        break;
                    case "firstName":
                        firstName = information;
                        break;
                    case "secondName":
                        secondName = information;
                        break;
                    case "groupNumber":
                        groupNumber = information;
                        break;
                    case "semester0":
                        socialWork[0] = Integer.parseInt(information);
                        break;
                    case "semester1":
                        socialWork[1] = Integer.parseInt(information);
                        break;
                    case "semester2":
                        socialWork[2] = Integer.parseInt(information);
                        break;
                    case "semester3":
                        socialWork[3] = Integer.parseInt(information);
                        break;
                    case "semester4":
                        socialWork[4] = Integer.parseInt(information);
                        break;
                    case "semester5":
                        socialWork[5] = Integer.parseInt(information);
                        break;
                    case "semester6":
                        socialWork[6] = Integer.parseInt(information);
                        break;
                    case "semester7":
                        socialWork[7] = Integer.parseInt(information);
                        break;
                    case "semester8":
                        socialWork[8] = Integer.parseInt(information);
                        break;
                    case "semester9":
                        socialWork[9] = Integer.parseInt(information);
                        break;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName){
            System.out.println(2);
            if ((surname != null && !surname.isEmpty()) && (groupNumber != null && !groupNumber.isEmpty()) &&
                    (firstName != null && !firstName.isEmpty()) && (secondName != null && !secondName.isEmpty())) {
                studentList.add(new Student(surname, firstName, secondName, groupNumber, socialWork));
                surname = null;
                firstName = null;
                secondName = null;
                groupNumber = null;
            }
        }
    }
}
