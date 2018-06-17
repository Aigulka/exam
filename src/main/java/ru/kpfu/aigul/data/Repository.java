package ru.kpfu.aigul.data;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import ru.kpfu.aigul.models.TaskItem;

@org.springframework.stereotype.Repository
public class Repository {

    //обертка для list умеющая слушать изменения данных вобъектах коллекции, для заполнения данными в таблицу
    private ObservableList<TaskItem> allTasks = FXCollections.observableArrayList(item -> new Observable[]{item.completedProperty()});

    private FilteredList<TaskItem> completedTasks = new FilteredList<TaskItem>(allTasks, TaskItem::isCompleted);

    private FilteredList<TaskItem> activeTasks = new FilteredList<TaskItem>(allTasks, taskItem -> !taskItem.isCompleted());

    private ListProperty<TaskItem> tasksProperty = new SimpleListProperty<>(allTasks);

    public void showAllTasks() {
        tasksProperty.set(allTasks);
    }

    public void showCompletedTasks() {
        tasksProperty.set(completedTasks);
    }

    public void showActiveTasks() {
        tasksProperty.set(activeTasks);
    }

    public void create(TaskItem item) {
        allTasks.add(item);
    }

    public void delete(TaskItem item) {
        allTasks.remove(item);
    }

    public ListProperty<TaskItem> getTasksProperty() {
        return tasksProperty;
    }
}
