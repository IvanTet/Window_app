package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;



public class Main extends Application {

    public FlowPane group0(){
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);

        TextField txt = new TextField("Text1");
        txt.setPrefColumnCount(11);

        CheckBox ch1 = new CheckBox("Checkbox 1");
        CheckBox ch2 = new CheckBox("Checkbox 2");
        CheckBox ch3 = new CheckBox("Checkbox 3");

        Button btn = new Button("Button1");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = txt.getText();
                if(name.equals("Checkbox 1") )
                    ch1.fire();
                else
                {
                    if(name.equals("Checkbox 2"))
                        ch2.fire();
                    else{
                        if(name.equals("Checkbox 3"))
                            ch3.fire();
                        else{
                            Label secLab = new Label("Wrong name(");
                            FlowPane secLayout = new FlowPane();
                            secLayout.getChildren().add(secLab);

                            Scene secScene = new Scene(secLayout, 230, 100);

                            Stage newWind = new Stage();
                            newWind.setTitle("Error Window");
                            newWind.setScene(secScene);
                            newWind.setX(400);
                            newWind.setY(300);
                            newWind.show();

                        }
                    }
                }
            }
        });
        root.getChildren().addAll(btn, txt, ch1, ch2, ch3);
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(group0(), 300, 275));
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}
