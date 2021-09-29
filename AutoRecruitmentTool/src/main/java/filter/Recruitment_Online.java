/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import objmodels.Candidate;
import objmodels.Recruiter;
import java.util.*;
import java.util.Date;
import objmodels.CandiidateModel;

/**
 *
 * @author Eagle
 */
public class Recruitment_Online {
    
    public Recruiter oRecruiter; 
    public String JobTitle;
    public String Experience;
    public String Expectation;
    public Date cvDate;
    public String Location;
    public String Phone;
    public String Refeeral;
    
    public Recruiter getoRecruiter(){
        return oRecruiter;
    }

    public void setoRecruiter(Recruiter oRecruiter) {
        this.oRecruiter = oRecruiter;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String JobTitle) {
        this.JobTitle = JobTitle;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }

    public String getExpectation() {
        return Expectation;
    }

    public void setExpectation(String Expectation) {
        this.Expectation = Expectation;
    }

    public Date getCvDate() {
        return cvDate;
    }

    public void setCvDate(Date cvDate) {
        this.cvDate = cvDate;
    }


    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getRefeeral() {
        return Refeeral;
    }

    public void setRefeeral(String Refeeral) {    
        this.Refeeral = Refeeral;
    }

    public Recruitment_Online(Recruiter oRecruiter, String JobTitle, String Experience, String Expectation, String Location, String Refeeral) {
        this.oRecruiter = oRecruiter;
        this.JobTitle = JobTitle;
        this.Experience = Experience;
        this.Expectation = Expectation;
        this.Location = Location;
        this.Refeeral = Refeeral;
    }
    
    public List<CandiidateModel> Filter() {
        return null;
    }
    
}
