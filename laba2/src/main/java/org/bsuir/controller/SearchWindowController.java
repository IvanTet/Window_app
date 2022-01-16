package org.bsuir.controller;

import javafx.scene.control.Alert;
import org.bsuir.view.window.SearchWindow;
import org.bsuir.view.сomponent.SearchByGroupNumberAndWorkingHours;
import org.bsuir.view.сomponent.SearchBySurnameAndWorkingHours;
import org.bsuir.view.сomponent.SearchBySurnameOrGroupNumber;
import javafx.collections.FXCollections;

public class SearchWindowController {

    public static void setController(SearchWindow window){
        setSearchModeBox(window);
        setSearchButton(window);
    }

    private static void setSearchModeBox(SearchWindow window){
        window.getSearchMode().setOnAction(actionEvent -> {
            switch (window.getSearchMode().getValue()) {
                case "Поиск по фамилии или номеру группы":
                    window.getSearchMenuPane().setCard(new SearchBySurnameOrGroupNumber(window.getStudentList()));
                    break;
                case "Поиск по фамилии и рабочим часам":
                    window.getSearchMenuPane().setCard(new SearchBySurnameAndWorkingHours());
                    break;
                case "Поиск по номеру группы и рабочим часам":
                    window.getSearchMenuPane().setCard(new SearchByGroupNumberAndWorkingHours(window.getStudentList()));
                    break;
            }
        });
    }

    private static void setSearchButton(SearchWindow window){
        window.getSearchButton().setOnAction(actionEvent -> {
            window.getSearchList().clear();
            switch (window.getSearchMode().getValue()) {
                case "Поиск по фамилии или номеру группы":
                    window.getSearchList().addAll(FXCollections.observableArrayList(
                            window.getStudentList().searchBySurnameOrGroupNumber(
                                    ((SearchBySurnameOrGroupNumber) window.getSearchMenuPane().getCard()).getSurname(),
                                    ((SearchBySurnameOrGroupNumber) window.getSearchMenuPane().getCard()).getGroupNumber()
                            ))
                    );
                    break;
                case "Поиск по фамилии и рабочим часам":
                    window.getSearchList().addAll(FXCollections.observableArrayList(
                            window.getStudentList().searchBySurname(
                                    ((SearchBySurnameAndWorkingHours) window.getSearchMenuPane().getCard()).getGroupNumber(),
                                    ((SearchBySurnameAndWorkingHours) window.getSearchMenuPane().getCard()).getMinHoursNumber(),
                                    ((SearchBySurnameAndWorkingHours) window.getSearchMenuPane().getCard()).getMaxHoursNumber()

                            ))
                    );
                    break;
                case "Поиск по номеру группы и рабочим часам":
                    window.getSearchList().addAll(FXCollections.observableArrayList(
                            window.getStudentList().searchByGroupNumber(
                                    ((SearchByGroupNumberAndWorkingHours) window.getSearchMenuPane().getCard()).getGroupNumber(),
                                    ((SearchByGroupNumberAndWorkingHours) window.getSearchMenuPane().getCard()).getMinHoursNumber(),
                                    ((SearchByGroupNumberAndWorkingHours) window.getSearchMenuPane().getCard()).getMaxHoursNumber()
                            ))
                    );
                    break;
            }
            if(window.getSearchList().size() == 0)
                notFoundMessage();
        });
    }

    private static void notFoundMessage(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Не найдено ни одной подходящей записи");
        alert.show();
    }
}
