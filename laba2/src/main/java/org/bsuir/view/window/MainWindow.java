package org.bsuir.view.window;

import org.bsuir.controller.MainWindowController;
import org.bsuir.controller.TableController;
import org.bsuir.model.*;
import org.bsuir.view.сomponent.CustomMenuBar;
import org.bsuir.view.сomponent.NumberCount;
import org.bsuir.view.сomponent.InfoTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class MainWindow extends Application{
    private final Button saveButton;
    private final Button openButton;
    private final Button addButton;
    private final Button deleteButton;
    private final Button searchButton;
    private final Button firstPageButton;
    private final Button lastPageButton;
    private final Button nextPageButton;
    private final Button prevPageButton;
    private final Label currentPageValue;
    private final Label allRecordsNum;
    private final Label allPageNum;
    private final StudentList studentsList;
    private final InfoTable infoTable;
    private final TableController tableController;
    private final NumberCount recordsNumValue;
    private final CustomMenuBar menu;

    public MainWindow(){
        saveButton = new Button("Сохранить");
        openButton = new Button("Отрыть");
        addButton = new Button("Добавить");
        deleteButton = new Button("Удалить");
        searchButton = new Button("Найти");
        firstPageButton = new Button("Первая страница");
        lastPageButton = new Button("Последняя страница");
        nextPageButton = new Button("=>");
        prevPageButton = new Button("<=");
        currentPageValue = new Label("Страница : 0");
        allPageNum = new Label("Число всех страниц : 0");
        allRecordsNum = new Label("Число всех записей : 0");
        studentsList = new StudentList();
        recordsNumValue = new NumberCount(10, 120);
        ObservableList<Student> visibleList = FXCollections.observableArrayList();
        infoTable = new InfoTable(visibleList, 1100, 400);
        tableController = new TableController(studentsList, visibleList, recordsNumValue);
        menu = new CustomMenuBar();
    }

    @Override
    public void start(Stage stage){
        MainWindowController.setController(this);

        tableController.setCurrentPageNum(currentPageValue);
        tableController.setAllRecordsNum(allRecordsNum);
        tableController.setAllPageNum(allPageNum);

        GridPane root = new GridPane();
        root.setAlignment(Pos.TOP_CENTER);
        root.add(menu, 0, 0, 2, 1);
        root.add(addMenuPanel(), 1, 1);
        root.add(infoTable, 0,1);
        root.add(addTableMenu(), 0, 2);

        stage.setScene(new Scene(root, 1200, 500));
        stage.show();
    }

    private VBox addMenuPanel(){
        Button[] menuButtons = {saveButton, openButton, addButton, deleteButton, searchButton};
        for (Button button:menuButtons
             ) {
            button.setMinWidth(80);
        }

        VBox vBox = new VBox(10);
        vBox.setMinSize(150, 350);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(saveButton, openButton, addButton, deleteButton, searchButton,
                new Label("Количесво записей\nна странице"), recordsNumValue, allRecordsNum, allPageNum);
        return new VBox(vBox);
    }

    private HBox addTableMenu(){
        firstPageButton.setMinWidth(80);
        lastPageButton.setMinWidth(80);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setMinHeight(80);
        hBox.getChildren().addAll(firstPageButton, prevPageButton, currentPageValue, nextPageButton, lastPageButton);

        return hBox;
    }

    public TableController getTableController() {
        return tableController;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getOpenButton() {
        return openButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public Button getFirstPageButton() {
        return firstPageButton;
    }

    public Button getLastPageButton() {
        return lastPageButton;
    }

    public Button getNextPageButton() {
        return nextPageButton;
    }

    public Button getPrevPageButton() {
        return prevPageButton;
    }

    public StudentList getStudentsList() {
        return studentsList;
    }

    public CustomMenuBar getMenu() {
        return menu;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
