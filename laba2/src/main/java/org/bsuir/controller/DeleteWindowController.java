package org.bsuir.controller;

import javafx.scene.control.Alert;
import org.bsuir.view.window.DeleteWindow;
import org.bsuir.view.сomponent.SearchByGroupNumberAndWorkingHours;
import org.bsuir.view.сomponent.SearchBySurnameAndWorkingHours;
import org.bsuir.view.сomponent.SearchBySurnameOrGroupNumber;
import javafx.stage.Stage;

public class DeleteWindowController {

    public static void setController(DeleteWindow window){
        setDeleteModeBox(window);
        setDeleteButton(window);
    }

    private static void setDeleteModeBox(DeleteWindow window){
        window.getDeleteMode().setOnAction(actionEvent -> {
            switch (window.getDeleteMode().getValue()) {
                case "Удаление по фамилии или номеру группы":
                    window.getDeleteMenuPane().setCard(new SearchBySurnameOrGroupNumber(window.getStudentList()));
                    break;
                case "Удаление по фамилии и рабочим часам":
                    window.getDeleteMenuPane().setCard(new SearchBySurnameAndWorkingHours());
                    break;
                case "Удаление по номеру группы и рабочим часам":
                    window.getDeleteMenuPane().setCard(new SearchByGroupNumberAndWorkingHours(window.getStudentList()));
                    break;
            }
        });
    }

    private static void setDeleteButton(DeleteWindow window){
        window.getDeleteButton().setOnAction(actionEvent -> {
            int remoteStudentsNum = 0;
            switch (window.getDeleteMode().getValue()) {
                case "Удаление по фамилии или номеру группы":
                    remoteStudentsNum = window.getStudentList().removeBySurnameOrGroupNumber(
                            ((SearchBySurnameOrGroupNumber) window.getDeleteMenuPane().getCard()).getSurname(),
                            ((SearchBySurnameOrGroupNumber) window.getDeleteMenuPane().getCard()).getGroupNumber());
                    displayMessage(remoteStudentsNum);
                    break;
                case "Удаление по фамилии и рабочим часам":
                    remoteStudentsNum = window.getStudentList().removeBySurname(
                            ((SearchBySurnameAndWorkingHours) window.getDeleteMenuPane().getCard()).getGroupNumber(),
                            ((SearchBySurnameAndWorkingHours) window.getDeleteMenuPane().getCard()).getMinHoursNumber(),
                            ((SearchBySurnameAndWorkingHours) window.getDeleteMenuPane().getCard()).getMaxHoursNumber());
                    displayMessage(remoteStudentsNum);
                    break;
                case "Удаление по номеру группы и рабочим часам":
                    remoteStudentsNum = window.getStudentList().removeByGroupNumber(
                            ((SearchByGroupNumberAndWorkingHours) window.getDeleteMenuPane().getCard()).getGroupNumber(),
                            ((SearchByGroupNumberAndWorkingHours) window.getDeleteMenuPane().getCard()).getMinHoursNumber(),
                            ((SearchByGroupNumberAndWorkingHours) window.getDeleteMenuPane().getCard()).getMaxHoursNumber());
                    displayMessage(remoteStudentsNum);
                    break;
            }

            if(remoteStudentsNum > 0)
                ((Stage)window.getDeleteButton().getScene().getWindow()).close();
            window.getTableController().updateTable();
        });
    }

    private static void displayMessage(int remoteStudentsNum){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Некорректный ввод данных!");
        if(remoteStudentsNum == 0){
            alert.setContentText("Не найдено ни одной подходящей записи");
        }else{
            alert.setContentText("Удалено записей : " + remoteStudentsNum);
        }
        alert.show();
    }
}
