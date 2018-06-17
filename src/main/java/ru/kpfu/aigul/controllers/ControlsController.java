package ru.kpfu.aigul.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControlsController {
    private MainController mainController;

    @Autowired
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    void showActive(ActionEvent event) {
        mainController.showActiveTasks();
    }

    @FXML
    void showCompleted(ActionEvent event) {
        mainController.showCompletedTasks();
    }

    @FXML
    void showAll(ActionEvent event) {
        mainController.showAllTasks();
    }
}
