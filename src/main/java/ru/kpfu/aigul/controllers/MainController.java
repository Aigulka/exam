package ru.kpfu.aigul.controllers;

import javafx.beans.property.ListProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kpfu.aigul.data.Repository;
import ru.kpfu.aigul.models.TaskItem;

@Controller
public class MainController {
    private Repository repository;

    @Autowired
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void createTask(TaskItem task) { repository.create(task); }

    public void deleteTask(TaskItem task) { repository.delete(task); }

    public void showAllTasks() { repository.showAllTasks(); }

    public void showCompletedTasks() { repository.showCompletedTasks(); }

    public void showActiveTasks() { repository.showActiveTasks(); }

    public ListProperty<TaskItem> getListProperty() {
        return repository.getTasksProperty();
    }

}
