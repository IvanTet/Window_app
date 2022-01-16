package org.bsuir.view.window;

import org.bsuir.controller.SearchWindowController;
import org.bsuir.model.*;
import org.bsuir.view.сomponent.InfoTable;
import org.bsuir.view.сomponent.MenuSearch;
import org.bsuir.view.сomponent.SearchBySurnameOrGroupNumber;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SearchWindow extends Application {
    private final StudentList studentList;
    private final ComboBox<String> searchMode;
    private final MenuSearch searchMenuPane;
    private final Button searchButton;
    private final ObservableList<Student> searchList;
    private final InfoTable infoTable;

    public SearchWindow(StudentList studentList){
        this.studentList = studentList;
        searchMode = new ComboBox<>(FXCollections.observableArrayList("Поиск по фамилии или номеру группы",
                "Поиск по фамилии и рабочим часам", "Поиск по номеру группы и рабочим часам"));
        searchMenuPane = new MenuSearch(new SearchBySurnameOrGroupNumber(studentList), 250, 200);
        searchButton = new Button("Поиск");
        searchList = FXCollections.observableArrayList();
        infoTable = new InfoTable(searchList, 600, 400);

        start(new Stage());
    }

    @Override
    public void start(Stage stage){
        SearchWindowController.setController(this);

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.add(addMenu(), 0,0);
        root.add(infoTable, 1, 0);

        stage.setScene(new Scene(root, 1000, 500));
        stage.show();
    }

    private VBox addMenu(){
        searchMode.setValue("Поиск по фамилии или номеру группы");

        VBox vBox = new VBox(10, searchMode, searchMenuPane, searchButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinSize(300, 200);

        return vBox;
    }

    public StudentList getStudentList() {
        return studentList;
    }

    public ComboBox<String> getSearchMode() {
        return searchMode;
    }

    public MenuSearch getSearchMenuPane() {
        return searchMenuPane;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public ObservableList<Student> getSearchList() {
        return searchList;
    }
}
