package ru.kpfu.aigul.models;

import javafx.beans.property.SimpleBooleanProperty;

public class TaskItem {
    private String name;
    //именно такой класс чтобы изменения тут же отображались в таблице
    private SimpleBooleanProperty completed = new SimpleBooleanProperty(false);

    public TaskItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed.get();
    }

    public SimpleBooleanProperty completedProperty() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed.set(completed);
    }
}
