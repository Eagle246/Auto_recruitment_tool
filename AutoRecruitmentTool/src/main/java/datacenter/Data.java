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
import objmodels.Recruiter;

/**
 *
 * @author Eagle
 */

public class Data {
    
    //Definition data
    public static List<Recruiter> lstRecruiters = new ArrayList<>();
    public static List<String> lstRecruiterNames = new ArrayList<>();
    public static HashMap<String, String> lstResumeUpd = new HashMap<String, String>();
    public static List<String> lstLocators =  new ArrayList<>();
    public static List<String> lstTitles =  new ArrayList<>();
    public static List<String> lstStatus =  new ArrayList<>();
    public static List<String> lstExperiences =  new ArrayList<>();
    public static List<String> lstLabels = new ArrayList<>();
    public static List<String> lstReferrals = new ArrayList<>();
    public static List<String> lstCVDate = new ArrayList<>();

    public static List<Candidate> lstCandidates = new ArrayList<>(); ////
    
    public static List<CandiidateModel> lstCandidateModel = new ArrayList<>();
    

     
    //Load Defintion XML to get lstRecruiter, lstLocators, lstTitles, lstCVUpdate
    public static void loadDefinitionData(){
        
       lstRecruiterNames.addAll(Arrays.asList("VietNamWork","ITviet")); //////
       lstLocators.addAll(Arrays.asList("TP HCM","Da Nang", "Hue"));
       lstStatus.addAll(Arrays.asList("New","Screening", "Passed screen", "Failed screen", "Approaching", "Reject interview", "Interviewing", "Failed test/interview", "Offering", "Rejected offer", "Accepted offer", "Reject onboard", "Onboard"));
      
       lstResumeUpd.put("Any","Any");
       lstResumeUpd.put("Today","0");
       lstResumeUpd.put("Yesterday", "1");
       lstResumeUpd.put("1 week(s)", "7");
       lstResumeUpd.put("2 week(s)", "14");
       lstResumeUpd.put("1 month(s)", "30");
       lstResumeUpd.put("2 month(s)", "60");
       lstResumeUpd.put("6 month(s)", "180");
       lstResumeUpd.put("12 month(s)", "360");
       
       lstTitles.addAll(Arrays.asList("dgdfgfdg","tttt"));
       
       
       //test ----------------------
       
          lstCandidateModel.addAll(Arrays.asList(
                new CandiidateModel(1, "Nhac", "Developer", 3, "google", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
                new CandiidateModel(2, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
                new CandiidateModel(3, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
                new CandiidateModel(4, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890)
        ));
       //------------------------------
     
    }
    
     public static void Update(){
         lstRecruiterNames = lstRecruiters.stream().distinct().map(Recruiter::getName).collect(Collectors.toList());
         //lstReferrals  = lstCandidates.stream().distinct().map(Candidate::getReferral).collect(Collectors.toList());
         //lstTitles  = lstCandidates.stream().distinct().map(Candidate::getJob_title).collect(Collectors.toList());
         //lstExperiences= lstCandidates.stream().distinct().map(Candidate::getExp_year).collect(Collectors.toList());
         //lstLabels=lstCandidates.stream().distinct().map(Candidate::getLabel).collect(Collectors.toList());
         
        //CandidateModel
         //lstRecruiterNames = lstRecruiters.stream().distinct().map(Recruiter::getName).collect(Collectors.toList());
         lstReferrals  = lstCandidateModel.stream().distinct().map(CandiidateModel::getReferral).collect(Collectors.toList());
         //lstTitles  = lstCandidates.stream().distinct().map(CandiidateModel::getJob).collect(Collectors.toList()); 
         //lstExperiences= lstCandidates.stream().distinct().map(CandiidateModel::getExperience).collect(Collectors.toList());
         //lstLabels=lstCandidates.stream().distinct().map(CandiidateModel::getLabel).collect(Collectors.toList());
     }
     
 }
