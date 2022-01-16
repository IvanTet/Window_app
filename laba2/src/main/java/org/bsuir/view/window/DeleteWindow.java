package org.bsuir.view.window;

import org.bsuir.controller.DeleteWindowController;
import org.bsuir.controller.TableController;
import org.bsuir.model.StudentList;
import org.bsuir.view.сomponent.MenuSearch;
import org.bsuir.view.сomponent.SearchBySurnameOrGroupNumber;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteWindow extends Application {
    private final TableController tableController;
    private final StudentList studentList;
    private final ComboBox<String> deleteMode;
    private final MenuSearch deleteMenuPane;
    private final Button deleteButton;


    public DeleteWindow(StudentList studentList, TableController tableController){
        this.studentList = studentList;
        this.tableController = tableController;
        deleteMode = new ComboBox<>(FXCollections.observableArrayList("Удаление по фамилии или номеру группы",
                "Удаление по фамилии и рабочим часам", "Удаление по номеру группы и рабочим часам"));
        deleteMenuPane = new MenuSearch(new SearchBySurnameOrGroupNumber(studentList), 250, 200);
        deleteButton = new Button("Удалить");
        start(new Stage());
    }

    @Override
    public void start(Stage stage){
        DeleteWindowController.setController(this);

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.add(addMenu(), 0, 0);
        root.add(deleteMenuPane, 1, 0);

        stage.setScene(new Scene(root, 600, 200));
        stage.show();
    }

    private VBox addMenu(){
        deleteMode.setValue("Удаление по фамилии или номеру группы");

        VBox vBox = new VBox(10, deleteMode, deleteButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinSize(300, 200);

        return vBox;
    }

    public TableController getTableController() {
        return tableController;
    }

    public StudentList getStudentList() {
        return studentList;
    }

    public ComboBox<String> getDeleteMode() {
        return deleteMode;
    }

    public MenuSearch getDeleteMenuPane() {
        return deleteMenuPane;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
}
