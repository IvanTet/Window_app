package org.bsuir.view.сomponent;

import org.bsuir.model.StudentList;
import javafx.scene.control.ComboBox;

import java.util.HashSet;
import java.util.Set;

import org.bsuir.model.Student;

public class GroupNumberComboBox extends ComboBox<String> {
    GroupNumberComboBox(StudentList studentList){
        setItems(studentList);
    }

    private void setItems(StudentList studentList){
        Set<String> groupNumbers = new HashSet<>();
        for (Student student : studentList.getList()) {
            groupNumbers.add(student.getGroupNumber());
        }

        for (String groupNumber : groupNumbers) {
            this.getItems().add(groupNumber);
        }
    }
}
