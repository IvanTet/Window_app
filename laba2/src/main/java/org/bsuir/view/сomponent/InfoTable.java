package org.bsuir.view.сomponent;

import org.bsuir.model.Student;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;


public class InfoTable extends TableView<Student> {

    public InfoTable(ObservableList visibleList, int width, int height){
        super(visibleList);
        this.setMaxWidth(width);
        this.setMaxHeight(height);

        setColumns();
    }

    private void setColumns(){
        TableColumn<Student, String> nameColumn = new TableColumn<>("ФИО");
        nameColumn.setPrefWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("fio"));

        TableColumn<Student, String> groupNumberColumn = new TableColumn<>("Номер\nгруппы");
        groupNumberColumn.setCellValueFactory(new PropertyValueFactory<>("groupNumber"));

        TableColumn<Student, String> socialWorkColumn = new TableColumn<>("Общественная работа");

        this.getColumns().addAll(nameColumn, groupNumberColumn, socialWorkColumn);

        for(int i = 0; i < 10; i++){
            int finalI = i;
            TableColumn workingHours = new TableColumn<>(i + 1 + " семестр");
            workingHours.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Integer>, ObservableValue<Integer>>() {
                @Override
                public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Student, Integer> studentIntegerCellDataFeatures) {
                    return studentIntegerCellDataFeatures.getValue().getSocialWork(finalI);
                }
            });
            socialWorkColumn.getColumns().add(workingHours);
        }
        System.out.println();
    }
}
