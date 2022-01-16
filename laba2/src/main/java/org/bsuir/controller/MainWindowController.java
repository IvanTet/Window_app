package org.bsuir.controller;

import org.xml.sax.SAXException;
import org.bsuir.view.window.AddWindow;
import org.bsuir.view.window.DeleteWindow;
import org.bsuir.view.window.MainWindow;
import org.bsuir.view.window.SearchWindow;
import org.bsuir.xmlParser.DOMxmlWriter;
import org.bsuir.xmlParser.SAXmlReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class MainWindowController {

    public static void setController(MainWindow window){
        tuneMenuButtons(window);
        tuneTableMenuButtons(window);
        tuneMenuBar(window);
    }

    private static void tuneMenuButtons(MainWindow window) {
        window.getSaveButton().setOnAction(actionEvent -> {
            if (window.getStudentsList().getList().isEmpty()) return;
            try {
                DOMxmlWriter.saveDocument(window.getStudentsList());
            } catch (ParserConfigurationException | TransformerException e) {
                e.printStackTrace();
            }
        });
        window.getOpenButton().setOnAction(actionEvent -> {
            window.getStudentsList().getList().clear();
            try {
                window.getStudentsList().getList().addAll(SAXmlReader.openFile());
                window.getTableController().updateTable();
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
        });
        window.getAddButton().setOnAction(actionEvent -> new AddWindow(window.getStudentsList(),
                window.getTableController()));
        window.getDeleteButton().setOnAction(actionEvent -> new DeleteWindow(window.getStudentsList(),
                window.getTableController()));
        window.getSearchButton().setOnAction(actionEvent -> new SearchWindow(window.getStudentsList()));
    }

    private static void tuneTableMenuButtons(MainWindow window){
        window.getMenu().getSaveFile().setOnAction(actionEvent -> window.getSaveButton().fire());
        window.getMenu().getOpenFile().setOnAction(actionEvent -> window.getOpenButton().fire());
        window.getNextPageButton().setOnAction(actionEvent -> window.getTableController().tablePageNumIncrement());
        window.getPrevPageButton().setOnAction(actionEvent -> window.getTableController().tablePageNumDecrement());
        window.getFirstPageButton().setOnAction(actionEvent -> window.getTableController().firstTablePageOn());
        window.getLastPageButton().setOnAction(actionEvent -> window.getTableController().lastTablePageOn());
    }

    private static void tuneMenuBar(MainWindow window){
        window.getMenu().getAddStudent().setOnAction(actionEvent -> window.getAddButton().fire());
        window.getMenu().getDeleteStudent().setOnAction(actionEvent -> window.getDeleteButton().fire());
        window.getMenu().getSearchStudent().setOnAction(actionEvent -> window.getSearchButton().fire());
    }
}
