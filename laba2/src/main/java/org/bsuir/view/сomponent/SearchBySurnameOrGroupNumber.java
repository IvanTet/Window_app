package org.bsuir.view.сomponent;

import org.bsuir.model.StudentList;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class SearchBySurnameOrGroupNumber extends VBox {
    private final TextField surname;
    private final GroupNumberComboBox groupNumberBox;

    public SearchBySurnameOrGroupNumber(StudentList studentList){
        super(10);

        surname = new TextField();
        groupNumberBox = new GroupNumberComboBox(studentList);

        setCard();
    }

    private void setCard(){
        surname.setMaxWidth(200);
        surname.setPromptText("Фамилия");

        groupNumberBox.setMaxWidth(200);
        groupNumberBox.setValue("Номер группы");

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(surname, groupNumberBox);
    }

    public String getSurname() {
        return surname.getText();
    }

    public String getGroupNumber(){
        return groupNumberBox.getValue();
    }
}
