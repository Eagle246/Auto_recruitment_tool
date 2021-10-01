/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import static gui.controller.MainUI.viewCandidateModel;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import objmodels.CandiidateModel;

/**
 *
 * @author LE THUY
 */
public class DetailCandidate implements Initializable {

    @FXML
    private Label lbl_name;

    @FXML
    private Label lbl_jobtitle;

    @FXML
    private Label lbl_gender;

    @FXML
    private TextField input_year;

    @FXML
    private TextField input_skills;

    @FXML
    private TextField input_cmt;

    @FXML
    private TextField input_status;

    @FXML
    private TextField input_label;

    @FXML
    private TextField input_updBy;

    @FXML
    private TextField input_location;

    @FXML
    private TextField input_cvdate;

    @FXML
    private TextField input_phone;

    @FXML
    private TextField input_src;

    @FXML
    private TextField input_referral;

    private static CandiidateModel view1 = null;

    public DetailCandidate() {
    }

    public DetailCandidate(CandiidateModel view) {
        view1 = view;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(MainUI.flag.equalsIgnoreCase("View")){
            Display_NoEdit();
            Display();
        }else{
            Display();
        }
    }

    public void Display() {
        lbl_name.setText(view1.getName());
        lbl_jobtitle.setText(view1.getJob());
        input_skills.setText(view1.getSkills());
        input_year.setText(String.valueOf(view1.getExperience()) + " Year");
        input_status.setText(view1.getStatus());
        input_cmt.setText(view1.getComment());
        input_cvdate.setText(view1.getCv_date());
        input_location.setText(view1.getCan_location());
        input_phone.setText(String.valueOf(view1.getPhone()));
        input_referral.setText(view1.getReferral());
        input_updBy.setText(view1.getUser());
        input_label.setText(view1.getLabel());
        input_src.setText(view1.getCv_link());
    }

    public void Display_NoEdit() {
        lbl_name.setText(view1.getName());
        lbl_jobtitle.setText(view1.getJob());
        input_skills.setText(view1.getSkills());
        input_year.setText(String.valueOf(view1.getExperience()) + " Year");
        input_status.setText(view1.getStatus());
        input_cmt.setText(view1.getComment());
        input_cvdate.setText(view1.getCv_date()); 
        input_location.setText(view1.getCan_location());
        input_phone.setText(String.valueOf(view1.getPhone()));
        input_referral.setText(view1.getReferral());
        input_updBy.setText(view1.getUser());
        input_label.setText(view1.getLabel());
        input_src.setText(view1.getCv_link());
        //-----------
        input_cmt.setEditable(false);
        input_year.setEditable(false);
        input_status.setEditable(false);
        input_phone.setEditable(false);
        input_cvdate.setEditable(false);
        input_referral.setEditable(false);
        input_updBy.setEditable(false);
        input_src.setEditable(false);
        input_skills.setEditable(false);
        input_label.setEditable(false);
        input_location.setEditable(false);
    }

    public void Show() {
        try {
            URL url = new File("src/main/java/gui/page/DetailCandidate.fxml").toURI().toURL();
            URL css = new File("src/main/java/gui/App.css").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("View Detail CV management");
            Scene main = new Scene(root, 1150, 620);
            main.getStylesheets().add(css.toExternalForm());
            primaryStage.setScene(main);
            primaryStage.show();
            //-------------
            primaryStage.setOnCloseRequest(event
                    -> {
                event.consume();
                exit(primaryStage);
            });
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit!");
        alert.setContentText("Do you want to save before exiting?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You successfully logged out!");
            stage.close();
        }
    }

    public CandiidateModel save() {
        CandiidateModel candidate = null;
        String status = input_status.getText();
        String phone = input_phone.getText();
        return candidate;
    }

}
