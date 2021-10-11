package gui;

import gui.controller.MainUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       MainUI oMainUI = new MainUI();
       oMainUI.Show(primaryStage,"Candidate management");
    }

    public static void main(String[] args) {
        launch(args);
    }

}