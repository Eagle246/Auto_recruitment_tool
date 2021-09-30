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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author LE THUY
 */
public class DetailCandidate implements Initializable{
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

    @FXML
    private Label lbl_name;

    @FXML
    private Label lbl_jobtitle;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       view();
    }
    private void view(){
        lbl_name.setText(MainUI.viewCandidateModel.getName());   
        lbl_jobtitle.setText(MainUI.viewCandidateModel.getJob());
        input_skills.setText(MainUI.viewCandidateModel.getSkills()); 
        input_year.setText(String.valueOf(MainUI.viewCandidateModel.getExperience())+" Year");
        input_status.setText(MainUI.viewCandidateModel.getStatus()); 
        input_cmt.setText(MainUI.viewCandidateModel.getComment()); 
        input_cvdate.setText(MainUI.viewCandidateModel.getCv_date());   
        input_location.setText(MainUI.viewCandidateModel.getCan_location());
        input_phone.setText(String.valueOf(MainUI.viewCandidateModel.getPhone())); 
        input_referral.setText(MainUI.viewCandidateModel.getReferral()); 
        input_updBy.setText(MainUI.viewCandidateModel.getUser()); 
        input_label.setText(MainUI.viewCandidateModel.getLabel()); 
        input_src.setText(MainUI.viewCandidateModel.getCv_link()); 
    }
    @FXML
    void Edit(MouseEvent event) {
        System.out.println(input_status.getText());
        System.out.println(input_updBy.getText());
    }
    
}
