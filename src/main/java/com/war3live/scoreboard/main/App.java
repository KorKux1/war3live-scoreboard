package com.war3live.scoreboard.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class that is responsible for starting the project
 * @author KorKux
 */
public class App extends Application {


    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("scoreboard"));
        stage.setResizable(false);
        stage.setTitle("War3Live Scoreboard");
        stage.getIcons().add(new Image(getClass().getResource("/com/war3live/scoreboard/img/icon64x64.png").toExternalForm()));
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/war3live/scoreboard/views/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}