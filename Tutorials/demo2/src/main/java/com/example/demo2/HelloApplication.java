package com.example.demo2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloApplication extends Application {
    private final Text txtTime = new Text();
    private volatile boolean enough = false;

    Thread timer = new Thread(() -> {
       SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");

       while(!enough) {
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {}

           final String time = dt.format(new Date());

           Platform.runLater(() -> {
               txtTime.setText(time);
           });
       }
    });
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        root.setCenter(txtTime);

        Scene scene = new Scene(root, 200, 150);
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
z
        timer.start();
        stage.show();


        }
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();


    @Override
    public void stop() {
        enough = true;
    }

    public static void main(String[] args) {
        launch();
    }
}