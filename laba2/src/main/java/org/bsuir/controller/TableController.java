package org.bsuir.controller;

import javafx.collections.ObservableList;
import org.bsuir.model.StudentList;
import org.bsuir.model.Student;
import org.bsuir.view.сomponent.NumberCount;
import javafx.scene.control.Label;

public class TableController {
    private final StudentList studentList;
    private final NumberCount recordsNumValue;
    private final ObservableList<Student> visibleList;
    private int recordsNum;
    private int currentPageNum;
    private int lastPageValue;
    private Label currentPageValue;
    private Label allRecordsNum;
    private Label allPageNum;

    public TableController(StudentList studentList, ObservableList<Student> visibleList, NumberCount recordsNumValue){
        this.studentList = studentList;
        this.visibleList = visibleList;
        this.recordsNumValue = recordsNumValue;
        currentPageValue = new Label();
        allPageNum = new Label();
        allRecordsNum = new Label();
    }

    private void tuneTableParameters(){
        if(recordsNumValue.getValue() == 0){
            recordsNum = 0;
            currentPageNum = 0;
            lastPageValue = 0;
            return;
        }
        recordsNum = recordsNumValue.getValue();

        if(studentList.getList().size() <= recordsNum || recordsNum == 0)
            lastPageValue = 0;
        else if(studentList.getList().size()%recordsNum > 0)
            lastPageValue = studentList.getList().size() / recordsNum;
        else
            lastPageValue = studentList.getList().size() / recordsNum - 1;

        if(currentPageNum > lastPageValue)
            currentPageNum = lastPageValue;
    }

    public void updateTable(){
        visibleList.clear();
        tuneTableParameters();
        if(studentList.getList().size() <= recordsNum){
            visibleList.addAll(studentList.getList());
            currentPageNum = 0;
        }else {
            int fromIndex = recordsNum * currentPageNum;
            int toIndex = recordsNum * currentPageNum +
                    Math.min(recordsNum, studentList.getList().size() - recordsNum * currentPageNum);
            visibleList.addAll(studentList.getList().subList(fromIndex, toIndex));
        }

        displayLabels();
    }

    public void tablePageNumIncrement(){
        if(recordsNumValue.getValue() == 0) return;

        recordsNum = recordsNumValue.getValue();
        if(studentList.getList().size()/(currentPageNum + 1)/recordsNum >= 1){
            currentPageNum++;
        }
        updateTable();
    }

    public void displayLabels(){
        if(studentList.getList().isEmpty()) {
            currentPageValue.setText("Страница : 0");
            allPageNum.setText("Число всех страниц : 0");
            allRecordsNum.setText("Число всех записей : 0");
        }
        else {
            currentPageValue.setText("Страница : " + (currentPageNum + 1));
            allPageNum.setText("Число всех страниц : " + (lastPageValue + 1));
            allRecordsNum.setText("Число всех записей : " + studentList.getList().size());
        }
    }

    public void tablePageNumDecrement() {
        if(currentPageNum > 0) {
            currentPageNum--;
        }
        updateTable();
    }

    public void firstTablePageOn(){
        recordsNum = recordsNumValue.getValue();
        currentPageNum = 0;
        updateTable();
    }

    public void lastTablePageOn(){
        currentPageNum = lastPageValue;
        updateTable();
    }

    public void setCurrentPageNum(Label currentPageValue) {
        this.currentPageValue = currentPageValue;
    }

    public void setAllRecordsNum(Label allRecordsNum) {
        this.allRecordsNum = allRecordsNum;
    }

    public void setAllPageNum(Label allPageNum) {
        this.allPageNum = allPageNum;
    }
}
