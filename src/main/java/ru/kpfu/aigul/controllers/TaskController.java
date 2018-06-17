package ru.kpfu.aigul.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.kpfu.aigul.models.TaskItem;

@Component
@Scope("prototype")
public class TaskController {
    private MainController mainController;

    @Autowired
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private TaskItem task;

    @FXML
    private Label taskHeader;

    @FXML
    private CheckBox completedCB;

    @FXML
    private Label taskStatus;

    @FXML
    void deleteTask(ActionEvent event) {
        mainController.deleteTask(task);
    }

    public void setTask(TaskItem task) {
        this.task = task;

        taskHeader.setText(task.getName());

        completedCB.selectedProperty().bindBidirectional(task.completedProperty());

        task.completedProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue) taskStatus.setText("completed");
            else taskStatus.setText("active");
        }));


    }
}
