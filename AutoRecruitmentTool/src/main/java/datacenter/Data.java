/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import objmodels.Candidate;
import objmodels.CandiidateModel;
import objmodels.InterviewStatus;
import objmodels.Recruiter;
import java.sql.*;
/**
 *
 * @author Eagle
 */
public class Data {

    //Definition data
    public static List<Recruiter> lstRecruiters = new ArrayList<>();
    public static List<String> lstRecruiterNames = new ArrayList<>();
    public static HashMap<String, String> lstResumeUpd = new HashMap<String, String>();
    public static List<String> lstLocators = new ArrayList<>();
    public static List<String> lstTitles = new ArrayList<>();
    public static List<String> lstStatus = new ArrayList<>();
    public static List<String> lstExperiences = new ArrayList<>();
    public static List<String> lstLabels = new ArrayList<>();
    public static List<String> lstReferrals = new ArrayList<>();
    public static List<String> lstCVDate = new ArrayList<>();

    public static List<Candidate> lstCandidates = new ArrayList<>(); ////

    public static List<CandiidateModel> lstCandidateModel = new ArrayList<>();
    private List<InterviewStatus> lst = new ArrayList<>();
    
    //Load Defintion XML to get lstRecruiter, lstLocators, lstTitles, lstCVUpdate
    public static void loadDefinitionData() throws SQLException {
//        DBServer db= new DBServer();
//        Connection connectdb= db.getConnection();
//        String connectquery="SELECT * FROM hr.candidate";
//        Statement st = connectdb.createStatement();
//        ResultSet rs = st.executeQuery(connectquery);
//        System.out.println(rs.toString());
//        while(rs.next()){
//            int id=rs.getInt(1);
//            String name=rs.getString(2);
//            String jobtitle=rs.getString(3);
//            int year=rs.getInt(4);
//            String link_src=rs.getString(5);
//            String skill=rs.getString(6);
//            String status=rs.getString(7);
//            String comment=rs.getString(8);
//            String updBy=rs.getString(9);
//            String label=rs.getString(10);
//            String cvDate=rs.getString(11);
//            String location=rs.getString(12);
//            String refferal=rs.getString(13);
//            int phone=rs.getInt(14);
//            List<InterviewStatus> lst = new ArrayList<>();
//            CandiidateModel c= new CandiidateModel(id, name, jobtitle, year, link_src, skill, status, comment, updBy, label, cvDate, location, refferal, phone, "false", lst);
//            lstCandidateModel.add(c);
//        }
        //-----------------------------
        lstRecruiterNames.addAll(Arrays.asList("VietNamWork", "ITviet")); //////
        lstLocators.addAll(Arrays.asList("TP HCM", "Da Nang", "Hue"));
        lstStatus.addAll(Arrays.asList("New", "Screening", "Passed screen", "Failed screen", "Approaching", "Reject interview", "Interviewing", "Failed test/interview", "Offering", "Rejected offer", "Accepted offer", "Reject onboard", "Onboard"));

        lstResumeUpd.put("Any", "Any");
        lstResumeUpd.put("Today", "0");
        lstResumeUpd.put("Yesterday", "1");
        lstResumeUpd.put("1 week(s)", "7");
        lstResumeUpd.put("2 week(s)", "14");
        lstResumeUpd.put("1 month(s)", "30");
        lstResumeUpd.put("2 month(s)", "60");
        lstResumeUpd.put("6 month(s)", "180");
        lstResumeUpd.put("12 month(s)", "360");
        lstTitles.addAll(Arrays.asList("dgdfgfdg", "tttt"));

        //test ----------------------
        List<InterviewStatus> lst = new ArrayList<>();
        List<InterviewStatus> lst1 = new ArrayList<>();
        List<InterviewStatus> lst2 = new ArrayList<>();
        List<InterviewStatus> lst3 = new ArrayList<>();
        lstCandidateModel.addAll(Arrays.asList(
                new CandiidateModel(1, "Nhac", "Developer", 3, "google", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890, "false",lst ),
                new CandiidateModel(2, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890, "false", lst1),
                new CandiidateModel(3, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890, "false", lst2),
                new CandiidateModel(4, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890, "false", lst3)
        ));
        //------------------------------
//        CandiidateModel.lstStatus.addAll(Arrays.asList(
//                new InterviewStatus("New", "abc", "Thuy", "AI", "2021-10-07"),
//                new InterviewStatus("New", "abc", "Thuy", "AI", "2021-10-07"),
//                new InterviewStatus("New", "abc", "Thuy", "AI", "2021-10-07"),
//                new InterviewStatus("New", "abc", "Thuy", "AI", "2021-10-07")
//        ));
    }

    public static void Update() {
        lstRecruiterNames = lstRecruiters.stream().distinct().map(Recruiter::getName).collect(Collectors.toList());
        //lstReferrals  = lstCandidates.stream().distinct().map(Candidate::getReferral).collect(Collectors.toList());
        //lstTitles  = lstCandidates.stream().distinct().map(Candidate::getJob_title).collect(Collectors.toList());
        //lstExperiences= lstCandidates.stream().distinct().map(Candidate::getExp_year).collect(Collectors.toList());
        //lstLabels=lstCandidates.stream().distinct().map(Candidate::getLabel).collect(Collectors.toList());

        //CandidateModel
        //lstRecruiterNames = lstRecruiters.stream().distinct().map(Recruiter::getName).collect(Collectors.toList());
        lstReferrals = lstCandidateModel.stream().distinct().map(CandiidateModel::getReferral).collect(Collectors.toList());
        //lstTitles  = lstCandidates.stream().distinct().map(CandiidateModel::getJob).collect(Collectors.toList()); 
        //lstExperiences= lstCandidates.stream().distinct().map(CandiidateModel::getExperience).collect(Collectors.toList());
        //lstLabels=lstCandidates.stream().distinct().map(CandiidateModel::getLabel).collect(Collectors.toList());
    }

}
