package ru.kpfu.aigul.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.aigul.models.TaskItem;

@Component
public class HeaderController {
    private MainController mainController;

    @Autowired
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private TextField taskNameInput;

    @FXML
    void addTask(ActionEvent event) {
        mainController.createTask(new TaskItem(taskNameInput.getText()));
        taskNameInput.setText("");
    }
}
