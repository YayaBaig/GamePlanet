package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main extends Application {


    public ImageView rec;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        primaryStage.setTitle("Game");
        primaryStage.setScene(new Scene(root, 541, 388));
        primaryStage.show();
    }
    
        public static void main(String[] args) {

        launch(args);
    }


    public void play(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        rec.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Easy.fxml"));
        Stage stage = new Stage();
        stage.setTitle("PlantsVsZombies");
        stage.setScene(new Scene(root, 591, 224));
        stage.show();
    }
    public void record(MouseEvent mouseEvent) {


    }
}
