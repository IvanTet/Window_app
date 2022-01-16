package org.bsuir.view.сomponent;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class CustomMenuBar extends MenuBar {
    private final MenuItem saveFile = new MenuItem("Сохранить как");
    private final MenuItem openFile = new MenuItem("Открыть файл");

    private final MenuItem addStudent = new MenuItem("Добавить");
    private final MenuItem deleteStudent = new MenuItem("Удалить");
    private final MenuItem searchStudent = new MenuItem("Найти");


    public CustomMenuBar(){
        customiseMenuBar();
    }

    private void customiseMenuBar(){
        Menu fileMenu = new Menu("Файл");
        fileMenu.getItems().setAll(saveFile, openFile);

        Menu studentMenu = new Menu("Студент");
        studentMenu.getItems().setAll(addStudent, deleteStudent, searchStudent);

        getMenus().setAll(fileMenu, studentMenu);
    }

    public MenuItem getSaveFile() {
        return saveFile;
    }

    public MenuItem getOpenFile() {
        return openFile;
    }

    public MenuItem getAddStudent() {
        return addStudent;
    }

    public MenuItem getDeleteStudent() {
        return deleteStudent;
    }

    public MenuItem getSearchStudent() {
        return searchStudent;
    }
}
