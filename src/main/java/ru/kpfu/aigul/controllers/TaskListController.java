package ru.kpfu.aigul.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.aigul.models.TaskItem;
import ru.kpfu.aigul.utils.FXMLLoaderProvider;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@Component
public class TaskListController implements Initializable{
    private MainController mainController;
    private FXMLLoaderProvider loaderProvider;
    private Map<TaskItem, Node> taskNodeCache = new HashMap<>();

    @Autowired
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Autowired
    public void setLoaderProvider(FXMLLoaderProvider loaderProvider) {
        this.loaderProvider = loaderProvider;
    }

    @FXML
    private ListView<TaskItem> tasksList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tasksList.setItems(mainController.getListProperty());

        tasksList.setCellFactory(new Callback<ListView<TaskItem>, ListCell<TaskItem>>() {
            @Override
            public ListCell<TaskItem> call(ListView<TaskItem> param) {
                return new ListCell<TaskItem>(){
                    @Override
                    protected void updateItem(TaskItem taskItem, boolean empty) {
                        super.updateItem(taskItem, empty);
                        if(empty) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            setText(null);

                            if(!taskNodeCache.containsKey(taskItem)) {
                                final Node parent = loadTaskFxml(taskItem);
                                taskNodeCache.put(taskItem, parent);
                            }

                            Node node = taskNodeCache.get(taskItem);
                            Node currentNode = getGraphic();
                            if(currentNode == null || !currentNode.equals(node)) {
                                setGraphic(node);
                            }
                        }
                    }
                };
            }
        });
    }

    private Node loadTaskFxml(TaskItem item) {
        String pathToTaskFxml = "/task.fxml";
        FXMLLoader loader = loaderProvider.getLoader(pathToTaskFxml);

        try{
            Node node = loader.load();
            TaskController taskController = loader.getController();
            taskController.setTask(item);

            return node;
        }catch(IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
