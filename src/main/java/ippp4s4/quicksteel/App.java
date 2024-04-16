package ippp4s4.quicksteel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene mainwindow = new Scene(fxmlLoader.load(), 1280, 768);
        stage.setTitle("Quicksteel 24.04");
        stage.setScene(mainwindow);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("/qs-icon.png")));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}