package org.bsuir.view.window;

import org.bsuir.controller.AddWindowController;
import org.bsuir.controller.TableController;
import org.bsuir.model.StudentList;
import org.bsuir.view.сomponent.NumberCount;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class AddWindow extends Application {
    private final StudentList studentList;
    private final TableController tableController;
    private final TextField firstName;
    private final TextField surname;
    private final TextField secondName;
    private final TextField groupNumber;
    private final List<NumberCount> workingHoursPerSemester;
    private final Button add;

    public AddWindow(StudentList studentList, TableController tableController){
        this.studentList = studentList;
        this.tableController = tableController;
        surname = new TextField();
        firstName = new TextField();
        secondName = new TextField();
        groupNumber = new TextField();
        workingHoursPerSemester = new ArrayList<>();
        add = new Button("Добавить");

        start(new Stage());
    }

    @Override
    public void start(Stage stage){
        AddWindowController.setController(this);

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.add(addTextFields(), 0, 0);
        root.add(addWorkingHours(), 1, 0);

        stage.setScene(new Scene(root, 515, 300));
        stage.show();
        add.requestFocus();
    }

    @Override
    public void stop(){
        System.out.println(0);
    }

    private VBox addTextFields(){
        firstName.setPromptText("Имя");
        firstName.setMaxWidth(120);

        surname.setPromptText("Фамилия*");
        surname.setMaxWidth(120);

        secondName.setPromptText("Отчество");
        secondName.setMaxWidth(120);

        groupNumber.setPromptText("Номер группы*");
        groupNumber.setMaxWidth(120);

        VBox vBox = new VBox(8);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinWidth(250);
        vBox.getChildren().addAll(surname, firstName, secondName, groupNumber, add);

        return vBox;
    }

    private ScrollPane addWorkingHours(){
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinWidth(250);

        for(int i = 0; i < 10; i++){
            vBox.getChildren().add(new Label(i + 1 + " семестр"));

            NumberCount field = new NumberCount(200);
            workingHoursPerSemester.add(field);
            vBox.getChildren().add(field);
        }

        ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.setMinViewportWidth(250);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        return scrollPane;
    }

    public TableController getTableController() {
        return tableController;
    }

    public StudentList getStudentList() {
        return studentList;
    }

    public TextField getFirstName() {
        return firstName;
    }

    public TextField getSurname() {
        return surname;
    }

    public TextField getSecondName() {
        return secondName;
    }

    public TextField getGroupNumber() {
        return groupNumber;
    }

    public List<NumberCount> getWorkingHoursPerSemesterFields() {
        return workingHoursPerSemester;
    }

    public Button getAdd() {
        return add;
    }
}
