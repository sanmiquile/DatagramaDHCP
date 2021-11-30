package co.edu.uniquindio.redes.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        HelloApplication.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/datagrama-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1010, 620);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getStage(){
        return stage;
    }

    public static void main(String[] args) {
        Application.launch();
    }
}