package org.bsuir.view.сomponent;

import org.bsuir.model.StudentList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SearchByGroupNumberAndWorkingHours extends VBox {
    private final GroupNumberComboBox groupNumber;
    private final NumberCount minHoursNumber;
    private final NumberCount maxHoursNumber;

    public SearchByGroupNumberAndWorkingHours(StudentList studentList){
        super(10);

        groupNumber = new GroupNumberComboBox(studentList);
        minHoursNumber = new NumberCount(120);
        maxHoursNumber = new NumberCount(120);

        setCard();
    }

    private void setCard(){
        groupNumber.setMaxWidth(200);
        groupNumber.setValue("Номер группы");

        HBox min = new HBox(8, new Label("от :"), minHoursNumber);
        min.setMaxWidth(150);
        HBox max = new HBox(8, new Label("до :"), maxHoursNumber);
        max.setMaxWidth(150);

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(groupNumber, new Label("Рабочие часы"), min, max);
    }

    public String getGroupNumber() {
        return groupNumber.getValue();
    }

    public int getMinHoursNumber() {
        return minHoursNumber.getValue();
    }

    public int getMaxHoursNumber() {
        return maxHoursNumber.getValue();
    }
}
