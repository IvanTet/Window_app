package sample;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableControl {
    private StringProperty pos1, pos2;

    public TableControl (String text) {

        pos1 = new SimpleStringProperty(text);
    }

    public StringProperty pos1Property() {

        if(pos1 == null) {
            pos1 = new SimpleStringProperty("");
        }
        return pos1;
    }

    public StringProperty pos2Property() {

        if(pos2 == null) {
            pos2 = new SimpleStringProperty("");
        }
        return pos2;
    }

    public void goLeft() {

        if(pos2.get() != "") {
            pos1.set(pos2.get());;
            pos2.set("");
        }
    }

    public void goRight() {

        if(pos1.get() != "") {
            pos2.set(pos1.get());;
            pos1.set("");
        }
    }

}
