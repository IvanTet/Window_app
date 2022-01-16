package org.bsuir.view.сomponent;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class NumberCount extends HBox {
    private final TextField textField;
    private final Button plus;
    private final Button minus;

    public NumberCount(int size){
        super(3);
        textField = new TextField("0");
        plus = new Button("+");
        minus = new Button("-");


        this.setMaxWidth(size);
        textField.setMaxWidth(size - 66);

        this.getChildren().addAll(minus, textField, plus);
        tuneButtons();
    }

    public NumberCount(int startValue, int size){
        super(3);
        textField = new TextField(String.valueOf(startValue));
        plus = new Button("+");
        minus = new Button("-");


        this.setMaxWidth(size);
        textField.setMaxWidth(size - 66);

        this.getChildren().addAll(minus, textField, plus);
        tuneButtons();
    }

    private void tuneButtons(){
        plus.setMinWidth(30);
        minus.setMinWidth(30);

        plus.setOnAction(actionEvent -> {
            textField.setText(String.valueOf(Integer.parseInt(textField.getText()) + 1));
        });

        minus.setOnAction(actionEvent -> {
            if(Integer.parseInt(textField.getText()) > 0)
                textField.setText(String.valueOf(Integer.parseInt(textField.getText()) - 1));
        });

        textField.textProperty().addListener((obs, oldText, newText) -> {
            if (newText.equals(""))return;

            try{
                Integer.parseInt(newText);
            }catch (NumberFormatException e){
                textField.setText(oldText);
            }
        });
    }

    public int getValue(){
        return Integer.parseInt(textField.getText());
    }
}
