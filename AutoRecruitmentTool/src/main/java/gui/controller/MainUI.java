/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import common.Utils;
import datacenter.Data;
import filter.Recruitment_Online;
import filter.Recruitment_VietNamWork;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import objmodels.CandiidateModel;
import objmodels.Recruiter;
import org.controlsfx.control.CheckComboBox;

/**
 * FXML Controller class
 *
 * @author Eagle
 */
public class MainUI implements Initializable {

    //Declare top filter Controls---------------------------
    @FXML
    private CheckComboBox<String> cbTitlesTop;
    @FXML
    private CheckComboBox<String> cbExpTop;
    @FXML
    private CheckComboBox<String> cbStatusTop;
    @FXML
    private CheckComboBox<String> cbLabelTop;
    @FXML
    private CheckComboBox<String> cbCVDateTop;
    @FXML
    private CheckComboBox<String> cbReferralTop;
    @FXML
    private CheckComboBox<String> cbLocationTop;
    @FXML
    private TextField txtSearchTop;

    //Declare left filter controls
    @FXML
    private ComboBox<String> cbEmployerOnlineSearch;
    public static String txt_cbEmloyerOnlinesearch;
    @FXML
    private TextField txtSearchKeywordOnlineSearch;
    public static String txt_search;
    @FXML
    private TextField txtExperienceFromOnlineSearch;
    public static String txt_ExpFrom;
    @FXML
    private TextField txtExperienceToOnlineSearch;
    public static String txt_ExpTo;
    @FXML
    private ComboBox<String> cbLastResumeUpdateOnlineSearch;
    public static String txt_cbLastResumeUpdateOnlineSearch;
    //private ComboBox<UpdateList> cbLastResumeUpdateOnlineSearch;
    @FXML
    private ComboBox<String> cbWorkingLocationOnlineSearch;
    public static String txt_cbWorkingLocationOnlineSearch;

    @FXML
    private CheckBox check_viewed;

    @FXML
    private ComboBox<String> cbLatestResumeUpdateOnlineSearch;
    @FXML
    private ComboBox<String> cbStatusLocalSearch;
    @FXML
    private ComboBox<String> cbLastStatusUpdateLocalSearch;
    @FXML
    private ComboBox<String> cbExpectedLocationLocalSearch;
    @FXML
    private TextField txtFolderSearch;
    @FXML
    private CheckBox checkIncludeSubFolderFolderSearch;

    //Declare Table View ------------------------
    @FXML
    private TableView<CandiidateModel> tbData;
    @FXML
    public TableColumn<CandiidateModel, Integer> id;
    @FXML
    public TableColumn<CandiidateModel, String> name;
    @FXML
    public TableColumn<CandiidateModel, String> job;
    @FXML
    public TableColumn<CandiidateModel, Integer> experience;
    @FXML
    public TableColumn<CandiidateModel, String> cv_link;
    @FXML
    public TableColumn<CandiidateModel, String> skills;
    @FXML
    public TableColumn<CandiidateModel, String> status;
    @FXML
    public TableColumn<CandiidateModel, String> comment;
    @FXML
    public TableColumn<CandiidateModel, String> user;
    @FXML
    public TableColumn<CandiidateModel, String> label;
    @FXML
    public TableColumn<CandiidateModel, String> cv_date;
    @FXML
    public TableColumn<CandiidateModel, String> can_location;
    @FXML
    public TableColumn<CandiidateModel, String> referral;
    @FXML
    public TableColumn<CandiidateModel, Integer> phone;

    // Variable ------------------------------------------------------------
    private ObservableList<CandiidateModel> lstCandidates = null;
    public static CandiidateModel viewCandidateModel=null;
    //-----------------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableView();
        InitFilterControls();
        createDefaultFilterValue();
        ccbTitleUpdateListener(cbTitlesTop, "Title");
        ccbTitleUpdateListener(cbExpTop, "Experience");
        ccbTitleUpdateListener(cbStatusTop, "Status");
        ccbTitleUpdateListener(cbLabelTop, "Label");
        ccbTitleUpdateListener(cbLocationTop, "Location");
        ccbTitleUpdateListener(cbCVDateTop, "CV Date");
        ccbTitleUpdateListener(cbReferralTop, "Referral");
        CreatContextMenu();
    }

    private void initTableView() {

        //Init columns------------------------------------------    
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setName(t.getNewValue());
        });
        job.setCellValueFactory(new PropertyValueFactory<>("job"));
        job.setCellFactory(TextFieldTableCell.forTableColumn());
        job.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setJob(t.getNewValue());
        });
        experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        experience.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        cv_link.setCellValueFactory(new PropertyValueFactory<>("cv_link"));
        cv_link.setCellFactory(TextFieldTableCell.forTableColumn());
        cv_link.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setCv_link(t.getNewValue());
        });
        skills.setCellValueFactory(new PropertyValueFactory<>("skills"));
        skills.setCellFactory(TextFieldTableCell.forTableColumn());
        skills.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setSkills(t.getNewValue());
        });
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        status.setCellFactory(TextFieldTableCell.forTableColumn());
        status.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setStatus(t.getNewValue());
        });
        comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        comment.setCellFactory(TextFieldTableCell.forTableColumn());
        comment.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setComment(t.getNewValue());
        });
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        user.setCellFactory(TextFieldTableCell.forTableColumn());
        user.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setUser(t.getNewValue());
        });
        label.setCellValueFactory(new PropertyValueFactory<>("label"));
        label.setCellFactory(TextFieldTableCell.forTableColumn());
        label.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setLabel(t.getNewValue());
        });
        cv_date.setCellValueFactory(new PropertyValueFactory<>("cv_date"));
        cv_date.setCellFactory(TextFieldTableCell.forTableColumn());
        cv_date.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setCv_date(t.getNewValue());
        });
        can_location.setCellValueFactory(new PropertyValueFactory<>("can_location"));
        can_location.setCellFactory(TextFieldTableCell.forTableColumn());
        can_location.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setLocation(t.getNewValue());
        });
        referral.setCellValueFactory(new PropertyValueFactory<>("referral"));
        referral.setCellFactory(TextFieldTableCell.forTableColumn());
        referral.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setReferral(t.getNewValue());
        });
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        //Init table data --------------------------------------------------
        lstCandidates = FXCollections.observableArrayList(Data.lstCandidateModel);
        tbData.setItems(lstCandidates);

    }

    private void InitFilterControls() {
        // Defined controls
        cbStatusTop.getItems().addAll(FXCollections.observableList(addAllCheck(Data.lstStatus)));
        cbLastResumeUpdateOnlineSearch.setItems(FXCollections.observableList(new ArrayList<>(Data.lstResumeUpd.keySet())));
        cbLocationTop.getItems().addAll(FXCollections.observableList(Data.lstLocators));
        cbEmployerOnlineSearch.setItems(FXCollections.observableList(Data.lstRecruiterNames));
        cbWorkingLocationOnlineSearch.setItems(FXCollections.observableList(Data.lstLocators));
        //------------------------------------------
        cbCVDateTop.getItems().addAll(FXCollections.observableList(Arrays.asList("None")));
        cbTitlesTop.getItems().addAll(FXCollections.observableList(Arrays.asList("None")));
        cbExpTop.getItems().addAll(FXCollections.observableList(Arrays.asList("None")));
        cbLabelTop.getItems().addAll(FXCollections.observableList(Arrays.asList("None")));
        cbReferralTop.getItems().addAll(FXCollections.observableList(Arrays.asList("None")));
    }

    private void createDefaultFilterValue() {
        cbTitlesTop.getCheckModel().check(0);
        cbTitlesTop.setTitle("Title: " + makeTitle(cbTitlesTop));
        cbExpTop.getCheckModel().check(0);
        cbExpTop.setTitle("Experience: " + makeTitle(cbTitlesTop));
        cbStatusTop.getCheckModel().check(0);
        cbStatusTop.setTitle("Status: " + makeTitle(cbStatusTop));
        cbLabelTop.getCheckModel().check(0);
        cbLabelTop.setTitle("Label: " + makeTitle(cbLabelTop));
        cbLocationTop.getCheckModel().check(0);
        cbLocationTop.setTitle("Location: " + makeTitle(cbStatusTop));
        cbCVDateTop.getCheckModel().check(0);
        cbCVDateTop.setTitle("CV Date: " + makeTitle(cbStatusTop));
        cbReferralTop.getCheckModel().check(0);
        cbReferralTop.setTitle("Referral: " + makeTitle(cbStatusTop));
    }

    private String makeTitle(CheckComboBox ccb) {
        return ccb.getCheckModel().getCheckedItems().toString()
                .substring(1, ccb.getCheckModel().getCheckedItems().toString().length() - 1);
    }

    private void ccbTitleUpdateListener(CheckComboBox ccb, String title) {
        ccb.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                while (c.next()) {
                    ccb.setTitle(title + ": " + makeTitle(ccb));
                    //do something with changes here
                }
            }
        });
    }

    private List addAllCheck(List data) {
        List temp = new ArrayList(data) {{
            // cannot remove "None" since refreshData is broken
            add(0, "all");
        }};
        return temp;
    }

    //Update data to controls after searching
    private void refreshData() {
        cbCVDateTop.getItems().addAll(FXCollections.observableList(Data.lstCVDate));
        cbTitlesTop.getItems().addAll(FXCollections.observableList(Data.lstTitles));
        cbExpTop.getItems().addAll(FXCollections.observableList(Data.lstExperiences));
        cbLabelTop.getItems().addAll(FXCollections.observableList(Data.lstLabels));
        cbReferralTop.getItems().addAll(FXCollections.observableList(Data.lstReferrals));
        lstCandidates = FXCollections.observableArrayList(Data.lstCandidateModel);
        cbTitlesTop.getCheckModel().check(0);
        tbData.setItems(lstCandidates);
        tbData.refresh();
    }

    private void CreatContextMenu() {
        tbData.setRowFactory(new Callback<TableView<CandiidateModel>, TableRow<CandiidateModel>>() {
            @Override
            public TableRow<CandiidateModel> call(TableView<CandiidateModel> p) {
                final TableRow<CandiidateModel> row = new TableRow<>();
                final ContextMenu rowMenu = new ContextMenu();
                ContextMenu tableMenu = p.getContextMenu();
                if (tableMenu != null) {
                    rowMenu.getItems().addAll(tableMenu.getItems());
                    rowMenu.getItems().add(new SeparatorMenuItem());
                }
                MenuItem viewItem = new MenuItem("View Detail");
                viewItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        try {
                            viewCandidateModel=row.getItem();       
                            //System.out.println(row.getItem());   
                            URL url = new File("src/main/java/gui/page/DetailCV.fxml").toURI().toURL();
                            URL css = new File("src/main/java/gui/App.css").toURI().toURL();
                            Parent root = FXMLLoader.load(url);
                            Stage primaryStage = new Stage();
                            primaryStage.setTitle("View Detail CV management");  
                            Scene main = new Scene(root, 1150, 620);
                            main.getStylesheets().add(css.toExternalForm());
                            primaryStage.setScene(main);
                            primaryStage.show();
                            System.out.println("view detail");
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                MenuItem editItem = new MenuItem("Edit");
                MenuItem bulkchangeItem = new MenuItem("Bulk Change");
                MenuItem exportItem = new MenuItem("Export Excel");
                rowMenu.getItems().addAll(viewItem, editItem, bulkchangeItem, exportItem);
                row.contextMenuProperty().bind(
                        Bindings.when(Bindings.isNotNull(row.itemProperty()))
                                .then(rowMenu)
                                .otherwise((ContextMenu) null));
                return row;
            }
        }
        );
    }
    
    //Action control --------------------------------------------------
    @FXML
    void HandleSearchDB(MouseEvent event) {
        System.out.println("HandleSearchDB!");
        refreshData();
    }

    @FXML
    void HandleSearchFolder(MouseEvent event) {
        System.out.println("HandleSearchFolder!");

    }

    @FXML
    void HandleSearchOnline(MouseEvent event) {
        System.out.println("HandleSearchOnline!");
        String text_source=cbEmployerOnlineSearch.getSelectionModel().getSelectedItem();
        String keysearch=txtSearchKeywordOnlineSearch.getText();
        String txt_lstresumeupd=cbLastResumeUpdateOnlineSearch.getSelectionModel().getSelectedItem();
        String expFrom=txtExperienceFromOnlineSearch.getText();
        String expTo=txtExperienceToOnlineSearch.getText();
        String location=cbWorkingLocationOnlineSearch.getSelectionModel().getSelectedItem();
        Recruitment_Online orecruiter_onl;
        if (text_source.equalsIgnoreCase("VietNamWork")) {
            orecruiter_onl = new Recruitment_VietNamWork(Utils.find(text_source),keysearch,"","",location,text_source);
            orecruiter_onl.Filter(); 
        }
        //Data.Update();
        refreshData();
       
    }
}
