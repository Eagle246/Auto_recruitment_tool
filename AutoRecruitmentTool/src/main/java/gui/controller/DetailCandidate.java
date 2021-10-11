/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import datacenter.Data;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import objmodels.CandiidateModel;
import objmodels.InterviewStatus;

/**
 *
 * @author LE THUY
 */
public class DetailCandidate extends BaseController {

    @FXML
    private Label lbl_name;

    @FXML
    private Label lbl_jobtitle;

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
    private TableView<InterviewStatus> tbHistory;

    @FXML
    private TableColumn<InterviewStatus, String> updDate;

    @FXML
    private TableColumn<InterviewStatus, String> cmt;

    @FXML
    private TableColumn<InterviewStatus, String> status;

    @FXML
    private TableColumn<InterviewStatus, String> updBy;

    @FXML
    private TableColumn<InterviewStatus, String> updlabel;

    private static CandiidateModel cv = null;
    private static CandiidateModel cvedit = null;
    private static boolean edited;
    private ObservableList<InterviewStatus> lstInterviewStatus = null;

    public DetailCandidate() {
    }

    public DetailCandidate(CandiidateModel cv, boolean edited) {
        this.cv = cv;
        //System.out.println("candidate detail: " + cv.toString());
        this.edited = edited;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableViewHistory();
        if (edited == true) {
            Display();
        } else {
            Display_NoEdit();
        }
    }

    private void initTableViewHistory() {
        //Init columns------------------------------------------    
        updDate.setCellValueFactory(new PropertyValueFactory<>("updDate"));
        updDate.setCellFactory(TextFieldTableCell.forTableColumn());
        updDate.setOnEditCommit((TableColumn.CellEditEvent<InterviewStatus, String> t) -> {
            ((InterviewStatus) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setUpdDate(t.getNewValue());
        });
        cmt.setCellValueFactory(new PropertyValueFactory<>("comment"));
        cmt.setCellFactory(TextFieldTableCell.forTableColumn());
        cmt.setOnEditCommit((TableColumn.CellEditEvent<InterviewStatus, String> t) -> {
            ((InterviewStatus) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setComment(t.getNewValue());
        });

        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        status.setCellFactory(TextFieldTableCell.forTableColumn());
        status.setOnEditCommit((TableColumn.CellEditEvent<InterviewStatus, String> t) -> {
            ((InterviewStatus) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setStatus(t.getNewValue());
        });
        updBy.setCellValueFactory(new PropertyValueFactory<>("updBy"));
        updBy.setCellFactory(TextFieldTableCell.forTableColumn());
        updBy.setOnEditCommit((TableColumn.CellEditEvent<InterviewStatus, String> t) -> {
            ((InterviewStatus) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setUpdBy(t.getNewValue());
        });
        updlabel.setCellValueFactory(new PropertyValueFactory<>("label"));
        updlabel.setCellFactory(TextFieldTableCell.forTableColumn());
        updlabel.setOnEditCommit((TableColumn.CellEditEvent<InterviewStatus, String> t) -> {
            ((InterviewStatus) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setLabel(t.getNewValue());
        });
        //Init table data --------------------------------------------------
        lstInterviewStatus = FXCollections.observableArrayList(cv.getLstStatus());
        tbHistory.setItems(lstInterviewStatus);
    }

    public void Display() {
        lbl_name.setText(cv.getName());
        lbl_jobtitle.setText(cv.getJob());
        input_skills.setText(cv.getSkills());
        input_year.setText(String.valueOf(cv.getExperience()));
        input_status.setText(cv.getStatus());
        input_cmt.setText(cv.getComment());
        input_cvdate.setText(cv.getCv_date());
        input_location.setText(cv.getCan_location());
        input_phone.setText(String.valueOf(cv.getPhone()));
        input_referral.setText(cv.getReferral());
        input_updBy.setText(cv.getUser());
        input_label.setText(cv.getLabel());
        input_src.setText(cv.getCv_link());
    }

    public void Display_NoEdit() {
        lbl_name.setText(cv.getName());
        lbl_jobtitle.setText(cv.getJob());
        input_skills.setText(cv.getSkills());
        input_year.setText(String.valueOf(cv.getExperience()));
        input_status.setText(cv.getStatus());
        input_cmt.setText(cv.getComment());
        input_cvdate.setText(cv.getCv_date());
        input_location.setText(cv.getCan_location());
        input_phone.setText(String.valueOf(cv.getPhone()));
        input_referral.setText(cv.getReferral());
        input_updBy.setText(cv.getUser());
        input_label.setText(cv.getLabel());
        input_src.setText(cv.getCv_link());
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
    
    public void Show(String sTitle) throws IOException {
        this.Show(null, sTitle);
        priStage.setOnCloseRequest(event-> {
            save();
            event.consume();
            ((MainUI)getInstance("MainUI")).testMethod();  ////
            priStage.close();
        });
    }

    public void refreshCandiateGUI() {
        MainUI sc = new MainUI();
        System.out.println(sc);
        sc.refreshCandiateList();
    }

    public void save() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit!");
        alert.setContentText("Do you want to save before exiting?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You successfully logged out!");
            if (edited == true) {
                EditCandidate(cvedit);
            } else {
                EditCandidate(cv);
            }
        }
    }

    @FXML
    void Change_txt(KeyEvent event) {
        cvedit = get_txt();
    }

    public CandiidateModel get_txt() {
        CandiidateModel candidate = null;
        String year = input_year.getText();
        int yearexp;
        if (year.isEmpty()) {
            yearexp = 0;
        } else {
            yearexp = Integer.parseInt(year);
        }
        String src = input_src.getText();
        String skills = input_skills.getText();
        String status = input_status.getText();
        String comment = input_cmt.getText();
        String updBY = input_updBy.getText();
        String label = input_label.getText();
        String cv_date = input_cvdate.getText();
        String location = input_location.getText();
        String phone = input_phone.getText();
        String referal = input_referral.getText();
        candidate = new CandiidateModel(cv.getId(), cv.getName(), cv.getJob(), yearexp, src, skills, status, comment, updBY, label, cv_date, location, referal, Integer.parseInt(phone), "true", cv.getLstStatus());
        return candidate;
    }

    public void EditCandidate(CandiidateModel candidate) {
        if (edited == true) {
            if (cvedit != null) {
                InterviewStatus historystatus = new InterviewStatus(cvedit.getStatus(), cvedit.getComment(), cvedit.getUser(), cvedit.getLabel(), cvedit.getCv_date());
                candidate.setLstStatus(historystatus);
                int index = Data.lstCandidateModel.indexOf(cv);
                Data.lstCandidateModel.set(index, candidate);
                cvedit=null;
            }else{
                int index = Data.lstCandidateModel.indexOf(cv);
                Data.lstCandidateModel.set(index, cv);
            }
        }
    }

}
