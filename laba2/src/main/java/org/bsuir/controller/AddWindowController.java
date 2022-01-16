package org.bsuir.controller;

import javafx.scene.control.Alert;
import org.bsuir.model.*;
import org.bsuir.view.window.AddWindow;
import javafx.stage.Stage;

public class AddWindowController {
    public static void setController(AddWindow window) {
        window.getAdd().setOnAction(actionEvent -> {
            String surname = window.getSurname().getText();
            String firstName = window.getFirstName().getText();
            String secondName = window.getSecondName().getText();
            String groupNumber = window.getGroupNumber().getText();

            if (surname.isEmpty() || groupNumber.isEmpty()) {
                displayErrorMessage();
                return;
            }

            int[] workingHoursPerSemester = new int[10];
            for (int i = 0; i < 10; i++) {
                workingHoursPerSemester[i] = window.getWorkingHoursPerSemesterFields().get(i).getValue();
            }

            window.getStudentList().addStudent(new Student(surname, firstName, secondName, groupNumber, workingHoursPerSemester));
            window.getTableController().updateTable();
            ((Stage) window.getAdd().getScene().getWindow()).close();
        });
    }

    private static void displayErrorMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Некорректный ввод данных!");
        alert.show();
    }
}
