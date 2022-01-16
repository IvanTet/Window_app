package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Group3 {
    final TextField textBox;
    final Button button;
    final RadioButton radButton1, radButton2, radButton3;
    final ToggleGroup radButtonFamily;
    final ObservableList<RadioButton> radButtonArray;
    final Pane aligner;

    public Group3() {

        final String buttonName = "Choose variant",
                buttonName1 = "Enter",
                buttonName2 = "Some",
                buttonName3 = "Text";

        textBox = new TextField();
        button = new Button();
        button.setText(buttonName);
        radButton1 = new RadioButton();
        radButton1.setText(buttonName1);
        radButton2 = new RadioButton();
        radButton2.setText(buttonName2);
        radButton3 = new RadioButton();
        radButton3.setText(buttonName3);
        radButtonArray = FXCollections.observableArrayList();
        radButtonArray.addAll(radButton1,
                radButton2,
                radButton3);
        radButtonFamily = new ToggleGroup();
        radButtonFamily.getToggles().addAll(radButtonArray);

        aligner = new VBox();
        aligner.getChildren().addAll(textBox,
                button);
        aligner.getChildren().addAll(radButtonArray);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String input;

                input = textBox.getText();
                boolean match = false;
                for (RadioButton matchButton : radButtonArray) {
                    if (match = matchButton.getText().equals(input)) {
                        matchButton.fire();
                        break;
                    }
                }
                if (!match) {
                    Alert error = new Alert(Alert.AlertType.WARNING);
                    error.setTitle("Error");
                    error.setContentText("Can't find specified element!");
                    error.show();
                }
            }
        });
    }

    public Pane getAligner() {

        return aligner;
    }

}
