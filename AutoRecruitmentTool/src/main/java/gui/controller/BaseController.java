/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eagle
 */
public class BaseController implements Initializable {

    private static final HashMap<String, Object> lstControlers = new HashMap<String, Object>();
    public Stage priStage;
    public Scene priScene;

    public BaseController() {
        lstControlers.put(this.getClass().getSimpleName(), this);
    }

    public Object getInstance(String sName) {
        return lstControlers.get(sName);
    }

    public void Show(Stage oStage, String sTitle) throws MalformedURLException, IOException {
        priStage = (oStage == null ? new Stage() : oStage);
        String sFXML = String.format("src/main/java/gui/page/%s.fxml", this.getClass().getSimpleName());
        URL url = new File(sFXML).toURI().toURL();
        URL css = new File("src/main/java/gui/App.css").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        priStage.setTitle(sTitle);
        priScene = new Scene(root, 1150, 620);
        priScene.getStylesheets().add(css.toExternalForm());
        priStage.setScene(priScene);
        priStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
