/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Eagle
 */
 
public class DetailCV implements Initializable {
    /**
     * Initializes the controller class.
     */
@FXML
    private Label lbl_skills;

    @FXML
    private Label lbl_gender;

    @FXML
    private Label lbl_status;

    @FXML
    private Label lbl_updBy;

    @FXML
    private Label lbl_cvdate;

    @FXML
    private Label lbl_comment;

    @FXML
    private Label lbl_location;

    @FXML
    private Label lbl_phone;

    @FXML
    private Label lbl_src;

    @FXML
    private Label lbl_year;

    @FXML
    private Label lbl_referral;

    @FXML
    private Label lbl_label;

    @FXML
    private Label lbl_name;

    @FXML
    private Label lbl_jobtitle;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       view();
    }    
    
    private void view(){
        lbl_name.setText(MainUI.viewCandidateModel.getName());   
        lbl_jobtitle.setText(MainUI.viewCandidateModel.getJob());
        lbl_skills.setText(MainUI.viewCandidateModel.getSkills()); 
        lbl_year.setText(String.valueOf(MainUI.viewCandidateModel.getExperience())+" Year");
        lbl_status.setText(MainUI.viewCandidateModel.getStatus()); 
        lbl_comment.setText(MainUI.viewCandidateModel.getComment()); 
        lbl_cvdate.setText(MainUI.viewCandidateModel.getCv_date());   
        lbl_location.setText(MainUI.viewCandidateModel.getCan_location());
        lbl_phone.setText(String.valueOf(MainUI.viewCandidateModel.getPhone())); 
        lbl_referral.setText(MainUI.viewCandidateModel.getReferral()); 
        lbl_updBy.setText(MainUI.viewCandidateModel.getUser()); 
        lbl_label.setText(MainUI.viewCandidateModel.getLabel()); 
        lbl_src.setText(MainUI.viewCandidateModel.getCv_link()); 
    }
}
