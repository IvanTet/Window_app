package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Group4 {
    final TextField textBox;
    final Button addButton, leftButton, rightButton;
    final HBox buttons;
    final TableView<TableControl> table;
    final TableColumn<TableControl, String> column1, column2;
    ObservableList<TableControl> tableElementArray = FXCollections.observableArrayList();
    final Pane aligner;

    public Group4() {

        final String ButtonName = "Add",
                LeftButton = "To the Left",
                RightButton = "To the Right",
                Column1 = "1",
                Column2 = "2";

        textBox = new TextField();
        addButton = new Button();
        addButton.setText(ButtonName);
        leftButton = new Button();
        leftButton.setText(LeftButton);
        rightButton = new Button();
        rightButton.setText(RightButton);
        buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(addButton,
                leftButton,
                rightButton);

        column1 = new TableColumn<>(Column1);
        column1.setCellValueFactory(new PropertyValueFactory<>("pos1"));
        column1.setSortable(false);
        column1.setMinWidth(123);
        column2 = new TableColumn<>(Column2);
        column2.setCellValueFactory(new PropertyValueFactory<>("pos2"));
        column2.setSortable(false);
        column2.setMinWidth(123);

        table = new TableView<>(tableElementArray);
        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.setMaxHeight(150);

        aligner = new VBox();
        aligner.getChildren().addAll(textBox,
                buttons,
                table);

        addButton.setOnAction(ae -> {
            String input;

            input = textBox.getText();
            if(input.length() > 0) {
                TableControl newElement = new TableControl(input);
                tableElementArray.add(newElement);
            }
        });

        leftButton.setOnAction(ae -> {
            TableControl selectedElement = table.getSelectionModel().getSelectedItem();

            if(selectedElement != null) {
                selectedElement.goLeft();
            }
        });

        rightButton.setOnAction(ae -> {
            TableControl selectedElement = table.getSelectionModel().getSelectedItem();

            if(selectedElement != null) {
                selectedElement.goRight();
            }
        });
    }

    public Pane getAligner() {
        return aligner;
    }
}
