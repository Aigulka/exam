package ru.kpfu.aigul;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kpfu.aigul.configs.SpringConfig;
import ru.kpfu.aigul.utils.FXMLLoaderProvider;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        FXMLLoader loader = ctx.getBean(FXMLLoaderProvider.class).getLoader("/main.fxml");

        //интерфейс содерж файл main.fxml
        Parent root = loader.load();
        primaryStage.setTitle("JavaFX");
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
