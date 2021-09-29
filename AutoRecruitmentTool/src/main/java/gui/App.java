package gui;

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
        URL url = new File("src/main/java/gui/page/MainUI.fxml").toURI().toURL();
        //URL url = new File("src/main/java/gui/page/DetailCV.fxml").toURI().toURL();  
        URL css = new File("src/main/java/gui/App.css").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Candidate management");
        //Scene main = new Scene(root, 1350, 620);
        Scene main = new Scene(root, 1150, 620);
        main.getStylesheets().add(css.toExternalForm());
        primaryStage.setScene(main);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}