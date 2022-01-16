package org.bsuir.view.сomponent;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SearchBySurnameAndWorkingHours extends VBox {
    private final TextField surname;
    private final NumberCount minHoursNumber;
    private final NumberCount maxHoursNumber;

    public SearchBySurnameAndWorkingHours(){
        super(10);

        surname = new TextField();
        minHoursNumber = new NumberCount(120);
        maxHoursNumber = new NumberCount(120);

        setCard();
    }

    private void setCard(){
        surname.setMaxWidth(200);
        surname.setPromptText("Фамилия");

        HBox min = new HBox(8, new Label("от :"), minHoursNumber);
        min.setMaxWidth(150);
        HBox max = new HBox(8, new Label("до :"), maxHoursNumber);
        max.setMaxWidth(150);

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(surname, new Label("Рабочие часы"), min, max);
    }

    public String getGroupNumber() {
        return surname.getText();
    }

    public int getMinHoursNumber() {
        return minHoursNumber.getValue();
    }

    public int getMaxHoursNumber() {
        return maxHoursNumber.getValue();
    }
}
