package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Group1 {
    final TextField textBox;
    final Button button;
    final ComboBox<String> comBox;
    final HBox horizontal;
    final Pane aligner;

    public Group1(){
        final String name = "Tap";

        textBox = new TextField();
        button = new Button();
        button.setText(name);
        comBox = new ComboBox<String>();
        comBox.setMaxWidth(100);
        horizontal = new HBox();
        horizontal.getChildren().addAll(comBox,
                button);

        aligner = new VBox();
        aligner.getChildren().addAll(textBox,horizontal);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean elementExists;
                String textFromTextBox;
                textFromTextBox = textBox.getText();

                elementExists = comBox.getItems().contains(textFromTextBox);

                if (!elementExists) {
                    comBox.getItems().add(textFromTextBox);
                    comBox.setValue(textFromTextBox);
                } else {
                    Alert error = new Alert(Alert.AlertType.WARNING);
                    error.setTitle("Error");
                    error.setContentText("This element already exists!");
                    error.show();
                }
            }
            });
        }
        public Pane getAligner() {

            return aligner;
        }
}
