package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Group2 {
    final Button button1, button2;
    final TextField textBox;
    final HBox buttons;
    final Pane aligner;

    public Group2() {

        final String name1 = "Button 1",
                name2 = "Button 2";

        textBox = new TextField();
        button1 = new Button();
        button1.setText(name1);
        button2 = new Button();
        button2.setText(name2);
        buttons = new HBox();
        buttons.getChildren().addAll(button1,
                button2);
        aligner = new VBox();
        aligner.getChildren().addAll(textBox,
                buttons);

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text;
                text = textBox.getText();
                button2.setText(text);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String button1Text, button2Text;
                button1Text = button1.getText();
                button2Text = button2.getText();
                button1.setText(button2Text);
                button2.setText(button1Text);
            }
        });
    }

    public Pane getAligner() {

        return aligner;
    }
}
